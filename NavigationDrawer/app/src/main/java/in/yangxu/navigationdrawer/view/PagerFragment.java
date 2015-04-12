package in.yangxu.navigationdrawer.view;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.yangxu.navigationdrawer.R;
import in.yangxu.navigationdrawer.adapter.MypagerAdapter;
import in.yangxu.navigationdrawer.utils.PagerSlidingTabStrip;

/**
 * Created by yangxu on 15/04/12.
 */
public class PagerFragment extends Fragment {
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MypagerAdapter adapter;

    private FragmentManager fm;

    public PagerFragment(){

    }

    @SuppressLint("ValidFragment")
    public PagerFragment(FragmentManager fm) {

        this.fm = fm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.home, container, false);


            tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
            pager = (ViewPager) rootView.findViewById(R.id.pager);
            adapter = new MypagerAdapter(fm);

            pager.setAdapter(adapter);

            final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                    .getDisplayMetrics());
            pager.setPageMargin(pageMargin);

            tabs.setViewPager(pager);



        getActivity().setTitle("旅・日本");
        return rootView;
    }
}
