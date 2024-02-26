package exercise.mcommerce.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import exercise.mcommerce.adapters.BeerAdapter;
import exercise.mcommerce.gridview.databinding.ActivityAdvancedGridviewExBinding;
import exercise.mcommerce.models.Beers;

public class advancedGridview_ex extends AppCompatActivity {

    ActivityAdvancedGridviewExBinding binding;

    BeerAdapter adapter;

    ArrayList<Beers> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdvancedGridviewExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        loadData();
        addEvents();

    }

    private void initData() {
        beers = new ArrayList<>();
        beers.add(new Beers(R.drawable.beer333, "Beer 333", 20000.0));
        beers.add(new Beers(R.drawable.hanoi, "Beer Hanoi", 25000.0));
        beers.add(new Beers(R.drawable.saigon, "Beer Saigon", 30000.0));
        beers.add(new Beers(R.drawable.tiger, "Beer Tiger", 35000.0));
        beers.add(new Beers(R.drawable.larue, "Beer Larue", 40000.0));
        beers.add(new Beers(R.drawable.sapporo, "Beer Sapporo", 45000.0));
    }

    private void loadData() {
        adapter = new BeerAdapter(
                advancedGridview_ex.this,
                R.layout.item_layout,
                beers
        );
        binding.gridViewAdvanced.setAdapter(adapter);
    }

    private void addEvents() {
        binding.gridViewAdvanced.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Beers selectedBeer = beers.get(position);
                Intent intent = new Intent(advancedGridview_ex.this, on_click_details.class);
                intent.putExtra("beerThumb", selectedBeer.getBeerThumb());
                intent.putExtra("beerName", selectedBeer.getBeerName());
                intent.putExtra("beerPrice", selectedBeer.getBeerPrice());
                startActivity(intent);
            }
        });
        // hold to delete
        binding.gridViewAdvanced.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast.makeText(advancedGridview_ex.this, "Deleted " + beers.get(position).getBeerName(), Toast.LENGTH_SHORT).show();
            beers.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}