package com.example.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GridFragment extends Fragment {

  private RecyclerView mRecyclerView;
  private RecyclerView.Adapter mAdapter;

  public GridFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_grid, container, false);

    mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    mRecyclerView.setHasFixedSize(true);

    GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
    mRecyclerView.setLayoutManager(mLayoutManager);

    mAdapter = new MyAdapter();
    mRecyclerView.setAdapter(mAdapter);

    return view;
  }

}
