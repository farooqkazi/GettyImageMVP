package com.hrskrs.gettyimagemvp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hrskrs.gettyimagemvp.R;
import com.hrskrs.gettyimagemvp.core.BaseRecyclerView;
import com.hrskrs.gettyimagemvp.core.BaseViewHolder;
import com.hrskrs.gettyimagemvp.models.GettyDisplaySize;
import com.hrskrs.gettyimagemvp.models.GettyImage;
import com.hrskrs.gettyimagemvp.views.HKImageView;
import com.hrskrs.gettyimagemvp.views.HKTextView;

import java.util.ArrayList;

import butterknife.BindView;

import static com.hrskrs.gettyimagemvp.utils.ImageUtils.loadImage;

/**
 * Created by hrskrs on 4/11/2017.
 */

public class GettyImagesAdapter extends BaseRecyclerView<GettyImage> {

  private LayoutInflater inflater;
  private ArrayList<GettyImage> gettyImages;
  private GettyImageAdapterListener listener;

  public GettyImagesAdapter(Context context, ArrayList<GettyImage> gettyImages, GettyImageAdapterListener listener) {
    this.inflater = LayoutInflater.from(context);
    this.gettyImages = gettyImages;
    this.listener = listener;
  }

  @Override
  public GettyImage getItem(int position) {
    return gettyImages.get(position);
  }

  @Override
  public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    GettyImageViewHolder viewHolder = new GettyImageViewHolder(
        inflater.inflate(R.layout.item_getty_image, parent, false));

    viewHolder.itemView.setOnClickListener(v -> {
      if (listener != null)
        listener.onItemClick(gettyImages.get(viewHolder.getAdapterPosition()));
    });
    return viewHolder;
  }

  @Override
  public int getItemCount() {
    return gettyImages.size();
  }

  public void appendList(ArrayList<GettyImage> gettyImages) {
    this.gettyImages.addAll(gettyImages);
  }

  static class GettyImageViewHolder extends BaseViewHolder<GettyImage> {

    @BindView(R.id.item_gi_id)
    HKTextView id;
    @BindView(R.id.item_gi_title)
    HKTextView title;
    @BindView(R.id.item_gi_image)
    HKImageView image;

    public GettyImageViewHolder(View itemView) {
      super(itemView);
    }

    @Override
    public void populateItem(GettyImage item) {
      id.setText(item.getId());
      title.setText(item.getTitle());
      GettyDisplaySize gettyImage = item.getDisplaySizes().get(0);
      loadImage(image, gettyImage.getUri());
    }
  }

  public interface GettyImageAdapterListener {
    void onItemClick(GettyImage gettyImage);
  }
}
