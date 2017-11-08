import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADRESY")
@SequenceGenerator(name = "SEQ_ADR_ID", sequenceName = "SEQ_ADR_ID")
public class Adres implements Serializable {

    private static final long serialVersionUID = -8234678507231456918L;

    @Id
    @Column(name = "ADR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADR_ID")
    private Long id;

    @Column(name = "ADR_KOD")
    private String kod;

    @Column(name = "ADR_MIEJSCOWOSC")
    private String miejscowosc;

    @Column(name = "ADR_ULICA")
    private String ulica;

    @Column(name = "ADR_NR_DOMU")
    private Integer nrDomu;

    @Column(name = "ADR_NR_MIESZKANIA")
    private Integer nrMieszkania;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    public Integer getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(Integer nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }
}
