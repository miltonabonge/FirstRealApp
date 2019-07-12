package com.example.jasonpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jasonpractice2.R;

import java.util.List;

public class ShibeAdapter extends RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder> {

    private List<String> shibeUrls;
    private Context context;
    private OnShibeClicked listener;

    //    Step 2:
//    Decleare private instance of your constructor
    public ShibeAdapter(List<String> shibeUrls, OnShibeClicked onShibeClicked) {
        this.shibeUrls = shibeUrls;
        this.listener = onShibeClicked;
    }

    @NonNull
    @Override
    public ShibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.shibe_item,parent,false);
        context = parent.getContext();
        return new ShibeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShibeViewHolder holder, int position) {
        final String url = shibeUrls.get(position);
        Glide.with(context).load(url).into(holder.ivPhoto);

//        step3:
//        set an onclick event on the holder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.shibeclicked(url);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shibeUrls.size();
    }

    class ShibeViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;

        ShibeViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }

//    To create an interface for an onclick RecyclerViewAdaptor;
//   Step 1:
    public interface OnShibeClicked  {
        void shibeclicked (String url);
    }
}
