package draft.vysh.vysakhdraft;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import draft.vysh.vysakhdraft.fragments.DeviceListFragment;
import draft.vysh.vysakhdraft.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity{

    private HomeFragment homeFragment;
    private Fragment selectedFragment;
    private DeviceListFragment deviceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this,TabActivity.class));
        finish();

        homeFragment = HomeFragment.newInstance();
        deviceFragment = new DeviceListFragment();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.action_home:
                                selectedFragment = homeFragment;
                                break;
                            case R.id.action_favourites:
                                selectedFragment = deviceFragment;
                                break;
                            case R.id.action_profile:
                                //selectedFragment = profileFragment;
                                break;
                            case R.id.action_payments:
                                //selectedFragment = referEarnFragment;
                            default:
                                break;
                        }
                        if(selectedFragment!=null) {
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_layout, selectedFragment);
                            transaction.commit();
                        }
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, homeFragment);
        transaction.commit();
    }
}
