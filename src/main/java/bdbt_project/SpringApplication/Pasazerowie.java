package bdbt_project.SpringApplication;

public class Pasazerowie {
    private int id_pasazera;
    private String imie;
    private String nazwisko;
    private String nr_telefonu;
    private String email;
    private String login;
    private String haslo;

    public Pasazerowie(){
    }

    public Pasazerowie(int id_pasazera, String imie, String nazwisko, String nr_telefonu, String email, String login, String haslo) {
        this.id_pasazera = id_pasazera;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "Pasazerowie{" +
                "id_pasazera=" + id_pasazera +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + nr_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }

    public int getId_pasazera() {
        return id_pasazera;
    }

    public void setId_pasazera(int id_pasazera) {
        this.id_pasazera = id_pasazera;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
