package net.agten.heatersimulator.domain.algorithm;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class FuzzyController implements ControllerAlgorithm{

    public final static int MAX_RESULT = 255;
    private final int outputDivisor;
    private int pGain;
    private int iGain;
    private int dGain;
    private int targetAdc;
    private int iState = 0;
    private int lastAdc = 1024;

    public FuzzyController(int outputDivisor, int pGain, int iGain, int dGain) {
        this.outputDivisor = outputDivisor;
        this.pGain = pGain;
        this.iGain = iGain;
        this.dGain = dGain;
    }

    @Override
    public short nextValue(short curAdc) {
        String filename = "C:\\Users\\crist\\Desktop\\SSTR FInal\\tema4\\src\\net\\agten\\" +
                "heatersimulator\\fuzzy.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("temp_now", curAdc);
        fb.setVariable("temp_target", this.targetAdc);
        // Evaluate
        fb.evaluate();

        double result = fb.getVariable("power").getValue();
        return (short) result;
    }

    @Override
    public void setTargetAdc(short targetAdc) {
        this.targetAdc = targetAdc;
    }
}
