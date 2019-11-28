package com;

import org.postgresql.copy.CopyManager;
import org.postgresql.jdbc.PgConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportCSV {

    public static void main1(String[] args) {
        String s= "q,q";
        String []f=s.split(",");
        System.out.println(f.length);
    }
    public static void main(String[] args) {
        try {

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            PreparedStatement ps =con.prepareStatement("select *from nse_daily where Symbol = ?");
            ps.setString(1, "s");
            System.out.println(ps);
            PgConnection copyOperationConnection = con.unwrap(PgConnection.class);
            CopyManager cpm = new CopyManager(copyOperationConnection);
            //company_share(cpm);
            String FILE = "C:\\clone\\c\\daily.csv";
            String s = " COPY nse_daily (Symbol , Open , High , Low , Last_Traded_Price , Change , p_Change , Traded_Volume , Traded_Value , _52_Week_High , _52_Week_Low , _365_Days_p_Change , _30_Days_p_Change)"
                    + " FROM STDIN WITH DELIMITER ','";
            daily(cpm, FILE, s);

            System.out.println("done");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private static void daily(CopyManager cpm, String FILE, String s) throws SQLException, IOException {
        InputStream input = new FileInputStream(FILE);
        cpm.copyIn(s, input);
    }

    private static void company_share(CopyManager cpm) throws SQLException, IOException {
        InputStream input = new FileInputStream("C:\\clone\\c\\1.csv");
        String s = " COPY company (company ,total ,a_share ,promoter_holding ,b_share ,promoter_x ,promoter_x_a ,promoter_x_a_b_c ,disclosure_promoters ,depository ,demat ,demat_p)"
                + " FROM STDIN WITH DELIMITER ','";
        cpm.copyIn(s, input);
    }
}
