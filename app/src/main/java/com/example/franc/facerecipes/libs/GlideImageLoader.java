package com.example.franc.facerecipes.libs;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.example.franc.facerecipes.libs.base.ImageLoader;

/**
 * Created by franc on 11/4/2017.
 */

public class GlideImageLoader implements ImageLoader{

    private RequestManager glideRequestManager;
    private RequestListener onFiniRequestListener;

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }


    @Override
    public void load(ImageView imgAvatar, String url) {
        if(onFiniRequestListener != null){
            glideRequestManager
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .listener(onFiniRequestListener)
                    .into(imgAvatar);

        }else
        {
            glideRequestManager
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imgAvatar);
        }
    }

    @Override
    public void setOnFinishedImageLoadListener(Object listener) {
        if(listener instanceof RequestListener)
        {

        }
        this.onFiniRequestListener = (RequestListener) listener;
    }
}
