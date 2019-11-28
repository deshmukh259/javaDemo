package com;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.postgresql.copy.CopyManager;
import org.postgresql.jdbc.PgConnection;

import java.io.*;
import java.sql.*;
import java.util.*;

interface OfType {
    public Object getRandData();
}

public class InsertData {
    public static Set<String> set = new HashSet();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection con = null;
        try {
            // 1 record = 0.114 kb
            // 1 mb = 9000 rec -- 10 column avg
            // 500k-->51 sec
            long s = System.currentTimeMillis();
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@//drevm03.unix.morrisons.net:1522/MOMDEV1A", "XXWMM_INT_ORDERDS", "OrdIntegrationDev2016");
            //con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            String selectQueryForJobId = "SELECT ct.job_id,ct.EXTERNAL_PO_NR FROM NB_MO_INTG_PO_CTRL ct WHERE ct.job_id = ?";

            PreparedStatement preparedStatement = con.prepareStatement(selectQueryForJobId);
                preparedStatement.setString(1, "123");

                ResultSet rs = preparedStatement.executeQuery();

            System.out.println(rs.next());



//            driverClass: oracle.jdbc.OracleDriver
//            user: XXWMM_INT_ORDERDS
//            password: OrdIntegrationDev2016
//            url: jdbc:oracle:thin:@//drevm03.unix.morrisons.net:1522/MOMDEV1A

            con.setAutoCommit(false);
            putData0(con, "stock_movement", 50, "C:/clone/abcc.txt");
            System.out.println("Finish : " + (System.currentTimeMillis() - s));
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return;


    }

    private static void putData0(Connection con, String table, int totalInsert, String outFile) throws SQLException, IOException {
        //stock_movement
        DatabaseMetaData meta = con.getMetaData();
        String columnName = "";
        List<OfType> list = new ArrayList<>();

        ResultSet columns = meta.getColumns(null, null, table, null);
        while (columns.next()) {
            String is_autoIncrment = columns.getString("IS_AUTOINCREMENT");
            if (!is_autoIncrment.equals("YES")) {
                if (columnName == "") {

                    columnName = columns.getString("COLUMN_NAME");
                } else {

                    columnName = columnName + "," + columns.getString("COLUMN_NAME");
                }
                String datatype = columns.getString("DATA_TYPE");
                String columnsize = columns.getString("COLUMN_SIZE");

                if (datatype.equals("-5")) {
                    list.add(new IntType(Integer.valueOf(columnsize)));
                }
                if (datatype.equals("12")) {
                    list.add(new StringType(Integer.valueOf(columnsize)));
                }
                if (datatype.equals("93")) {
                    list.add(new DateType(Integer.valueOf(columnsize)));
                }
                if (datatype.equals("1111")) {
                    list.add(new JsonType(Integer.valueOf(columnsize)));
                }
            }
        }
        PgConnection copyOperationConnection = con.unwrap(PgConnection.class);
        CopyManager cpm = new CopyManager(copyOperationConnection);
        int capacity = 2200;
        StringBuilder builder = new StringBuilder(capacity);
        OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile), 1024);
        int liness = 0;
        String sql = "COPY " + table
                + "(" + columnName + ")"
                + " FROM STDIN WITH DELIMITER ','";
        while (liness <= totalInsert) {

            builder.append(list.get(0).getRandData());
            for (int i = 1; i < list.size(); i++) {
                builder.append(",");
                builder.append(list.get(i).getRandData().toString());
            }

            builder.append(System.getProperty("line.separator"));
            liness++;
            if (liness % 500 == 0) {
                set.size();
                //System.out.println(builder.toString());
                putData(cpm, builder, out, sql);
            }

        }
        putData(cpm, builder, out, sql);
        con.commit();
        out.close();
    }

    private static void putData(CopyManager cpm, StringBuilder builder, OutputStream out, String sql) throws IOException, SQLException {
        byte[] bytes = builder.toString().getBytes();
        out.write(bytes);
        InputStream is = new ByteArrayInputStream(bytes);
        cpm.copyIn(sql, is);
        builder.setLength(0);
    }


}

class IntType implements OfType {
    int size;

    IntType(int size) {
        this.size = size;
    }

    @Override
    public Object getRandData() {
        long v = System.currentTimeMillis();

        Random rand = new Random();

        int n = 0;
        boolean nj = true;
        while (nj) {
            nj = false == InsertData.set.add(String.valueOf((v + n)));
            n = rand.nextInt(5000) + 1;

        }
        StringBuilder sb = new StringBuilder(String.valueOf((v + n)));

        if (sb.length() > size)
            sb.setLength(size);
        System.out.println(sb);
        return sb.toString();
    }
}

class StringType implements OfType {

    int size;

    public StringType(int size) {
        this.size = size;
    }

    @Override
    public Object getRandData() {
        size = size > 3 ? size - 1 : size;
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();
        return randomStringGenerator.generate(size).toString();

    }
}

class DateType implements OfType {
    final int size;

    DateType(int size) {
        this.size = size;
    }

    @Override
    public Object getRandData() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }
}

class JsonType implements OfType {
    final int size;

    JsonType(int size) {
        this.size = size;
    }

    @Override
    public Object getRandData() {
        return "{}";
    }
}
