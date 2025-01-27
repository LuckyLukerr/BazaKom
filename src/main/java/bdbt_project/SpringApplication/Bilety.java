package bdbt_project.SpringApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bilety {
    private int id_biletu;
    private String rodzaj_biletu;
    private LocalDateTime data_kupienia;
    private int id_centrali;
    private int id_pasazera;
    private boolean active;


    public Bilety() {
    }

    public Bilety(int id_biletu, String rodzaj_biletu, LocalDateTime data_kupienia, int id_centrali, int id_pasazera) {
        this.id_biletu = id_biletu;
        this.rodzaj_biletu = rodzaj_biletu;
        this.data_kupienia = data_kupienia;
        this.id_centrali = id_centrali;
        this.id_pasazera = id_pasazera;
    }

    @Override
    public String toString() {
        return "Bilety{" +
                "id_biletu=" + id_biletu +
                ", data_kupienia=" + data_kupienia + '\'' +
                ", rodzaj_biletu='" + rodzaj_biletu + '\'' +
                ", id_centrali=" + id_centrali +
                ", id_pasazera=" + id_pasazera +
                '}';
    }

    // Formatowanie daty przed zwróceniem jej do modelu
    public String getFormattedDataKupienia() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return data_kupienia.format(formatter);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId_biletu() {
        return id_biletu;
    }

    public void setId_biletu(int id_biletu) {
        this.id_biletu = id_biletu;
    }

    public LocalDateTime getData_kupienia() {
        return data_kupienia;
    }

    public void setData_kupienia(LocalDateTime data_kupienia) {
        this.data_kupienia = data_kupienia;
    }

    public String getRodzaj_biletu() {
        return rodzaj_biletu;
    }

    public void setRodzaj_biletu(String rodzaj_biletu) {
        this.rodzaj_biletu = rodzaj_biletu;
    }

    public int getId_centrali() {
        return id_centrali;
    }

    public void setId_centrali(int id_centrali) {
        this.id_centrali = id_centrali;
    }

    public int getId_pasazera() {
        return id_pasazera;
    }

    public void setId_pasazera(int id_pasazera) {
        this.id_pasazera = id_pasazera;
    }
}
