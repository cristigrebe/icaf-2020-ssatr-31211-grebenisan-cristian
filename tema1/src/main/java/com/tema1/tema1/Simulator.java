package com.tema1.tema1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {
    List<Location> locations;
    List<Transition> transitions;
    List<Location> initialState;
    int nrOfTransitionsThatCanBeExecuted;
    List<Transition> transitionsThatCanBeExecuted;
    boolean deadlock = false;
    boolean backToInitialState = false;
    int time = 0;
    private static final String FILENAME = "C:\\Users\\crist\\Desktop\\SSTR FInal\\tema1\\result\\result.txt";

    public Simulator(List<Location> locations, List<Transition> transitions) {
        this.locations = locations;
        this.transitions = transitions;
        initialState = new ArrayList<>(locations.size());
        initialState = getInitialState(locations);
    }

    public void executeSimulation(){
        //write in the file the locations of given petri net
        String initialContent ="\r\n" + "Time " +time +  " => Locations: " + locations.toString() + "\r\n" + "\r\n";
        try {
            Files.write(Paths.get(FILENAME), initialContent.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!deadlock  && !backToInitialState && time < transitions.size()) {
            time ++;
            //initialize the transitions that can be executed at every moment of time
            nrOfTransitionsThatCanBeExecuted =0;
            transitionsThatCanBeExecuted = new ArrayList<>();
            checkForTransitionThatCanBeExecuted(transitions);

            if(nrOfTransitionsThatCanBeExecuted == 0){
                System.out.println("Nici o tranzitie nu se poate executa =>  DEADLOCK!");
                //write in the file that petri net is in deadlock
                String deadlockContent = "DEADLOCK!" + "\r\n";
                try {
                    Files.write(Paths.get(FILENAME), deadlockContent.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                deadlock=true;
                return ;
            }

            if(nrOfTransitionsThatCanBeExecuted >= 1) {
                System.out.println("Se pot executa " + nrOfTransitionsThatCanBeExecuted + " tranzitii!");
                for(Transition t: transitionsThatCanBeExecuted){
                    //verify again if the transition can be executed because after a transition is executed another one
                    // can become not executable
                    if(checkIfTransitionCanBeExecuted(t.getInput())){
                        executeTransition(t.getInput(), t.getOutput(), t.getTmin(),  t.getTmax());
                        System.out.println("Tranzitia " +t.getId() + " a fost executata!");

                        // write in the file after execution
                        String content = "Time " +time +  " => Locations: " + locations.toString() + "\r\n" + "\r\n";
                        try {
                            Files.write(Paths.get(FILENAME), content.getBytes(), StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //after execution verify if petri net is in initial state
                        if(initialState.toString().contentEquals(locations.toString())){
                            System.out.println("S-a ajuns la starea initiala");
                            //write in the file that petri net is in initial state
                            String backToInitialStateContent = "S-a ajuns din nou la starea initiala!" + "\r\n";
                            try {
                                Files.write(Paths.get(FILENAME), backToInitialStateContent.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            backToInitialState = true;
                            return;
                        }
                    } else {
                        System.out.println("Tranzitia " + t.getId() + " nu mai poate fi executata");
                    }
                }
            }
        }

    }

    //get the initial state
    private List<Location> getInitialState(List<Location> locations) {
        List<Location> initialLocations = new ArrayList<>();
        for (Location l : locations) {
            Location location = new Location(l.getId(), l.getToken());
            initialLocations.add(location);
        }
        return initialLocations;
    }

    //verify for transitions that can be executed
    private void checkForTransitionThatCanBeExecuted(List<Transition> transitions){
        for(Transition t: transitions) {
            if(checkIfTransitionCanBeExecuted(t.getInput())) {
                System.out.println("Tranzitia " + t.getId()+" poate fi executata!");
                nrOfTransitionsThatCanBeExecuted = nrOfTransitionsThatCanBeExecuted +1;
                transitionsThatCanBeExecuted.add(t);
            }
        }
    }

    //verify if transition can be executed
    private boolean checkIfTransitionCanBeExecuted(int[] input){
        for(int i: input){
            for(Location l : locations){
                if(i == l.getId()){
                    if(l.getToken() == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //execute transition
    private void executeTransition(int[] input, int[] output, int tmin, int tmax) {
        int timer ;
        //get the input tokens
        for (int i : input) {
            for (Location l : locations) {
                if (l.getId() == i) {
                    l.nrOfTokensExit();
                }
            }
        }

        // temporization => counter
        if(tmin == tmax) {
            timer = tmin;
        } else {
            timer = (new Random()).nextInt(tmax - tmin +1) +tmin;
        }

        while (timer != 0){
            timer --;
        }

        //put the output tokens
        for (int i : output) {
            for (Location l : locations) {
                if (l.getId() == i) {
                    l.nrOfTokensEnter();
                }
            }
        }
    }


}
