package com;

import java.sql.*;
import java.util.Scanner;

public class demo33 {
    public static void main1(String[] args)  {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection("jdbc:oracle:thin:@//drevm03.unix.morrisons.net:1522/MOMDEV1A", "XXWMM_INT_ORDERDS", "OrdIntegrationDev2016");
            //con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            String selectQueryForJobId = "SELECT ct.job_id,ct.EXTERNAL_PO_NR FROM NB_MO_INTG_PO_CTRL ct WHERE ct.job_id = ?";

            PreparedStatement preparedStatement = con.prepareStatement(selectQueryForJobId);
            preparedStatement.setString(1, "123");

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println(rs.next());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();

                //"{\"Ordered\":100.0,\"Confirmed\":null,\"Received\":null,\"Picked\":null,\"Shipped\":null,\"Delivered\":null,\"Invoiced\":null}"
            }
        }

    }
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();
    double d = Double.parseDouble(scan.nextLine());
    String s = scan.nextLine();

    // Write your code here.

    System.out.println("String: " + s);
    System.out.println("Double: " + d);
    System.out.println("Int: " + i);
    }
    public static void main2(String[] args) {
    	int N = 24;
    	if(N%2!=0 ){
            System.out.println("Weird");
        }
        if((N%2==0 && N>5 && N<21)){
            System.out.println("Not Weird");
        }
        if((N%2==0 && N>1 && N<6) || (N/2==0 && N>20)){
            System.out.println("Not Weird");
        }

	}
}
