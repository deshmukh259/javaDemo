package com.hackerrank;

public class PdfViwer {

    public static void main(String[] args) {

        int[] h = new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
        System.out.println(designerPdfViewer(h, "zaba"));

    }

    static int designerPdfViewer(int[] h, String word) {

        int b = 0;
        for (int i = 0; i < word.length(); i++) {
            int v = word.charAt(i) - 97;
            if (b < h[v]) {
                b = h[v];
            }
        }
        return b * word.length();

    }
}
