package org.gwnu.tutorial.MotionTuto;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.gwnu.tutorial.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    ArrayList<Contents> contentsList;
    Context context;

    public ListAdapter(ArrayList<Contents> contentsList){
        this.contentsList = contentsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.motion_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        context = view.getContext();

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher, null));
            } else {
                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher));
            }


        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (contentsList != null ? contentsList.size() : 0);
    }

    //리스트에서 아이템을 제거하는 메소드
    public void removeItem(int position){
        try {
            contentsList.remove(position); //아이템에 해당하는 리스트를 제거
            notifyItemRemoved(position); //아이템을 제거(후에 Remove가 적용됨)
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.motion_list_image_view);
        }
    }
}
