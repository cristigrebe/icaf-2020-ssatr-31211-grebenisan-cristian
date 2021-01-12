public class OutPort {
    int index;
    int indexInPortCommunication;
    int indexCapsuleCommunication;

    public OutPort(int index, int indexInPortCommunication,int indexCapsuleCommunication ) {
        this.index = index;
        this.indexInPortCommunication = indexInPortCommunication;
        this.indexCapsuleCommunication = indexCapsuleCommunication;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexInPortCommunication() {
        return indexInPortCommunication;
    }

    public void setIndexInPortCommunication(int indexInPortCommunication) {
        this.indexInPortCommunication = indexInPortCommunication;
    }

    public int getIndexCapsuleCommunication() {
        return indexCapsuleCommunication;
    }

    public void setIndexCapsuleCommunication(int indexCapsuleCommunication) {
        this.indexCapsuleCommunication = indexCapsuleCommunication;
    }
}
