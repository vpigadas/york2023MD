package gr.york.md.fragment;

import androidx.lifecycle.ViewModel;

public class FragmentViewModel extends ViewModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
