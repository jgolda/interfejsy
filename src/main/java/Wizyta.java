import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WIZYTY")
@SequenceGenerator(name = "SEQ_WIZ_ID", sequenceName = "SEQ_WIZ_ID")
public class Wizyta implements Serializable {

    private static final long serialVersionUID = -1461418187899599870L;

    @Id
    @Column(name = "WIZ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WIZ_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "WIZ_PAC_ID", referencedColumnName = "PAC_ID")
    private Pacjent pacjent;

    @ManyToOne
    @JoinColumn(name = "WIZ_LEK_ID", referencedColumnName = "LEK_ID")
    private Lekarz lekarz;

    @OneToMany(mappedBy = "wizyta", cascade = CascadeType.PERSIST)
    private List<Zabieg> zabiegi = new ArrayList<Zabieg>();

    @OneToMany(mappedBy = "wizyta", cascade = CascadeType.PERSIST)
    private List<Usluga> uslugi = new ArrayList<Usluga>();

    @Column(name = "WIZ_DATA")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "WIZ_TYP")
    private String typ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Zabieg> getZabiegi() {
        return zabiegi;
    }

    public void setZabiegi(List<Zabieg> zabiegi) {
        this.zabiegi = zabiegi;
    }

    public List<Usluga> getUslugi() {
        return uslugi;
    }

    public void setUslugi(List<Usluga> uslugi) {
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
