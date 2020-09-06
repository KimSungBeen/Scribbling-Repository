package org.gwnu.tutorial.MotionTuto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import org.gwnu.tutorial.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Contents> contentsArrayList = new ArrayList<>();

    @Override
    public int getCount() {
        return contentsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return contentsArrayList.get(i);
    }

    public void addItem(Contents contents){
        contentsArrayList.add(contents);
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = view.getContext(); // 뷰그룹에 고유한 값 저장

        if(view == null){ // 뷰에 아무것도 없으면
            LayoutInflater list = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //리스트뷰에 아이템을 합치는 명령
            view = list.inflate(R.layout.motion_list_item, viewGroup, false); // 리스트에서 보이는 뷰에 생성한 아이템 합친것 적용
        }

        //뷰 선언, 초기화
        ImageView imageView = view.findViewById(R.id.motion_list_image_view);

        //ArrayList에 있는 아이템의 정보들 저장
        Contents contents = contentsArrayList.get(i);

        //아이템의 이미지, 텍스트 셋팅
        imageView.setImageDrawable(contents.getContentsImage());

        return view;
    }
}
