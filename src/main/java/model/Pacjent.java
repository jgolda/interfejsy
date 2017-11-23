package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PACJENCI")
@PrimaryKeyJoinColumn(name = "PAC_ID")
public class Pacjent extends Osoba {

    private static final long serialVersionUID = 6164980147741689752L;

    @Column(name = "PAC_NR_KARTY_UBEZP")
    private String nrKartyUbezpieczeniowej;

    @OneToMany(mappedBy = "pacjent")
    private Set<Wizyta> wizyty = new HashSet<>();

    public String getNrKartyUbezpieczeniowej() {
        return nrKartyUbezpieczeniowej;
    }

    public void setNrKartyUbezpieczeniowej(String nrKartyUbezpieczeniowej) {
        this.nrKartyUbezpieczeniowej = nrKartyUbezpieczeniowej;
    }

    public Set<Wizyta> getWizyty() {
        return wizyty;
    }

    public void setWizyty(Set<Wizyta> wizyty) {
        this.wizyty = wizyty;
    }
}
