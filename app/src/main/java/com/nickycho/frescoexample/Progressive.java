package com.nickycho.frescoexample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class Progressive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_progressive);
//        Uri photoUri = Uri.parse("http://www.pooyak.com/p/progjpeg/jpegload.cgi?o=1");
        Uri photoUri = Uri.parse("http://www.sultanswallpaper.com/static/images/wallpaper-hd-nature-cool-wallpapers-hdwalljoy-1080p-hd-wallpaper-3d-desktop-wallpapers-pack-1920x1080-phone-hot-girl-for-ps3-abstract-nature_8FouZtj.jpg");

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simpleDraweeView);
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(photoUri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController draweeController  = Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .build();
        simpleDraweeView.setController(draweeController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_progressive, menu);
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
