package bdbt_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class AdresyDAOTest {
    private AdresyDAO dao;
    private LinieDAO daoLinie;
    private PasazerowieDAO daoPasazerowie;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("bdbtgra03");
        datasource.setPassword("BDBTGRA03");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresyDAO(new JdbcTemplate(datasource));
        daoLinie = new LinieDAO(new JdbcTemplate(datasource));
        daoPasazerowie = new PasazerowieDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList() {
        List<Adresy> listAdresy = dao.list();
        assertTrue(listAdresy.isEmpty());
    }

    @Test
    void testSave() {
        Adresy adresy = new Adresy(50, "Warszawa", "Marszałkowska", "00-000", "1");
        dao.saveAdresy(adresy);
        Linie linie = new Linie(2, "a", "Metro", "c", "ab", "12:12", "1", "1");
        daoLinie.saveLinie(linie);
        Pasazerowie pasazerowie = new Pasazerowie(2,"adam","cos", "123456789","mieszkanie@wp.pl","esa","esaxd");
        daoPasazerowie.savePasazerowie(pasazerowie);
    }

    @Test
    void testGet() {
        int id = 1;
        Adresy adresy = dao.get(id);
        System.out.println(adresy.toString());
    }

    @Test
    void testUpdate() {
        Adresy adresy = new Adresy();
        adresy.setId_adresu(1);
        adresy.setMiasto("Warszawa");
        adresy.setUlica("Marszałkowska11");
        adresy.setKod_pocztowy("33-000");
        adresy.setNr_lokalu("12");
        Linie linie = new Linie(1, "a", "Metro", "c", "ab", "12:12", "1", "1");
        dao.updateAdresy(adresy);
        daoLinie.updateLinie(linie);
    }

    @Test
    void testDelete() {
        int id = 62;
        dao.deleteAdresy(id);
    }
}