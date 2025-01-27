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
public class LinieDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public LinieDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Linie> list() {
        String sql = "SELECT * FROM linie";
        List<Linie> listLinie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Linie.class));
        return listLinie;
    }
    public void saveLinie(Linie linie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("linie").usingColumns("nazwa_linii", "typ_linii", "dni_dzialania", "godzina_rozpoczecia", "godzina_zakonczenia", "id_centrali", "id_trasy");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(linie);
        insertActor.execute(param);
    }
    public Linie get(int id_lini){
        Object[] args = {id_lini};
        String sql = "SELECT * FROM linie WHERE id_lini = " + args[0];
        Linie linia = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Linie.class));
        return linia;
    }
    public void updateLinie(Linie linie) {
        String sql = "UPDATE linie SET nazwa_linii=:nazwa_linii, typ_linii=:typ_linii, dni_dzialania=:dni_dzialania, godzina_rozpoczecia=:godzina_rozpoczecia, godzina_zakonczenia=:godzina_zakonczenia, id_centrali=:id_centrali, id_trasy=:id_trasy WHERE id_lini=:id_lini";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(linie);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void deleteLinie(int id_lini) {
        String sql = "DELETE FROM linie WHERE id_lini=:id_line";
        jdbcTemplate.update(sql, id_lini);
    }
}