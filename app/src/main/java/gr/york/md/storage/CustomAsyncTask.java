package gr.york.md.storage;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.List;

public class CustomAsyncTask extends AsyncTask<Void, Void, List<UserEntity>> {

    interface Listener {
        void onResult(List<UserEntity> dataList);
    }

    private Context context;
    private Listener listener;

    public CustomAsyncTask(Context context, Listener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<UserEntity> doInBackground(Void... voids) {
        DatabaseInstance databaseInstance =
                Room.databaseBuilder(context, DatabaseInstance.class, "Database").build();

        return databaseInstance.getUserDao().read();
    }

    @Override
    protected void onPostExecute(List<UserEntity> userEntity) {
        super.onPostExecute(userEntity);

        listener.onResult(userEntity);
    }
}
