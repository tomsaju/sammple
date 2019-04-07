package draft.vysh.vysakhdraft.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import draft.vysh.vysakhdraft.Device;
import draft.vysh.vysakhdraft.R;
import draft.vysh.vysakhdraft.RecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    protected View rootView;
    protected TextView homeTxt;
    protected RelativeLayout relativeLayout;
    protected RelativeLayout relMain;
    protected LinearLayout linearLayout;
    protected LinearLayout topBanner;
    protected TextView homeTxt2;
    protected RelativeLayout relativeLayout2;
    protected RecyclerView favSceneRecyclerview;
    protected RecyclerView recyclerview2;
    protected RecyclerView recyclerview3;
    protected RecyclerView recyclerview4;
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        ArrayList<Device> dList = new ArrayList<Device>();
        Device device = new Device();
        for (int i = 0; i < 10; i++) {
            dList.add(device);
        }

        RecyclerAdapter adapter = new RecyclerAdapter(dList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false);
        favSceneRecyclerview.setLayoutManager(manager);
        favSceneRecyclerview.setAdapter(adapter);
        recyclerview2.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        recyclerview2.setAdapter(adapter);
        recyclerview3.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        recyclerview3.setAdapter(adapter);
        recyclerview4.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        recyclerview4.setAdapter(adapter);


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initView(View rootView) {
        homeTxt = (TextView) rootView.findViewById(R.id.home_txt);
        relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relativeLayout);
        relMain = (RelativeLayout) rootView.findViewById(R.id.rel_main);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout);
        topBanner = (LinearLayout) rootView.findViewById(R.id.top_banner);
        homeTxt2 = (TextView) rootView.findViewById(R.id.home_txt2);
        relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.relativeLayout2);
        favSceneRecyclerview = (RecyclerView) rootView.findViewById(R.id.fav_scene_recyclerview);
        recyclerview2 = (RecyclerView) rootView.findViewById(R.id.recyclerview2);
        recyclerview3 = (RecyclerView) rootView.findViewById(R.id.recyclerview3);
        recyclerview4 = (RecyclerView) rootView.findViewById(R.id.recyclerview4);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
