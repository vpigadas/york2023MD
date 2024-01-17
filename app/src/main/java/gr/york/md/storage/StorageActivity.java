package gr.york.md.storage;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import gr.york.md.R;

public class StorageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", "Vassilis");
        //editor.commit();
        editor.apply();

        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
        sharedEditor.putString("name", "Vassilis");
        //sharedEditor.commit();
        sharedEditor.apply();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        DatabaseInstance databaseInstance =
                Room.databaseBuilder(this, DatabaseInstance.class, "Database")
                        .allowMainThreadQueries().build();

        UserEntity userEntity = new UserEntity();
        userEntity.setName("Vassilis");
        userEntity.setAge(100);
        userEntity.setJob_title("Blabla");

        databaseInstance.getUserDao().save(userEntity);

        CustomAsyncTask customAsyncTask = new CustomAsyncTask(this,
                new CustomAsyncTask.Listener() {
            @Override
            public void onResult(List<UserEntity> dataList) {

            }
        });
        customAsyncTask.execute();

    }
}