import java.io.Serializable;

public class Zabieg implements Serializable {

    private static final long serialVersionUID = 8945600723324911353L;

    private Long id;

    private String nrZeba;

    private String opis;

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
