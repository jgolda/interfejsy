import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OSOBY")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "SEQ_OSO_ID", sequenceName = "SEQ_OSO_ID")
public abstract class Osoba implements Serializable {

    private static final long serialVersionUID = 2833828861729461910L;

    @Id
    @Column(name = "OSO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OSO_ID")
    private Long id;

    @Column(name = "OSO_IMIE")
    private String imie;

    @Column(name = "OSO_NAZWISKO")
    private String nazwisko;

    @Column(name = "OSO_PESEL")
    private String pesel;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EMP_ADR_ID", referencedColumnName = "ADR_ID")
    private Adres adres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
