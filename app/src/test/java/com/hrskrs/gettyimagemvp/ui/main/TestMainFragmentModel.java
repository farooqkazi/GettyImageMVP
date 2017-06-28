package com.hrskrs.gettyimagemvp.ui.main;

import com.hrskrs.gettyimagemvp.core.BaseTest;
import com.hrskrs.gettyimagemvp.network.FakeInterceptor;
import com.hrskrs.gettyimagemvp.network.api.GettyImagesService;
import com.hrskrs.gettyimagemvp.network.responses.GetImagesResponse;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentModel;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentModelImp;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.junit.Test;

import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;

/**
 * Created by hrskrs on 4/14/2017.
 */

public class TestMainFragmentModel extends BaseTest {

  private MainFragmentModel model;

  @Override
  public void setup() throws Exception {
    super.setup();
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new FakeInterceptor())
        .build();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(FAKE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    GettyImagesService mockService = retrofit.create(GettyImagesService.class);
    model = new MainFragmentModelImp(mockService);
  }

  @Test
  public void testModelIfNull() throws Exception{
    assertThat(model).isNotNull();
  }

  @Test
  public void testGetImages() throws Exception{
    TestScheduler testScheduler = new TestScheduler();
    TestObserver<GetImagesResponse> testObserver = TestObserver.create();
    model.getImages(PAGE_NO, PAGE_COUNT, PHRASE)
        .subscribeOn(testScheduler)
        .observeOn(testScheduler)
        .subscribeWith(testObserver);
    testObserver.assertNoErrors();
    testObserver.onNext(any());
    assertThat(testObserver.getEvents().get(0)).isNotEmpty();
  }
}
