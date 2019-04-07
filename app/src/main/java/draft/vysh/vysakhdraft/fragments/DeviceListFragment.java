package draft.vysh.vysakhdraft.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import draft.vysh.vysakhdraft.Device;
import draft.vysh.vysakhdraft.R;
import draft.vysh.vysakhdraft.RecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceListFragment extends Fragment {


    protected View rootView;
    protected RecyclerView deviceList;

    public DeviceListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_device_list, container, false);
        initView(rootView);

        ArrayList<Device> dList = new ArrayList<Device>();
        Device device = new Device();
        for (int i = 0; i < 10; i++) {
            dList.add(device);
        }

        RecyclerAdapter adapter = new RecyclerAdapter(dList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        deviceList.setLayoutManager(manager);
        deviceList.setAdapter(adapter);
        return rootView;
    }

    private void initView(View rootView) {
        deviceList = (RecyclerView) rootView.findViewById(R.id.deviceList);
    }
}
