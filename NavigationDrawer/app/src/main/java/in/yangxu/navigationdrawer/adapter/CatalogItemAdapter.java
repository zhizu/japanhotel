package in.yangxu.navigationdrawer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.yangxu.navigationdrawer.ContentActivity;
import in.yangxu.navigationdrawer.R;
import in.yangxu.navigationdrawer.modal.CatalogItem;
import in.yangxu.navigationdrawer.modal.Item;

/**
 * Created by yangxu on 15/04/12.
 */
public class CatalogItemAdapter extends BaseAdapter{
    private List<CatalogItem> info = null;
    private Map<Integer, View> rowViews = new HashMap<Integer, View>();
    private Context context = null;
    private Item item;

    public CatalogItemAdapter(List<CatalogItem> info, Context context) {
        this.info = info;
        this.context = context;
    }

    @Override
    public int getCount() {
        return info.size();
    }

    @Override
    public Object getItem(int position) {
        return info.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = rowViews.get(position);
        if (rowView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            rowView = layoutInflater.inflate(R.layout.catalogitemlayout, null);

            rowViews.put(position, rowView);

        }
        return rowView;
    }
}
