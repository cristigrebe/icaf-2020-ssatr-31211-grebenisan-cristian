import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SignalIN {
    int portReceiver;
    int capsuleReceiver;

    public SignalIN(int portReceiver, int capsuleReceiver) {
        this.portReceiver = portReceiver;
        this.capsuleReceiver = capsuleReceiver;
    }

    public void receiveMessage(){
        String FILENAME = "E:\\FACULTATE\\MASTER\\AN1\\SEM1\\SSTR\\tema2\\output\\capsula"+capsuleReceiver+"port"+ portReceiver +".txt";
        File file = new File(FILENAME);
        if(file.exists()){
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()){
                    System.out.println("S-a primit: " +sc.nextLine());
                }
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Inca nu s-a trimis nici un mesaj la capsula " + capsuleReceiver + " portul de intrare " + portReceiver);
        }
    }

    public int getPortReceiver() {
        return portReceiver;
    }

    public void setPortReceiver(int portReceiver) {
        this.portReceiver = portReceiver;
    }

    public int getCapsuleReceiver() {
        return capsuleReceiver;
    }

    public void setCapsuleReceiver(int capsuleReceiver) {
        this.capsuleReceiver = capsuleReceiver;
    }
}
