package bdbt_project.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Pojazdy {
    private int id_pojazdu;
    private String vin;
    private String rodzaj_pojazdu;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_waznosci_przegladu;
    private String rodzaj_paliwa;
    private String liczba_miejsc_siedzacych;
    private String id_centrali;

    public Pojazdy() {
    }

    public Pojazdy(int id_pojazdu, String vin, String rodzaj_pojazdu, LocalDate data_waznosci_przegladu, String rodzaj_paliwa, String liczba_miejsc_siedzacych, String id_centrali) {
        this.id_pojazdu = id_pojazdu;
        this.vin = vin;
        this.rodzaj_pojazdu = rodzaj_pojazdu;
        this.data_waznosci_przegladu = data_waznosci_przegladu;
        this.rodzaj_paliwa = rodzaj_paliwa;
        this.liczba_miejsc_siedzacych = liczba_miejsc_siedzacych;
        this.id_centrali = id_centrali;
    }

    @Override
    public String toString() {
        return "Pojazdy{" +
                "id_pojadzu=" + id_pojazdu +
                ", vin='" + vin + '\'' +
                ", rodzaj_pojazdu='" + rodzaj_pojazdu + '\'' +
                ", data_waznosci_przegladu='" + data_waznosci_przegladu + '\'' +
                ", rodzaj_paliwa='" + rodzaj_paliwa + '\'' +
                ", liczba_miejsc_siedacych='" + liczba_miejsc_siedzacych + '\'' +
                ", id_centrali='" + id_centrali + '\'' +
                '}';
    }

    public int getId_pojazdu() {
        return id_pojazdu;
    }

    public void setId_pojazdu(int id_pojazdu) {
        this.id_pojazdu = id_pojazdu;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRodzaj_pojazdu() {
        return rodzaj_pojazdu;
    }

    public void setRodzaj_pojazdu(String rodzaj_pojazdu) {
        this.rodzaj_pojazdu = rodzaj_pojazdu;
    }

    public LocalDate getData_waznosci_przegladu() {
        return data_waznosci_przegladu;
    }

    public void setData_waznosci_przegladu(LocalDate data_waznosci_przegladu) {
        this.data_waznosci_przegladu = data_waznosci_przegladu;
    }

    public String getRodzaj_paliwa() {
        return rodzaj_paliwa;
    }

    public void setRodzaj_paliwa(String rodzaj_paliwa) {
        this.rodzaj_paliwa = rodzaj_paliwa;
    }

    public String getLiczba_miejsc_siedzacych() {
        return liczba_miejsc_siedzacych;
    }

    public void setLiczba_miejsc_siedzacych(String liczba_miejsc_siedzacych) {
        this.liczba_miejsc_siedzacych = liczba_miejsc_siedzacych;
    }

    public String getId_centrali() {
        return id_centrali;
    }

    public void setId_centrali(String id_centrali) {
        this.id_centrali = id_centrali;
    }
}
