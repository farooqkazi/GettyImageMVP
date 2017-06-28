package com.hrskrs.gettyimagemvp.ui.main.core;

import com.hrskrs.gettyimagemvp.models.GettyImage;
import com.hrskrs.gettyimagemvp.network.CallbackWrapper;
import com.hrskrs.gettyimagemvp.network.responses.GetImagesResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.hrskrs.gettyimagemvp.utils.AppUtils.checkNotNull;
import static com.hrskrs.gettyimagemvp.utils.AppUtils.isListEmpty;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class MainFragmentPresenterImp implements MainFragmentPresenter {

  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private MainFragmentView view;
  private MainFragmentModel model;

  @Inject
  public MainFragmentPresenterImp(MainFragmentView view, MainFragmentModel model) {
    this.view = checkNotNull(view);
    this.model = checkNotNull(model);
  }

  @Override
  public void requestImages(boolean loadMore) {
    CallbackWrapper<GetImagesResponse> observer =
        new CallbackWrapper<GetImagesResponse>(view) {
          @Override
          protected void onSuccess(GetImagesResponse getImagesResponse) {
            ArrayList<GettyImage> images = getImagesResponse.getImages();
            if (view != null && !isListEmpty(images)) {
              if (!loadMore) {
                view.onImagesLoad(images);
              } else {
                view.onNextPage(images);
              }
            }
          }
        };
    Observable<GetImagesResponse> observable = model.getImages(view.getPageNo(), view.getPageCount(), view.getPhrase());
    Disposable disposable = observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(observer);
    compositeDisposable.add(disposable);
  }

  @Override
  public void onDestroy() {
    if (compositeDisposable != null) {
      compositeDisposable.clear();
    }
  }

}
