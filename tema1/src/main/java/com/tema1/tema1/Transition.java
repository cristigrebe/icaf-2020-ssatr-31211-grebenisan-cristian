package com.tema1.tema1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Transition {
    private int id;
    private int tmin;
    private int tmax;
    private int [] input;
    private int [] output;

    public Transition(int id, int tmin, int tmax, int [] input, int [] output){
        this.id=id;
        this.tmin=tmin;
        this.tmax=tmax;
        this.input=input;
        this.output=output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTmin() {
        return tmin;
    }

    public void setTmin(int tmin) {
        this.tmin = tmin;
    }

    public int getTmax() {
        return tmax;
    }

    public void setTmax(int tmax) {
        this.tmax = tmax;
    }

    public int[] getInput() {
        return input;
    }

    public void setInput(int[] input) {
        this.input = input;
    }

    public int[] getOutput() {
        return output;
    }

    public void setOutput(int[] output) {
        this.output = output;
    }


    @Override
    public String toString(){
        return "Transition { id = " + id + ", input = " + Arrays.toString(input) +
                " , output = " + Arrays.toString(output) + " , tmin = " + tmin + ", tmax = " + tmax + "} ";

    }
}
