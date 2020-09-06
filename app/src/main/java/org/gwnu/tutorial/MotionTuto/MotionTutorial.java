package org.gwnu.tutorial.MotionTuto;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.gwnu.tutorial.R;
import org.gwnu.tutorial.Utils.AndroidUtils;
import org.gwnu.tutorial.activity.DefaultActivity;

import java.util.ArrayList;

public class MotionTutorial extends DefaultActivity {
    private static final String TAG = MotionTutorial.class.getSimpleName();
//    RecyclerView recyclerView;
//    ArrayList<Contents> contentsArrayList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_tutorial);

//        recyclerView = findViewById(R.id.motion_list);
//        contentsArrayList = new ArrayList<>();
//        ListAdapter listAdapter = new ListAdapter(contentsArrayList);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        recyclerView.setAdapter(listAdapter);
//        recyclerView.setLayoutManager(gridLayoutManager);

        ListViewAdapter listViewAdapter = new ListViewAdapter();
        listView = new ListView(this);
        listView.setAdapter(listViewAdapter);


        Contents contents = getContents();

        for (int i = 0; i < 30; i++) {
//            contentsArrayList.add(contents);

            listViewAdapter.addItem(contents);
        }
    }

    private Contents getContents() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            return new Contents(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
        } else {
            return new Contents(getResources().getDrawable(R.mipmap.ic_launcher));
        }

    }



}