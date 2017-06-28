package com.hrskrs.gettyimagemvp.core;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hrskrs.gettyimagemvp.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.hrskrs.gettyimagemvp.utils.DisplayUtils.showToast;

/**
 * Created by hrskrs on 4/11/2017.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

  private Unbinder unbinder;

  @LayoutRes
  protected abstract int getContentLayoutResId();

  protected abstract void setupToolbar(Toolbar toolbar, SearchView toolbarSearchView);

  protected abstract void populateUI(LayoutInflater inflater,
                                     View rootView,
                                     Bundle savedInstanceState);

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater,
                           @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(getContentLayoutResId(), container, false);
    unbinder = ButterKnife.bind(this, rootView);
    Toolbar toolbar = ((BaseActivity) getActivity()).toolbar;
    SearchView toolbarSearchView = ((BaseActivity) getActivity()).toolbarSearchView;
    setupToolbar(toolbar, toolbarSearchView);
    populateUI(inflater, rootView, savedInstanceState);
    return rootView;
  }

  @Override
  public void onDestroyView() {
    if (unbinder != null) {
      unbinder.unbind();
    }
    super.onDestroyView();
  }

  @Override
  public void onUnknownError(String error) {
    showToast(getContext(), error, Toast.LENGTH_SHORT);
  }

  @Override
  public void onTimeout() {
    showToast(getContext(), getString(R.string.error_timeout), Toast.LENGTH_SHORT);
  }

  @Override
  public void onNetworkError() {
    showToast(getContext(), getString(R.string.error_network), Toast.LENGTH_SHORT);
  }

}
