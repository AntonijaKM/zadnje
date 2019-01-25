package ba.sum.fpmoz.wineshop.model;

public class Wine {
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

    public Integer getCijena() {
        return cijena;
    }

    public void setCijena(Integer cijena) {
        this.cijena = cijena;
    }

    public String naziv;
    public String opis;
    public String slika;
    public Integer cijena;

    public Wine() {
    }

    public Wine(String naziv, String opis, String slika) {
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
        this.cijena = cijena;
    }
}
