package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USLUGI")
public class Usluga implements Serializable {

    private static final long serialVersionUID = -5795062461768031102L;

    @Id
    @Column(name = "USL_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USL_CEN_ID")
    private Cennik cennik;

    @ManyToOne
    @JoinColumn(name = "USL_WIZ_ID")
    private Wizyta wizyta;

    @Column(name = "USL_CENA")
    private Double cena;

    @Column(name = "USL_OPIS")
    private String opis;

    @Column(name = "USL_RABAT")
    private Double rabat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cennik getCennik() {
        return cennik;
    }

    public void setCennik(Cennik cennik) {
        this.cennik = cennik;
    }

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getRabat() {
        return rabat;
    }

    public void setRabat(Double rabat) {
        this.rabat = rabat;
    }
}
