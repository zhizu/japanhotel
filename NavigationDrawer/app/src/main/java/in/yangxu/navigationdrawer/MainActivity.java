/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package in.yangxu.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentManager;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import in.yangxu.navigationdrawer.adapter.MenuListAdapter;
import in.yangxu.navigationdrawer.modal.ListViewMenuItem;
import in.yangxu.navigationdrawer.view.CatalogFragment;
import in.yangxu.navigationdrawer.view.PagerFragment;


public class MainActivity extends FragmentActivity {
    private Drawable oldBackground = null;
    private int currentColor = 0xFF3F9FE0;
    private final Handler handler = new Handler();

private List<ListViewMenuItem> info = new ArrayList<>();
private MenuListAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;


    private FragmentManager fragmentManager;

    private PagerFragment pagerFragment;
    private CatalogFragment cataFragment;

    private int one = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item, mPlanetTitles));
        ListViewMenuItem item0 = new ListViewMenuItem();
        ListViewMenuItem item1 = new ListViewMenuItem();
        ListViewMenuItem item2 = new ListViewMenuItem();
        ListViewMenuItem item3 = new ListViewMenuItem();
        ListViewMenuItem item4 = new ListViewMenuItem();
        ListViewMenuItem item5 = new ListViewMenuItem();
        item0.setMenuName("楊　旭");
        item1.setMenuName("首页");
        item2.setMenuName("分类");
        item3.setMenuName("搜索");
        item4.setMenuName("投稿");
        item5.setMenuName("设置");
        item0.setFlag(false);
        item1.setFlag(true);
        item2.setFlag(false);
        item3.setFlag(false);
        item4.setFlag(false);
        item5.setFlag(false);

        info.add(item0);
        info.add(item1);
        info.add(item2);
        info.add(item3);
        info.add(item4);
        info.add(item5);
        adapter = new MenuListAdapter(info,MainActivity.this);


        mDrawerList.setAdapter(adapter);


        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            fragmentManager = this.getSupportFragmentManager();
            pagerFragment = new PagerFragment(fragmentManager);
            cataFragment = new CatalogFragment(MainActivity.this);
            selectItem(one);
            mDrawerList.setItemChecked(one, true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
            case R.id.action_settings:
                // create intent to perform web search for this planet
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
                // catch event that there's no activity to handle intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if(position!=1 && position!=2){
                mDrawerList.setItemChecked(one, true);

                if(position==3){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,SearchActivity.class);
                    MainActivity.this.startActivity(intent);
                }else if(position==4){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,ToukouActivity.class);
                    MainActivity.this.startActivity(intent);
                }else if(position==5){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,SettingActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }else{
                info.get(position).setFlag(true);
                mDrawerList.setItemChecked(position,true);
                selectItem(position);
                info.get(one).setFlag(false);
                one = position;

            }





           adapter.notifyDataSetChanged();
           // selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments

        mDrawerLayout.closeDrawer(mDrawerList);


        if(position == 1){
            if(fragmentManager.findFragmentByTag("one") != null) {
                //if the fragment exists, show it.
                fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("one")).commit();
            } else {
                //if the fragment does not exist, add it to fragment manager.
                fragmentManager.beginTransaction().add(R.id.content_frame, pagerFragment, "one").commit();
            }
            if(fragmentManager.findFragmentByTag("two") != null){
                //if the other fragment is visible, hide it.
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("two")).commit();
            }

        }else if(position == 2){
            if(fragmentManager.findFragmentByTag("two") != null) {
                //if the fragment exists, show it.
                fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("two")).commit();
            } else {
                //if the fragment does not exist, add it to fragment manager.
                fragmentManager.beginTransaction().add(R.id.content_frame, cataFragment, "two").commit();
            }
            if(fragmentManager.findFragmentByTag("one") != null){
                //if the other fragment is visible, hide it.
                fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("one")).commit();
            }
        }

;


    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}