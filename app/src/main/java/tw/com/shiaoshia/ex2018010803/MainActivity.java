package tw.com.shiaoshia.ex2018010803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    //String str[] = {"John","Tom","Andy","Amy","Merry"};
    //String str1[] = {"01","02","03","04","05"};
    //int img[] = {R.drawable.images001,R.drawable.images002,R.drawable.images003,
            //R.drawable.images001,R.drawable.images002};
    ArrayList<Map<String,Object>> myList = new ArrayList<>();
    boolean chks[] = new boolean[6]; //記憶checkbox狀態
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView);
        myAdapter adapter = new myAdapter();
        lv.setAdapter(adapter);

        HashMap<String,Object> m1 = new HashMap<>();
        m1.put("name","Tom");
        m1.put("code","01");
        m1.put("img",R.drawable.images001);
        myList.add(m1);
        HashMap<String,Object> m2 = new HashMap<>();
        m2.put("name","John");
        m2.put("code","02");
        m2.put("img",R.drawable.images002);
        myList.add(m2);
        HashMap<String,Object> m3 = new HashMap<>();
        m3.put("name","Amy");
        m3.put("code","03");
        m3.put("img",R.drawable.images003);
        myList.add(m3);
        HashMap<String,Object> m4 = new HashMap<>();
        m4.put("name","Tom2");
        m4.put("code","201");
        m4.put("img",R.drawable.images001);
        myList.add(m4);
        HashMap<String,Object> m5 = new HashMap<>();
        m5.put("name","John2");
        m5.put("code","202");
        m5.put("img",R.drawable.images002);
        myList.add(m5);
        HashMap<String,Object> m6 = new HashMap<>();
        m6.put("name","Amy2");
        m6.put("code","203");
        m6.put("img",R.drawable.images003);
        myList.add(m3);
    }

    class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            Log.d("GatView","position" + position);
            View v = inflater.inflate(R.layout.mylayout,null);

            TextView tv = v.findViewById(R.id.textView);
            tv.setText(myList.get(position).get("name").toString());
            TextView tv1 = v.findViewById(R.id.textView2);
            tv1.setText(myList.get(position).get("code").toString());
            ImageView iv = v.findViewById(R.id.imageView);
            iv.setImageResource((Integer)myList.get(position).get("img"));
            CheckBox cb = v.findViewById(R.id.checkBox);
            cb.setChecked(chks[position]);  //儲存checkbox狀態
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    chks[position] = b; //儲存checkbox狀態
                }
            });
            return v;
        }
    }

}
