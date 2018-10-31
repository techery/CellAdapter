package io.techery.sample.home;

import androidx.annotation.StringRes;

public class MenuItem {

    @StringRes final int titleId;
    final Class clazz;

    public MenuItem(@StringRes int titleId, Class clazz) {
        this.titleId = titleId;
        this.clazz = clazz;
    }
}