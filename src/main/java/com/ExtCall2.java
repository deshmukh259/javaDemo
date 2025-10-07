package com;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExtCall2 {

    static volatile int n = 0;

    public static void main(String[] args) throws IOException {
        get();
//        for (int i = 0; i < 100; i++) {
//
//            int finalI = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    postShipment(finalI);
//                }
//            }).start();
//
//            int finalI1 = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    post22(finalI1);
//                }
//            }).start();
//        }
//        //get();
    }

    private static void get() throws IOException {
        BufferedReader bf = null;
        BufferedWriter bw = null;
        try {
            bf = new BufferedReader(new FileReader("C:\\a\\23_pickId.csv"));
            bw = new BufferedWriter(new FileWriter("C:\\a\\23_pickIdOutPut.csv"));
            String x = null;
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);


            System.out.println("Maximum threads inside pool " + executor.getMaximumPoolSize());

            while ((x = bf.readLine()) != null) {
                String c = x;
                BufferedWriter finalBw = bw;
                Runnable runnable = () -> {
                    try {
                        call0(finalBw, c, ++n);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                executor.execute(runnable);
            }
            //bw.close();
            //bf.close();
            executor.shutdown();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            //bw.close();
            //bf.close();
        }
    }

    private static void call0(BufferedWriter bw, String x, int n) throws IOException {
        String u = "https://api.mol.osp.tech/storepicklayout/v2/sites/023/pick-locations/xxx";
        u = u.replace("xxx", x.trim());
        URL url = new URL(u);
        Proxy proxy = getWmmproxyservice();

        HttpURLConnection conn = getConn(url, proxy);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        conn.setRequestProperty("Authorization", "Bearer TAeJwlx7sKwjAUANC_yRYw73TIILWDgwpWu4b0Jhciamma9vsteLbjc3TWjDoy5JRbBCoZCto0saEoWESjEqoRiV-X4ur0gVCJ39AxpY02TBq2d_mXW743uCWVLUMKANP6rb7myzC_TjOJrqQa8jsVUlyIgfMDIgUJiUoAQS0XimoZYhLywNFKsri-uw_ntvPHtr09r4_-B7FUNdM2a6128b2a6fd3e7febbbf2273f001c56b4fcff808c90c5cfa475724fbf16965b");
        conn.setRequestProperty("x-api-key", "KPmjCBzoOz8UBOw1Q4eMA45tQmM3F4L09z7sPbXK");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("RequestId", "22a0159c-e788-4a00-8a1e-c7ccd01335d2");

//                if (conn.getResponseCode() != 200) {
//                    System.out.println(conn);
//                    throw new RuntimeException("Failed : HTTP error code : "
//                            + conn.getResponseCode());
//                }

//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        (conn.getInputStream())));

        String x1 = x + "," + conn.getResponseCode() + "," + n;
        bw.write(x1 + "\n");
        System.out.println(x1);
//                if (conn.getResponseCode() != 200) {
//                    //System.out.println("Output from Server .... \n");
////                    while ((output = br.readLine()) != null) {
////                    }
//                }

        conn.disconnect();
    }

    private static HttpURLConnection getConn(URL url, Proxy proxy) throws IOException {
        return (HttpURLConnection) url.openConnection(proxy);
    }

    private static Proxy getWmmproxyservice() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress("wmmproxyservice", 8080));
    }

    private static void post() {
        try {

            URL url = new URL("https://dev-api.morrisons.com/stockmovement/v1/shipmentconfirmations?apikey=u5mB4ZzQjDzFHll9LtPC4YW8ELgu83p9");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(getWmmproxyservice());
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setRequestProperty("Authorization", "Basic dTVtQjRaelFqRHpGSGxsOUx0UEM0WVc4RUxndTgzcDk6MmpvRVd1d1N4ZjJFV1ZsQQ==");

            String input = getInput();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

//            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private static void post1() {
        try {

            URL url = new URL("https://dev-api.morrisons.com/stockmovement/v1/shipmentconfirmations?apikey=u5mB4ZzQjDzFHll9LtPC4YW8ELgu83p9");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(getWmmproxyservice());
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setRequestProperty("Authorization", "Basic dTVtQjRaelFqRHpGSGxsOUx0UEM0WVc4RUxndTgzcDk6MmpvRVd1d1N4ZjJFV1ZsQQ==");

            String input = getInput();

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

//            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private static void postShipment(int i) {
        try {

            URL url = new URL("http://localhost:8084/stockmovementshipment/v1/shipmentconfirmations?apikey=u5mB4ZzQjDzFHll9LtPC4YW8ELgu83p9");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            //conn.setRequestProperty("Authorization", "Basic dTVtQjRaelFqRHpGSGxsOUx0UEM0WVc4RUxndTgzcDk6MmpvRVd1d1N4ZjJFV1ZsQQ==");

            //String input = getInput();
            String input = getInput1(i);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

//            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private static void post22(int i) {
        try {

            URL url = new URL("http://localhost:8084/stockmovementshipment/v1/shipmentconfirmations?apikey=u5mB4ZzQjDzFHll9LtPC4YW8ELgu83p9");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            //conn.setRequestProperty("Authorization", "Basic dTVtQjRaelFqRHpGSGxsOUx0UEM0WVc4RUxndTgzcDk6MmpvRVd1d1N4ZjJFV1ZsQQ==");

            //String input = getInput();
            String input = getInput11(i);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

//            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private static String getInput11(int i) {
        return "{  \n" +
                "   \"trailerId\":\"123456789\",\n" +
                "   \"shippedFromLocationId\":\"0970\",\n" +
                "   \"shippedDate\":\"2018-10-06T12:00:00Z\",\n" +
                "   \"asns\":[  \n" +
                "      {  \n" +
                "         \"asnId\":\"345345\",\n" +
                "         \"destinationLocationId\":\"0971\",\n" +
                "         \"containers\":[  \n" +
                "            {  \n" +
                "               \"containerId\":\"123456789\",\n" +
                "               \"orders\":[  \n" +
                "                  {  \n" +
                "                     \"orderId\":\"256302\",\n" +
                "                     \"orderType\":\"Stock\",\n" +
                "                     \"items\":[  \n" +
                "                        {  \n" +
                "                           \"itemId\":\"\",\n" +
                "                           \"packId\":\"108285394\",\n" +
                "                           \"shippedQuantity\":" + i + ",\n" +
                "                           \"shippedQuantityType\":\"CS\",\n" +
                "                           \"shippedWeight\":555,\n" +
                "                           \"shippedWeightType\":\"grams\"\n" +
                "                           \n" +
                "                        },\n" +
                "                                                {  \n" +
                "                           \"itemId\":\"\",\n" +
                "                           \"packId\":\"108285395\",\n" +
                "                           \"shippedQuantity\":" + i + ",\n" +
                "                           \"shippedQuantityType\":\"CS\",\n" +
                "                           \"shippedWeight\":555,\n" +
                "                           \"shippedWeightType\":\"grams\"\n" +
                "                           \n" +
                "                        }\n" +
                "\n" +
                "                       \n" +
                "                     ]\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}";
    }

    private static String getInput1(int i) {
        return "{  \n" +
                "   \"trailerId\":\"123456789\",\n" +
                "   \"shippedFromLocationId\":\"0970\",\n" +
                "   \"shippedDate\":\"2018-10-06T12:00:00Z\",\n" +
                "   \"asns\":[  \n" +
                "      {  \n" +
                "         \"asnId\":\"345345\",\n" +
                "         \"destinationLocationId\":\"0971\",\n" +
                "         \"containers\":[  \n" +
                "            {  \n" +
                "               \"containerId\":\"123456789\",\n" +
                "               \"orders\":[  \n" +
                "                  {  \n" +
                "                     \"orderId\":\"256302\",\n" +
                "                     \"orderType\":\"Stock\",\n" +
                "                     \"items\":[  \n" +
                "                        {  \n" +
                "                           \"itemId\":\"\",\n" +
                "                           \"packId\":\"108285394\",\n" +
                "                           \"shippedQuantity\":" + i + ",\n" +
                "                           \"shippedQuantityType\":\"CS\",\n" +
                "                           \"shippedWeight\":333,\n" +
                "                           \"shippedWeightType\":\"grams\"\n" +
                "                           \n" +
                "                        },\n" +
                "                                                {  \n" +
                "                           \"itemId\":\"\",\n" +
                "                           \"packId\":\"108285395\",\n" +
                "                           \"shippedQuantity\":" + i + ",\n" +
                "                           \"shippedQuantityType\":\"CS\",\n" +
                "                           \"shippedWeight\":333,\n" +
                "                           \"shippedWeightType\":\"grams\"\n" +
                "                           \n" +
                "                        }\n" +
                "\n" +
                "                       \n" +
                "                     ]\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}";
    }

    private static String getInput() {
        return "{  \n" +
                "   \"trailerId\":\"123456789\",\n" +
                "   \"shippedFromLocationId\":\"0970\",\n" +
                "   \"shippedDate\":\"2018-10-06T12:00:00Z\",\n" +
                "   \"asns\":[  \n" +
                "      {  \n" +
                "         \"asnId\":\"345345\",\n" +
                "         \"destinationLocationId\":\"0971\",\n" +
                "         \"containers\":[  \n" +
                "            {  \n" +
                "               \"containerId\":\"123456789\",\n" +
                "               \"orders\":[  \n" +
                "                  {  \n" +
                "                     \"orderId\":\"256302\",\n" +
                "                     \"orderType\":\"Stock\",\n" +
                "                     \"items\":[  \n" +
                "                        {  \n" +
                "                           \"itemId\":\"\",\n" +
                "                           \"packId\":\"108285394\",\n" +
                "                           \"shippedQuantity\":4,\n" +
                "                           \"shippedQuantityType\":\"CS\",\n" +
                "                           \"shippedWeight\":200,\n" +
                "                           \"shippedWeightType\":\"grams\"\n" +
                "                           \n" +
                "                        },\n" +
                "                                                {  \n" +
                "                           \"itemId\":\"\",\n" +
                "                           \"packId\":\"108285395\",\n" +
                "                           \"shippedQuantity\":4,\n" +
                "                           \"shippedQuantityType\":\"CS\",\n" +
                "                           \"shippedWeight\":200,\n" +
                "                           \"shippedWeightType\":\"grams\"\n" +
                "                           \n" +
                "                        }\n" +
                "\n" +
                "                       \n" +
                "                     ]\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ]\n" +
                "}";
    }


    public static List<String> list() {
        List a = new ArrayList<String>();
        a.add("AT-L16");
        a.add("AT-L15");
        a.add("AT-L14");
        a.add("AT-L13");
        a.add("AT-L12");
        a.add("AT-L11");
        a.add("AT-L10");
        a.add("AT-L9");
        a.add("AT-L8");
        a.add("AT-L7");
        a.add("AT-L6");
        a.add("AT-L5");
        a.add("AT-L4");
        a.add("AT-L3");
        a.add("AT-L2");
        a.add("AT-L1");
        a.add("AS-L6");
        a.add("AS-L5");
        a.add("AS-L4");
        a.add("AS-L3");
        a.add("AS-L2");
        a.add("AS-L1");
        a.add("U-RE2");
        a.add("U-RE3");
        a.add("AR-L14");
        a.add("AR-L13");
        a.add("AR-L12");
        a.add("AR-L11");
        a.add("AR-L10");
        a.add("U-RE4");
        a.add("U-L9");
        a.add("U-L8");
        a.add("U-L7");
        a.add("U-L6");
        a.add("U-L5");
        a.add("AR-L9");
        a.add("AR-L8");
        a.add("AR-L7");
        a.add("AR-L6");
        a.add("U-L4");
        a.add("U-L3");
        a.add("U-L2");
        a.add("U-L1");
        a.add("AR-L5");
        a.add("AR-L4");
        a.add("AR-L3");
        a.add("AR-L2");
        a.add("AR-L1");
        a.add("U-FE2");
        a.add("U-FE3");
        a.add("U-R1");
        a.add("T-L1");
        a.add("T-L2");
        a.add("T-L3");
        a.add("U-R2");
        a.add("U-R3");
        a.add("U-R4");
        a.add("U-R5");
        a.add("U-R6");
        a.add("T-L4");
        a.add("T-L5");
        a.add("T-L6");
        a.add("T-L7");
        a.add("U-R7");
        a.add("U-R8");
        a.add("U-R9");
        a.add("T-L8");
        a.add("T-L9");
        a.add("T-RE3");
        a.add("T-RE2");
        a.add("T-R9");
        a.add("T-R8");
        a.add("T-R7");
        a.add("S-L9");
        a.add("S-L8");
        a.add("S-L7");
        a.add("S-L6");
        a.add("S-L5");
        a.add("S-L4");
        a.add("T-R6");
        a.add("T-R5");
        a.add("T-R4");
        a.add("T-R3");
        a.add("T-R2");
        a.add("T-R1");
        a.add("S-L3");
        a.add("S-L2");
        a.add("S-L1");
        a.add("T-FE1");
        a.add("T-FE2");
        a.add("S-FE2");
        a.add("S-FE3");
        a.add("O-FE1");
        a.add("S-R1");
        a.add("S-R2");
        a.add("S-R3");
        a.add("R-L1");
        a.add("R-L2");
        a.add("R-L3");
        a.add("R-L4");
        a.add("R-L5");
        a.add("R-L6");
        a.add("S-R4");
        a.add("S-R5");
        a.add("S-R6");
        a.add("S-R7");
        a.add("S-R8");
        a.add("S-R9");
        a.add("R-L7");
        a.add("R-L8");
        a.add("R-L9");
        a.add("R-L10");
        a.add("S-RE1");
        a.add("S-RE2");
        a.add("S-RE3");
        a.add("R-RE2");
        a.add("R-RE1");
        a.add("G-FE1");
        a.add("Q-L10");
        a.add("Q-L9");
        a.add("Q-L8");
        a.add("R-R10");
        a.add("R-R9");
        a.add("R-R8");
        a.add("R-R7");
        a.add("R-R6");
        a.add("R-R5");
        a.add("Q-L7");
        a.add("Q-L6");
        a.add("Q-L5");
        a.add("Q-L4");
        a.add("Q-L3");
        a.add("Q-L2");
        a.add("R-R4");
        a.add("R-R3");
        a.add("R-R2");
        a.add("R-R1");
        a.add("Q-L1");
        a.add("Q-FE1");
        a.add("R-FE3");
        a.add("R-FE2");
        a.add("Q-FE2");
        a.add("Q-FE3");
        a.add("P-FE1");
        a.add("Q-R1");
        a.add("Q-R2");
        a.add("Q-R3");
        a.add("P-L1");
        a.add("P-L2");
        a.add("P-L3");
        a.add("P-L4");
        a.add("P-L5");
        a.add("Q-R4");
        a.add("Q-R5");
        a.add("Q-R6");
        a.add("Q-R7");
        a.add("Q-R8");
        a.add("P-L7");
        a.add("P-L8");
        a.add("P-L9");
        a.add("P-L10");
        a.add("Q-R9");
        a.add("Q-R10");
        a.add("Q-RE1");
        a.add("Q-RE2");
        a.add("O-RE3");
        a.add("O-L10");
        a.add("P-R10");
        a.add("O-L9");
        a.add("O-L8");
        a.add("O-L7");
        a.add("O-L6");
        a.add("P-R9");
        a.add("P-R8");
        a.add("P-R7");
        a.add("P-R6");
        a.add("P-R5");
        a.add("P-R4");
        a.add("O-L5");
        a.add("O-L4");
        a.add("O-L3");
        a.add("O-L2");
        a.add("O-L1");
        a.add("P-R3");
        a.add("P-R2");
        a.add("P-R1");
        a.add("P-FE3");
        a.add("R-FE1");
        a.add("P-FE2");
        a.add("O-FE2");
        a.add("N-FE1");
        a.add("O-FE3");
        a.add("O-R1");
        a.add("O-R2");
        a.add("O-R3");
        a.add("N-L2");
        a.add("N-L3");
        a.add("N-L4");
        a.add("O-R4");
        a.add("O-R5");
        a.add("O-R6");
        a.add("N-L5");
        a.add("N-L6");
        a.add("N-L7");
        a.add("O-R7");
        a.add("O-R8");
        a.add("O-R9");
        a.add("N-L8");
        a.add("N-L9");
        a.add("N-L10");
        a.add("O-R10");
        a.add("O-RE1");
        a.add("O-RE2");
        a.add("N-RE2");
        a.add("M-RE5");
        a.add("N-RE1");
        a.add("M-L10");
        a.add("M-L9");
        a.add("M-L8");
        a.add("N-R10");
        a.add("N-R9");
        a.add("N-R8");
        a.add("M-L7");
        a.add("M-L6");
        a.add("M-L5");
        a.add("N-R7");
        a.add("N-R6");
        a.add("N-R5");
        a.add("N-R4");
        a.add("M-L4");
        a.add("M-L3");
        a.add("M-L2");
        a.add("M-L1");
        a.add("N-R3");
        a.add("N-R2");
        a.add("N-R1");
        a.add("N-FE3");
        a.add("M-FE1");
        a.add("N-FE2");
        a.add("M-FE2");
        a.add("L-FE2");
        a.add("L-FE1");
        a.add("M-FE3");
        a.add("L-L1");
        a.add("L-L2");
        a.add("L-L3");
        a.add("M-R2");
        a.add("M-R3");
        a.add("M-R4");
        a.add("M-R5");
        a.add("M-R6");
        a.add("L-L4");
        a.add("L-L5");
        a.add("L-L6");
        a.add("L-L7");
        a.add("L-L8");
        a.add("M-R7");
        a.add("M-R8");
        a.add("M-R9");
        a.add("M-R10");
        a.add("L-L9");
        a.add("L-L10");
        a.add("L-L11");
        a.add("M-RE3");
        a.add("L-RE2");
        a.add("K-RE3");
        a.add("K-RE2");
        a.add("L-RE3");
        a.add("K-L11");
        a.add("K-L10");
        a.add("K-L9");
        a.add("L-R11");
        a.add("L-R10");
        a.add("L-R9");
        a.add("L-R8");
        a.add("L-R7");
        a.add("L-R6");
        a.add("K-L8");
        a.add("K-L7");
        a.add("K-L6");
        a.add("K-L5");
        a.add("K-L4");
        a.add("K-L3");
        a.add("L-R5");
        a.add("L-R4");
        a.add("L-R3");
        a.add("L-R2");
        a.add("L-R1");
        a.add("K-L2");
        a.add("K-L1");
        a.add("K-FE1");
        a.add("L-FE3");
        a.add("K-FE2");
        a.add("J-FE2");
        a.add("K-FE3");
        a.add("J-FE1");
        a.add("J-L1");
        a.add("J-L2");
        a.add("J-L3");
        a.add("J-L4");
        a.add("K-R1");
        a.add("K-R2");
        a.add("K-R3");
        a.add("K-R4");
        a.add("K-R5");
        a.add("K-R6");
        a.add("K-R7");
        a.add("J-L5");
        a.add("J-L6");
        a.add("J-L7");
        a.add("J-L8");
        a.add("J-L9");
        a.add("K-R8");
        a.add("K-R9");
        a.add("K-R10");
        a.add("K-R11");
        a.add("J-L10");
        a.add("J-L11");
        a.add("K-RE1");
        a.add("J-RE2");
        a.add("J-RE1");
        a.add("I-RE3");
        a.add("I-L11");
        a.add("I-L10");
        a.add("I-L9");
        a.add("J-R15");
        a.add("J-R14");
        a.add("J-R13");
        a.add("J-R12");
        a.add("J-R11");
        a.add("J-R10");
        a.add("J-R9");
        a.add("J-R8");
        a.add("J-R7");
        a.add("J-R2");
        a.add("J-R1");
        a.add("J-FE3");
        a.add("I-FE1");
        a.add("I-FE2");
        a.add("H2-FE1");
        a.add("I-FE3");
        a.add("H3-L1");
        a.add("H2-L2");
        a.add("H2-R3");
        a.add("I-R1");
        a.add("I-R2");
        a.add("I-R3");
        a.add("I-R4");
        a.add("I-R5");
        a.add("H2-RE1");
        a.add("H3-FE1");
        a.add("H3-L2");
        a.add("H3-L3");
        a.add("H2-R1");
        a.add("H3-RE1");
        a.add("G-L10");
        a.add("G-L9");
        a.add("G-L8");
        a.add("H3-R3");
        a.add("H3-R2");
        a.add("H3-R1");
        a.add("G-L7");
        a.add("G-L6");
        a.add("G-L5");
        a.add("H1-RE1");
        a.add("G-L4");
        a.add("G-L3");
        a.add("G-L2");
        a.add("G-L1");
        a.add("H1-R3");
        a.add("H1-R2");
        a.add("H1-R1");
        a.add("H1-FE1");
        a.add("H1-L1");
        a.add("H2-R2");
        a.add("H1-L2");
        a.add("H2-L3");
        a.add("H1-L3");
        a.add("G-FE2");
        a.add("G-FE3");
        a.add("F-FE1");
        a.add("F-FE3");
        a.add("G-R1");
        a.add("G-R2");
        a.add("G-R3");
        a.add("F-L1");
        a.add("F-L2");
        a.add("F-L3");
        a.add("F-L4");
        a.add("F-L5");
        a.add("F-L6");
        a.add("G-R4");
        a.add("G-R5");
        a.add("G-R6");
        a.add("G-R7");
        a.add("G-R8");
        a.add("G-R9");
        a.add("F-L7");
        a.add("F-L8");
        a.add("F-L9");
        a.add("F-L10");
        a.add("F-L11");
        a.add("G-R10");
        a.add("F-RE4");
        a.add("F-RE3");
        a.add("F-RE2");
        a.add("AU-L1");
        a.add("AU-L2");
        a.add("AU-L3");
        a.add("AW-L1");
        a.add("AW-L2");
        a.add("AW-L3");
        a.add("AW-L4");
        a.add("AW-L5");
        a.add("AW-L6");
        a.add("EE-L43");
        a.add("AX-L1");
        a.add("AX-L2");
        a.add("AY-L1");
        a.add("AY-L2");
        a.add("EE-L42");
        a.add("EE-L39");
        a.add("EE-L37");
        a.add("EE-L38");
        a.add("EE-L36");
        a.add("BA-L1");
        a.add("BA-L2");
        a.add("BA-L3");
        a.add("BA-L4");
        a.add("BA-L5");
        a.add("BB-L1");
        a.add("BB-L2");
        a.add("BB-L3");
        a.add("EE-L35");
        a.add("EE-L31");
        a.add("EE-L30");
        a.add("BB-L4");
        a.add("BB-L5");
        a.add("BB-L6");
        a.add("BB-L7");
        a.add("EE-L33");
        a.add("EE-L34");
        a.add("BD-L1");
        a.add("EE-L18");
        a.add("EE-L19");
        a.add("EE-L23");
        a.add("EE-L24");
        a.add("EE-L25");
        a.add("EE-L16");
        a.add("EE-L17");
        a.add("EE-L20");
        a.add("EE-L21");
        a.add("EE-L22");
        a.add("F-R12");
        a.add("F-R11");
        a.add("F-R9");
        a.add("F-R7");
        a.add("F-R6");
        a.add("F-R5");
        a.add("BG-L3");
        a.add("BG-L4");
        a.add("F-R2");
        a.add("F-R1");
        a.add("E-RE4");
        a.add("E-L1");
        a.add("E-L2");
        a.add("E-L3");
        a.add("E-RE1");
        a.add("E-RE2");
        a.add("E-R3");
        a.add("E-R2");
        a.add("E-R1");
        a.add("D-L1");
        a.add("D-L2");
        a.add("D-L3");
        a.add("D-FE1");
        a.add("D-R4");
        a.add("D-R3");
        a.add("D-R2");
        a.add("D-RE1");
        a.add("V-RE1");
        a.add("V-R13");
        a.add("V-R12");
        a.add("V-R10");
        a.add("V-R9");
        a.add("V-R8");
        a.add("V-R7");
        a.add("V-R6");
        a.add("C-RE4");
        a.add("C-L1");
        a.add("C-L2");
        a.add("C-L3");
        a.add("C-RE1");
        a.add("C-RE2");
        a.add("BG-L1");
        a.add("BG-L2");
        a.add("C-R3");
        a.add("C-R2");
        a.add("C-R1");
        a.add("C-RE5");
        a.add("B-L1");
        a.add("B-L2");
        a.add("B-L3");
        a.add("B-R3");
        a.add("B-FE1");
        a.add("B-R2");
        a.add("B-R1");
        a.add("B-RE2");
        a.add("A-L1");
        a.add("A-L2");
        a.add("A-L3");
        a.add("BI-L1");
        a.add("BI-L2");
        a.add("BI-L3");
        a.add("BI-L4");
        a.add("BJ-L14");
        a.add("BK-L1");
        a.add("BK-L2");
        a.add("BK-L3");
        a.add("BK-L4");
        a.add("BK-L5");
        a.add("BK-L6");
        a.add("BK-L7");
        a.add("BJ-L13");
        a.add("BJ-L12");
        a.add("BJ-L11");
        a.add("BJ-L10");
        a.add("BK-L8");
        a.add("BK-L9");
        a.add("BK-L10");
        a.add("EF-L30");
        a.add("EF-L31");
        a.add("EF-L32");
        a.add("W-FE2");
        a.add("W-FE3");
        a.add("W-R1");
        a.add("W-R2");
        a.add("W-R3");
        a.add("V-L1");
        a.add("V-L2");
        a.add("V-L3");
        a.add("V-L4");
        a.add("V-L5");
        a.add("V-L6");
        a.add("W-R4");
        a.add("W-R5");
        a.add("W-R6");
        a.add("W-R7");
        a.add("W-R8");
        a.add("V-L7");
        a.add("V-L8");
        a.add("V-L9");
        a.add("V-L10");
        a.add("W-R9");
        a.add("W-R10");
        a.add("W-R11");
        a.add("W-R12");
        a.add("V-L11");
        a.add("V-L12");
        a.add("V-L13");
        a.add("V-RE2");
        a.add("W-R13");
        a.add("W-RE2");
        a.add("W-L13");
        a.add("W-L12");
        a.add("W-L11");
        a.add("W-L10");
        a.add("W-L9");
        a.add("X-RE1");
        a.add("X-RE2");
        a.add("X-R9");
        a.add("X-R8");
        a.add("X-R7");
        a.add("W-L8");
        a.add("W-L7");
        a.add("W-L6");
        a.add("W-L5");
        a.add("W-L4");
        a.add("W-L3");
        a.add("X-R5");
        a.add("X-R4");
        a.add("X-R3");
        a.add("X-R2");
        a.add("X-R1");
        a.add("W-L2");
        a.add("W-L1");
        a.add("X-FE1");
        a.add("X-FE3");
        a.add("Y-FE1");
        a.add("Y-R1");
        a.add("Y-R2");
        a.add("Y-R3");
        a.add("X-L1");
        a.add("X-L2");
        a.add("X-L3");
        a.add("X-L4");
        a.add("X-L5");
        a.add("Y-R4");
        a.add("Y-R5");
        a.add("Y-R6");
        a.add("Y-R7");
        a.add("Y-R8");
        a.add("X-L6");
        a.add("X-L7");
        a.add("X-L8");
        a.add("X-L9");
        a.add("Y-R9");
        a.add("Y-R10");
        a.add("X-RE3");
        a.add("Y-R11");
        a.add("Y-R12");
        a.add("Y-R13");
        a.add("Y-RE1");
        a.add("Y-RE2");
        a.add("Z-RE2");
        a.add("Z-R13");
        a.add("Z-R12");
        a.add("Z-R11");
        a.add("Y-L13");
        a.add("Y-L12");
        a.add("Y-L11");
        a.add("Y-L10");
        a.add("Y-L9");
        a.add("Y-L8");
        a.add("Z-R10");
        a.add("Z-R9");
        a.add("Z-R8");
        a.add("Z-R7");
        a.add("Z-R6");
        a.add("Y-L7");
        a.add("Y-L6");
        a.add("Y-L5");
        a.add("Y-L4");
        a.add("Y-L3");
        a.add("Z-R5");
        a.add("Z-R4");
        a.add("Z-R3");
        a.add("Z-R2");
        a.add("Z-R1");
        a.add("Y-L2");
        a.add("Y-L1");
        a.add("Z-FE5");
        a.add("Z-FE4");
        a.add("Z-FE3");
        a.add("Z-FE2");
        a.add("Z-FE1");
        a.add("AA-FE3");
        a.add("A-R1");
        a.add("A-R2");
        a.add("A-R3");
        a.add("Z-L1");
        a.add("Z-L2");
        a.add("Z-L3");
        a.add("Z-L4");
        a.add("Z-L5");
        a.add("Z-L6");
        a.add("A-R4");
        a.add("A-R5");
        a.add("A-R6");
        a.add("A-R7");
        a.add("A-R8");
        a.add("A-R9");
        a.add("Z-L7");
        a.add("Z-L8");
        a.add("Z-L9");
        a.add("Z-L10");
        a.add("Z-L11");
        a.add("A-R10");
        a.add("A-R11");
        a.add("A-R12");
        a.add("A-R13");
        a.add("Z-L12");
        a.add("Z-L13");
        a.add("W-FE1");
        a.add("AA-RE2");
        a.add("AA-RE1");
        a.add("AC2-RE1");
        a.add("AC2-RE2");
        a.add("AC2-RE3");
        a.add("AD-RE1");
        a.add("AD-R13");
        a.add("AD-R12");
        a.add("AD-R11");
        a.add("AC2-L4");
        a.add("AC2-L3");
        a.add("AC2-L2");
        a.add("AC2-L1");
        a.add("AD-R10");
        a.add("AD-R9");
        a.add("AC2-FE1");
        a.add("AC2-FE2");
        a.add("AC1-RE2");
        a.add("AD-R8");
        a.add("AD-R7");
        a.add("AD-R6");
        a.add("AC1-RE3");
        a.add("AC1-L6");
        a.add("AC1-L5");
        a.add("AC1-L4");
        a.add("AC1-L3");
        a.add("AD-R5");
        a.add("AD-R4");
        a.add("AD-R3");
        a.add("AD-R2");
        a.add("AD-R1");
        a.add("AC1-L2");
        a.add("AC1-L1");
        a.add("AD-FE2");
        a.add("AD-FE4");
        a.add("AE1-FE3");
        a.add("AE1-R1");
        a.add("AE1-R2");
        a.add("AE1-R3");
        a.add("AE1-R4");
        a.add("AE1-R5");
        a.add("AD-R14");
        a.add("AD-R15");
        a.add("AD-R16");
        a.add("AD-R17");
        a.add("AD-R18");
        a.add("AE1-RE1");
        a.add("AD-R19");
        a.add("AD-R20");
        a.add("AD-R21");
        a.add("AE2-FE3");
        a.add("AE1-RE2");
        a.add("AE2-FE2");
        a.add("AE2-R1");
        a.add("AE2-R2");
        a.add("AE2-R3");
        a.add("AD-R22");
        a.add("AD-R23");
        a.add("AD-R24");
        a.add("AD-R25");
        a.add("AD-R26");
        a.add("AD-R27");
        a.add("AD-R28");
        a.add("AD-R29");
        a.add("AD-R30");
        a.add("AD-R31");
        a.add("AD-R32");
        a.add("AD-R33");
        a.add("AE2-R4");
        a.add("AE2-R5");
        a.add("AE2-R6");
        a.add("AE2-RE1");
        a.add("AD-RE3");
        a.add("AD-RE2");
        a.add("AE2-RE2");
        a.add("AE2-RE3");
        a.add("AF-RE1");
        a.add("AE2-L6");
        a.add("AE2-L5");
        a.add("AE2-L4");
        a.add("AE2-L3");
        a.add("AF-R13");
        a.add("AF-R12");
        a.add("AF-R11");
        a.add("AF-R10");
        a.add("AF-R9");
        a.add("AE2-L1");
        a.add("AE2-L2");
        a.add("AE2-FE1");
        a.add("AF-R8");
        a.add("AF-R7");
        a.add("AF-R6");
        a.add("AF-R5");
        a.add("AE1-RE3");
        a.add("AE1-L4");
        a.add("AE1-L3");
        a.add("AE1-L2");
        a.add("AE1-L1");
        a.add("AF-R4");
        a.add("AF-R3");
        a.add("AF-R2");
        a.add("AF-R1");
        a.add("AE1-FE2");
        a.add("AF-FE5");
        a.add("AF-FE4");
        a.add("AF-FE1");
        a.add("AF-FE2");
        a.add("AG1-FE3");
        a.add("AG1-FE2");
        a.add("AF-L1");
        a.add("AF-L2");
        a.add("AF-L3");
        a.add("AG1-R1");
        a.add("AG1-R2");
        a.add("AG1-R3");
        a.add("AG1-R4");
        a.add("AG1-R5");
        a.add("AG1-R6");
        a.add("AF-L4");
        a.add("AF-L5");
        a.add("AF-L6");
        a.add("AG1-RE1");
        a.add("AF-L7");
        a.add("AF-L8");
        a.add("AF-L9");
        a.add("AG1-RE2");
        a.add("AG2-FE2");
        a.add("AG2-FE3");
        a.add("AG2-R1");
        a.add("AG2-R2");
        a.add("AG2-R3");
        a.add("AF-L10");
        a.add("AF-L11");
        a.add("AF-L12");
        a.add("AF-L13");
        a.add("AG2-R4");
        a.add("AG2-RE1");
        a.add("AF-RE3");
        a.add("AG2-RE2");
        a.add("AG2-RE3");
        a.add("AH-RE2");
        a.add("AG2-L4");
        a.add("AG2-L3");
        a.add("AG2-L2");
        a.add("AG2-L1");
        a.add("AH-R13");
        a.add("AH-R12");
        a.add("AH-R11");
        a.add("AH-R10");
        a.add("AH-R9");
        a.add("AH-R8");
        a.add("AG2-FE1");
        a.add("AG1-RE3");
        a.add("AG1-L7");
        a.add("AG1-L6");
        a.add("AG1-L5");
        a.add("AH-R7");
        a.add("AH-R6");
        a.add("AH-R5");
        a.add("AH-R4");
        a.add("AH-R3");
        a.add("AH-R2");
        a.add("AH-R1");
        a.add("AG1-L4");
        a.add("AG1-L3");
        a.add("AG1-L2");
        a.add("AG1-FE1");
        a.add("AH-FE2");
        a.add("AK-RE1");
        a.add("AN-L6");
        a.add("AN-L5");
        a.add("AN-L4");
        a.add("AN-L3");
        a.add("AK-R4");
        a.add("AK-R3");
        a.add("AK-R2");
        a.add("AK-R1");
        a.add("AN-L2");
        a.add("AN-L1");
        a.add("AO-L1");
        a.add("AO-L2");
        a.add("AO-L3");
        a.add("AO-L4");
        a.add("AO-L5");
        a.add("AK-L1");
        a.add("AK-L2");
        a.add("AK-L3");
        a.add("AK-L4");
        a.add("AL-R1");
        a.add("AL-R2");
        a.add("AL-R3");
        a.add("AL-R4");
        a.add("AL-RE2");
        a.add("AM-RE1");
        a.add("AL-L4");
        a.add("AL-L3");
        a.add("AM-R4");
        a.add("AM-R3");
        a.add("AM-R2");
        a.add("AM-R1");
        a.add("AL-L2");
        a.add("AL-L1");
        a.add("AO-L6");
        a.add("AO-L7");
        a.add("AO-L8");
        a.add("AO-L9");
        a.add("AO-L10");
        a.add("AO-L11");
        a.add("AM-FE2");
        a.add("AO-L12");
        a.add("AP-L1");
        a.add("AP-L2");
        a.add("AP-L3");
        a.add("AP-L4");
        a.add("AM-FE1");
        a.add("AM-L2");
        a.add("AM-L3");
        a.add("AM-L4");
        a.add("AP-L5");
        a.add("AP-L6");
        a.add("AP-L7");
        a.add("AM-RE3");
        a.add("AM-RE2");
        a.add("AI-FE2");
        a.add("AI-FE3");
        a.add("AI-R1");
        a.add("AI-R2");
        a.add("AI-R3");
        a.add("AH-L1");
        a.add("AH-L2");
        a.add("AH-L3");
        a.add("AH-L4");
        a.add("AH-L5");
        a.add("AH-L6");
        a.add("AI-R4");
        a.add("AI-R5");
        a.add("AI-R6");
        a.add("AI-R7");
        a.add("AI-R8");
        a.add("AI-R9");
        a.add("AH-L7");
        a.add("AH-L8");
        a.add("AH-L9");
        a.add("AH-L10");
        a.add("AH-L11");
        a.add("AH-L12");
        a.add("AI-R10");
        a.add("AI-R11");
        a.add("AI-R12");
        a.add("AH-L13");
        a.add("AH-RE3");
        a.add("AI-RE2");
        a.add("AI-RE3");
        a.add("AI-RE4");
        a.add("AI-L19");
        a.add("AI-L18");
        a.add("AI-L17");
        a.add("AI-L16");
        a.add("AI-L15");
        a.add("AI-L14");
        a.add("AI-L13");
        a.add("AI-L12");
        a.add("AI-L11");
        a.add("AI-L10");
        a.add("AI-L9");
        a.add("AI-L8");
        a.add("AI-L7");
        a.add("AI-L6");
        a.add("AI-L5");
        a.add("AI-L4");
        a.add("AI-L3");
        a.add("AI-L2");
        a.add("AI-L1");
        a.add("AJ-FE1");
        a.add("AJ-FE2");
        a.add("AJ-FE3");
        a.add("AJ-FE4");
        a.add("AJ-R1");
        a.add("AJ-R23");
        a.add("AJ-R2");
        a.add("AJ-R24");
        a.add("AJ-R3");
        a.add("AJ-R25");
        a.add("AJ-R4");
        a.add("AJ-R26");
        a.add("AJ-R5");
        a.add("AJ-R27");
        a.add("AJ-R6");
        a.add("AJ-R28");
        a.add("AJ-R7");
        a.add("AJ-R29");
        a.add("AJ-R8");
        a.add("AJ-R30");
        a.add("AJ-R9");
        a.add("AJ-R31");
        a.add("AJ-R10");
        a.add("AJ-R32");
        a.add("AJ-R11");
        a.add("AJ-R33");
        a.add("AJ-R12");
        a.add("AJ-R34");
        a.add("AJ-R13");
        a.add("AJ-R35");
        a.add("AJ-R14");
        a.add("AJ-R36");
        a.add("AJ-R15");
        a.add("AJ-R37");
        a.add("AJ-R16");
        a.add("AJ-R38");
        a.add("AJ-R17");
        a.add("AJ-R39");
        a.add("AJ-R18");
        a.add("AJ-R40");
        a.add("AJ-R19");
        a.add("AJ-R41");
        a.add("AJ-R20");
        a.add("AJ-R42");
        a.add("AJ-R21");
        a.add("AJ-R43");
        a.add("AJ-R22");
        a.add("AJ-R44");
        a.add("AJ-RE2");
        a.add("AJ-RE3");
        a.add("AJ-RE4");
        a.add("AJ-L22");
        a.add("AJ-L44");
        a.add("AJ-L21");
        a.add("AJ-L43");
        a.add("AJ-L20");
        a.add("AJ-L42");
        a.add("AJ-L19");
        a.add("AJ-L41");
        a.add("AJ-L18");
        a.add("AJ-L40");
        a.add("AJ-L17");
        a.add("AJ-L39");
        a.add("AJ-L16");
        a.add("AJ-L38");
        a.add("AJ-L15");
        a.add("AJ-L37");
        a.add("AJ-L14");
        a.add("AJ-L36");
        a.add("AJ-L13");
        a.add("AJ-L35");
        a.add("AJ-L12");
        a.add("AJ-L34");
        a.add("AJ-L11");
        a.add("AJ-L33");
        a.add("AJ-L10");
        a.add("AJ-L32");
        a.add("AJ-L9");
        a.add("AJ-L31");
        a.add("AJ-L8");
        a.add("AJ-L30");
        a.add("AJ-L7");
        a.add("AJ-L29");
        a.add("AJ-L6");
        a.add("AJ-L28");
        a.add("AJ-L5");
        a.add("AJ-L27");
        a.add("AJ-L4");
        a.add("AJ-L26");
        a.add("AJ-L3");
        a.add("AJ-L25");
        a.add("AJ-L2");
        a.add("AJ-L24");
        a.add("AJ-L1");
        a.add("AJ-L23");
        a.add("AQ-L1");
        a.add("AQ-L2");
        a.add("AQ-L3");
        a.add("AQ-L4");
        a.add("AQ-L5");
        a.add("AQ-L6");
        a.add("AQ-L7");
        a.add("AQ-L8");
        a.add("AQ-L9");
        a.add("AQ-L10");
        a.add("AQ-L11");
        a.add("AQ-L12");
        a.add("AQ-L13");
        a.add("AQ-L14");
        a.add("AQ-L15");
        a.add("AQ-L16");
        a.add("AQ-L17");
        a.add("AQ-L18");
        a.add("AQ-L19");
        a.add("AQ-L20");

        return a;
    }
}