package com.example.hello;

import java.io.IOException;
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
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class RSSPullService extends IntentService {
   
	private static final String appKey = "nauz1o9fzoembkj";
    private static final String appSecret = "j870lnh1sjovx46";
    
    private static final int REQUEST_LINK_TO_DBX = 0;
    DbxFileSystem dbxFs;
   
    private DbxAccountManager mDbxAcctMgr;
	public RSSPullService( ) {
		super("aa");
		
	}
	public RSSPullService(DbxFileSystem d) {
		super("aa");
		dbxFs=d;
	}
	@Override
    protected void onHandleIntent(Intent workIntent) {
		mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), appKey, appSecret);
		 
		// MyObject obj = (MyObject) workIntent.getSerializableExtra("object");
		 //DbxFileSystem dbxFs=obj.dbxFs;
		try {
			
			dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr.getLinkedAccount());
		
		//DbxFileSystem myObject = (DbxFileSystem) workIntent.getExtras().getSerializable("myobject");
		final String TEST_DATA = "Hello Dropbox";
        final String TEST_FILE_NAME = "comeon.txt";
        DbxPath testPath = new DbxPath(DbxPath.ROOT, TEST_FILE_NAME);
        
        DbxFile testFile = dbxFs.create(testPath);
		try {
            testFile.writeString("Hello Dropbox!");
        } finally {
            testFile.close();
        }
        
			
			
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
	
	@SuppressLint("NewApi") public void onTaskRemoved(Intent rootIntent) {
	    Log.e("FLAGX : ", ServiceInfo.FLAG_STOP_WITH_TASK + "");
	    Intent restartServiceIntent = new Intent(getApplicationContext(),
	            this.getClass());
	    restartServiceIntent.setPackage(getPackageName());

	    PendingIntent restartServicePendingIntent = PendingIntent.getService(
	            getApplicationContext(), 1, restartServiceIntent,
	            PendingIntent.FLAG_ONE_SHOT);
	    AlarmManager alarmService = (AlarmManager) getApplicationContext()
	            .getSystemService(Context.ALARM_SERVICE);
	    alarmService.set(AlarmManager.ELAPSED_REALTIME,
	            SystemClock.elapsedRealtime() + 10,
	            restartServicePendingIntent);

	    super.onTaskRemoved(rootIntent);
	}
	
	
	
	
	
	
	
	
}