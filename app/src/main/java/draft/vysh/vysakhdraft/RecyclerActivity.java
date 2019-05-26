package draft.vysh.vysakhdraft;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements StartDragListener {

    protected RecyclerView recyclerDrag;
    ItemTouchHelper touchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_recycler);
        initView();


        ArrayList<Device> list = new ArrayList<Device>();
        Device model = new Device();
        model.setDelay_value("00:00:01");
        model.setDevice_name_tv("Philips Hue");

        list.add(model);

        Device model2 = new Device();
        model2.setDelay_value("00:00:10");
        model2.setDevice_name_tv("Nest Thermostat");

        list.add(model2);

        Device model3 = new Device();
        model3.setDelay_value("00:00:30");
        model3.setDevice_name_tv("Lloyd AC");

        list.add(model3);

        Device model4 = new Device();
        model4.setDelay_value("00:00:45");
        model4.setDevice_name_tv("Security Cam");

        list.add(model4);

        Device model5 = new Device();
        model5.setDelay_value("00:00:50");
        model5.setDevice_name_tv("Google Nest hub");

        list.add(model5);


        // use this if you want the RecyclerView to look like a vertical list view
        recyclerDrag.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



        RoomRecyclerAdapter adapter = new RoomRecyclerAdapter(list, this);

        ItemTouchHelper.Callback callback = new ItemMoveCallback(adapter);
         touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerDrag);


        recyclerDrag.setAdapter(adapter);

    }

    @Override
    public void requestDrag(RecyclerView.ViewHolder viewHolder) {
        touchHelper.startDrag(viewHolder);
    }

    private void initView() {
        recyclerDrag = (RecyclerView) findViewById(R.id.recyclerDrag);
    }
}
