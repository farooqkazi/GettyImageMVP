package com.hrskrs.gettyimagemvp.ui.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by hrskrs on 4/11/2017.
 * Android known bug avoidance
 */

public class CustomLinearLayoutManager extends LinearLayoutManager {

  private static final String TAG = CustomLinearLayoutManager.class.getSimpleName();

  public CustomLinearLayoutManager(Context context) {
    super(context);
  }

  public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
    super(context, orientation, reverseLayout);
  }

  public CustomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override
  public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
    try {
      super.onLayoutChildren(recycler, state);
    } catch (IndexOutOfBoundsException e) {
      Log.e(TAG, "onLayoutChildren: IOOBE in RecyclerView");
    }
  }
}
