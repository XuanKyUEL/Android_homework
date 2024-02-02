package com.example.login_ex1;

import static android.graphics.Color.BLACK;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtRegister = findViewById(R.id.txtregister);
        txtRegister.setPaintFlags(txtRegister.getPaintFlags() | android.graphics.Paint.UNDERLINE_TEXT_FLAG);

//        TextView signUpText = findViewById(R.id.txtforgotpassword);
//        String fullText = signUpText.getText().toString();
//        SpannableString spanString = new SpannableString(fullText);
//
//        int start = fullText.indexOf("Sign Up");
//        int end = start + "Sign Up".length();
//        spanString.setSpan(new UnderlineSpan(), start, end, 0);
//        spanString.setSpan(new ForegroundColorSpan(Color.BLACK), start, end, 0);
//
//        signUpText.setText(spanString);
    }
}