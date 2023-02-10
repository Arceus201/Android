package hungnguyen.nth.eventhandling.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import hungnguyen.nth.eventhandling.R;

public class TenologyAdapter extends ArrayAdapter<Tenology> {
    // hien thi tren context
    private Context context;
    // chua 1 danh sach
    private Tenology[] mlist;
    public TenologyAdapter(@NonNull Context context, Tenology[] mlist) {
        super(context, R.layout.item_listview_2,mlist);
        this.context = context;
        this.mlist = mlist;
    }
    //adapter tra ve 1 view

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.item_listview_2, null,true);

        // tham chieu
        ImageView img = view.findViewById(R.id.img);
        TextView tname = view.findViewById(R.id.tname);
        TextView tsub = view.findViewById(R.id.tsub);
        TextView tdes = view.findViewById(R.id.tdes);

        // gan du lieu
        Tenology t  = mlist[position];
        img.setImageResource(t.getImg());
        tname.setText(t.getName());
        tsub.setText(t.getSub());
        tdes.setText(t.getDes());

        return view;
    }
    public Tenology getItem(int position){
        return mlist[position];
    }
}
