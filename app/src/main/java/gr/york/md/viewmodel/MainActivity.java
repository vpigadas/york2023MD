package gr.york.md.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import java.util.List;

import gr.york.md.R;
import gr.york.md.storage.DatabaseInstance;
import gr.york.md.storage.UserEntity;

public class MainActivity extends AppCompatActivity {

    private CustomViewModel customViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        customViewModel = new ViewModelProvider(this).get(CustomViewModel.class);
        customViewModel.initialise();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewModel.performButtonAction(MainActivity.this);
            }
        });

        TextView textView = findViewById(R.id.textview);
        //textView.setText("");

        customViewModel.observeTitleStream(this, new Observer<UserUIModel>() {
            @Override
            public void onChanged(UserUIModel userUIModel) {
                TextView textView = findViewById(R.id.textview);
                textView.setText(String.valueOf(userUIModel.getAge()));
            }
        });


    }
}