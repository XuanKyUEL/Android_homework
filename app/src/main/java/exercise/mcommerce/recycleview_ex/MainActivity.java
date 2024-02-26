package exercise.mcommerce.recycleview_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import exercise.mcommerce.adapters.recyAdapter;
import exercise.mcommerce.models.Beers;
import exercise.mcommerce.recycleview_ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    recyAdapter adapter;

    ArrayList<Beers> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        loadData();
        addEventes();

    }

    private int currentItem = 0;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (currentItem == adapter.getItemCount()) {
                currentItem = 0;
            }
            binding.recyclerView.smoothScrollToPosition(currentItem++);
            handler.postDelayed(this, 2500);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 2500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new Beers(R.drawable.beer333, "Beer 333", 20000.0));
        data.add(new Beers(R.drawable.hanoi, "Beer Hanoi", 25000.0));
        data.add(new Beers(R.drawable.saigon, "Beer Saigon", 30000.0));
        data.add(new Beers(R.drawable.tiger, "Beer Tiger", 35000.0));
        data.add(new Beers(R.drawable.larue, "Beer Larue", 40000.0));
        data.add(new Beers(R.drawable.sapporo, "Beer Sapporo", 45000.0));
        data.add(new Beers(R.drawable.heineken, "Beer Heineken", 50000.0));
        adapter = new recyAdapter(data);
    }

    private void loadData() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
    }

    private void addEventes() {
        // on click show toast of beer name
    }
}