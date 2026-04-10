package com;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EnCrypt {

    public static void main(String[] args) {
        //String e = "EN5+pm8/sPC+t6SSV3gGjJJz8b/pW7jqplwEIkdPe/8nkjwucqZcbvSCustT/8FIm2zUuvxAcNcpayuHpi1I9dvRyxZFsad5nDne5HsxWlZv+Mfad/BUNw==";
        String o = encrypt("3O5swyBNSdQGjMbFo8malQm36iP3DGAm");
        //decrypt(e);
        //
        //decrypt("gAAAAABc9ozKFfAvVRS0cnzqlLpl_srMD42OWpFnvrHABI86jR4w41Pb42eBdpb7GtcYKrojak86W-Y8wK7Xms69PapumjwHoIeyrXx5yq_Q2VcygkWdjRQ=");
        //System.out.println(decrypt(o).equals(e));
        //Holly7time2soon
    }

    public static String decrypt(String in) {
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword("morrisonsAuthentication");
        String d = decryptor.decrypt(in);
        System.out.println("dec:" + in + ": " + d);
        return d;

    }

    public static String encrypt(String in) {
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword("morrisonsAuthentication");
        String s = decryptor.encrypt(in);
        System.out.println("enc:" + in + ": " + s);
        return s;

    }


}
