package com.hrskrs.gettyimagemvp.core;

import com.hrskrs.gettyimagemvp.models.GettyDisplaySize;
import com.hrskrs.gettyimagemvp.models.GettyImage;
import com.hrskrs.gettyimagemvp.network.responses.GetImagesResponse;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

/**
 * Created by hrskrs on 4/14/2017.
 */

public abstract class BaseTest {

  protected static final String FAKE_URL = "http://mock.api";
  protected static final int PAGE_NO = 1;
  protected static final int PAGE_COUNT = 10;
  protected static final String PHRASE = "mobile";

  protected static final String ID = "1";
  protected static final String TITLE = "Mock Title";
  protected static final String CAPTION = "Mock Caption";
  protected static final String IMAGE_URI = "Mock Uri";

  protected static final GettyDisplaySize MOCK_FIRST_DSIZE_ITEM =
      GettyDisplaySize.create(IMAGE_URI);
  protected static final ArrayList<GettyDisplaySize> MOCK_DSIZE_LIST =
      Lists.newArrayList(
          MOCK_FIRST_DSIZE_ITEM,
          new GettyDisplaySize(),
          new GettyDisplaySize()
      );
  protected static final GettyImage MOCK_FIRST_ITEM =
      GettyImage.create(ID, TITLE, CAPTION, MOCK_DSIZE_LIST);
  protected static final ArrayList<GettyImage> MOCK_GIMAGE_LIST =
      Lists.newArrayList(
          MOCK_FIRST_ITEM,
          new GettyImage(),
          new GettyImage(),
          new GettyImage(),
          new GettyImage()
      );

  protected static final GetImagesResponse MOCK_GIMAGE_RESPONSE =
      GetImagesResponse.create(6, MOCK_GIMAGE_LIST);

  @Before
  public void setup() throws Exception{
    MockitoAnnotations.initMocks(this);
  }
}
