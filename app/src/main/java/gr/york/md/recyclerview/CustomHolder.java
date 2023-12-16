package gr.york.md.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gr.york.md.R;

public class CustomHolder extends RecyclerView.ViewHolder {

    public CustomHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String data) {
        TextView text = itemView.findViewById(R.id.row_text);
        text.setText(data);
    }
}
