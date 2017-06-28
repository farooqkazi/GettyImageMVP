package com.hrskrs.gettyimagemvp;

import com.hrskrs.gettyimagemvp.network.NetworkModule;
import com.hrskrs.gettyimagemvp.network.api.GettyImagesService;
import com.hrskrs.gettyimagemvp.network.api.GettyImagesServiceModule;
import com.hrskrs.gettyimagemvp.ui.main.dagger.MainFragmentComponent;
import com.hrskrs.gettyimagemvp.ui.main.dagger.MainFragmentModule;

import dagger.Component;

/**
 * Created by hrskrs on 4/10/2017.
 */

@AppScope
@Component(modules = {GettyImagesServiceModule.class, NetworkModule.class, AppModule.class})
public interface AppComponent {

  MainFragmentComponent plus(MainFragmentModule fragmentModule);

  GettyImagesService gettyImagesApi();
}
