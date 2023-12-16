package gr.york.md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString("name");
            //String name = getIntent().getStringExtra("name");

            //int age = getIntent().getExtras().getInt("user_age");
            int age = getIntent().getIntExtra("user_age", 0);

            TextView textView = findViewById(R.id.textview);
            textView.setText(name + System.lineSeparator() + String.valueOf(age));
        }

        Button bUtton = findViewById(R.id.second_btn);
        bUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.putExtra("variable", "finished");
                intent.putExtra("bool", true);
                setResult(3000, intent);

                finish();
            }
        });
    }
}