package com.hrskrs.gettyimagemvp.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by hrskrs on 4/11/2017.
 */

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

  private LinearLayoutManager manager;

  private boolean loading = true;
  private int visibleThreshold = 10;
  private int lastLoadItemCount = 0;

  private boolean isFabVisible = false;

  public EndlessScrollListener(LinearLayoutManager manager) {
    this.manager = manager;
  }

  public EndlessScrollListener(LinearLayoutManager manager, int visibleThreshold) {
    this.manager = manager;
    this.visibleThreshold = visibleThreshold;
  }

  @Override
  public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
    if(newState == RecyclerView.SCROLL_STATE_IDLE){
      showFab();
      isFabVisible = true;
    }
    super.onScrollStateChanged(recyclerView, newState);
  }

  @Override
  public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
    if(dy > 0 || (dy < 0 && isFabVisible)){
      hideFab();
    }
    int visibleItemCount = manager.getChildCount();
    int totalItemCount = manager.getItemCount();
    int firstVisibleItem = manager.findFirstVisibleItemPosition();

    if (loading) {
      if (totalItemCount > lastLoadItemCount) {
        loading = false;
        lastLoadItemCount = totalItemCount;
      }
    }
    if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
      Log.e("TEST", "onScrolled: ");
      onLoadMore();
      loading = true;
    }
  }

  public abstract void onLoadMore();

  public abstract void showFab();

  public abstract void hideFab();
}

