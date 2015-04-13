package in.yangxu.navigationdrawer.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
//        View rowView = rowViews.get(position);
//        if (rowView == null) {
        CatalogItem item = info.get(position);

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.catalogitemlayout, null);

            TextView text = (TextView)convertView.findViewById(R.id.text);
        ImageView image = (ImageView)convertView.findViewById(R.id.image);
        if(item.getTitle().equals("東　京")){
            text.getBackground().setAlpha(130);
            text.setText("東　京");
            image.setBackground(context.getResources().getDrawable(R.drawable.cata01));
        }else if(item.getTitle().equals("北海道")){
            text.getBackground().setAlpha(130);
            text.setText("北海道");
            image.setBackground(context.getResources().getDrawable(R.drawable.cata02));
        }else if(item.getTitle().equals("京都・大阪")){
            text.getBackground().setAlpha(130);
            text.setText("京都・大阪");
            image.setBackground(context.getResources().getDrawable(R.drawable.cata04));
        }else if(item.getTitle().equals("名古屋")){
            text.getBackground().setAlpha(130);
            text.setText("名古屋");
            image.setBackground(context.getResources().getDrawable(R.drawable.cata08));
        }

//            rowViews.put(position, rowView);

//        }
        return convertView;
    }
}
