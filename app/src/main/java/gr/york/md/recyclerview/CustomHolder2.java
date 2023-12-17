package gr.york.md.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import gr.york.md.R;

public class CustomHolder2 extends CustomHolderClass {

    public CustomHolder2(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(String data) {
        TextView text = itemView.findViewById(R.id.row_text);
        text.setText(data);
    }
}
