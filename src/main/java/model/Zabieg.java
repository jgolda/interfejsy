package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ZABIEGI")
public class Zabieg implements Serializable {

    private static final long serialVersionUID = 8945600723324911353L;

    @Id
    @Column(name = "ZAB_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "ZAB_NR_ZEBA")
    private String nrZeba;

    @Column(name = "ZAB_OPIS")
    private String opis;

    @ManyToOne
    @JoinColumn(name = "ZAB_WIZ_ID", foreignKey = @ForeignKey(name = "zab_wiz_id_fk"))
    private Wizyta wizyta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrZeba() {
        return nrZeba;
    }

    public void setNrZeba(String nrZeba) {
        this.nrZeba = nrZeba;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }
}
