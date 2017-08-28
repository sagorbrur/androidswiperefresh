# androidswiperefresh
This application is a example of android **swipe refresh** with simple code.<br>
To add Swipe Refresh we need to add android SwipeRefreshLayout widget under `activity_main.xml` file
```xml
<!--refresh layout-->
    <android.support.v4.widget.SwipeRefreshLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/swiperefresh"
        android:layout_width="368dp"
        android:layout_height="495dp"
        tools:layout_editor_absoluteY="8dp"
        tools:layout_editor_absoluteX="8dp">       
</android.support.v4.widget.SwipeRefreshLayout>
```

Inside `SwipeRefreshLayout` we need to put our refresh widget such as **ListView**,**TextView**<br>

Then we need to add menu 
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/menu_refresh"
        android:title="@string/menu_refresh"
        app:showAsAction="never"
        />
</menu>
```
Now we need to add some code to our `MainActivity.java` class<br>
First refer our SwipeRefreshLayout
```SwipeRefreshLayout SRL;```
inside `onCreate()` Method we need to add this simple code to hadle swiperefresh onClick listener
```java
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
```
Here ```myUpdateOperation()``` is a method to handle our refresh thing and calls ```setRefreshing(false)``` when it's finished
We need to add same code under `OnOptionsItemSelected` method
```java
case R.id.menu_refresh:
                Log.i(TAG, "Refresh menu item selected");

                // Signal SwipeRefreshLayout to start the progress indicator
                SRL.setRefreshing(true);

                // Start the refresh background task.
                // This method calls setRefreshing(false) when it's finished.
                myUpdateOperation();

                return true;
```

