package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pacjent extends Osoba {

    private static final long serialVersionUID = 6164980147741689752L;

    private String nrKartyUbezpieczeniowej;

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
