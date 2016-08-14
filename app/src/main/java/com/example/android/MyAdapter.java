package com.example.android;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public View view;
    public SimpleDraweeView imgView;

    public ViewHolder(View v) {
      super(v);
      view = v;
      imgView = (SimpleDraweeView) view.findViewById(R.id.img);
    }
  }

  // Provide a suitable constructor (depends on the kind of dataset)
  public MyAdapter() {
  }

  // Create new views (invoked by the layout manager)
  @Override
  public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
    View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.cardview, parent, false);
    return new MyAdapter.ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    SimpleDraweeView draweeView = holder.imgView;
    Uri uri = new Uri.Builder()
            .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
            .path(String.valueOf(R.drawable.img_test))
            .build();
    draweeView.setImageURI(uri);
  }

  // Return the size of your dataset (invoked by the layout manager)
  @Override
  public int getItemCount() {
    return 1;
  }

}