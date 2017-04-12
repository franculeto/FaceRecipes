package com.example.franc.facerecipes.libs.base;

import android.widget.ImageView;

/**
 * Created by franc on 20/2/2017.
 */
public interface ImageLoader {
    void load(ImageView imgAvatar, String url);
    void setOnFinishedImageLoadListener(Object listener);
}
