public class InPort {
    int index;
    int indexOutPortCommunication;
    int indexCapsuleCommunication;

    public InPort(int index, int indexOutPortCommunication, int indexCapsuleCommunication) {
        this.index = index;
        this.indexOutPortCommunication = indexOutPortCommunication;
        this.indexCapsuleCommunication = indexCapsuleCommunication;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexOutPortCommunication() {
        return indexOutPortCommunication;
    }

    public void setIndexOutPortCommunication(int indexOutPortCommunication) {
        this.indexOutPortCommunication = indexOutPortCommunication;
    }

    public int getIndexCapsuleCommunication() {
        return indexCapsuleCommunication;
    }

    public void setIndexCapsuleCommunication(int indexCapsuleCommunication) {
        this.indexCapsuleCommunication = indexCapsuleCommunication;
    }
}
