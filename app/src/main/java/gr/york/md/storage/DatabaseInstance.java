package gr.york.md.storage;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import gr.york.md.viewmodel.UserDaoOverStreams;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseInstance extends RoomDatabase {

    public abstract UserDao getUserDao();
    public abstract UserDaoOverStreams getUserDaoWithStreams();
}
