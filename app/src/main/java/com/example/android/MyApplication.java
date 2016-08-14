package com.example.android;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    init();
  }

  protected void init() {
    Fresco.initialize(this);
  }
}
