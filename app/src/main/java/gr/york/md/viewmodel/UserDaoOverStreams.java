package gr.york.md.viewmodel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import gr.york.md.storage.UserEntity;

@Dao
public interface UserDaoOverStreams {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(UserEntity data);

    @Insert
    void insert(UserEntity data) throws Exception;

    @Update
    void update(UserEntity data) throws Exception;

    @Delete
    void delete(UserEntity data);

    @Query("SELECT * FROM User")
    @NotNull
    LiveData<List<UserEntity>> read();

    @Query("SELECT * FROM User LIMIT 1")
    @Nullable
    LiveData<UserEntity> readFirst();

    @Query("SELECT * FROM User WHERE name LIKE :character ")
    @NonNull
    LiveData<List<UserEntity>> read(String character);

    @Query("SELECT * FROM User WHERE name LIKE :character LIMIT 1")
    @org.jetbrains.annotations.Nullable
    LiveData<UserEntity> readFirst(String character);
}

