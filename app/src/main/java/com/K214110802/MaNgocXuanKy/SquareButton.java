package com.K214110802.MaNgocXuanKy;

import android.content.Context;
import android.util.AttributeSet;
import android.graphics.drawable.GradientDrawable;


public class SquareButton extends androidx.appcompat.widget.AppCompatButton {

    public SquareButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(getResources().getColor(R.color.login_btn_color)); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(20);
        this.setBackground(gd);
    }

    public SquareButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // This is the key line
    }
}
