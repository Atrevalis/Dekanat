package GUI.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

public class HttpURLConnection {

//    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "http://localhost:8081";

    private static final String POST_URL = "http://localhost:8081";

    private static final String POST_PARAMS = "userName=Pankaj";


    public static String sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // con.setRequestProperty("User-Agent", USER_AGENT); int responseCode =
        con.getResponseCode();
        //System.out.println("GET Response Code :: " + responseCode);
        // if (responseCode == HttpURLConnection.HTTP_OK) { // success
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }


    public static int sendPOST(String json,String method) throws IOException {
        URL obj = new URL(POST_URL+method);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        return  con.getResponseCode();
    }

    public static String sendPOSTWaitAns(String json,String method) throws IOException {
        URL obj = new URL(POST_URL+method);
        java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}