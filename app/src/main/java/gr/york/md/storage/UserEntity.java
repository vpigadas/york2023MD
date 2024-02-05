package gr.york.md.storage;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity( tableName = "User", primaryKeys = {"name"})
public class UserEntity {
//    @PrimaryKey(autoGenerate = true)
//    private int id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;
    @ColumnInfo(name = "age")
    private int age;
    @ColumnInfo(name = "job_title")
    private String job_title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(job_title, that.job_title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job_title);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job_title='" + job_title + '\'' +
                '}';
    }
}
