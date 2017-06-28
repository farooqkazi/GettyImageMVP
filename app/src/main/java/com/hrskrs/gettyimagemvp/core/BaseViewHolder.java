package com.hrskrs.gettyimagemvp.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by hrskrs on 4/11/2017.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  public abstract void populateItem(T item);

  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
