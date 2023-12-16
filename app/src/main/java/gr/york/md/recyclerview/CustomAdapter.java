package gr.york.md.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gr.york.md.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {

    private List<String> arrayData;

    public CustomAdapter(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_row_item, parent, false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        String data = arrayData.get(position);

        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
