package com.breum.airwallet;

       import android.app.Activity;
       import android.bluetooth.BluetoothAdapter;
       import android.content.Context;
       import android.util.Log;
       import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

       import java.util.ArrayList;
       import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
  //  private final String[] itemname;
//    private final Integer[] imgid;
//    private final String[] price;
    //private Context context;
    private ArrayList<String> itemname;
    private ArrayList<String> price;
    private ArrayList<Integer> BT_used_index;

    private BluetoothAdapter bTAdapter;
    Integer[] imgid = {
            R.mipmap.box
    };

    public CustomListAdapter(Activity context, ArrayList<String> itemname, ArrayList<String> price ,BluetoothAdapter bTAdapter ,ArrayList<Integer> index_used){
        super(context, android.R.layout.simple_list_item_1);
        this.bTAdapter = bTAdapter;
        this.context = context;
        this.itemname = itemname;
        this.BT_used_index = index_used;
        // TODO Auto-generated constructor stub

      // this.itemname=itemname;
//        this.imgid=imgid;
           this.price=price;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_pics, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        Log.d("NAME in cstmadapter : ", price.get(position));

        txtTitle.setText(itemname.get(BT_used_index.get(position)));
        imageView.setImageResource(imgid[0]);
        extratxt.setText("Pris pr. time: " + price.get(BT_used_index.get(position)) + " DKK");
        return rowView;

    };
}