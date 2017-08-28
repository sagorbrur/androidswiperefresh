package com.example.sagorsarker.addingswiprefresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class
            .getSimpleName();
    SwipeRefreshLayout SRL;

    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = (TextView) findViewById(R.id.text_edit);

        //Swipe Refresh
        SRL = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        SRL.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                Log.i(TAG, "onRefresh called from SwipeRefreshLayout");

                // This method performs the actual data-refresh operation.
                // The method calls setRefreshing(false) when it's finished.
                myUpdateOperation();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            // Check if user triggered a refresh:
            case R.id.menu_refresh:
                Log.i(TAG, "Refresh menu item selected");

                // Signal SwipeRefreshLayout to start the progress indicator
                SRL.setRefreshing(true);

                // Start the refresh background task.
                // This method calls setRefreshing(false) when it's finished.
                myUpdateOperation();

                return true;
        }

        // User didn't trigger a refresh, let the superclass handle this action
        return super.onOptionsItemSelected(item);

    }

    private void myUpdateOperation(){
        tx.setText("Updated Text , Voula!");
        SRL.setRefreshing(false);
    }
}
