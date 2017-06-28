package com.hrskrs.gettyimagemvp.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.hrskrs.gettyimagemvp.App;
import com.hrskrs.gettyimagemvp.R;
import com.hrskrs.gettyimagemvp.core.BaseFragment;
import com.hrskrs.gettyimagemvp.models.GettyImage;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentPresenterImp;
import com.hrskrs.gettyimagemvp.ui.main.core.MainFragmentView;
import com.hrskrs.gettyimagemvp.ui.main.dagger.MainFragmentModule;
import com.hrskrs.gettyimagemvp.utils.DisplayUtils;
import com.hrskrs.gettyimagemvp.views.HKProgressBar;
import com.hrskrs.gettyimagemvp.views.HKTextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by hrskrs on 4/11/2017.
 */

public class MainFragment extends BaseFragment implements MainFragmentView {

  private Animation slideIn;
  private Animation slideOut;

  private static String phrase = "mobile";
  private static int pageNo = 1;
  private static int pageCount = 10;

  @BindView(R.id.main_recyclerview)
  ShimmerRecyclerView recyclerView;
  @BindView(R.id.main_loadmore_progressbar)
  HKProgressBar loadMoreProgressbar;
  @BindView(R.id.main_search_fab)
  FloatingActionButton searchFab;

  @Inject
  MainFragmentPresenterImp mainPresenterImp;

  private GettyImagesAdapter adapter;
  private Toolbar toolbar;
  SearchView searchView;

  public static MainFragment newInstance() {
    Bundle b = new Bundle();
    MainFragment fragment = new MainFragment();
    fragment.setArguments(b);
    return fragment;
  }

  @Override
  protected int getContentLayoutResId() {
    return R.layout.fragment_main;
  }

  @Override
  protected void setupToolbar(Toolbar toolbar, SearchView toolbarSearchView) {
    this.toolbar = toolbar;
    this.searchView = toolbarSearchView;
  }

  @Override
  protected void populateUI(LayoutInflater inflater, View rootView, Bundle savedInstanceState) {
    setupAdapter(new ArrayList<>());
    App.getAppComponent()
        .plus(new MainFragmentModule(this))
        .inject(this);
    slideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_top);
    slideOut = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_top);
    mainPresenterImp.requestImages(false);
  }

  private void setupAdapter(ArrayList<GettyImage> gettyImages) {
    adapter = new GettyImagesAdapter(getActivity(), gettyImages, this::showCaptionPopup);
    CustomLinearLayoutManager manager = new CustomLinearLayoutManager(
        getActivity(), LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(adapter);
    recyclerView.showShimmerAdapter();
    recyclerView.addOnScrollListener(new EndlessScrollListener(manager) {
      @Override
      public void onLoadMore() {
        pageNo++;
        mainPresenterImp.requestImages(true);
        loadMoreProgressbar.setVisibility(View.VISIBLE);
      }

      @Override
      public void showFab() {
        if (toolbar == null || toolbar.getVisibility() == View.GONE) {
          showSearchFab();
        }
      }

      @Override
      public void hideFab() {
        hideSearchFab();
      }
    });
  }

  private void showCaptionPopup(GettyImage gettyImage) {
    if (!TextUtils.isEmpty(gettyImage.getCaption())) {
      LayoutInflater inflater = LayoutInflater.from(getActivity());
      View view = inflater.inflate(R.layout.view_dialog_caption, null, false);
      HKTextView caption = (HKTextView) view.findViewById(R.id.view_caption);
      caption.setText(gettyImage.getCaption());
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setView(view);
      builder.show();
    }
  }

  @Override
  public int getPageNo() {
    return pageNo;
  }

  @Override
  public int getPageCount() {
    return pageCount;
  }

  @Override
  public String getPhrase() {
    return phrase;
  }

  @Override
  public void onImagesLoad(ArrayList<GettyImage> gettyImages) {
    showSearchFab();
    setupAdapter(gettyImages);
    recyclerView.hideShimmerAdapter();
  }

  @Override
  public void onNextPage(ArrayList<GettyImage> gettyImages) {
    //TODO: handle when reached end of page (result_count)
    if (adapter != null) {
      adapter.appendList(gettyImages);
      int startPos = ((pageNo - 1) * pageCount) - 1;
      int endPos = pageNo * pageCount;
      adapter.notifyItemRangeInserted(startPos, endPos);
      loadMoreProgressbar.setVisibility(View.GONE);
    }
  }

  @OnClick(R.id.main_search_fab)
  public void onSearchFabClick() {
    showSearchToolbar();
    hideSearchFab();
  }

  private void showSearchFab() {
    if (searchFab != null) {
      searchFab.show();
    }
  }

  private void hideSearchFab() {
    if (searchFab != null) {
      searchFab.hide();
    }
  }

  private void showSearchToolbar() {
    if (toolbar != null) {
      toolbar.setVisibility(View.VISIBLE);
      toolbar.startAnimation(slideIn);
    }
    if (searchView != null) {
      searchView.setIconified(false);
      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
          pageNo = 1;
          phrase = query;
          if (!TextUtils.isEmpty(phrase)) {
            recyclerView.showShimmerAdapter();
            mainPresenterImp.requestImages(false);
            hideSearchToolbar();
          } else {
            DisplayUtils.showToast(getActivity(),
                getString(R.string.warn_empty_field), Toast.LENGTH_SHORT);
          }
          return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
          return false;
        }
      });
      searchView.setOnCloseListener(() -> {
        hideSearchToolbar();
        showSearchFab();
        return false;
      });
    }
  }

  private void hideSearchToolbar() {
    if (toolbar != null) {
      toolbar.setVisibility(View.GONE);
      toolbar.startAnimation(slideOut);
    }
    if (searchView != null) {
      searchView.setOnQueryTextListener(null);
    }
  }

  @Override
  public void onDestroyView() {
    mainPresenterImp.onDestroy();
    super.onDestroyView();
  }
}
