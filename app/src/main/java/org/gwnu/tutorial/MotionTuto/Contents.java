package org.gwnu.tutorial.MotionTuto;

import android.graphics.drawable.Drawable;

public class Contents {
    Drawable contentsImage;

    public Contents(Drawable contentsImage) {
        this.contentsImage = contentsImage;
    }

    public Drawable getContentsImage() {
        return contentsImage;
    }

    public void setContentsImage(Drawable contentsImage) {
        this.contentsImage = contentsImage;
    }
}
