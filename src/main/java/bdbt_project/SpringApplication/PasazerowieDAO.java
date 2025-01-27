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
public class PasazerowieDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PasazerowieDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pasazerowie> list() {
        String sql = "SELECT * FROM pasazerowie";

        List<Pasazerowie> listPasazerowie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pasazerowie.class));
        return listPasazerowie;
    }

    public void savePasazerowie(Pasazerowie pasazerowie){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pasazerowie").usingGeneratedKeyColumns("id_pasazera").usingColumns("imie","nazwisko","nr_telefonu","email","haslo","login");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pasazerowie);
        insertActor.execute(param);
    }

    public Pasazerowie get(int id_pasazera){
        Object[] args = {id_pasazera};
        String sql = "SELECT * FROM pasazerowie WHERE id_pasazera = " + args[0];
        Pasazerowie pasazer = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Pasazerowie.class));
        return pasazer;
    }

    public void updatePasazerowie(Pasazerowie pasazerowie){
        String sql = "UPDATE pasazerowie SET imie=:imie, nazwisko=:nazwisko, nr_telefonu=:nr_telefonu, email=:email, login=:login, haslo=:haslo WHERE id_pasazera=:id_pasazera";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pasazerowie);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deletePasazerowie(int id_pasazera){

        String sqlBilety = "DELETE FROM bilety WHERE id_pasazera = :id_pasazera";
        jdbcTemplate.update(sqlBilety, id_pasazera);

        String sql = "DELETE FROM pasazerowie WHERE id_pasazera=:id_pasazera";
        jdbcTemplate.update(sql, id_pasazera);
    }

}
