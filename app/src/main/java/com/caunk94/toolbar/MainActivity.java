package com.caunk94.toolbar;
//this is secound commits
import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        my_toolbar.setTitle(R.string.my_title_main);
        my_toolbar.setSubtitle(R.string.my_subtitle_main);
        my_toolbar.setLogo(R.mipmap.ic_navigation_drawer);
        setSupportActionBar(my_toolbar);

        Intent myintent = getIntent();
        if (Intent.ACTION_SEARCH.equals(myintent.getAction())){
            String query = myintent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query , Toast.LENGTH_SHORT).show();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView)menu.findItem(R.id.item_search).getActionView();
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_setting:
            startActivity(new Intent(this, SettingsActivity.class));
            //Toast.makeText(this, R.string.item_setting, Toast.LENGTH_SHORT).show();
            break;

            case R.id.item_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                // /Toast.makeText(this, R.string.item_profile, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
