package exercise.mcommerce.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // convert to modified list
        List<String> modifiedList = new ArrayList<>(Arrays.asList(data));
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                modifiedList
        );
        binding.gridView.setAdapter(adapter);
    }

    private void addEvents() {
        // Hold to delete
        binding.gridView.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast.makeText(
                    basicGridview_ex.this,
                    "Xóa " + adapter.getItem(position) + " thành công",
                    Toast.LENGTH_SHORT).show();
            adapter.remove(adapter.getItem(position));
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}