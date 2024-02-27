package exercise.mcommerce.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import exercise.mcommerce.models.Beers;
import exercise.mcommerce.recycleview_ex.R;

public class recyAdapter extends RecyclerView.Adapter<recyAdapter.ViewHolder> {
    private final List<Beers> list;
    // Constructor
    public recyAdapter(List<Beers> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public recyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyAdapter.ViewHolder holder, int position) {
        Beers beer = list.get(position);
        holder.beerName.setText(beer.getBeerName());
        // Convert double to string, add đ to the end and add separator
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
        String formattedPrice = numberFormat.format(beer.getBeerPrice()) + " đ";
        holder.beerPrice.setText(formattedPrice);
        holder.beerImage.setImageResource(beer.getBeerThumb());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView beerImage;
        TextView beerName, beerPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            beerImage = itemView.findViewById(R.id.beerImage);
            beerName = itemView.findViewById(R.id.beerName);
            beerPrice = itemView.findViewById(R.id.beerPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Do something when the item is clicked
                    Beers selectedBeer = list.get(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), selectedBeer.getBeerName() +"-" + selectedBeer.getRoundBeerPrice(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // Do something when the item is held
                    Beers selectedBeer = list.get(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Deleted " + selectedBeer.getBeerName(), Toast.LENGTH_SHORT).show();
                    list.remove(selectedBeer);
                    notifyItemMoved(getAdapterPosition(), list.size() - 1);
                    return true;
                }
            });
        }
    }
}

