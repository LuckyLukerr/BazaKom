package bdbt_project.SpringApplication;

public class Linie {
    private int id_lini;
    private String nazwa_linii;
    private String typ_linii;
    private String dni_dzialania;
    private String godzina_rozpoczecia;
    private String godzina_zakonczenia;
    private String id_centrali;
    private String id_trasy;

    public Linie() {
    }

    public Linie(int id_lini, String nazwa_linii, String typ_linii, String dni_dzialania, String godzina_rozpoczecia, String godzina_zakonczenia, String id_centrali, String id_trasy) {
        this.id_lini = id_lini;
        this.nazwa_linii = nazwa_linii;
        this.typ_linii = typ_linii;
        this.dni_dzialania = dni_dzialania;
        this.godzina_rozpoczecia = godzina_rozpoczecia;
        this.godzina_zakonczenia = godzina_zakonczenia;
        this.id_centrali = id_centrali;
        this.id_trasy = id_trasy;
    }

    @Override
    public String toString() {
        return "Linie{" +
                "id_lini=" + id_lini +
                ", nazwa_linii='" + nazwa_linii + '\'' +
                ", typ_linii='" + typ_linii + '\'' +
                ", dni_dzialania='" + dni_dzialania + '\'' +
                ", godzina_rozpoczecia='" + godzina_rozpoczecia + '\'' +
                ", godzina_zakonczenia='" + godzina_zakonczenia + '\'' +
                ", id_centrali='" + id_centrali + '\'' +
                ", id_trasy='" + id_trasy + '\'' +
                '}';
    }

    public int getId_lini() {
        return id_lini;
    }

    public void setId_lini(int id_lini) {
        this.id_lini = id_lini;
    }

    public String getNazwa_linii() {
        return nazwa_linii;
    }

    public void setNazwa_linii(String nazwa_linii) {
        this.nazwa_linii = nazwa_linii;
    }

    public String getTyp_linii() {
        return typ_linii;
    }

    public void setTyp_linii(String typ_linii) {
        this.typ_linii = typ_linii;
    }

    public String getDni_dzialania() {
        return dni_dzialania;
    }

    public void setDni_dzialania(String dni_dzialania) {
        this.dni_dzialania = dni_dzialania;
    }

    public String getGodzina_rozpoczecia() {
        return godzina_rozpoczecia;
    }

    public void setGodzina_rozpoczecia(String godzina_rozpoczecia) {
        this.godzina_rozpoczecia = godzina_rozpoczecia;
    }

    public String getGodzina_zakonczenia() {
        return godzina_zakonczenia;
    }

    public void setGodzina_zakonczenia(String godzina_zakonczenia) {
        this.godzina_zakonczenia = godzina_zakonczenia;
    }

    public String getId_centrali() {
        return id_centrali;
    }

    public void setId_centrali(String id_centrali) {
        this.id_centrali = id_centrali;
    }

    public String getId_trasy() {
        return id_trasy;
    }

    public void setId_trasy(String id_trasy) {
        this.id_trasy = id_trasy;
    }
}
