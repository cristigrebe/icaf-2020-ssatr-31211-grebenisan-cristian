
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[])throws Exception {
        List<Capsule> listCapsule = new ArrayList<>();
        int[] inPorts;
        int[] outPorts;

        String jsonContent = new String(Files.readAllBytes(Paths.get("datas.json")));
        JSONObject jsonObject = new JSONObject(jsonContent);
        JSONArray jsonCapsule = jsonObject.getJSONArray("capsules");

        for(int i=0; i< jsonCapsule.length(); i++){
            // aici se vor pune porturile de intrare  pentru capsula curenta
            List<InPort> listInPort = new ArrayList<>();
            // aici se vor pune porturile de iesire pentru capsula curenta
            List<OutPort> listOutPort = new ArrayList<>();
            // aici se vor pune porturile de intrare pentru fiecare capsula si anume fiecare index
            inPorts = new int[jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("inPort").length()];
            // aici se vor pune porturile de iesire pentru fiecare capsula si anume fiecare index
            outPorts = new int[jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("outPort").length()];

            //  se parcurge vectorul porturilor de intrare, se ia fiecare valoare din vector si se cauta portul de iesire pt portul de intrare curent,
            // precum si indexul capsulei din care face parte portul de iesire, creandu-se astfel un port IN cu parametrii respectivi
            for(int j =0; j< jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("inPort").length(); j++){
                inPorts[j] = jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("inPort").getInt(j);
                String currentIndexPort = Integer.toString(jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("inPort").getInt(j));
                int indexOutPortCommunication;
                for(int k=0; k<jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").length();k++){
                    if(!jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").getJSONObject(k).
                            getJSONObject("communication").getJSONObject("inPortRel").isEmpty()){
                        try{
                            indexOutPortCommunication= jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").getJSONObject(k).
                                    getJSONObject("communication").getJSONObject("inPortRel").getInt(currentIndexPort);

                            int indexCapsuleCommunication = jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").getJSONObject(k).
                                    getJSONObject("communication").getInt("index");
                            InPort inPort = new InPort(inPorts[j], indexOutPortCommunication, indexCapsuleCommunication);
                            listInPort.add(inPort);

                        }catch (JSONException exception){
                            exception.getMessage();
                        }
                    }
                }
            }

            //  se parcurge vectorul porturilor de iesire, se ia fiecare valoare din vector si se cauta portul de intrare pt portul de iesire curent,
            // precum si indexul capsulei din care face parte portul de intrare, creandu-se astfel un port OUT cu parametrii respectivi
            for(int j =0; j< jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("outPort").length(); j++){
                outPorts[j] = jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("outPort").getInt(j);
                String currentIndexPort = Integer.toString(jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("outPort").getInt(j));
                int indexInPortCommunication;
                for(int k=0; k<jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").length();k++){
                    if(!jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").getJSONObject(k).
                            getJSONObject("communication").getJSONObject("outPortRel").isEmpty()){
                        try{
                            indexInPortCommunication= jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").getJSONObject(k).
                                    getJSONObject("communication").getJSONObject("outPortRel").getInt(currentIndexPort);
                            int indexCapsuleCommunication = jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").getJSONObject(k).
                                    getJSONObject("communication").getInt("index");
                            OutPort outPort = new OutPort(outPorts[j], indexInPortCommunication, indexCapsuleCommunication);
                            listOutPort.add(outPort);

                        }catch(JSONException exception){
                            exception.getMessage();
                        }
                    }
                }
            }

            //  se iau comunicatiile intre capsule (capsula curenta cu ce capsule comunica)
            int[] communicationsIndex = new int[jsonCapsule.getJSONObject(i).getJSONObject("capsule").
                    getJSONArray("communications").length()];
            for(int j=0; j<jsonCapsule.getJSONObject(i).getJSONObject("capsule").getJSONArray("communications").length(); j++){
                communicationsIndex[j] = jsonCapsule.getJSONObject(i).getJSONObject("capsule").
                        getJSONArray("communications").getJSONObject(j).getJSONObject("communication").getInt("index");
            }

            Capsule capsule = new Capsule(jsonCapsule.getJSONObject(i).getJSONObject("capsule").getInt("index"),
                    inPorts.length, outPorts.length, listInPort, listOutPort, communicationsIndex);
            listCapsule.add(capsule);
        }

        for(Capsule c: listCapsule){
            StateMachine stateMachine = new StateMachine(c);
            stateMachine.start();
        }
    }
}
