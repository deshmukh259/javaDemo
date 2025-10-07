package com;

import java.io.*;

public class Demo1 {

    public static void main(String[] args) {
        String inputPath = "C:\\clone\\allocafile";
        String outputPath = "C:\\clone\\allocafile\\resp";

        File inputFolder = new File(inputPath);
        File[] files = inputFolder.listFiles();


        final String lineSep = System.getProperty("line.separator");

        for (File f : files) {
            System.out.println(f.getName());
            String fn = f.getName();
            fn = fn.replace("ALLOC", "ALLOCRESP");
            File outputFile = new File(outputPath, fn + "");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));) {
                String line = null;
                int i = 0;
                for (line = br.readLine(); line != null; line = br.readLine(), i++) {
                    bw.write(line + ",06,0000040");
                    bw.write(lineSep);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
