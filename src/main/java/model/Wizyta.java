package model;

import java.io.Serializable;
import java.util.*;

public class Wizyta implements Serializable {

    private static final long serialVersionUID = -1461418187899599870L;

    private Long id;

    private Pacjent pacjent;

    private Lekarz lekarz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Set<Zabieg> zabiegi = new HashSet<Zabieg>();

    private Set<Usluga> uslugi = new HashSet<Usluga>();

    private Date data;

    private String typ;

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public Set<Zabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(Set<Zabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }

    public Set<Usluga> getUslugi() {
        return uslugi;
    }

    public void setUslugi(Set<Usluga> uslugi) {
        this.uslugi = uslugi;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
