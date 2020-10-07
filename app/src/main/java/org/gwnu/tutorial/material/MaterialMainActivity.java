package org.gwnu.tutorial.material;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import org.gwnu.tutorial.R;

public class MaterialMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RelativeLayout frontLayout;
    private LinearLayout backLayout;
    private TextView textView;
    private RadioButton rbYes, rbNo;
    private RelativeLayout.LayoutParams lp;
    MenuItem itemcheck;
    boolean showBackLayout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_main);

        toolbar = findViewById(R.id.toolbar);
        frontLayout = findViewById(R.id.front_layout);
        backLayout = findViewById(R.id.back_layout);
        textView = findViewById(R.id.front_text);
        rbYes = findViewById(R.id.rb_yes);
        rbNo = findViewById(R.id.rb_no);

        initListener();

        setSupportActionBar(toolbar);
    }

    private void initListener() {
        rbYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("You Choose Yes");
            }
        });

        rbNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("You Choose No");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu this adds items to the action bar if is present

        getMenuInflater().inflate(R.menu.menu_item, menu);
        itemcheck = menu.findItem(R.id.action_pilih);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_pilih) {
            dropLayout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dropLayout() {
        showBackLayout = !showBackLayout;
        itemcheck.setIcon(ContextCompat.getDrawable(
                MaterialMainActivity.this, showBackLayout ? R.drawable.close : R.drawable.pilih
        ));

        lp = (RelativeLayout.LayoutParams) frontLayout.getLayoutParams();

        if (showBackLayout) {
            ValueAnimator var = ValueAnimator.ofInt(backLayout.getHeight());
            Log.d("My Log", "backLayout: " + backLayout.getHeight());
            var.setDuration(1000);
            var.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    lp.setMargins(0, (Integer) valueAnimator.getAnimatedValue(), 0, 0);
                    Log.d("My Log", "valueAnimator: " + (Integer) valueAnimator.getAnimatedValue());
                    frontLayout.setLayoutParams(lp);
                }
            });

            var.start();
        } else {
            lp.setMargins(0, 0, 0, 0);
            frontLayout.setLayoutParams(lp);
            TranslateAnimation anim = new TranslateAnimation(
                    0, 0, backLayout.getHeight(), 0
            );

            anim.setStartOffset(0);
            anim.setDuration(1000);
            frontLayout.setAnimation(anim);
        }
    }
}