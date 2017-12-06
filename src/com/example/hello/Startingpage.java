package com.example.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;





public class Startingpage extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		 
		 
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.startingpoint);
		 
	
					
					Thread th =new Thread()
					{
						public void run()
						{
							try {
								sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    	Intent ne = new Intent("com.example.hello.MIDDLE");
					    	startActivity(ne);
				 
						}
					
					};
					th.start();
				}
	
	 protected void onPause()
	 {
		 super.onPause();
		 finish();
	 
	 }

}

