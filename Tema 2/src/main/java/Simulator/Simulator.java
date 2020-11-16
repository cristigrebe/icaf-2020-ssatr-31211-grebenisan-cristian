package Simulator;

import Model.Capsule;
import Model.Port;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    public static void main(String[] args) {
        List<Capsule> capsules = new ArrayList<>();
        Port p0 = new Port("P0");
        Port p1 = new Port("P1");
        capsules.add(new Capsule("Capsule 0", p0, p1));
        capsules.add(new Capsule("Capsule 1", p1, p0));
        capsules.forEach(c -> c.start());
        capsules.forEach(System.out::println);
    }
}