/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package in.yangxu.navigationdrawer.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import in.yangxu.navigationdrawer.R;
import in.yangxu.navigationdrawer.adapter.ItemAdapter;
import in.yangxu.navigationdrawer.modal.Item;

public class SuperAwesomeCardFragment extends Fragment {

	private static final String ARG_POSITION = "position";
    private ItemAdapter adapter;
	private int position;
    private int totalItemCount1 = 0;
    //最后可见的Item
    private int lastVisibleItem = 0;
    List<Item> list = new ArrayList<Item>();
	public static SuperAwesomeCardFragment newInstance(int position) {
		SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homelistviewlayout,container,false);
        final SwipeRefreshLayout mSwipeRefreshLayout= (SwipeRefreshLayout)v.findViewById(R.id.activity_main_swipe_refresh_layout);


        if(position==0){
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mSwipeRefreshLayout.setRefreshing(false);

                }
            });
            ListView listView = (ListView)v.findViewById(R.id.activity_main_listview);
            listView.setCacheColorHint(Color.TRANSPARENT);
            listView.setDividerHeight(0);




            Item item1 = new Item();
            Item item2 = new Item();
            Item item3 = new Item();
            list.add(item1);
            list.add(item2);
            list.add(item3);
            adapter = new ItemAdapter(list,getActivity());
            listView.setAdapter(adapter);

            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if(lastVisibleItem == totalItemCount1 && scrollState == SCROLL_STATE_IDLE){

                        Item item4 = new Item();
                        list.add(item4);

                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    lastVisibleItem = firstVisibleItem + visibleItemCount;
                    totalItemCount1 = totalItemCount;
                }
            });
        }else{
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mSwipeRefreshLayout.setRefreshing(false);

                }
            });
            ListView listView = (ListView)v.findViewById(R.id.activity_main_listview);
            listView.setCacheColorHint(Color.TRANSPARENT);
            listView.setDividerHeight(0);




            Item item1 = new Item();
            list.add(item1);
            adapter = new ItemAdapter(list,getActivity());
            listView.setAdapter(adapter);


            listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                    if(lastVisibleItem == totalItemCount1 && scrollState == SCROLL_STATE_IDLE){

                        Item item4 = new Item();
                        list.add(item4);

                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    lastVisibleItem = firstVisibleItem + visibleItemCount;
                    totalItemCount1 = totalItemCount;
                }
            });
        }

		return v;
	}

}