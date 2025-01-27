package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.beans.JavaBean;
import java.util.List;

@Repository
public class PojazdyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PojazdyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pojazdy> list() {
        String sql = "SELECT * FROM pojazdy";

        List<Pojazdy> listPojazdy = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pojazdy.class));
        return listPojazdy;
    }

    public void savePojazdy(Pojazdy pojazdy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pojazdy").usingGeneratedKeyColumns("id_pojazdu").usingColumns("vin", "data_waznosci_przegladu", "rodzaj_paliwa", "liczba_miejsc_siedzacych", "rodzaj_pojazdu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pojazdy);
        insertActor.execute(param);
    }

    public Pojazdy get(int id_pojazdu) {
        Object[] args = {id_pojazdu};
        String sql = "SELECT * FROM pojazdy WHERE id_pojazdu = " + args[0];
        Pojazdy pojazdy = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Pojazdy.class));
        return pojazdy;
    }

    public void updatePojazdy(Pojazdy pojazdy) {
        String sql = "UPDATE pojazdy SET vin=:vin, data_waznosci_przegladu=:data_waznosci_przegladu, liczba_miejsc_siedzacych=:liczba_miejsc_siedzacych, rodzaj_pojazdu=:rodzaj_pojazdu WHERE id_pojazdu=:id_pojazdu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pojazdy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deletePojazdy(int id_pojazdu) {
        String sql = "DELETE FROM pojazdy WHERE id_pojazdu=:id_pojazdu";
        jdbcTemplate.update(sql, id_pojazdu);
    }
}
