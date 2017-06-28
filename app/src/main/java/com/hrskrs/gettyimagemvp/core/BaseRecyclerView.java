package com.hrskrs.gettyimagemvp.core;

import android.support.v7.widget.RecyclerView;

/**
 * Created by hrskrs on 4/11/2017.
 */

public abstract class BaseRecyclerView<T> extends RecyclerView.Adapter<BaseViewHolder> {

  public abstract T getItem(int position);

  @Override
  public void onBindViewHolder(BaseViewHolder holder, int position) {
    holder.populateItem(getItem(position));
  }
}
