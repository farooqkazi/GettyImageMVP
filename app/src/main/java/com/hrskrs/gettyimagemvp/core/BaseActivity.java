package com.hrskrs.gettyimagemvp.core;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hrskrs.gettyimagemvp.R;
import com.hrskrs.gettyimagemvp.utils.FragmentTransactionUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hrskrs.gettyimagemvp.utils.DisplayUtils.showToast;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

  private Unbinder unbinder;

  @Nullable
  @BindView(R.id.toolbarContainer)
  FrameLayout toolbarContainer;
  @Nullable
  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @Nullable
  @BindView(R.id.toolbar_searchview)
  SearchView toolbarSearchView;

  protected @LayoutRes int getContentLayoutResId() {
    return R.layout.activity_base;
  }

  protected @IdRes int getFragmentContainerId() {
    return R.id.fragmentContainer;
  }

  protected abstract void setupToolbar(Toolbar toolbar, SearchView toolbarSearchView);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentLayoutResId());
    unbinder = ButterKnife.bind(this);
    initToolbar();
  }

  private void initToolbar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      if (toolbarContainer != null)
        toolbarContainer.setElevation(
            getResources().getDimension(R.dimen.hk_toolbar_elevation));
    }
    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    setupToolbar(toolbar, toolbarSearchView);
  }

  @Override
  public void onUnknownError(String error) {
    showToast(this, error, Toast.LENGTH_SHORT);
  }

  @Override
  public void onTimeout() {
    showToast(this, getString(R.string.error_timeout), Toast.LENGTH_SHORT);
  }

  @Override
  public void onNetworkError() {
    showToast(this, getString(R.string.error_network), Toast.LENGTH_SHORT);
  }


  @Override
  protected void onDestroy() {
    if (unbinder != null) unbinder.unbind();
    super.onDestroy();
  }

  protected void addFragment(@NonNull Fragment fragment) {
    FragmentTransactionUtil.addFragment(getSupportFragmentManager(),
        fragment, getFragmentContainerId(), false);
  }

  protected void addFragment(@NonNull Fragment fragment, boolean addToBackStack) {
    FragmentTransactionUtil.addFragment(getSupportFragmentManager(),
        fragment, getFragmentContainerId(), addToBackStack);
  }

  protected void replaceFragment(@NonNull Fragment fragment) {
    FragmentTransactionUtil.replaceFragment(getSupportFragmentManager(),
        fragment, getFragmentContainerId(), false);
  }

  protected void replaceFragment(@NonNull Fragment fragment, boolean addToBackStack) {
    FragmentTransactionUtil.replaceFragment(getSupportFragmentManager(),
        fragment, getFragmentContainerId(), addToBackStack);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }

}
