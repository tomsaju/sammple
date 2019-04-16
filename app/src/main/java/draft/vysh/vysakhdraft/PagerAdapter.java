package draft.vysh.vysakhdraft;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import draft.vysh.vysakhdraft.fragments.DeviceListFragment;
import draft.vysh.vysakhdraft.fragments.DevicesFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;
    // tab titles
    private String[] tabTitles = new String[]{"Manage", "Devices", "Presets"};
    DeviceListFragment deviceListFragment;
    FragmentManager fragmentManager;
    private Map<Integer, String> mFragmentTags;
    private DevicesFragment df;

    public PagerAdapter(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount = tabCount;
        this.fragmentManager = fm;
        deviceListFragment = new DeviceListFragment();
        mFragmentTags = new HashMap<Integer, String>();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:

                deviceListFragment = new DeviceListFragment();
                return deviceListFragment;

            case 1:
                deviceListFragment = new DeviceListFragment();
                return deviceListFragment;
            // TopItemFragment topItemFragment = new TopItemFragment();
            // topItemFragment = new TopItemFragment();
            // return topItemFragment;

            case 2:
                deviceListFragment = new DeviceListFragment();
                return deviceListFragment;
            // TopItemFragment topItemFragment = new TopItemFragment();
            // topItemFragment = new TopItemFragment();
            // return topItemFragment;

            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            String tag = fragment.getTag();
            mFragmentTags.put(position, tag);
        }
        return object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    public Fragment getFragment(int position) {
        Fragment fragment = null;
        String tag = mFragmentTags.get(position);
        if (tag != null) {
            fragment = fragmentManager.findFragmentByTag(tag);
        }
        if(position==2){
            if(df!=null){
                df.onResume();
            }
        }
        return fragment;
    }
}
