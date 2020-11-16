import java.util.List;
import java.util.Map;

public class Entity {


    private List<Map<String, List<String>>> tranzitii;
    private List<Map<String, List<String>>> locatii;
    private String marcajInitial;
    private List<Map<String,Integer>> temporizari;

    public List<Map<String, List<String>>> getLocatii() {
        return locatii;
    }

    public void setLocatii(List<Map<String, List<String>>> locatii) {
        this.locatii = locatii;
    }

    public String getMarcajInitial() {
        return marcajInitial;
    }

    public void setMarcajInitial(String marcajInitial) {
        this.marcajInitial = marcajInitial;
    }

    public List<Map<String, Integer>> getTemporizari() {
        return temporizari;
    }

    public void setTemporizari(List<Map<String, Integer>> temporizari) {
        this.temporizari = temporizari;
    }

    public List<Map<String, List<String>>> getTranzitii() {
        return tranzitii;
    }

    public void setTranzitii(List<Map<String, List<String>>> tranzitii) {
        this.tranzitii = tranzitii;
    }
}
