package draft.vysh.vysakhdraft;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dreamz on 07-04-2019.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DeviceViewHolder> implements View.OnClickListener {

    private ArrayList<Device> deviceList;
    private Context mContext;


    public class DeviceViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title,artist;
        public ImageView albumArt;

        public DeviceViewHolder(View itemView) {
            super(itemView);

        }
    }


    public RecyclerAdapter(ArrayList<Device> devices){
        this.deviceList = devices;
    }

    @Override
    public RecyclerAdapter.DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false);
        itemView.setOnClickListener(this);
        return new DeviceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return deviceList.size();
    }


    @Override
    public void onClick(View view) {

    }
}
