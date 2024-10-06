package com.linden.deal;

public class RandomGenerator {

    /**
     * Gets a random number between min and max.
     *
     * @param min   Minimum value
     * @param max   Maximum value
     * @return      integer random value
     */
    public static int getRandomNumberBetween(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
