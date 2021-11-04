package com.sinu.qseek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.HashMap;

public class SeekActivity extends AppCompatActivity {
    SharedPreferences sp;

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_seek);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        String site = sp.getString("site", "custom");
        if (site.equals("custom")) {
            site = sp.getString("custom_url", null);
        } else {
            site = UrlMap.getUrlOfSite(site);
        }

        if (site == null || !site.contains("%s")) {
            Toast.makeText(this, R.string.error_bad_url, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        String text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString();

        webView = findViewById(R.id.seek_webview);
        webView.loadUrl(String.format(site, text));
    }
}