package gr.york.md.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gr.york.md.R;

public class ListActivity extends AppCompatActivity {
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new CustomAdapter(getListOfItems(counter)));
        ListAdapter adapter = new CustomListAdapter(new CustomDiffUtilItem());
        recyclerView.setAdapter(adapter);


        Button button = findViewById(R.id.addMore);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 5 + counter;
                adapter.submitList(getListOfItems(counter));
                //recyclerView.setAdapter(new CustomAdapter(getListOfItems(counter)));
            }
        });
    }

    private List<String> getListOfItems(int count) {
        List<String> arrayData = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            arrayData.add(String.valueOf(i));
        }
        return arrayData;
    }
}