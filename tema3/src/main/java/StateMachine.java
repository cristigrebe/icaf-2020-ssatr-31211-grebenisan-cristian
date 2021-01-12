
public class StateMachine extends Thread {
    Capsule capsule;

    public StateMachine(Capsule capsule) {
        this.capsule = capsule;
    }

    @Override
    public void run() {
        while (true){
            for(OutPort o: capsule.getCapsuleListOutPort()){
                int portReceiver =  o.indexInPortCommunication;
                int portSender = o.getIndex();
                int capsuleReceiver = o.indexCapsuleCommunication;
                int capsuleSender = capsule.getIndex();
                SignalOUT signalOUT = new SignalOUT(portReceiver, portSender, capsuleReceiver, capsuleSender);
                signalOUT.sendMessage();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            for(InPort i: capsule.getCapsuleListInPort()){
                int portReceiver =  i.getIndex();
                int capsuleReceiver = capsule.getIndex();
                SignalIN signalIN = new SignalIN(portReceiver, capsuleReceiver);
                signalIN.receiveMessage();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Capsule getCapsule() {
        return capsule;
    }

    public void setCapsule(Capsule capsule) {
        this.capsule = capsule;
    }
}
