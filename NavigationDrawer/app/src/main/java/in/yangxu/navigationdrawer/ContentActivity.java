package in.yangxu.navigationdrawer;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

/**
 * Created by yangxu on 2015/04/10.
 */
public class ContentActivity extends Activity{

    private String Url;
    private ImageButton imageButton = null;
    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.contentlayout);


        webView = (WebView) findViewById(R.id.webView);
        webView.setScrollbarFadingEnabled(true);
//        webView.setScrollBarStyle(0);
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(false);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setHorizontalScrollbarOverlay(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollbarOverlay(false);
        webView.setScrollbarFadingEnabled(false);
//        settings.setSupportZoom(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
//        settings.setPluginsEnabled(true);
//        settings.setBuiltInZoomControls(true);
        webView.loadUrl("http://backpackersjapan.com/17");
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                webView.loadUrl(url);
                return true;
            }

        });
    }
}
