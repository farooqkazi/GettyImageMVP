package com.hrskrs.gettyimagemvp.network.api;

import com.hrskrs.gettyimagemvp.network.responses.GetImagesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hrskrs on 4/10/2017.
 */

public interface GettyImagesService {

  @GET("search/images")
  Observable<GetImagesResponse> getImages(
      @Query("page") int page,
      @Query("page_size") int pageSize,
      @Query("phrase") String phrase
  );
}
