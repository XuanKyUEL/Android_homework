package exercise.mcommerce.recycleview_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import exercise.mcommerce.recycleview_ex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEventes();

    }

    private void loadData() {
        String[] data = {"Máy ảnh", "Laptop", "Điện thoại", "Máy tính bảng", "Tai nghe", "Loa", "Ổ cứng di động", "USB", "Thẻ nhớ", "Pin sạc", "Bàn phím", "Chuột"};
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
//        binding.recyclerView.setAdapter(adapter);
    }

    private void addEventes() {
    }
}