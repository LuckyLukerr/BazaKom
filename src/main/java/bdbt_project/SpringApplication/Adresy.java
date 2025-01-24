package bdbt_project.SpringApplication;

public class Adresy {
    private int id_adresu;
    private String miasto;
    private String ulica;
    private String kod_pocztowy;
    private String nr_lokalu;

    public Adresy() {
    }

    public Adresy(int id_adresu, String miasto, String ulica, String kod_pocztowy, String nr_lokalu) {
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kod_pocztowy = kod_pocztowy;
        this.nr_lokalu = nr_lokalu;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "id_adresu=" + id_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                ", nr_domu='" + nr_lokalu + '\'' +
                '}';
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_domu) {
        this.nr_lokalu = nr_domu;
    }
}
