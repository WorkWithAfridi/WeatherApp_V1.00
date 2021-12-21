package com.kyotobytes.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {
    private String mTemperature, Micon, mCity,mWeatherType;
    private int mCondition;
    public static weatherData fromJson(JSONObject jsonObject){
        try{
            weatherData weatherD = new weatherData();
            weatherD.mCity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.Micon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;
        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int Condition) {
        if(Condition>=0 && Condition<=300){
            return "thunderstorm";
        }
        if(Condition>=300 && Condition<=500){
            return "lightrain";
        }
        if(Condition>=500 && Condition<=600){
            return "shower";
        }
        if(Condition>=600 && Condition<=700){
            return "show";
        }
        if(Condition>=700 && Condition<=771){
            return "fog";
        }
        if(Condition>=772 && Condition<=800){
            return "overcast";
        }
        if(Condition==8000){
            return "sunny";
        }
        if(Condition>=801 && Condition<=804){
            return "cloudy";
        }
        if(Condition>=900 && Condition<=902){
            return "thunderstorm";
        }
        if(Condition>=905 && Condition<=1000){
            return "thunderstorm";
        }
        if(Condition==903){
            return "show";
        }
        if(Condition==904){
            return "sunny";
        }

        return "finding";
    }

    public String getmTemperature() {
        return mTemperature+"ºC";
    }

    public String getMicon() {
        return Micon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
