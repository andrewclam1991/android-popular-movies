package com.andrewclam.popularmovie.views.detail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.andrewclam.popularmovie.R;
import com.andrewclam.popularmovie.data.model.Movie;
import com.andrewclam.popularmovie.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * View class responsible for hosting the {@link DetailFragment}
 */
public class DetailActivity extends DaggerAppCompatActivity {

  /**
   * Unique id of the {@link Movie}. This class requires this id to load
   * and display the {@link Movie} details.
   */
  public static final String ARG_DETAIL_ACT_ITEM_ID = "ITEM_DETAIL_ID";

  @Inject
  Lazy<DetailFragment> mFragmentProvider;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
        .findFragmentById(R.id.fragment_container);

    if (fragment == null) {
      // Create the fragment
      fragment = mFragmentProvider.get();
      ActivityUtils.addFragmentToActivity(
          getSupportFragmentManager(), fragment, R.id.fragment_container);
    }
  }

}
