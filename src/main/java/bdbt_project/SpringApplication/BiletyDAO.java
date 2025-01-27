package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Repository
public class BiletyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BiletyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bilety> list(String id_pasazera) {
        String sql = "select bilety.*, (current_date - bilety.data_kupienia) as time_diff from bilety join pasazerowie on bilety.id_pasazera = pasazerowie.id_pasazera where pasazerowie.login=:id_pasazera";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_pasazera", id_pasazera);

        List<Bilety> biletyList = namedParameterJdbcTemplate.query(
                sql,
                params, // Parametry do zapytania
                BeanPropertyRowMapper.newInstance(Bilety.class) // Mapper do obiektów
        );

        for (Bilety bilety : biletyList) {
            LocalDateTime zakupData = bilety.getData_kupienia();
            LocalDateTime currentDateTime = LocalDateTime.now();

            long minutesDiff = ChronoUnit.MINUTES.between(zakupData, currentDateTime);
            System.out.println(minutesDiff);

            if ("15 Minutes".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 15) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else if ("75 Minutes".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 75) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else if ("1 Day".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 1440) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else if ("3 Days".equals(bilety.getRodzaj_biletu())) {
                    if (minutesDiff <= 4320) {
                        bilety.setActive(true);
                        break;
                    } else {
                        bilety.setActive(false);
                    }
            } else if ("15 Days".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 21600) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else if ("30 Days".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 43200) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else if ("45 Days".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 64800) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else if ("60 Days".equals(bilety.getRodzaj_biletu())) {
                if (minutesDiff <= 86400) {
                    bilety.setActive(true);
                    break;
                } else {
                    bilety.setActive(false);
                }
            } else {
                bilety.setActive(false);
            }
        }
        return biletyList;
    }
    public void saveBilety(Bilety bilety) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("bilety").usingGeneratedKeyColumns("id_biletu").usingColumns("rodzaj_biletu","id_centrali","id_pasazera");

    }

    public Bilety get(int id_biletu) {
        Object[] args = {id_biletu};
        String sql = "select * from bilety where id_biletu = " + args[0];
        Bilety bilety = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Bilety.class), args);
        return bilety;
    }
}
