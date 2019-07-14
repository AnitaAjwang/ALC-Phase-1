package com.example.alcphaseone;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutALC extends AppCompatActivity {
    private WebView about_alc_web_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        about_alc_web_view = (WebView) findViewById(R.id.about_alc_web_view);
      //  about_alc_web_view.setBackgroundColor(Color.TRANSPARENT);
        webView();
    }

    private void webView(){

        //Handling Page Navigation
        about_alc_web_view.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = about_alc_web_view.getSettings();
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        about_alc_web_view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);




        //Load a URL on WebView
        about_alc_web_view.loadUrl(getString(R.string.website_url));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(AboutALC.this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

            handler.proceed();
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            view.loadUrl(url);

/*            if (Uri.parse(url).getHost().equals(getString(R.string.website_domain))) { //Force to open the url in WEBVIEW
                return false;
            }*/
/*
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);*/
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(AboutALC.this,"Page could not be loaded. Please try again",Toast.LENGTH_LONG).show();
        }


    }


}
