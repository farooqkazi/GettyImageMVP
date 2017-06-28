package com.hrskrs.gettyimagemvp.ui.main;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.hrskrs.gettyimagemvp.core.BaseActivity;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class MainActivity extends BaseActivity {

  @Override
  protected void setupToolbar(Toolbar toolbar, SearchView toolbarSearchView) {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState == null) {
      addFragment(MainFragment.newInstance());
    }
  }
}
