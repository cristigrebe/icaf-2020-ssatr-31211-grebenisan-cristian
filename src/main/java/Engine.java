import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Engine {

    public static void start() throws IOException {
        InitPetriNet.initPN();
        List<Locatie> locatii = InitPetriNet.locatii;
        List<Tranzitie> tranzitii= InitPetriNet.tranzitii;

        FileWriter fileWriter = new FileWriter("Out.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        Marcaj m1 = new Marcaj(locatii.size());
        m1.marcaj[Integer.parseInt(InitPetriNet.marcajInitial.substring(1))]++; // marcaj initial

        List<Marcaj> marcaje = new ArrayList<Marcaj>();
        marcaje.add(m1);


            for(Locatie l:locatii){
                if(l.getListTranzitii()!=null){
                    for(Tranzitie t: l.getListTranzitii()){
                        for(Tranzitie tranzitie:tranzitii){
                            if(t.getName().equals(tranzitie.getName()) && tranzitie.getLocatiiList()!=null ){
                                for(Locatie locatie:tranzitie.getLocatiiList()){

                                    Marcaj m = new Marcaj(locatii.size());
                                    m.marcaj[Integer.parseInt(locatie.getName().substring(1))] ++;
                                   marcaje.add(m);
                                }

                            }
                        }
                    }
                }
            }

        String result ="";
        printWriter.println("P1 P2 P3 P4");
        for(Marcaj m : marcaje){
            for(int i =0;i<m.marcaj.length;i++){

                result+=(m.marcaj[i]+"  ");

       }
            System.out.println(result);


            printWriter.println(result);

            result="";

        }

        printWriter.close();

    }

}
