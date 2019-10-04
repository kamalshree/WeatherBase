package tech.whatsupcoders.weatherbase.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import tech.whatsupcoders.weatherbase.BuildConfig;

public class WeatherHttpClient {
    static String api_key=BuildConfig.API_KEY;
    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static String API_KEY = "&appid="+api_key+"&units=metric";


    public String getWeatherData(String location) {
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            con = (HttpURLConnection) (new URL(BASE_URL + location + API_KEY)).openConnection();
            con.setRequestMethod("GET");
            con.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null)
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }

        return null;

    }
}
