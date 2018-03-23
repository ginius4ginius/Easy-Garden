package com.pro.ginius.easygarden.model;

import android.content.Context;
import android.widget.ImageView;

import com.pro.ginius.easygarden.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Derieu on 23/03/2018.
 */

public class PicassoPlante {

    public static void downloadImage (Context c, String imageUrl, ImageView img){
        if(imageUrl.length()>0 && imageUrl!=null){
            Picasso.with(c).load(imageUrl).placeholder(R.drawable.loading).into(img);
        }else{
            Picasso.with(c).load(R.drawable.loading).fit().centerInside().into(img);
        //    Picasso.with(c).load(R.drawable.jardin).resize(40,40).into(img);
        }
    }
}
