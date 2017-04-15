package xyz.dev_juyoung.cropicker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import xyz.dev_juyoung.cropicker.R;
import xyz.dev_juyoung.cropicker.base.CroPickerRecyclerAdapter;
import xyz.dev_juyoung.cropicker.base.CroPickerViewHolder;
import xyz.dev_juyoung.cropicker.models.Album;

/**
 * Created by juyounglee on 2017. 4. 15..
 */

public class DirectoryAdapter extends CroPickerRecyclerAdapter<Album, DirectoryAdapter.ViewHolder> {
    public DirectoryAdapter(Context context) {
        super(context);
    }

    public class ViewHolder extends CroPickerViewHolder {
        /*
        @BindView(R2.id.iv_resource)
        ImageView ivResource;
        @BindView(R2.id.tv_dir_name)
        TextView tvDirName;
        @BindView(R2.id.tv_dir_count)
        TextView tvDirCount;
        */

        public ImageView ivResource;
        public TextView tvDirName;
        public TextView tvDirCount;

        public ViewHolder(View itemView) {
            super(itemView);

            // View Binding
            ivResource = (ImageView) itemView.findViewById(R.id.iv_resource);
            tvDirName = (TextView) itemView.findViewById(R.id.tv_dir_name);
            tvDirCount = (TextView) itemView.findViewById(R.id.tv_dir_count);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_directory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        Album currentItem = getItem(position);

        Glide.with(getContext())
                .load(currentItem.getPreviewImagePath())
                //.thumbnail(0.1f)
                .centerCrop()
                .into(holder.ivResource);

        holder.tvDirName.setText(currentItem.getDisplayName());
        holder.tvDirCount.setText(String.valueOf(currentItem.getResourceCount()));
    }
}