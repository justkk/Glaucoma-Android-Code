package com.example.hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification.Style;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi") public class Imageviewr extends Activity {
	
	
	float width;
	  float height;
	  float currentHeight;
	  WebView mWebView;
	  String text;
	  
	  protected void onCreate(Bundle savedInstanceState) {

			 super.onCreate(savedInstanceState);
			 setContentView(R.layout.imageviewr);
			 text = getIntent().getStringExtra("imagepath");
			 
			 WebView webView = (WebView) findViewById(R.id.webView);
			 webView.setBackgroundColor(Color.parseColor("#000000"));
			 webView.getSettings().setBuiltInZoomControls(true);
			 webView.getSettings().setLoadWithOverviewMode(true);
			 webView.getSettings().setUseWideViewPort(true);          
			 webView.getSettings().setDomStorageEnabled(true);
			 webView.getSettings().setSupportZoom(true);
			 webView.getSettings().setBuiltInZoomControls(true);
			 webView.getSettings().setDisplayZoomControls(false);
			// webView.loadUrl(text);
			 webView.getSettings().setJavaScriptEnabled(true);
			 String mat= "<html><head><style> img { position: absolute; width: 300px; height: 300px; left: 50%; top: 50%; margin-left: -150px; margin-top: -150px; }</style> </head> <body> <img src=\""+"file://"+text+"\"> </body> </html>";
			 //webView.loadDataWithBaseURL(null,mat, "text/html", "UTF-8",null);
			 center();
			}
	  
	  
	  
	  
	  //this function will set the current height according to screen orientation
	  @Override
	  public void onConfigurationChanged(Configuration newConfig){
	          if(newConfig.equals(Configuration.ORIENTATION_LANDSCAPE)){

	                currentHeight=width; 
	                loadImage();                 

	         }if(newConfig.equals(Configuration.ORIENTATION_PORTRAIT)){

	                currentHeight=height;
	                loadImage();

	        }
	    } 


	  //call this function and it will place the image at the center
	  public void center(){

	    mWebView=(WebView)findViewById(R.id.webView);
	    mWebView.getSettings().setJavaScriptEnabled(true);
	    mWebView.getSettings().setBuiltInZoomControls(true);       
	    mWebView.setBackgroundColor(0);

	    DisplayMetrics displaymetrics = new DisplayMetrics();
	    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	    height = displaymetrics.heightPixels;
	    width = displaymetrics.widthPixels;
	    currentHeight=height;             //assuming that the phone
	                                     //is held in portrait mode initially
	         loadImage();        
	  }
	  public void loadImage(){
	       Bitmap BitmapOfMyImage=BitmapFactory.decodeFile(text);  
	       mWebView.loadDataWithBaseURL(null,"<html><center>"+"<img src=\""+"file://"+text+"\" vspace="+(currentHeight/2-(BitmapOfMyImage.getHeight()/2))+"></html>","text/html","utf-8",null);                    

	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
