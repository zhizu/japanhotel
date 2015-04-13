package in.yangxu.navigationdrawer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import in.yangxu.navigationdrawer.MainActivity;
import in.yangxu.navigationdrawer.R;
import in.yangxu.navigationdrawer.adapter.CatalogItemAdapter;
import in.yangxu.navigationdrawer.modal.CatalogItem;

/**
 * Created by yangxu on 15/04/12.
 */
@SuppressLint("ValidFragment")
public class CatalogFragment extends Fragment{
    private CatalogItemAdapter adapter;
private Context context;
    private List<CatalogItem> lists = new ArrayList<CatalogItem>();
    public CatalogFragment(Context context) {
this.context = context;
        // Empty constructor required for fragment subclasses
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cataloglayout, container, false);


        GridView gridView = (GridView)rootView.findViewById(R.id.gridView);

        CatalogItem item0 = new CatalogItem();
        CatalogItem item1 = new CatalogItem();
        CatalogItem item2 = new CatalogItem();
        CatalogItem item3 = new CatalogItem();

        item0.setTitle("東　京");
        item1.setTitle("北海道");
        item2.setTitle("京都・大阪");
        item3.setTitle("名古屋");


        lists.add(item0);
        lists.add(item1);
        lists.add(item2);
        lists.add(item3);

        adapter = new CatalogItemAdapter(lists,context);
        gridView.setAdapter(adapter);
        getActivity().setTitle("旅・日本");
        return rootView;
    }

}
