import java.io.Serializable;

public class Cennik implements Serializable {

    private static final long serialVersionUID = 5819866421684062813L;

    private Long id;

    private Double kwota;

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
