import java.util.List;

public class Capsule {
    public int index;
    public int nrInPort;
    public int nrOutPort;
    public List<InPort> capsuleListInPort;
    public List<OutPort> capsuleListOutPort;
    public int[] communicationsIndex;

    public Capsule(int index, int nrInPort, int nrOutPort, List<InPort> capsuleListInPort, List<OutPort> capsuleListOutPort,
                   int[] communicationsIndex) {
        this.index = index;
        this.nrInPort = nrInPort;
        this.nrOutPort = nrOutPort;
        this.capsuleListInPort = capsuleListInPort;
        this.capsuleListOutPort = capsuleListOutPort;
        this.communicationsIndex = communicationsIndex;
        System.out.println("\r\n"+"S-a creat  capsula " + index+" cu " + nrInPort + " intrari si "+ nrOutPort + " iesiri");

        System.out.print("Capsula " + index + " comunica cu capsula " );
        for(int i=0; i<communicationsIndex.length; i++){
            System.out.print(communicationsIndex[i] + " ");
        }

        System.out.println("\r\n"+"Porturile de intrare: ");
        if(capsuleListInPort.isEmpty()){
            System.out.print(" -> Nu exista porturi de intrare!");
        } else {
            for(InPort i: capsuleListInPort){
                System.out.println(" -> Portul "+i.getIndex() + " IN care comunica cu portul " + i.getIndexOutPortCommunication() +
                        " OUT din capsula "+ i.getIndexCapsuleCommunication());
            }
        }

        System.out.println("\r\n"+"Porturile de iesire: ");
        if(capsuleListOutPort.isEmpty()){
            System.out.print(" -> Nu exista porturi de iesire!");
        } else {
            for(OutPort o: capsuleListOutPort){
                System.out.println(" -> Portul "+o.getIndex() + " OUT care comunica cu portul " + o.getIndexInPortCommunication() +
                        " IN din capsula "+ o.getIndexCapsuleCommunication());
            }
        }
        System.out.println("\r\n");
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNrInPort() {
        return nrInPort;
    }

    public void setNrInPort(int nrInPort) {
        this.nrInPort = nrInPort;
    }

    public int getNrOutPort() {
        return nrOutPort;
    }

    public void setNrOutPort(int nrOutPort) {
        this.nrOutPort = nrOutPort;
    }

    public List<InPort> getCapsuleListInPort() {
        return capsuleListInPort;
    }

    public void setCapsuleListInPort(List<InPort> capsuleListInPort) {
        this.capsuleListInPort = capsuleListInPort;
    }

    public List<OutPort> getCapsuleListOutPort() {
        return capsuleListOutPort;
    }

    public void setCapsuleListOutPort(List<OutPort> capsuleListOutPort) {
        this.capsuleListOutPort = capsuleListOutPort;
    }

}
