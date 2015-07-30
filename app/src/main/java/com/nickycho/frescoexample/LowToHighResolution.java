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

public class LowToHighResolution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_low_to_high_resolution);

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simpleDraweeView);
        Uri lowResImageUri = Uri.parse("http://cs625128.vk.me/v625128868/2419d/jv-RiNp2yxc.jpg");
        Uri highRewImageUri = Uri.parse("http://orig11.deviantart.net/d23b/f/2014/180/8/7/one_piece_law_15_anniversary_by_candydfighter-d7og466.jpg");
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(lowResImageUri))
                .setImageRequest(ImageRequest.fromUri(highRewImageUri))
                .build();
        simpleDraweeView.setController(controller);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_low_to_high_resolution, menu);
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
