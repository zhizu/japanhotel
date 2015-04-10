package in.yangxu.navigationdrawer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import in.yangxu.navigationdrawer.SuperAwesomeCardFragment;

/**
 * Created by yangxu on 2015/04/06.
 */
public class MypagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = { "最新民宿", "人气民宿"};

    public MypagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return SuperAwesomeCardFragment.newInstance(position);
    }

}