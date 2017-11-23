package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CENNIK")
public class Cennik implements Serializable {

    private static final long serialVersionUID = 5819866421684062813L;

    @Id
    @Column(name = "CEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CEN_KWOTA")
    private Double kwota;

    @Column(name = "CEN_OPIS")
    private String opis;

    @OneToMany(mappedBy = "cennik")
    private Set<Usluga> uslugi = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Usluga> getUslugi() {
        return uslugi;
    }

    public void setUslugi(Set<Usluga> uslugi) {
        this.uslugi = uslugi;
    }
}
