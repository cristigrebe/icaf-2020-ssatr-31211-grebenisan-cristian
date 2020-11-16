import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InitPetriNet {

    public static List<Locatie> locatii= new ArrayList<Locatie>();
    public static List<Tranzitie> tranzitii= new ArrayList<Tranzitie>();
    public static String marcajInitial ;

       public static void initPN() throws IOException {

           ObjectMapper mapper = new ObjectMapper();
           Entity entity = mapper.readValue(new File("E:\\IdeaProjects\\Tema1\\Fisier"),Entity.class);



           for(Map<String, List<String>> sx : entity.getTranzitii()){

               for( String str : sx.keySet()){

                   Tranzitie tranzitie = new Tranzitie();
                   List<Locatie> locatiiList= new ArrayList<Locatie>();
                   tranzitie.setName(str);

                   for(String ss : sx.get(str)){
                       locatiiList.add(new Locatie(ss));
                   }
                   tranzitie.setLocatiiList(locatiiList);
                   tranzitii.add(tranzitie);

               }
           }

           for(Map<String,List<String>> sx : entity.getLocatii()){

               for( String str : sx.keySet()){
                    Locatie locatie = new Locatie();
                    List<Tranzitie> tranzitiiList = new ArrayList<Tranzitie>();
                    locatie.setName(str);
                   for(String ss : sx.get(str)){
                       tranzitiiList.add(new Tranzitie(ss));
                   }
                   locatie.setListTranzitii(tranzitiiList);
                   locatii.add(locatie);

               }


           }

           for(Map<String,Integer> t: entity.getTemporizari()){
               for( String str : t.keySet()){
                   for(Locatie l: locatii){
                       for(Tranzitie tr :l.getListTranzitii()){
                           if(str.equals(tr.getName())){
                               tr.setTemporizare(t.get(str));
                           }
                       }
                   }


               }
           }
           marcajInitial= entity.getMarcajInitial();
           //System.out.println(marcajInitial);



//           for(Locatie l : locatii){
//               System.out.print(l.getName()+":");
//               for(Tranzitie t : l.getListTranzitii()){
//                   System.out.println(t.getName()+" "+t.getTemporizare());
//               }
//           }
//
//           for(Tranzitie t : tranzitii){
//               System.out.print(t.getName()+":");
//               for(Locatie l : t.getLocatiiList()){
//                   System.out.println(l.getName()+" "+l.getCapacitate());
//               }
//           }
       }

}
