package golu;

import java.util.Arrays;

public class Sol {

    public static void main(String[] args) {
       // System.out.println(solution("011100"));
        System.out.println(solution(new int[]{-3,-14,-5,7,8,42,8,3}));
    }

    public static int solution(String S) {
        long decimal = Long.parseLong(S, 2);
        int c = 0;
        while (decimal > 0) {
            if (decimal % 2 == 0) {
                decimal = decimal / 2;
            } else {
                decimal = decimal - 1;
            }
            c++;
        }
        return c;
    }

    public static  String solution(int[] T) {

        int div = T.length / 4;
        int rr[] = new int[4];
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            // Arrays.stream(T);
            int v[] = new int[div];
            for ( int n = 0; n <  div; n++, counter++) {
                v[n] = T[counter];
            }
            int max = Arrays.stream(v).max().getAsInt();
            int min = Arrays.stream(v).min().getAsInt();
            rr[i] = (max - min) <0 ?(max - min) * -1 :(max - min);

        }
        int h = Arrays.stream(rr).max().getAsInt();

        int i = 0;
        for (; i < rr.length; i++) {
            if (rr[i] == h) {
                break;
            }
        }
        if (i == 0) return "WINTER";
        if (i == 1) return "SPRING";
        if (i == 2) return "SUMMER";
        if (i == 3) return "AUTUM";

        return "";
    }

    //winter 1
    //autom last day
}
