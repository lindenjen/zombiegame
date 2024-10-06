package com.linden.deal;

public class BriefCase {
    private int caseNumber;
    private double caseValue;
    private boolean opened = false;
    private boolean myCase = false;

    public BriefCase() {

    }

    public BriefCase(int caseNumber, double caseValue) {
        this.caseNumber = caseNumber;
        this.caseValue = caseValue;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public double getCaseValue() {
        return caseValue;
    }

    public void setCaseValue(double caseValue) {
        this.caseValue = caseValue;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean isMyCase() {
        return myCase;
    }

    public void setMyCase(boolean myCase) {
        this.myCase = myCase;
    }

    @Override
    public String toString() {
        return "BriefCase{" +
                "caseNumber=" + caseNumber +
                ", caseValue=" + caseValue +
                ", opened=" + opened +
                '}';
    }

    /**
     * Gets line 1 value - such as [ Case 1       ].
     *
     * @return  String value
     */
    public String getLineOne() {

        String line = "[ Case " + caseNumber;
        if (caseNumber < 10) {
            line += "       ]";
        } else {
            line += "      ]";
        }
        return line;
    }

    /**
     * Gets line 2 value - such as [ $200,000.00  ].
     *
     * @return  String value
     */
    public String getLineTwo() {

        // If this case is not opened and the player's case
        if (!opened && myCase) {
            return "[ Your Case!!   ]";
        }

        // get value depending on opened or not opened
        if (opened) {
            // if opened
            String line = "[ $" + String.format("%1$,.2f", caseValue);
            int add = 15 - line.length();
            line += " ".repeat(add);
            line += "]";
            return line;
        } else {
            // not opened
            return "[ unopened     ]";

        }
    }
}
