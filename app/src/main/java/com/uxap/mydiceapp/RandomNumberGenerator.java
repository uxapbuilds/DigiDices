package com.uxap.mydiceapp;

import java.util.Random;

public class RandomNumberGenerator {
    public static int[] getRandomNum(){
        Random randGen = new Random();
        return new int[] {
                randGen.nextInt(6), randGen.nextInt(6)
        };
    }
}
