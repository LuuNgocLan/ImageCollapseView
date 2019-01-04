
package com.lanltn.imagecollapseview.modules.myArtist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.databinding.FragmentMyArtistBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyArtistFragment extends Fragment {

    private MyArtistFragmentViewModel mViewModel;

    private RecyclerView recyclerView;

    private FragmentMyArtistBinding binding;

    public MyArtistFragment() {
        Bundle bundle = new Bundle();
        setArguments(bundle);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyArtistBinding.inflate(inflater, container, false);
        mViewModel = new MyArtistFragmentViewModel(getActivity());
        binding.setViewModel(mViewModel);
        initRecyclerView();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.setUp();
    }

    @Override
    public void onPause() {
        super.onPause();
        mViewModel.tearDown();
    }


    private void initRecyclerView() {
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

}
