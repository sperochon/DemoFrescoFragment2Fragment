package com.example.android;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

public class EndFragment extends Fragment {

  public EndFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_end, container, false);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.img);
      Uri uri = new Uri.Builder()
              .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
              .path(String.valueOf(R.drawable.img_test))
              .build();
      draweeView.setImageURI(uri);
    }

    return view;
  }

}
