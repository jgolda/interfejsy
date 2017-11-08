import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "LEK_ID", referencedColumnName = "OSO_ID")
public class Lekarz extends Osoba {

    private static final long serialVersionUID = -2959770805061923284L;

    @Column(name = "LEK_SPECJALIZACJA")
    private String specjalizacja;

    @Column(name = "LEK_TYTUL_NAUK")
    private String tytulNauk;

    @OneToMany(mappedBy = "lekarz")
    private List<Wizyta> wizyty;


    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public String getTytulNauk() {
        return tytulNauk;
    }

    public void setTytulNauk(String tytulNauk) {
        this.tytulNauk = tytulNauk;
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }

    public void setWizyty(List<Wizyta> wizyty) {
        this.wizyty = wizyty;
    }
}
