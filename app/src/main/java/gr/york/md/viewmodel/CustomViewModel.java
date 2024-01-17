package gr.york.md.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.List;

import gr.york.md.storage.DatabaseInstance;
import gr.york.md.storage.UserEntity;

public class CustomViewModel extends AndroidViewModel {
    private final MutableLiveData<UserUIModel> titleStream = new MutableLiveData<>();
    private DatabaseInstance databaseInstance;

    public CustomViewModel(@NonNull Application application) {
        super(application);
    }

    public void initialise() {
        UserUIModel userUIModel = new UserUIModel();
        userUIModel.setName("Vassilis");
        userUIModel.setAge(100);
        userUIModel.setJobTitle("");
        titleStream.setValue(userUIModel);


        databaseInstance =
                Room.databaseBuilder(getApplication(), DatabaseInstance.class, "Database")
                        .allowMainThreadQueries().build();
    }

    public void performButtonAction(LifecycleOwner owner) {
        Toast.makeText(getApplication(), "Button Clicked!!!", Toast.LENGTH_SHORT).show();

        UserUIModel userUIModel = titleStream.getValue();
//        if(userUIModel == null){
//            return;
//        }
        if (userUIModel != null) {
            userUIModel.setAge(userUIModel.getAge() + 1);
            titleStream.postValue(userUIModel);
        }


        databaseInstance.getUserDaoWithStreams().read().observe(owner, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {

            }
        });
    }

    public void observeTitleStream(LifecycleOwner owner, Observer<UserUIModel> userUIModelObserver) {
        titleStream.observe(owner, userUIModelObserver);
    }
}
