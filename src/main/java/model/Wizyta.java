package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "WIZYTY")
public class Wizyta implements Serializable {

    private static final long serialVersionUID = -1461418187899599870L;

    @Id
    @Column(name = "WIZ_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "WIZ_PAC_ID", foreignKey = @ForeignKey(name = "wiz_pac_id_fk"))
    private Pacjent pacjent;

    @ManyToOne
    @JoinColumn(name = "WIZ_LEK_ID", foreignKey = @ForeignKey(name = "wiz_lek_id_fk"))
    private Lekarz lekarz;

    @OneToMany(mappedBy = "wizyta")
    private Set<Zabieg> zabiegi = new HashSet<Zabieg>();

    @OneToMany(mappedBy = "wizyta")
    private Set<Usluga> uslugi = new HashSet<Usluga>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "WIZ_DATA")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "WIZ_TYP")
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
