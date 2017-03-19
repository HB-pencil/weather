package android.bignerdranch.com.weather;

/**
 * Created by dell on 2017/3/18.城市Model类
 */
public class City {
    private String name;
    private String weather;
    private String temperature;
    private String rage;
    private String wind;

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setRage(String rage) {
        this.rage = rage;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getRage() {
        return rage;
    }

    public String getWind() {
        return wind;
    }

    public String getName() {
        return name;
    }
}
