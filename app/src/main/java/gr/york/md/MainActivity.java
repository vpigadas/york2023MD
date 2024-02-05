package gr.york.md;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import gr.york.md.fragment.FragmActivity;
import gr.york.md.network.NetworkActivity;
import gr.york.md.recyclerview.ListActivity;

public class MainActivity extends AppCompatActivity {

    private String name;
    private final String type = "";
    private int ears = 0;

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

                EditText editText = findViewById(R.id.main_edit_password);
                Editable editable = editText.getText();
                String inputValue = editable.toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String name = inputValue;
                //int age = 100;

                intent.putExtra("name", name);
                //intent.putExtra("user_age", age);
                startActivity(intent);
            }
        });

        Button buttonRequest = findViewById(R.id.main_btn_request);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivityWithRequestCode();
            }
        });

        Button btnRecycler = findViewById(R.id.main_btn_list);
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        Button btnNetwork = findViewById(R.id.main_btn_net);
        btnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
            }
        });

        Button btnFragment = findViewById(R.id.main_btn_frag);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startNewActivityWithRequestCode() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(intent, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back pressed!!!", Toast.LENGTH_SHORT).show();
        //super.onBackPressed();
    }
}