package com.linden.deal;

import java.util.ArrayList;
import java.util.List;

public class GameSetup {

    /**
     * Returns a List of all the possible case values from .01 to 1,000,000.
     *
     * @return  List of Double values
     */
    public static List<Double> getValues() {
        List<Double> caseValues = new ArrayList<>();
        caseValues.add(.01D);  // the D tells java that is a Double value
        caseValues.add(1D);
        caseValues.add(5D);
        caseValues.add(10D);
        caseValues.add(25D);
        caseValues.add(50D);
        caseValues.add(75D);
        caseValues.add(100D);
        caseValues.add(200D);
        caseValues.add(300D);
        caseValues.add(400D);
        caseValues.add(500D);
        caseValues.add(750D);
        caseValues.add(1000D);
        caseValues.add(5000D);
        caseValues.add(10000D);
        caseValues.add(25000D);
        caseValues.add(50000D);
        caseValues.add(75000D);
        caseValues.add(100000D);
        caseValues.add(200000D);
        caseValues.add(300000D);
        caseValues.add(400000D);
        caseValues.add(500000D);
        caseValues.add(750000D);
        caseValues.add(1000000D);
        return caseValues;
    }
}
