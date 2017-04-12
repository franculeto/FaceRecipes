package com.example.franc.facerecipes.libs.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.franc.facerecipes.libs.GlideImageLoader;
import com.example.franc.facerecipes.libs.GreenRobotEventBus;
import com.example.franc.facerecipes.libs.base.EventBus;
import com.example.franc.facerecipes.libs.base.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by franc on 9/3/2017.
 */

@Module
public class LibsModule {
    private Activity activity;

    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(RequestManager requestManager) {
        return new GlideImageLoader(requestManager);
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager(Fragment fragment)
    {
        return Glide.with(fragment);
    }

    @Provides
    @Singleton
    Activity providesActivity()
    {
        return this.activity;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus()
    {
        return org.greenrobot.eventbus.EventBus.getDefault();
    }


}
