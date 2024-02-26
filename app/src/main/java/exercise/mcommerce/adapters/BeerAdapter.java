package exercise.mcommerce.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import exercise.mcommerce.gridview.R;
import exercise.mcommerce.models.Beers;

public class BeerAdapter extends BaseAdapter {

    Activity context;
    int item_Layout;
    List<Beers> list;

    // Constructor
    public BeerAdapter(
            Activity context,
            int item_Layout,
            List<Beers> list
    ) {
        this.context = context;
        this.item_Layout = item_Layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            // Inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    context.LAYOUT_INFLATER_SERVICE
            );
            holder = new ViewHolder();
            convertView = inflater.inflate(item_Layout, null);
            holder.beerImage = convertView.findViewById(R.id.beerImage);
            holder.beerName = convertView.findViewById(R.id.beerName);
            holder.beerPrice = convertView.findViewById(R.id.beerPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Set data
        Beers beers = list.get(position);
        holder.beerImage.setImageResource(beers.getBeerThumb());
        holder.beerName.setText(beers.getBeerName());
        holder.beerPrice.setText(Math.round(beers.getBeerPrice()) + " VND");

        return convertView;
    }

    public void remove(Beers beers) {
        list.remove(beers);
    }

    private class ViewHolder {
        ImageView beerImage;
        TextView beerName, beerPrice;
    }
}
