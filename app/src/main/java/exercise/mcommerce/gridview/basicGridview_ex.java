package exercise.mcommerce.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import exercise.mcommerce.gridview.databinding.ActivityBasicGridviewExBinding;

public class basicGridview_ex extends AppCompatActivity {

    ActivityBasicGridviewExBinding binding;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasicGridviewExBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void loadData() {
        String[] data = {"Máy ảnh", "Laptop", "Điện thoại", "Máy tính bảng", "Tai nghe", "Loa", "Ổ cứng di động", "USB", "Thẻ nhớ", "Pin sạc", "Bàn phím", "Chuột"};
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        binding.gridView.setAdapter(adapter);
    }

    private void addEvents() {
    }
}