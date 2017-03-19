package android.bignerdranch.com.weather;

import com.alibaba.fastjson.JSON;

/**
 * Created by dell on 2017/3/19.
 */
public class JsonUtils {
    /**
     * 返回NowBean;
     * @param jsonString
     * @return
     */
    public static JsonBean.ResultsBean.NowBean parseData(String jsonString){
        JsonBean jsonBean = JSON.parseObject(jsonString,JsonBean.class);
        JsonBean.ResultsBean resultsBean = jsonBean.getResults().get(0);
        return resultsBean.getNow();
    }
}
