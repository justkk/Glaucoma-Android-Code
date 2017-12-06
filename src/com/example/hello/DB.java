package com.example.hello;

import java.io.File;
import java.io.IOException;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxException.Unauthorized;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileInfo;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;
import com.dropbox.sync.android.DbxPath.InvalidPathException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DB extends Activity{
	String dat;
	
	String doctor="";
	String patient="";
	String imagefolder="";
	String picpath1="";
	
	String picrightpath1="";
	String picrightpath2="";
	String picleftpath1="";
	String picleftpath2="";
	
	
	
	
	static final int REQUEST_LINK_TO_DBX = 0;
	private DbxAccountManager mDbxAcctMgr;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.finalpage);
        mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), "nauz1o9fzoembkj", "j870lnh1sjovx46");
        dat=getIntent().getStringExtra("dat");
        picpath1=getIntent().getStringExtra("pathright1");
        
        
        picrightpath1=getIntent().getStringExtra("pathright1");
        picrightpath2=getIntent().getStringExtra("pathright2");
        picleftpath1=getIntent().getStringExtra("pathleft1");
        picleftpath2=getIntent().getStringExtra("pathleft2");
        doctor=getIntent().getStringExtra("doctor");
        patient=getIntent().getStringExtra("patient");
        TextView view = (TextView) findViewById(R.id.textView1);
        view.setText(dat);
        if(!mDbxAcctMgr.hasLinkedAccount())
        {
        	mDbxAcctMgr.startLink((Activity)this, REQUEST_LINK_TO_DBX);
        }
        
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_LINK_TO_DBX) {
	        if (resultCode == Activity.RESULT_OK) {
	           
	        	try {
					DbxFileSystem dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr.getLinkedAccount());
					DbxFile testFile = dbxFs.create(new DbxPath("Notes/"+doctor+"/"+patient+"/"+"data.txt"));
					testFile.writeString(dat);
					TextView view = (TextView) findViewById(R.id.textView1);
					view.setText("fine first");
					
					java.util.List<DbxFileInfo> infos = dbxFs.listFolder(new DbxPath("Notes/"));
					for (DbxFileInfo info : infos ) {
		                view.append("    " + info.path + ", " + info.modifiedTime + '\n');
		            }
					
					
					String extension = "";
					int i = picrightpath1.lastIndexOf('.');
					if (i >= 0) {
					    extension = picrightpath1.substring(i+1);
					}
						File pp = new File(picrightpath1);
					if(picrightpath1.length()!=0 && pp.exists())
					{
						DbxFile picFile1 = dbxFs.create(new DbxPath("Notes/"+doctor+"/"+patient+"/"+"Right/rightpic1."+extension));
						picFile1.writeFromExistingFile(pp, false);
					}
					
					
					i = picrightpath2.lastIndexOf('.');
					if (i >= 0) {
					    extension = picrightpath2.substring(i+1);
					}
					
					File pp1 = new File(picrightpath2);
					if(picrightpath2.length()!=0 &&pp1.exists())
					{
						DbxFile picFile2 = dbxFs.create(new DbxPath("Notes/"+doctor+"/"+patient+"/"+"Right/rightpic2."+extension));
						picFile2.writeFromExistingFile(pp1, false);
					}
					
					
					i = picleftpath1.lastIndexOf('.');
					if (i >= 0) {
					    extension = picleftpath1.substring(i+1);
					}
					
					File pp3 = new File(picleftpath1);
					if(picleftpath1.length()!=0 &&pp3.exists())
					{
						DbxFile picFile3 = dbxFs.create(new DbxPath("Notes/"+doctor+"/"+patient+"/"+"Left/leftpic1."+extension));
						picFile3.writeFromExistingFile(pp3, false);
					}
					
					i = picleftpath2.lastIndexOf('.');
					if (i >= 0) {
					    extension = picleftpath2.substring(i+1);
					}
					
					File pp4 = new File(picleftpath2);
					if(picleftpath2.length()!=0 && pp4.exists())
					{
						DbxFile picFile4 = dbxFs.create(new DbxPath("Notes/"+doctor+"/"+patient+"/"+"Left/leftpic2."+extension));
						picFile4.writeFromExistingFile(pp4, false);
					}
					
					
				//	view.setText("ok done");
					
				} catch (Unauthorized e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidPathException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DbxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	
	        } else {
	            // ... Link failed or was cancelled by the user.
	        }
	    } else {
	        super.onActivityResult(requestCode, resultCode, data);
	    }
	}
	
	
	
	
	
	

}
