package org.gwnu.tutorial.retrofit2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.gwnu.tutorial.R;

import java.util.ArrayList;
import java.util.List;

public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {
    List<RModel> rModelList = new ArrayList<>();

    public RAdapter(List<RModel> rModelList) {
        this.rModelList = rModelList;
    }

    @NonNull
    @Override
    public RAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_retrofit_and_recyclerview,
                parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RAdapter.MyViewHolder holder, int position) {
        Result result = rModelList.get(position).getResult().get(position);

        holder.NM_CONTENTS.setText(result.getNM_CONTENTS());
        holder.SYNOPSIS.setText(result.getSYNOPSIS());
        holder.ID_GENRE.setText(result.getID_GENRE());
        holder.STARRING.setText(result.getSTARRING());

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (rModelList != null ? rModelList.size() : 0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView NM_CONTENTS, SYNOPSIS, ID_GENRE, STARRING;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            NM_CONTENTS = itemView.findViewById(R.id.NM_CONTENTS);
            SYNOPSIS = itemView.findViewById(R.id.SYNOPSIS);
            ID_GENRE = itemView.findViewById(R.id.ID_GENRE);
            STARRING = itemView.findViewById(R.id.STARRING);
        }
    }
}
