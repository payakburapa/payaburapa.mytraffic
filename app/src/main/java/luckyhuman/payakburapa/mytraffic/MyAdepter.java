package luckyhuman.payakburapa.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PAYAK on 05/06/2559.
 */
public class MyAdepter extends BaseAdapter{

    //Explicit สร้างตัวแปล
    private Context context;
    private int[] ints;
    private String[] nameStrings, detailStrings;


    public MyAdepter(Context context,
                     int[] ints,
                     String[] nameStrings,
                     String[] detailStrings) {//Constructor มีหน้าที่ Set ค่าของตัวแปลเป็นแค่าเริ่มต้น (กดคีย์ Alt+insert แล้วกด Enter)
        this.context = context;
        this.ints = ints;
        this.nameStrings = nameStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//เป็นการเปิด Service
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //For Image
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);
        imageView.setImageResource(ints[i]);

        //For TextView
        TextView nameTextView = (TextView) view1.findViewById(R.id.textView2);
        nameTextView.setText(nameStrings[i]);

        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);
        detailTextView.setText(detailStrings[i]);

        return view1;
    }
}// Main Class
