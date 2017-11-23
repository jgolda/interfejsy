package model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LEKARZE")
@PrimaryKeyJoinColumn(name = "LEK_ID", foreignKey = @ForeignKey(name = "lek_id_oso_id_fk"))
public class Lekarz extends Osoba {

    private static final long serialVersionUID = -2959770805061923284L;

    @Column(name = "LEK_SPECJALIZACJA")
    private String specjalizacja;

    @Column(name = "LEK_TYTUL_NAUKOWY")
    private String tytulNauk;

    @OneToMany(mappedBy = "lekarz")
    private Set<Wizyta> wizyty;

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

    public Set<Wizyta> getWizyty() {
        return wizyty;
    }

    public void setWizyty(Set<Wizyta> wizyty) {
        this.wizyty = wizyty;
    }
}
