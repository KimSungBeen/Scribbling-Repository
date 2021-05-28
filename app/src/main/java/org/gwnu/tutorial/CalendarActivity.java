package org.gwnu.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import org.gwnu.tutorial.databinding.ActivityCalendarBinding;

public class CalendarActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;
    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setBinding(this);
    }

    public long currentTime() {
        return System.currentTimeMillis();
    }
}