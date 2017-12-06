package com.example.hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.DropBoxManager.Entry;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;






public class MainActivity extends ActionBarActivity {

	
	final static private String APP_KEY = "nauz1o9fzoembkj";
	final static private String APP_SECRET = "j870lnh1sjovx46";
	final static private String ACCOUNT_PREFS_NAME = "prefs";
	final static private String ACCESS_KEY_NAME = "ACCESS_KEY";
	final static private String ACCESS_SECRET_NAME = "ACCESS_SECRET";
	private static final boolean USE_OAUTH1 = false;
	
	 private static final String appKey = "nauz1o9fzoembkj";
	 private static final String appSecret = "j870lnh1sjovx46";

	 private static final int REQUEST_LINK_TO_DBX = 0;
	 private DbxAccountManager mDbxAcctMgr;

	Button singlebutton;
	Button singlebutton1;
	Button singlebutton2;
	Button singlebutton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);
       
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), appKey, appSecret);
        singlebutton = (Button) findViewById(R.id.button1);
        singlebutton = (Button) findViewById(R.id.button1);
        singlebutton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				Thread th =new Thread()
				{
					public void run()
					{
					String pp="{";
					Intent ne = new Intent("com.example.hello.PAGE0");
					ne.putExtra("report","}");
					ne.putExtra("datagoing",pp);
					startActivity(ne);
			
					}
				
				};
				th.start();
			}
		});
        singlebutton3 = (Button) findViewById(R.id.button4);
       
         singlebutton1 = (Button) findViewById(R.id.button2);
        
        singlebutton1 = (Button) findViewById(R.id.button2);
        singlebutton1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				
				userinput();
				
			/*	Thread th =new Thread()
				{
					public void run()
					{
						
					Intent ne = new Intent("com.example.hello.LIST");
					startActivity(ne);
					
					}
				
				};
				th.start();*/
		}
    });
        
        
        
        singlebutton2 = (Button) findViewById(R.id.button3);
        
        singlebutton2 = (Button) findViewById(R.id.button3);
        singlebutton2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				
				userinput1();
				
			/*	Thread th =new Thread()
				{
					public void run()
					{
						
					Intent ne = new Intent("com.example.hello.LIST");
					startActivity(ne);
					
					}
				
				};
				th.start();*/
		}
    });
        
 singlebutton3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				//startlink();
				 onClickLinkToDropbox();
			
		}
    });
         
        
 }

    
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LINK_TO_DBX) {
            if (resultCode == Activity.RESULT_OK) {
              // startlink();
            } else {
               
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    
    
    
    
    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    
    public void userinput()
    {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);

    	alert.setTitle("Enter Your Doctor Id");
    	alert.setMessage("You Will be Seeing Only your Case Reportings");

    	// Set an EditText view to get user input 
    	final EditText input = new EditText(this);
    	alert.setView(input);

    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int whichButton) {
    	final String value = input.getText().toString();
    		
    	Thread th =new Thread()
		{
			public void run()
			{
				
			Intent ne = new Intent("com.example.hello.LIST2");
			
			ne.putExtra("name",value);
			startActivity(ne);
	
			}
		
		};
		th.start();
    	
    	 // Do something with value!
    	 }
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	 public void onClick(DialogInterface dialog, int whichButton) {
    	     // Canceled.
    	}
    	});

    	 alert.show();
    
    }
    public void userinput1()
    {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);

    	alert.setTitle("Enter Your Doctor Id");
    	alert.setMessage("You Will be Seeing Case Reportings");

    	// Set an EditText view to get user input 
    	final EditText input = new EditText(this);
    	alert.setView(input);

    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int whichButton) {
    	final String value = input.getText().toString();
    		
    	Thread th =new Thread()
		{
			public void run()
			{
				
			Intent ne = new Intent("com.example.hello.LIST");
			
			ne.putExtra("name",value);
			startActivity(ne);
	
			}
		
		};
		th.start();
    	
    	 // Do something with value!
    	 }
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	 public void onClick(DialogInterface dialog, int whichButton) {
    	     // Canceled.
    	}
    	});

    	 alert.show();
    
    }
    
    
    
    @Override
	protected void onResume() {
		super.onResume();
		if (mDbxAcctMgr.hasLinkedAccount()) {
		    showLinkedView();
		    startlink();		   
		} else {
			showUnlinkedView();
		}
	}

    private void showLinkedView() {
    	 singlebutton3.setVisibility(View.GONE);
    }

    private void showUnlinkedView() {
    	 singlebutton3.setVisibility(View.VISIBLE);
    }
    
    public void startlink()
    {
    	
    	File root = new File(Environment.getExternalStorageDirectory(), "Notes");
        if (!root.exists()) {
            root.mkdirs();
        }
    	
try {
			
	DbxFileSystem dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr.getLinkedAccount());
			File folder = new File(Environment.getExternalStorageDirectory(), "Notes/");
			 // System.out.println(folder);
			 // System.out.println(folder.listFiles());
			  File[] listOfFiles = folder.listFiles(); 
			  ArrayList<String> results = new ArrayList<String>();
			  for (int i = 0; i < listOfFiles.length; i++) 
			  {
				  if (listOfFiles[i].isFile() )
				  {
					  String files = listOfFiles[i].getName();
					  //System.out.println(files);
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
							//  System.out.println("error");
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
					 // System.out.println(lowerfiles);
					  for (int j = 0; j < lowerfiles.length; j++) 
					  {
						  String semf = lowerfiles[j].getName();
						  if (lowerfiles[j].isFile())
						  {
							  
							   //System.out.println(files);
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
							//  System.out.println
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
		
    	
    	
    	
    	
    }
    private void onClickLinkToDropbox() {
        mDbxAcctMgr.startLink((Activity)this, REQUEST_LINK_TO_DBX);
    }
    
    
    
    
    
    
    
    
    
    

}
