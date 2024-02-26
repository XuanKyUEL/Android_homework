package exercise.mcommerce.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import exercise.mcommerce.gridview.databinding.ActivityOnClickDetailsBinding;

public class on_click_details extends AppCompatActivity {

    ActivityOnClickDetailsBinding binding;
    ImageView beerThumb;
    TextView beerName, beerPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnClickDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        beerName = binding.beerName;
        beerPrice = binding.beerPrice;
        beerThumb = binding.beerImage;

        Intent intent = getIntent();
        if (intent != null) {
            beerThumb.setImageResource(intent.getIntExtra("beerThumb", 0));
            beerName.setText(intent.getStringExtra("beerName"));
            // Round the price to 0 decimal places, add the currency symbol and thousand separator
            double price = intent.getDoubleExtra("beerPrice", 0.0);
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
            String formattedPrice = numberFormat.format(price) + " đ";
            beerPrice.setText(formattedPrice);
        }
        addEvents();
    }

    private void addEvents() {
        binding.btnBack.setOnClickListener(v -> {
            // Rollback to previous activity
            finish();
        });
    }
}