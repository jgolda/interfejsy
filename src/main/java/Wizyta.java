import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private List<Zabieg> zabiegi = new ArrayList<Zabieg>();

    private List<Usluga> uslugi = new ArrayList<Usluga>();

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
