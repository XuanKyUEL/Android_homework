package exercise.mcommerce.recycleview_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
    private boolean isScrollingRight = true;

    private int currentItem = 0;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (currentItem >= adapter.getItemCount()) {
                currentItem = 0;
                LinearLayoutManager layoutManager = (LinearLayoutManager) binding.recyclerView.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(0, 0);
                isScrollingRight = true; // Đặt lại hướng cuộn là sang phải khi đã đến mục cuối cùng
            } else if (currentItem <= 0) {
                currentItem = adapter.getItemCount() - 1;
                LinearLayoutManager layoutManager = (LinearLayoutManager) binding.recyclerView.getLayoutManager();
                layoutManager.scrollToPositionWithOffset(adapter.getItemCount() - 1, 0);
                isScrollingRight = false; // Đặt lại hướng cuộn là sang trái khi đã đến mục đầu tiên
            } else {
                if (isScrollingRight) {
                    binding.recyclerView.smoothScrollToPosition(currentItem++);
                } else {
                    binding.recyclerView.smoothScrollToPosition(currentItem--);
                }
            }
            handler.postDelayed(this, 2000);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 2000);
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

//    public class CustomDividerItemDecoration extends DividerItemDecoration {
//        private final int verticalSpaceHeight;
//
//        public CustomDividerItemDecoration(Context context, int orientation, int verticalSpaceHeight) {
//            super(context, orientation);
//            this.verticalSpaceHeight = verticalSpaceHeight;
//        }
//
//        @Override
//        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            if (parent.getChildAdapterPosition(view) == 0) {
//                outRect.top = verticalSpaceHeight;
//            }
//            outRect.bottom = verticalSpaceHeight;
//        }
//    }

    private void loadData() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);

        // Add a line between each item
//        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        // Custom line's color and size
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        Drawable drawable = getResources().getDrawable(R.drawable.custom_divider);
        assert drawable != null;
        itemDecoration.setDrawable(drawable);
        binding.recyclerView.addItemDecoration(itemDecoration);

        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void addEventes() {
        // on click show toast of beer name
    }
}