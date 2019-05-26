package draft.vysh.vysakhdraft;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dreamz on 25-05-2019.
 */

public class RoomRecyclerAdapter extends RecyclerView.Adapter<RoomRecyclerAdapter.Viewholder> implements ItemMoveCallback.ItemTouchHelperContract {

    private ArrayList<Device> data;
    private Device model;
    private Context context;
    private StartDragListener mStartDragListener;

    public RoomRecyclerAdapter(ArrayList<Device> data, Context context) {
        this.data = data;
        this.context = context;
        this.mStartDragListener = (StartDragListener)context;
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        // 1. Declare your Views here

        public TextView delay_value;
        public View line;
        public ImageView icon;
        public TextView device_name_tv;
        ImageView handle;


        public Viewholder(View itemView) {
            super(itemView);

            // 2. Define your Views here

            delay_value = (TextView)itemView.findViewById(R.id.delay_value);
            line = (View)itemView.findViewById(R.id.line);
            icon = (ImageView)itemView.findViewById(R.id.icon);
            device_name_tv = (TextView)itemView.findViewById(R.id.device_name_tv);
            handle = (ImageView) itemView.findViewById(R.id.drag_handle);

        }
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dragable_list_item_layout, parent, false);

        return new Viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {

        model = data.get(position);

        // 3. set the data to your Views here

        /**
         *
         The format to set data should be like this example:
         --------------------------------------
         holder.txvName.setText(model.getName());
         *
         */
        holder.device_name_tv.setText(model.getDevice_name_tv());
        holder.handle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mStartDragListener.requestDrag(holder);
                }
                return false;
            }
        });

    }

    @Override
    public void onRowMoved(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRowSelected(Viewholder myViewHolder) {
      //  myViewHolder.rowView.setBackgroundColor(Color.GRAY);

    }

    @Override
    public void onRowClear(Viewholder myViewHolder) {

        //myViewHolder.rowView.setBackgroundColor(Color.WHITE);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}

