package com.example.acer.e_planner.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static com.example.acer.e_planner.R.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private CardView mua;
    private CardView fg;

    public HomeFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        mua = (CardView)rootView.findViewById(id.mua);
        mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(MuaFragment.class);
                //Toast.makeText(getActivity(), "MUA FRAGMENT", Toast.LENGTH_SHORT).show();
            }
        });

        fg = (CardView)rootView.findViewById(id.fg);
        fg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(FgFragment.class);
            }
        });
        return rootView;
    }

    public void setFragment(Class<? extends Fragment> fragment) {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            // awalnya kenapa getSupportFragmentManager() merah, sebab method ini bukan di activity,
            // tapi di fragment, kalau di fragment disipikan getActivity()
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // bukan merefer ke id home (button)
            //fragmentTransaction.replace(id.home, fragment.newInstance());
            // tapi merefer ke id nya fragment
            fragmentTransaction.replace(id.content, fragment.newInstance());
            fragmentTransaction.commit();
        } catch (Exception e) {
        }
    }

    // ini tak perlu, jangan pakai tooltips untuk solved error, gak smuanya bsa pake itu.
    /*protected FragmentManager getSupportFragmentManager() {
        return null;
    }*/

    /*
    * SEKARANG YANG PERLU DI PIKIRKAN ADALAH
    * Cara back nya :P
    * */

}
