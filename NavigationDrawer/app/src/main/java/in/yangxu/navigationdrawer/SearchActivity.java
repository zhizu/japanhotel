package in.yangxu.navigationdrawer;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

/**
 * Created by yangxu on 2015/04/14.
 */
public class SearchActivity extends Activity{
    private SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search_layout);
        sv=(SearchView)findViewById(R.id.sv);
        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(false);
        sv.setBackgroundColor(Color.WHITE);
        int magId = sv.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView imageView = (ImageView)sv.findViewById(magId);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(0,0));
        //为该SearchView组件设置事件监听器
//        sv.setOnQueryTextListener(this);
        //设置该SearchView显示搜索按钮
        sv.setSubmitButtonEnabled(false);
        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");
    }
}
