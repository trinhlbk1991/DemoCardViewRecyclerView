package com.icetea09.demomaterialdesigncard.utils;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class BitmapUtils {

    /**
     * Get a bitmap image from assets
     */
    public static Bitmap getBitmapFromAsset(AssetManager assetManager, String strName) {
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }

}
