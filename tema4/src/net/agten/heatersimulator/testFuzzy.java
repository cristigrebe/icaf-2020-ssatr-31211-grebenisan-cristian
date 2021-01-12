package net.agten.heatersimulator;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class testFuzzy {
    public static void main(String[] args) throws Exception {
        String filename = "E:\\FACULTATE\\MASTER\\AN1\\SEM1\\SSTR\\tema4\\src\\net\\agten\\heatersimulator\\fuzzy.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("temp_now", -60.0);
        fb.setVariable("temp_target", 70.0);
        // Evaluate
        fb.evaluate();

        System.out.println(fb);
        System.out.println("Power: " + fb.getVariable("power").getValue());

        // Show output variable's chart
        fb.getVariable("power").defuzzify();

        JFuzzyChart.get().chart(fb);

        // Print ruleSet
        System.out.println(fb);
        System.out.println("Power: " + fb.getVariable("power").getValue());

    }
}
