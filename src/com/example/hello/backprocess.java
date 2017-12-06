package com.example.hello;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxException.Unauthorized;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class backprocess extends AsyncTask< DbxAccountManager , Integer, Long> {
	 private static final String appKey = "nauz1o9fzoembkj";
	 private static final String appSecret = "j870lnh1sjovx46";
	 private DbxAccountManager mDbxAcctMgr;
	

	protected Long doInBackground( DbxAccountManager ds) {
		
    	 mDbxAcctMgr = ds;
    	 System.out.println("ok");
    	 return null;
    	/* try {
 			
    			DbxFileSystem dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr.getLinkedAccount());
    					File folder = new File(Environment.getExternalStorageDirectory(), "Notes/");
    					  System.out.println(folder);
    					  System.out.println(folder.listFiles());
    					  File[] listOfFiles = folder.listFiles(); 
    					  ArrayList<String> results = new ArrayList<String>();
    					  for (int i = 0; i < listOfFiles.length; i++) 
    					  {
    						  if (listOfFiles[i].isFile() )
    						  {
    							  String files = listOfFiles[i].getName();
    							  System.out.println(files);
    							  DbxPath testPath = new DbxPath("Notes/"+files);
    					   //
    							  if(dbxFs.exists(testPath)){
    						   
    								  DbxFile testFile = dbxFs.open(testPath);
    								  File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files);
    								  if(fol.hashCode()==testFile.hashCode())
    								  {
    							   
    								  }
    								  else
    								  {
    									  
    									  testFile.writeFromExistingFile(fol,false);
    									  System.out.println("error");
    								  }
    								  testFile.close();
    					   
    							  }
    					   else
    					   {
    						   DbxFile testFile = dbxFs.create(testPath);
    						   File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files);
    						   testFile.writeFromExistingFile(fol,false);
    						   testFile.close();
    					   }
    						 }
    						  
    						  else if(listOfFiles[i].isDirectory())
    						  {
    							  String files = listOfFiles[i].getName();
    							  File koop = new File(Environment.getExternalStorageDirectory(), "Notes/"+files);
    							  File[] lowerfiles = koop.listFiles();
    							  System.out.println(lowerfiles);
    							  for (int j = 0; j < lowerfiles.length; j++) 
    							  {
    								  String semf = lowerfiles[j].getName();
    								  if (lowerfiles[j].isFile())
    								  {
    									  
    									   System.out.println(files);
    									   DbxPath testPath = new DbxPath("Notes/"+files+"/"+semf);
    									   //
    									   if(dbxFs.exists(testPath)){
    										   
    										   DbxFile testFile = dbxFs.open(testPath);
    										   File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files+"/"+semf);
    										   if(fol.hashCode()==testFile.hashCode())
    										   {
    											   
    										   }
    										   else
    										   {
    											   testFile.writeFromExistingFile(fol,false);
    										   }
    										   testFile.close();
    									   
    									  }
    									   else
    									   {
    										   DbxFile testFile = dbxFs.create(testPath);
    										   File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files+"/"+semf);
    										   testFile.writeFromExistingFile(fol,false);
    										   testFile.close();
    									   }
    								  }
    								  else if(lowerfiles[j].isDirectory())
    								  {
    									  
    									  File lefts = new File(Environment.getExternalStorageDirectory(), "Notes/"+files+"/"+semf);
    									  File[] leftfiles = lefts.listFiles();
    									  
    									  for (int mm = 0; mm < leftfiles.length; mm++) 
    									  {
    										  if (leftfiles[mm].isFile())
    										  {
    											 
    											  String leftpic = leftfiles[mm].getName();
    											   
    											   DbxPath testPath = new DbxPath("Notes/"+files+"/"+semf+"/"+leftpic);
    											   //
    											   if(dbxFs.exists(testPath)){
    												   
    												   DbxFile testFile = dbxFs.open(testPath);
    												   File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files+"/"+semf+"/"+leftpic);
    												   if(fol.hashCode()==testFile.hashCode())
    												   {
    													   
    												   }
    												   else
    												   {
    													   testFile.writeFromExistingFile(fol,false);
    												   }
    												   testFile.close();
    											   
    											  }
    											   else
    											   {
    												   DbxFile testFile = dbxFs.create(testPath);
    												   File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files+"/"+semf+"/"+leftpic);
    												   testFile.writeFromExistingFile(fol,false);
    												   testFile.close();
    											   }
    											  
    											  
    										  }
    										  
    									  }
    									  
    									  
    									  
    									  
    								  }
    							  }
    						  
    							  
    							  
    						  }
    						  
    						  
    						  
    					 }
    					
    					
    				} catch (DbxException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    		    	
    		    	*/
    	
    	
    	
    	
    	
//    	/return null;
        
        }
       
    

    protected void onProgressUpdate(Integer... progress) {
       // setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        //showDialog("Downloaded " + result + " bytes");
    }









	@Override
	protected Long doInBackground(DbxAccountManager... params) {
		// TODO Auto-generated method stub
		return null;
	}
}
