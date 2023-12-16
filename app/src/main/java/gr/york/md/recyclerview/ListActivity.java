package gr.york.md.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gr.york.md.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new CustomAdapter(getListOfItems()));
    }

    private List<String> getListOfItems() {
        List<String> arrayData = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            arrayData.add(String.valueOf(i));
        }
        return arrayData;
    }
}