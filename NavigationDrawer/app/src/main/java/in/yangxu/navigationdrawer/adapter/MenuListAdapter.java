package in.yangxu.navigationdrawer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.yangxu.navigationdrawer.R;
import in.yangxu.navigationdrawer.modal.ListViewMenuItem;
import in.yangxu.navigationdrawer.modal.ListViewMenuItem;

/**
* Created by yangxu on 2015/04/06.
*/
public class MenuListAdapter extends BaseAdapter{


    private List<ListViewMenuItem> info =null;
    private Map<Integer, View> rowViews = new HashMap<Integer, View>();
    private Context context = null;



    public MenuListAdapter(List<ListViewMenuItem> info, Context context) {
        this.info = info;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return info.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return info.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
      //  View rowView = rowViews.get(position);

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.drawer_list_item, null);

                ListViewMenuItem item = (ListViewMenuItem) getItem(position);
                TextView text = (TextView)convertView.findViewById(R.id.text1);
                text.setText(item.getMenuName().toString());


        if(position ==0){


              text.setBackground(context.getResources().getDrawable(R.drawable.bg_profile));
            text.setTextColor(Color.WHITE);
                Drawable icon = context.getResources().getDrawable(R.drawable.ig_profile_photo_default);
                icon.setBounds(-30,-5,116,141);
                text.setCompoundDrawables(icon, null, null, null);


        } else if(position ==1){
                          if(item.isFlag()==true){
                              text.setTextColor(Color.WHITE);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_sort_by_size_w);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
                          }else{
                              text.setTextColor(Color.BLACK);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_sort_by_size);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
                          }

            }else if(position == 2){
                          if(item.isFlag()==true){
                              text.setTextColor(Color.WHITE);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_view_as_grid_w);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
                          }else{
                              text.setTextColor(Color.BLACK);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_view_as_grid);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
                          }

            }else if(position==3){
//                          if(item.isFlag()==true){
//                              text.setTextColor(Color.WHITE);
//                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_search_w);
//                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
//                              text.setCompoundDrawables(icon, null, null, null);
//                          }else{
//                              text.setTextColor(Color.BLACK);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_search);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
//                          }



            }else if(position==4){

//                          if(item.isFlag()==true){
//                              text.setTextColor(Color.WHITE);
//                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_labels_w);
//                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
//                              text.setCompoundDrawables(icon, null, null, null);
//                          }else{
//                              text.setTextColor(Color.BLACK);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_labels);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
//                          }
            }else if(position == 5){
//                          if(item.isFlag()==true){
//                              text.setTextColor(Color.WHITE);
//                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_settings_w);
//                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
//                              text.setCompoundDrawables(icon, null, null, null);
//                          }else{
//                              text.setTextColor(Color.BLACK);
                              Drawable icon = context.getResources().getDrawable(R.drawable.ic_action_settings);
                              icon.setBounds(0,0,icon.getIntrinsicWidth(),icon.getIntrinsicHeight());
                              text.setCompoundDrawables(icon, null, null, null);
//                          }

            }



          //  rowViews.put(position, rowView);

        return convertView;
    }





}
