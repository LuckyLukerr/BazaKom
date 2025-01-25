package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.util.List;

@Repository
public class AdresyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list(){
        String sql = "SELECT * FROM adresy";

        List<Adresy> listAdresy = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }

    public void saveAdresy(Adresy adresy){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("miasto", "ulica", "kod_pocztowy", "nr_lokalu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        insertActor.execute(param);
    }

    public Adresy get(int nr_adresu){
        Object[] args = {nr_adresu};
        String sql = "SELECT * FROM adresy WHERE id_adresu = " + args[0];
        Adresy adres = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Adresy.class));
        return adres;
    }

    public void updateAdresy(Adresy adresy){
        String sql = "UPDATE adresy SET miasto=:miasto, ulica=:ulica, kod_pocztowy=:kod_pocztowy, nr_lokalu=:nr_lokalu WHERE id_adresu=:id_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteAdresy(int id_adresu){
        String sql = "DELETE FROM adresy WHERE id_adresu = ?";
        jdbcTemplate.update(sql, id_adresu);
    }
}
