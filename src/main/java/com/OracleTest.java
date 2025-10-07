package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by EXTMASJ2 on 30/06/2017.
 */
public class OracleTest {

    public static void main(String[] argv) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement;
        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@xgret01x.unix.morrisons.net:1522/MOMPRE2A",
                    "XXWMM_INT_FBB", "vF9eK3LpW5K_bXL7S");
            System.out.println("Oracle JDBC Driver Registered!");
            System.out.println("connected................");

            preparedStatement = con.prepareStatement("select NB_MO_PO_HDR_STG_SEQ.NEXTVAL from dual");
            int i = 303;

            while (i < 392) {

                preparedStatement.execute();
                System.out.println(i);
                i++;
            }
        } catch (Exception e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        } finally {
            if (con != null)
                con.close();
        }
    }
}
