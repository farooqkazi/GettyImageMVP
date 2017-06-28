package com.hrskrs.gettyimagemvp.ui.main.dagger;

import android.support.annotation.NonNull;

import com.hrskrs.gettyimagemvp.core.FragmentScope;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentModel;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentModelImp;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentPresenter;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentPresenterImp;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hrskrs on 4/10/2017.
 */

@Module
public class MainFragmentModule {

  private MainFragmentView view;

  public MainFragmentModule(@NonNull MainFragmentView view) {
    this.view = view;
  }

  @FragmentScope
  @Provides
  MainFragmentView provideView() {
    return view;
  }

  @FragmentScope
  @Provides
  MainFragmentModel provideModel(MainFragmentModelImp mainFragmentModelImp) {
    return mainFragmentModelImp;
  }

  @FragmentScope
  @Provides
  MainFragmentPresenter providePresenter(MainFragmentPresenterImp mainFragmentPresenterImp) {
    return mainFragmentPresenterImp;
  }

}
