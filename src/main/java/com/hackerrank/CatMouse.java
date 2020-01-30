package com.hackerrank;

public class CatMouse {

    static String catAndMouse(int x, int y, int z) {

        if (Math.abs(x - z) < Math.abs(y - z))
            return ("Cat A");
        else if (Math.abs(x - z) > Math.abs(y - z))
            return ("Cat B");
        else
            return "Mouse C";


    }
}
