package com.hackerrank;

import java.util.*;

public class ClambingLeaderBoard {


    public static void main(String[] args) {

        //int[] sco = new int[]{100, 100, 50, 40, 40, 20, 10};
        int[] sco = new int[]{295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4,
                200};

        //int[] al = new int[]{5, 25, 50, 120};
        int[] al = new int[]{5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400};
        int[] ints = climbingLeaderboard(sco, al);
        System.out.println(ints);
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        Set<Integer> set = new LinkedHashSet<>();
        Arrays.stream(scores).parallel().forEachOrdered(e -> set.add(e));
        int v[] = new int[alice.length];
        final int[] ali = {alice.length - 1};
        final int[] rank = {0};
        final boolean[] f = {false};
        set.stream().forEach(e -> {


        });
        return v;
    }

    /*
    *
    * if (e <= alice[ali[0]]) {
                rank[0]++;
                v[ali[0]] = rank[0];
                ali[0]--;
            } else
                rank[0]++;
            if (ali[0] == 0 && !f[0]) {
                if(alice.length%2==0){
                    ++rank[0];
                    v[ali[0]] = ++rank[0];
                    f[0] = true;
                }
            }
    * */

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard4(int[] scores, int[] alice) {

        Map<Integer, Object> map = new HashMap<>();
        Arrays.stream(scores).parallel().forEach(e -> map.put(e, null));
        int r[] = new int[alice.length];

        final int[] g = {0};
        Arrays.stream(alice).forEachOrdered(d -> {
            final int[] v = {0};
            map.entrySet().stream().forEach(f -> {
                if (d >= f.getKey()) {
                    r[g[0]] = v[0];
                } else v[0]++;

            });
            r[g[0]] = ++v[0];
            g[0]++;
        });
        return r;


    }

    static int[] climbingLeaderboard3(int[] scores, int[] alice) {

        //int r[] = new int[alice.length];

        final int[][] newA = {new int[alice.length]};
        final int[] i = {0};
        Arrays.stream(alice).parallel().forEach(e -> {
            Map<Integer, Object> map = new HashMap<>();
            int val = e;
            final int[] h = {0};
            bb(scores, newA, i, map, val, h);
            newA[0][i[0]] = ++h[0];
            i[0]++;
        });
        return newA[0];
    } // Complete the climbingLeaderboard function below.

    private static void bb(int[] scores, int[][] newA, int[] i, Map<Integer, Object> map, int val, int[] h) {
        Arrays.stream(scores).parallel().forEach(c -> {

            int score = c;
            if (val > score) {
                newA[0][i[0]] = h[0];
                return;

            }
            if (val >= score) {
                newA[0][i[0]] = h[0];
                return;
            }
            if (!map.containsKey(score)) {
                map.put(score, null);
                h[0]++;
            }
        });
    }

    static int[] climbingLeaderboard2(int[] scores, int[] alice) {

        //int r[] = new int[alice.length];

        int h = 0;
        for (int i = 0; i < alice.length; i++) {
            Map<Integer, Object> map = new HashMap<>();
            int val = alice[i];
            h = 0;
            for (int j = 0; j < scores.length; j++) {

                int score = scores[j];
                if (val > score) {
                    alice[i] = h;
                    break;
                }
                if (val >= score) {
                    alice[i] = h;
                    break;
                }
                if (!map.containsKey(score)) {
                    map.put(score, null);
                    h++;
                }
            }
            alice[i] = ++h;
        }
        return alice;
    }

}
