package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class ExtCall {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    postShipment(finalI);
                }
            }).start();

            int finalI1 = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    post22(finalI1);
                }
            }).start();
        }
        //get();
    }

    private static void get() {
        try {

            URL url = new URL("https://dev-api.morrisons.com/purchaseorder/v1/customers/@all/orders?" +
                    "apikey=IteGQMhWdc5anH1Al8xPvQCHi8LDLPz3&deliverydate[gt]=20100101");
            Proxy proxy = getWmmproxyservice();
            HttpURLConnection conn = getConn(url, proxy);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            conn.setRequestProperty("Authorization", "Basic " + "SXRlR1FNaFdkYzVhbkgxQWw4eFB2UUNIaThMRExQejM6Z0xpTXFEWmhHSDZvNnNuRw==");

            if (conn.getResponseCode() != 200) {
                System.out.println(conn);
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

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
}
