import java.util.List;

public class Tranzitie {

    private Integer temporizare;
    private List<Locatie> locatiiList;
    private String name;

    public String getName() {
        return name;
    }

    public Tranzitie() {
    }

    public Tranzitie(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTemporizare() {
        return temporizare;
    }

    public void setTemporizare(Integer temporizare) {
        this.temporizare = temporizare;
    }

    public List<Locatie> getLocatiiList() {
        return locatiiList;
    }

    public void setLocatiiList(List<Locatie> locatiiList) {
        this.locatiiList = locatiiList;
    }
}
