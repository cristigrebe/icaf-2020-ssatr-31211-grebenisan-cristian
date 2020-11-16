import java.util.List;

public class Locatie {

    private Integer capacitate;
    private List<Tranzitie> listTranzitii;
    private String name;

    public Locatie(String name) {
        this.name = name;
    }

    public Locatie(Integer capacitate) {
        this.capacitate = capacitate;
    }

    public Locatie() {
    }

    public Integer getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        this.capacitate = capacitate;
    }

    public List<Tranzitie> getListTranzitii() {
        return listTranzitii;
    }

    public void setListTranzitii(List<Tranzitie> listTranzitii) {
        this.listTranzitii = listTranzitii;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
