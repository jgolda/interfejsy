package model;

import java.util.List;
import java.util.Set;

public class Lekarz extends Osoba {

    private static final long serialVersionUID = -2959770805061923284L;

    private String specjalizacja;

    private String tytulNauk;

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
