package com.hrskrs.gettyimagemvp.ui.main;

import android.annotation.SuppressLint;

import com.hrskrs.gettyimagemvp.BuildConfig;
import com.hrskrs.gettyimagemvp.R;
import com.hrskrs.gettyimagemvp.core.BaseTest;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentPresenter;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentView;
import com.hrskrs.gettyimagemvp.utils.FragmentTransactionUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by hrskrs on 4/14/2017.
 */
@SuppressLint("VisibleForTests")
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class TestMainFragmentView extends BaseTest{

  @Mock
  private MainFragmentView view;
  @Mock
  private MainFragmentPresenter presenter;
  private MainFragment mainFragment;

  @Override
  public void setup() throws Exception{
    super.setup();
    mainFragment = MainFragment.newInstance();
    MainActivity activity = Robolectric.buildActivity(MainActivity.class)
        .create()
        .start()
        .get();
    FragmentTransactionUtil.addFragment(
        activity.getSupportFragmentManager(),
        mainFragment,
        R.id.fragmentContainer,
        false
    );
  }

  @Test
  public void testInitialValues() throws Exception{
    assertThat(mainFragment).isNotNull();
    assertThat(view).isNotNull();
    verify(view, never()).onImagesLoad(any());
    verify(view, never()).onNextPage(any());
    verify(view, never()).getPageNo();
    verify(view, never()).getPageCount();
    verify(view, never()).getPhrase();
  }

  @Test
  public void testIfFragmentAddedToActivity() throws Exception{
    assertNotNull(mainFragment.getView());
  }

  @Test
  public void testIf10ShimmerItemsAreBindedToRecyclerView() throws Exception{
    //Shimmer(placeholder) item count is setted on fragment_main
    assertNotNull(mainFragment.recyclerView);
    assertThat(mainFragment.recyclerView.getAdapter()
        .getItemCount())
        .isEqualTo(10);
  }

  @Test
  public void testLoadImages() throws Exception{
    //TODO: somehow still returning shimmer item count. Need to check
    view.onImagesLoad(MOCK_GIMAGE_LIST);
    assertNotNull(mainFragment.recyclerView);
    assertThat(mainFragment.recyclerView.getAdapter().getItemCount())
        .isEqualTo(MOCK_GIMAGE_LIST.size());
  }

  @Test
  public void testEmptySearch() throws Exception{
    assertNotNull(mainFragment.searchView);
    assertNotNull(mainFragment.searchFab);
    mainFragment.searchFab.performClick();
    assertThat(mainFragment.searchView.getQuery().toString()).isEmpty();
  }

}
