package model;

import java.util.List;

public class Lekarz extends Osoba {

    private static final long serialVersionUID = -2959770805061923284L;

    private String specjalizacja;

    private String tytulNauk;

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
