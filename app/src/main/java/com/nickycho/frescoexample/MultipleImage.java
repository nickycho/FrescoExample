package com.nickycho.frescoexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

public class MultipleImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_multiple_image);



        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simpleDraweeView);

//        ImageRequest imageRequest1 = ImageRequest.fromUri(Uri.parse("http://4.bp.blogspot.com/-vN2S9FWKK8Y/VAdEOkl4-NI/AAAAAAAABkQ/Z37bdBMUdo4/s1600/red-number-11.jpeg"));
        ImageRequest imageRequest1 = ImageRequest.fromUri(Uri.parse("http://www.wallpaperup.com/uploads/wallpapers/2014/10/21/489485/b807c2282ab0a491bd5c5c1051c6d312.jpg"));

        ImageRequest imageRequest2 = ImageRequest.fromUri(Uri.parse("http://clareluffman.com/wp-content/uploads/2013/10/red-number-5.jpg"));
        ImageRequest[] imageRequests = {imageRequest1, imageRequest2};
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setFirstAvailableImageRequests(imageRequests)
                .build();
        simpleDraweeView.setController(draweeController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multiple_image, menu);
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
