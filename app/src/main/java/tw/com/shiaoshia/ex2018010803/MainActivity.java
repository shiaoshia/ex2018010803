package tw.com.shiaoshia.ex2018010803;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String str[] = {"John","Tom","Andy","Amy","Merry"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listView);
        myAdapter adapter = new myAdapter();
        lv.setAdapter(adapter);

    }

    class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return str.length;
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
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View v = inflater.inflate(R.layout.mylayout,null);

            TextView tv = v.findViewById(R.id.textView);
            tv.setText("Hello" + position + " " +str[position]);

            return v;
        }
    }

}
