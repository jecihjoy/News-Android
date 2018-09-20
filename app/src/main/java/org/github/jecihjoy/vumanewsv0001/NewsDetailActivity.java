package org.github.jecihjoy.vumanewsv0001;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsDetailActivity extends AppCompatActivity {
    private WebView web;
    ProgressDialog progressDialog;
    String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Vuma News");
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();


        progressDialog = new ProgressDialog(this);


        web =(WebView) findViewById(R.id.web);
        // progressDialog.dismiss();

        progressDialog.show();
        progressDialog.setMessage("");
        progressDialog.setCanceledOnTouchOutside(true);
        web.loadUrl(bundle.getString("url"));



        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });


        web.getSettings().setJavaScriptEnabled(true);
    }
}
