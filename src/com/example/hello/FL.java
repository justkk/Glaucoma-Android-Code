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

public class FL extends Activity{

	
	String send="";
	static final int REQUEST_LINK_TO_DBX = 0;
	private DbxAccountManager mDbxAcctMgr;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.finalpage);
        mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), "nauz1o9fzoembkj", "j870lnh1sjovx46");
        TextView view = (TextView) findViewById(R.id.textView1);
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
					
					java.util.List<DbxFileInfo> infos = dbxFs.listFolder(new DbxPath("Notes/"));
					for (DbxFileInfo info : infos ) {
						send+=info.path.getName()+",";
		               
		            }
					TextView view = (TextView) findViewById(R.id.textView1);
					view.setText(send);
					Thread th =new Thread()
					{
						public void run()
						{
							
						Intent ne = new Intent("com.example.hello.LIST");
						ne.putExtra("fold",send);
						startActivity(ne);
						
						}
					
					};
					th.start();
					
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
