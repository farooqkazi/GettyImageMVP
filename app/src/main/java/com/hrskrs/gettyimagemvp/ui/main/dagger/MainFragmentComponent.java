package com.hrskrs.gettyimagemvp.ui.main.dagger;

import com.hrskrs.gettyimagemvp.core.FragmentScope;
import com.hrskrs.gettyimagemvp.ui.main.MainFragment;

import dagger.Subcomponent;

/**
 * Created by hrskrs on 4/10/2017.
 */

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentComponent {
  void inject(MainFragment mainFragment);
}
