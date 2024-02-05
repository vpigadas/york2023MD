package gr.york.md.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    public CustomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position % 2 == 0) {
            return BlankFragment.newInstance();
        } else {
            return BlankFragment2.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
