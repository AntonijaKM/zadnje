package ba.sum.fpmoz.wineshop.model;

public class Wine {
    private String naziv;
    private String opis;
    private String slika;
    private Float cijena;

    public Wine() {
    }

    public Wine(String naziv, String opis, String slika, Float cijena) {
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public Float getCijena() {
        return cijena;
    }

    public void setCijena(Float cijena) {
        this.cijena = cijena;
    }
}
