package gr.york.md.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.jetbrains.annotations.NotNull;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(UserEntity data);

    @Insert
    void insert(UserEntity data) throws Exception;

    @Update
    void update(UserEntity data) throws Exception;

    @Delete
    boolean delete(UserEntity data);

    @Query("SELECT * FROM User")
    @NotNull
    List<UserEntity> read();

    @Query("SELECT * FROM User LIMIT 1")
    @Nullable
    UserEntity readFirst();

    @Query("SELECT * FROM User WHERE name LIKE :character ")
    @NonNull
    List<UserEntity> read(String character);

    @Query("SELECT * FROM User WHERE name LIKE :character LIMIT 1")
    @org.jetbrains.annotations.Nullable
    UserEntity readFirst(String character);
}

