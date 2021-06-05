package com.example.aiautomationmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class BrowseActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        webView=(WebView)findViewById(R.id.web_browse_1);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.loadUrl("http://139.59.91.214/#/dashboard/IoT_Driven_AI_MODULE?authorization=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJEYXNoYm9hcmRfSW9UX0RyaXZlbl9BSV9NT0RVTEUiLCJ1c3IiOiJjbHVlbGVzc3NweSJ9.rs-hVLwAUXqWBklnzLduyntuGmZXyBNFkVvVPHGR3_w");
        webView.setWebViewClient(new WebViewClient());
        //String url=webView.getUrl().toString();
        webView.getProgress();
        webView.canGoBack();
        webView.canGoForward();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e("WEB_VIEW_TEST", "error code:" + errorCode);
                if(errorCode==404){
                    Toast.makeText(BrowseActivity.this,"Device is online",Toast.LENGTH_LONG).show();
                    onBackPressed();
                }

                onBackPressed();
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        //webView.loadUrl("http://139.59.91.214/#/dashboard/Timer_RTC?authorization=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiJEYXNoYm9hcmRfVGltZXJfUlRDIiwidXNyIjoiY2x1ZWxlc3NzcHkifQ.zqCBsJI2nrF9UQRnAYcnGdZAAxW9m-65Mx4nA5KfIQ8");
    }


}