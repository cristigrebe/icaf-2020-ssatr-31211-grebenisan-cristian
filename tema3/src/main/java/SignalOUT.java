import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class SignalOUT {
    int portReceiver;
    int portSender;
    int capsuleReceiver;
    int capsuleSender;


    public SignalOUT(int portReceiver, int portSender, int capsuleReceiver, int capsuleSender) {
        this.portReceiver = portReceiver;
        this.portSender = portSender;
        this.capsuleReceiver = capsuleReceiver;
        this.capsuleSender = capsuleSender;
    }

    public  void sendMessage(){
        String FILENAME = "C:\\Users\\crist\\Desktop\\SSTR FInal\\tema3\\output\\capsula"+capsuleReceiver+"port"+ portReceiver +".txt";
        String content = "Mesaj de la portul de iesire " + portSender + " din capsula " +capsuleSender +
                " la portul de intrare " +portReceiver + " din capsula " + capsuleReceiver + "\r\n";
        System.out.print("Se trimite: " + content);
        try {
            Files.write(Paths.get(FILENAME), content.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPortReceiver() {
        return portReceiver;
    }

    public void setPortReceiver(int portReceiver) {
        this.portReceiver = portReceiver;
    }

    public int getPortSender() {
        return portSender;
    }

    public void setPortSender(int portSender) {
        this.portSender = portSender;
    }

    public int getCapsuleReceiver() {
        return capsuleReceiver;
    }

    public void setCapsuleReceiver(int capsuleReceiver) {
        this.capsuleReceiver = capsuleReceiver;
    }

    public int getCapsuleSender() {
        return capsuleSender;
    }

    public void setCapsuleSender(int capsuleSender) {
        this.capsuleSender = capsuleSender;
    }
}
