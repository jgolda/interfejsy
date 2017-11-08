import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "PAC_ID", referencedColumnName = "OSO_ID")
public class Pacjent extends Osoba {

    private static final long serialVersionUID = 6164980147741689752L;

    @Column(name = "PAC_NR_KARTY_UBEZP")
    private String nrKartyUbezpieczeniowej;

    public String getNrKartyUbezpieczeniowej() {
        return nrKartyUbezpieczeniowej;
    }

    public void setNrKartyUbezpieczeniowej(String nrKartyUbezpieczeniowej) {
        this.nrKartyUbezpieczeniowej = nrKartyUbezpieczeniowej;
    }
}
