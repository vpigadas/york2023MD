package gr.york.md.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import gr.york.md.R;

public class FragmActivity extends AppCompatActivity {

    private FragmentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragm);

        viewModel = new ViewModelProvider(this).get(FragmentViewModel.class);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        FragmentContainerView containerView = findViewById(R.id.fragment_container);

        viewModel.setName("V Pigadas");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.add(R.id.fragment_container, BlankFragment.newInstance(), BlankFragment.class.getSimpleName());
        transaction.replace(R.id.fragment_container, BlankFragment.newInstance("Vassilis Pigadas"), BlankFragment.class.getSimpleName());
        transaction.commit();


        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager()));
    }
}