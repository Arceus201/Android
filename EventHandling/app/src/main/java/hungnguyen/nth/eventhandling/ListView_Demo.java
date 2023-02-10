package hungnguyen.nth.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_Demo extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_demo);
        lv = findViewById(R.id.lview);
        initListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), selection, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initListView(){
        String [] list = getResources().getStringArray(R.array.technology);
        adapter = new ArrayAdapter<>(this, R.layout.item_listview,list);
        lv.setAdapter(adapter);
    }
}