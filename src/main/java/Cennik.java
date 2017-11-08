import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CENNIKI")
@SequenceGenerator(name = "SEQ_CEN_ID", sequenceName = "SEQ_CEN_ID")
public class Cennik implements Serializable {

    private static final long serialVersionUID = 5819866421684062813L;

    @Id
    @Column(name = "CEN_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CEN_ID")
    private Long id;

    @Column(name = "CEN_KWOTA")
    private Double kwota;

    @Column(name = "CEN_OPIS")
    private String opis;

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
}
