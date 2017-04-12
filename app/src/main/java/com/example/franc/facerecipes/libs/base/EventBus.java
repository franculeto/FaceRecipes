package com.example.franc.facerecipes.libs.base;

/**
 * Created by franc on 18/2/2017.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
