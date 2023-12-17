package gr.york.md.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import gr.york.md.R;

public class CustomListAdapter extends ListAdapter<String, CustomHolderClass> {
    protected CustomListAdapter(@NonNull DiffUtil.ItemCallback<String> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CustomHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if (viewType == R.layout.holder_row_item) {
            return new CustomHolder(view);
        } else {
            return new CustomHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolderClass holder, int position) {
        String data = getItem(position);

        holder.bind(data);

//        if (holder instanceof CustomHolder) {
//           ((CustomHolder) holder).bind(data);
//        } else if (holder instanceof CustomHolder2) {
//            ((CustomHolder2) holder).bind(data);
//        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.holder_row_item;
        } else {
            return R.layout.holder_row_item_2;
        }
    }
}
