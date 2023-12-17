package gr.york.md.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class CustomHolderClass extends RecyclerView.ViewHolder {

    public CustomHolderClass(@NonNull View itemView) {
        super(itemView);
    }

    abstract void bind(String data);
}
