package tech.whatsupcoders.weatherbase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tech.whatsupcoders.weatherbase.models.Location;
import tech.whatsupcoders.weatherbase.models.Weather;

public class JSONWeatherParser {
    public static Weather getWeather(String data) throws JSONException {
        Weather weather = new Weather();

        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);

        // We start extracting the info
        Location loc = new Location();

        JSONObject sysObj = getObject("sys", jObj);
        loc.setCountry(getString("country", sysObj));
        loc.setSunrise(getInt("sunrise", sysObj));
        loc.setSunset(getInt("sunset", sysObj));
        loc.setCity(getString("name", jObj));
        weather.location = loc;

        weather.setName(jObj.getString("name"));
        weather.setDt(jObj.getLong("dt"));
        // We get weather info (This is an array)
        JSONArray jArr = jObj.getJSONArray("weather");

        // currentCondition
        JSONObject JSONWeather = jArr.getJSONObject(0);
        weather.currentCondition.setDescr(getString("description", JSONWeather));

        // Main
        JSONObject mainObj = getObject("main", jObj);
        weather.main.setHumidity(getString("humidity", mainObj));
        weather.main.setPressure(getString("pressure", mainObj));
        weather.main.setTempMin(getString("temp_min", mainObj));
        weather.main.setTempMax(getString("temp_max", mainObj));
        weather.main.setTemp(getFloat("temp", mainObj));


        // Wind
        JSONObject wObj = getObject("wind", jObj);
        weather.wind.setSpeed(getString("speed", wObj));


        return weather;
    }


    private static JSONObject getObject(String tagName, JSONObject jObj) throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }

    private static int getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }
}
