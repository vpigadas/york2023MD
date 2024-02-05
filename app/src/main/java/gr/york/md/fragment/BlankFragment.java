package gr.york.md.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.york.md.R;

public class BlankFragment extends Fragment {

    private FragmentViewModel viewModel;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    public static BlankFragment newInstance(String name) {
        BlankFragment fragment = new BlankFragment();
        Bundle parameters = new Bundle();
        parameters.putString("name", name);
        fragment.setArguments(parameters);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentActivity activity = getActivity();
        if(activity ==null){
            viewModel = new ViewModelProvider(this).get(FragmentViewModel.class);
        }else {
            viewModel = new ViewModelProvider(activity).get(FragmentViewModel.class);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.fragment_textview);
        String viewModelName = viewModel.getName();

        if (getArguments() != null) {
            if (viewModelName != null) {
                textView.setText(viewModelName);
            } else {
                String name = getArguments().getString("name");
                textView.setText(name);
            }
        } else {
            if (viewModelName != null) {
                textView.setText(viewModelName);
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        View view = getView();
        if (view != null) {
            TextView textView = view.findViewById(R.id.fragment_textview);
        }


    }
}