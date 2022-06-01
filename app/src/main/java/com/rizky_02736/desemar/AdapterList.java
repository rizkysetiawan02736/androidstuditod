package com.rizky_02736.desemar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderItem> {

    List<ModelList> mListItem;
    Context context;

    public AdapterList(List<ModelList> mListItem, Context context){
        this.mListItem = mListItem;
        this.context = context;
    }


    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rows_lowongan,parent,false);
        HolderItem holder = new HolderItem(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderItem holder, int position) {
        ModelList mlist = mListItem.get(position);
        holder.tv_title.setText(mlist.getJobname());
        holder.tv_deskripsi.setText(mlist.getRequirement());
        /*loading image*/
        Glide.with(context).load(mlist.getImg()).transition(DrawableTransitionOptions.withCrossFade()).into(holder.thubnail);
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder{
        ImageView thubnail;
        TextView tv_title, tv_deskripsi;

        public HolderItem(View v){
            super(v);
            thubnail=(ImageView) v.findViewById(R.id.image_cover);
            tv_title=(TextView) v.findViewById(R.id.tv_title);
            tv_deskripsi=(TextView) v.findViewById(R.id.tv_deskripsi);
        }
    }

}
