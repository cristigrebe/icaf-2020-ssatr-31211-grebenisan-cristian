package Model;

public class Capsule extends Thread {

    private String capsuleName;
    Model.State state;
    public Port inPort;
    public Port outPort;


    public Capsule(String capsuleName, Port inPort, Port outPort) {
        this.capsuleName = capsuleName;
        this.inPort = inPort;
        this.outPort = outPort;
    }

    @Override
    public void run() {
        int outValue;
        for(int i=0;i<20;i++) {
            if (Math.random() < 0.5) {
                state = Model.State.STATE_1;
            } else {
                state = Model.State.STATE_2;
            }
            int readedValue = (int) inPort.getValue();

            if (Model.State.STATE_1 == state) {
                outValue = readedValue + 10;
            } else {
                outValue = readedValue - 10;
            }
            System.out.println(capsuleName + " with state " + state + " readdedValue: " + readedValue + " outValue: " + outValue);

            outPort.setValue(outValue);
        }
    }
}
