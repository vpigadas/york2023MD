package gr.york.md;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.main_txt_one);
        text.setText(getString(R.string.demo_text));

        Button button = findViewById(R.id.main_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("APP", "Button Clicked!!!");
                Snackbar.make(v, "Button Clicked", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}