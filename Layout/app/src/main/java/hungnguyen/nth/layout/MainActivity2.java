package hungnguyen.nth.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some_widgets_6);
        sp = findViewById(R.id.sp1);
        String [] list = getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item,list);
        sp.setAdapter(adapter);

    }
}