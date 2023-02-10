package hungnguyen.nth.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import hungnguyen.nth.eventhandling.model.Tenology;
import hungnguyen.nth.eventhandling.model.TenologyAdapter;

public class ListView_Demo_2 extends AppCompatActivity {
    private ListView lv;
    TenologyAdapter adapter;
    private Tenology[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo2);
        lv = findViewById(R.id.lview);
        initView();
        adapter = new TenologyAdapter(this, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i=0;i<lv.getAdapter().getCount();i++){
                    lv.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                lv.getChildAt(position).setBackgroundColor(Color.BLUE);
                Tenology t= adapter.getItem(position);
                Toast.makeText(getApplicationContext(), t.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView(){
        Integer[] imgs = {R.drawable.menu_1,R.drawable.menu_2,R.drawable.menu_3};
        String[] name = {"Android","Ios","Window"};
        String[] sub = {"sub_1","sub_2","sub_3"};
        String[] des = {"des----1","des-----2","des-----3"};
        list = new Tenology[imgs.length];
        for(int i=0;i<list.length;i++){
            list[i] = new Tenology(imgs[i],name[i],sub[i],des[i]);

        }
    }
}