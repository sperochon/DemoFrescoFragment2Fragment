package com.example.android;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  private static final String TAG = MainActivity.class.getSimpleName();

  private Fragment startFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    startFragment = new GridFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.container, startFragment)
            .commit();

    setTitle("startFragment");
  }

  public void onClickItem(View view) {
    transitionToEndFragment(view);
  }

  public void transitionToEndFragment(View cardView) {
    View imageView = null;
    String transImg = null;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      imageView = cardView.findViewById(R.id.img);
      transImg = imageView.getTransitionName();
    }

    EndFragment endFragment = new EndFragment();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      startFragment.setSharedElementReturnTransition(TransitionInflater.from(
              this).inflateTransition(R.transition.change_image_trans));
      startFragment.setExitTransition(TransitionInflater.from(
              this).inflateTransition(android.R.transition.fade));

      endFragment.setSharedElementEnterTransition(TransitionInflater.from(
              this).inflateTransition(R.transition.change_image_trans));
      endFragment.setEnterTransition(TransitionInflater.from(
              this).inflateTransition(android.R.transition.fade));
    }

    setTitle("endFragment");

    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.container, endFragment)
            .addSharedElement(imageView, transImg)
            .commit();
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    return false;
  }
}
