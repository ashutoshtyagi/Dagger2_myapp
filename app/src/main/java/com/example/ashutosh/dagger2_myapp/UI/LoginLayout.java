package com.example.ashutosh.dagger2_myapp.UI;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import javax.inject.Inject;

/**
 * Created by ashutosh on 8/1/16.
 */
public class LoginLayout extends RelativeLayout {
    @Inject
    ActionBar actionBar;

    public LoginLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);

        if (changedView.equals(this) && visibility == VISIBLE) {
            actionBar.setTitle("Log in");
        }
    }
}