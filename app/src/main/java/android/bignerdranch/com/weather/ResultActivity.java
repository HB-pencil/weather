package android.bignerdranch.com.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by dell on 2017/3/18.结果Activity。
 */
public class ResultActivity extends AppCompatActivity {
    private static final String CITY = "city";
    private String city;
    private String url;
    private String jsonString;
    private TextView tempText;
    private TextView cityText;
    private TextView weatherText;
    private static final int UPDATE = 0;
    private String temperature;
    private String weather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tempText = (TextView) findViewById(R.id.temp);
        weatherText = (TextView) findViewById(R.id.weather);
        cityText = (TextView) findViewById(R.id.city_name);
        city = getIntent().getStringExtra(CITY);

        /**
         * 使用okHttp发起请求
         */
        url = "https://api.thinkpage.cn/v3/weather/now.json?key=cnywry1tedemwh0i&location=" + city + "&language=zh-Hans&unit=c";
        new Thread(new Runnable() {
             okHttpUtils request = new okHttpUtils();
                 @Override
                 public void run() {
                  try{
                      jsonString = request.run(url);
                  }catch (Exception e){
                      e.getMessage();
                  }
                      System.out.println("测试" + url + jsonString);

                     /**
                      * 解析Json数据
                      */

                      JsonBean.ResultsBean.NowBean mNow = JsonUtils.parseData(jsonString);
                      System.out.println("Test" + mNow.getTemperature()+ mNow.getText());
                      temperature = mNow.getTemperature();
                      weather = mNow.getText();

                      handler.obtainMessage(UPDATE).sendToTarget();
             }
        }).start();

    }

    /**
     * 主线程Handle修改UI
     */

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE:
                    tempText.setText(temperature + "℃");
                    weatherText.setText(weather);
                    cityText.setText(city);
            }
        }
    };
        /**
         * 传入城市名字并启动Activity
         */
    public static Intent newInstance(Context context,String cityname){
        Intent intent = new Intent(context,ResultActivity.class);
        intent.putExtra(CITY,cityname);
        return intent;
    }
}
