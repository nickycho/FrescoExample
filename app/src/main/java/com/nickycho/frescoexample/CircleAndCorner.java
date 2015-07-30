package com.nickycho.frescoexample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class CircleAndCorner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_circle_and_corner);

        Uri photoUri = Uri.parse("http://orig12.deviantart.net/4b89/f/2012/130/c/5/c56f54cdc66515326818d2faacb6304d-d4zb63r.jpg");
        SimpleDraweeView circleSdv = (SimpleDraweeView) findViewById(R.id.circleSdv);
        SimpleDraweeView cornerSdv = (SimpleDraweeView) findViewById(R.id.cornerSdv);
        circleSdv.setImageURI(photoUri);
        cornerSdv.setImageURI(photoUri);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_circle_and_corner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
