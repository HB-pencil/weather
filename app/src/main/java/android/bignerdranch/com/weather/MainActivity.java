package android.bignerdranch.com.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG","log");
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recyler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        /**
         * 配置Adapter
         */
        List<City> citylist = new ArrayList<>();
        City city1 = new City();
        city1.setName("广州");
        citylist.add(city1);

        City city2 = new City();
        city2.setName("深圳");
        citylist.add(city2);

        City city3 = new City();
        city3.setName("佛山");
        citylist.add(city3);

        City city4 = new City();
        city4.setName("珠海");
        citylist.add(city4);

        City city5 = new City();
        city5.setName("中山");
        citylist.add(city5);

        City city6 = new City();
        city6.setName("东莞");
        citylist.add(city6);

        City city7 = new City();
        city7.setName("惠州");
        citylist.add(city7);

        City city8 = new City();
        city8.setName("汕头");
        citylist.add(city8);

        City city9 = new City();
        city9.setName("湛江");
        citylist.add(city9);

        City city10 = new City();
        city10.setName("江门");
        citylist.add(city10);

        myAdapter adapter = new myAdapter(citylist);
        mRecyclerView.setAdapter(adapter);
    }

    private class CityHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTextView;
        public CityHolder(View view){
            super(view);
            view.setOnClickListener(this);
            mTextView = (TextView) view.findViewById(R.id.city_text);
        }

        /**
         * 为Item设置点击事件
          * @param view
         */
        @Override
        public void onClick(View view){
            Intent i = ResultActivity.newInstance(MainActivity.this,mTextView.getText().toString());
            startActivity(i);
        }

        /**
         * 绑定数据
         */
        public void bindData(City city){
            mTextView.setText(city.getName());
        }
    }

    private class myAdapter extends RecyclerView.Adapter<CityHolder>{
        List<City> mCities;
        public myAdapter(List<City> cities){
            mCities = cities;
        }

        @Override
        public CityHolder onCreateViewHolder(ViewGroup container,int viewType){
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.item_list,container,false);
            return new CityHolder(view);
        }

        @Override
        public void onBindViewHolder(CityHolder holdert,int position){
            City city = mCities.get(position);
            holdert.bindData(city);
        }

        @Override
        public int getItemCount(){
            return mCities.size();
        }
    }
}
