package com.nickycho.frescoexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

//        ImageRequest imageRequest = ImageRequest.fromUri("http://www.sultanswallpaper.com/static/images/wallpaper-hd-nature-cool-wallpapers-hdwalljoy-1080p-hd-wallpaper-3d-desktop-wallpapers-pack-1920x1080-phone-hot-girl-for-ps3-abstract-nature_8FouZtj.jpg");
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
//        imagePipeline.clearDiskCaches();
        imagePipeline.evictFromDiskCache(Uri.parse("http://www.sultanswallpaper.com/static/images/wallpaper-hd-nature-cool-wallpapers-hdwalljoy-1080p-hd-wallpaper-3d-desktop-wallpapers-pack-1920x1080-phone-hot-girl-for-ps3-abstract-nature_8FouZtj.jpg"));
////        imagePipeline.evictFromMemoryCache(Uri.parse("http://www.pooyak.com/p/progjpeg/jpegload.cgi?o=1"));
//        imagePipeline.prefetchToDiskCache(imageRequest, this);

    }

    private void removeAllDiskCaches(){
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.clearDiskCaches();
    }

    private void removeDiskCache(String uri){
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        imagePipeline.evictFromDiskCache(Uri.parse(uri));
    }

    public void clickLowToHigh(View view){
        Intent intent = new Intent(this, LowToHighResolution.class);
        startActivity(intent);
    }

    public void clickCircleAndCorner(View view){
        Intent intent = new Intent(this, CircleAndCorner.class);
        startActivity(intent);
    }

    public void clickProgressive(View view){
        Intent intent = new Intent(this, Progressive.class);
        startActivity(intent);
    }

    public void clickMultipleImage(View view){
        Intent intent = new Intent(this, MultipleImage.class);
        startActivity(intent);
    }


    public void clickAnimatedImage(View view){
        Intent intent = new Intent(this, AnimatedImage.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
