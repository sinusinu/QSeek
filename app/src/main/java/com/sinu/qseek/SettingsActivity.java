package com.sinu.qseek;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment(this))
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title_activity_settings);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        Context ctx;

        public SettingsFragment(Context ctx) {
            super();
            this.ctx = ctx;
        }

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

//            findPreference("about").setOnPreferenceClickListener(pref -> {
//                startActivity(new Intent(ctx, SeekActivity.class));
//                return true;
//            });

            findPreference("about").setTitle(getString(R.string.settings_about, BuildConfig.VERSION_NAME));
        }
    }
}