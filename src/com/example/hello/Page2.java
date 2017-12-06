package com.example.hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
@SuppressLint("NewApi") public class Page2 extends Activity {
	
	 private static int RESULT_LOAD_IMAGE = 1;
	 private static int RESULT_LOAD_IMAGE1 = 2;
	 String forimage1="";
	 String forimage2="";
	 ImageView img1;
	 ImageView img2;
	 
	 
	 String rightIop;
	 String imgpathright1;
	 String imgpathright2;
	 String rightppal;
	 String rightppas;
	 String rightrnfll;
	 String rightrnfls;
	 String decessionright;
	 String rightblocked;
	 
	 
	 
	 String leftIop;
	 String imgpathleft1;
	 String imgpathleft2;
	 String leftppal;
	 String leftppas;
	 String leftrnfll;
	 String leftrnfls;
	 String decession;
	 String leftblocked;
	 
	 String doctor;
	 String patient;
	 String age;
	 String gender;
	 String blocked;
	 String family;
	 
	 private static final String appKey = "nauz1o9fzoembkj";
	 private static final String appSecret = "j870lnh1sjovx46";

	 private static final int REQUEST_LINK_TO_DBX = 0;
	 private DbxAccountManager mDbxAcctMgr;
	 
	 
	 
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.page2);
		 
		 final String returndata=getIntent().getStringExtra("datagoing");
		 System.out.println(returndata);
		 final Boolean forret = returndata.contains("{");
		 if(forret==false)
		 {
			 setdata(returndata);
		 }
	
		 
		 
		 final String ww = getIntent().getStringExtra("way");
		 final Boolean ff = ww.contains("l");
		  doctor = getIntent().getStringExtra("doctor") ;
		  patient =getIntent().getStringExtra("patient") ;
		  age = getIntent().getStringExtra("age");
		  gender = getIntent().getStringExtra("gender");
		  blocked = getIntent().getStringExtra("blocked");
		  family = getIntent().getStringExtra("family");
		  
		  if(ff==true)
		  {
			      leftIop = getIntent().getStringExtra("leftIop") ;;
				  imgpathleft1 = getIntent().getStringExtra("imgpathleft1") ;;
				  imgpathleft2 = getIntent().getStringExtra("imgpathleft2") ;;
				  leftppal = getIntent().getStringExtra("leftppal") ;;
				  leftppas = getIntent().getStringExtra("leftppas") ;;
				  leftrnfll = getIntent().getStringExtra("leftrnfll") ;;
				  leftrnfls = getIntent().getStringExtra("leftrnfls") ;;
				  decession = getIntent().getStringExtra("decession") ;;
				  leftblocked= getIntent().getStringExtra("leftblocked") ;;
		  }

		 Button singlebutton = (Button) findViewById(R.id.buttonnextpage1);
	        singlebutton = (Button) findViewById(R.id.buttonnextpage2);
	        singlebutton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					Thread th =new Thread()
					{
						public void run()
						{
							if(ff==false)
							{
								String hh=getdata();
								Intent ne = new Intent("com.example.hello.PAGE1");
								ne.putExtra("way","r");
								//
								ne.putExtra("doctor",doctor);
								ne.putExtra("patient",patient);
								ne.putExtra("family",family);
								ne.putExtra("age",age);
								ne.putExtra("gender",gender);
								ne.putExtra("blocked",blocked);
								//
								ne.putExtra("rightIop",rightIop);
								ne.putExtra("imgpathright1",imgpathright1);
								ne.putExtra("imgpathright2",imgpathright2);
								ne.putExtra("rightppal",rightppal);
								ne.putExtra("rightppas",rightppas);
								ne.putExtra("rightrnfll",rightrnfll);
								ne.putExtra("rightrnfls",rightrnfls);
								ne.putExtra("decessionright",decessionright);
								ne.putExtra("rightblocked",rightblocked);
								ne.putExtra("datagoing",returndata);
								startActivity(ne);
							}
							else
							{
								String hh=getdata();
								String dd="";
								try {
									dd=generateNoteOnSD(doctor);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								//startlink();
								Intent ne = new Intent("com.example.hello.MIDDLE");
								//ne.putExtra("dat",dd);
							//	ne.putExtra("pathright1", imgpathright1);
							//	ne.putExtra("pathright2", imgpathright2);
							//	ne.putExtra("pathleft1", imgpathleft1);
							//	ne.putExtra("pathleft2", imgpathleft2);
							//	ne.putExtra("doctor",doctor );
							//	ne.putExtra("patient",patient);
							
								startActivity(ne);
							}
						}
					};
					th.start();
					
					
				}
			});
	        
	        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture2);
	        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View arg0) {

	            	Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,"Select Picture"), RESULT_LOAD_IMAGE);
                    
                   
                 
                
                 //   startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.select_picture)),GALLERY_INTENT_CALLED);
	    
	            }
	        });
	           
	        Button buttonLoadImage1 = (Button) findViewById(R.id.buttonLoadPicture21);
	        buttonLoadImage1.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View arg0) {	                        
	                        Intent intent = new Intent();
	                        intent.setType("image/*");
	                        intent.setAction(Intent.ACTION_GET_CONTENT);
	                        startActivityForResult(Intent.createChooser(intent,"Select Picture"), RESULT_LOAD_IMAGE1);  
	                        
	            }
	        });
	        img1 = (ImageView) findViewById(R.id.imgView2);
	        img1.setOnClickListener(new View.OnClickListener() {             
	            @Override
	            public void onClick(View arg0) {	                        
	            	Thread th =new Thread()
					{
						public void run()
						{
						Intent ne = new Intent("com.example.hello.ZOOMPAGE");
						ne.putExtra("imagepath",forimage1);
						startActivity(ne);
						}
					};
					if(forimage1!="")
					{
						th.start();
					}   
	                        
	            }
	        });
	        
	        
	        img2 = (ImageView) findViewById(R.id.imgView21);
	        img2.setOnClickListener(new View.OnClickListener() {             
	            @Override
	            public void onClick(View arg0) {	                        
	            	Thread th =new Thread()
					{
						public void run()
						{
						Intent ne = new Intent("com.example.hello.ZOOMPAGE");
						ne.putExtra("imagepath",forimage2);
						startActivity(ne);
						}
					};
					if(forimage2!="")
					{
						th.start();
					} 
	                        
	            }
	        });
	        
	 }
	
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	         
	        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
	            Uri selectedImage = data.getData();
	            ImageView imageView = (ImageView) findViewById(R.id.imgView2);
	            imageView.setImageURI(data.getData());
	            System.out.println(selectedImage.getPath());
	            String Path = selectedImage.getPath();
	            Boolean found = Path.contains(":");
	            if(found==false)
	            {
	            
	            
	            String result;
	            Cursor cursor = getContentResolver().query(selectedImage, null, null, null, null);
	            if (cursor == null) { // Source is Dropbox or other similar local file path
	                result = selectedImage.getPath();
	            } else { 
	                cursor.moveToFirst(); 
	                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA); 
	                result = cursor.getString(idx);
	                cursor.close();
	            }
	            forimage1=result;
	            System.out.println(result);
	            }
	            else
	            {
	            
	            
	            
	           String wholeID = DocumentsContract.getDocumentId(selectedImage);
	            System.out.println(wholeID);
	            String id = wholeID.split(":")[1];
	            String[] column = { MediaStore.Images.Media.DATA }; 
	            String sel = MediaStore.Images.Media._ID + "=?";
	            Cursor cursor = getContentResolver().
	                                      query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, 
	                                      column, sel, new String[]{ id }, null);
	            String filePath = "";

	            int columnIndex = cursor.getColumnIndex(column[0]);

	            if (cursor.moveToFirst()) {
	                filePath = cursor.getString(columnIndex);
	            }   
	            System.out.println(filePath);
	            File dir = new File(filePath);
	            String hh="file://"+dir.getAbsolutePath();
	            System.out.println(hh);
	            forimage1=dir.getAbsolutePath();
	            cursor.close();
	            }

	            
	    
	        }
	        
	        
	        if (requestCode == RESULT_LOAD_IMAGE1 && resultCode == RESULT_OK && null != data) {
	            Uri selectedImage = data.getData();
	            ImageView imageView = (ImageView) findViewById(R.id.imgView21);
	            imageView.setImageURI(data.getData());

	            System.out.println(selectedImage.getPath());
	            String Path = selectedImage.getPath();
	            Boolean found = Path.contains(":");
	            if(found==false)
	            {
	            
	            
	            String result;
	            Cursor cursor = getContentResolver().query(selectedImage, null, null, null, null);
	            if (cursor == null) { // Source is Dropbox or other similar local file path
	                result = selectedImage.getPath();
	            } else { 
	                cursor.moveToFirst(); 
	                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA); 
	                result = cursor.getString(idx);
	                cursor.close();
	            }
	            forimage2=result;
	            System.out.println(result);
	            }
	            else
	            {
	            
	            
	            
	           String wholeID = DocumentsContract.getDocumentId(selectedImage);
	            System.out.println(wholeID);
	            String id = wholeID.split(":")[1];
	            String[] column = { MediaStore.Images.Media.DATA }; 
	            String sel = MediaStore.Images.Media._ID + "=?";
	            Cursor cursor = getContentResolver().
	                                      query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, 
	                                      column, sel, new String[]{ id }, null);
	            String filePath = "";

	            int columnIndex = cursor.getColumnIndex(column[0]);

	            if (cursor.moveToFirst()) {
	                filePath = cursor.getString(columnIndex);
	            }   
	            System.out.println(filePath);
	            File dir = new File(filePath);
	            String hh="file://"+dir.getAbsolutePath();
	            System.out.println(hh);
	            forimage2=dir.getAbsolutePath();
	            cursor.close();
	            }

	            
	        }
	        
	    }
	 
	 public String getdata()
	 	{
	 		EditText leftip = (EditText)findViewById(R.id.editText1);
	 		EditText leftcomments = (EditText)findViewById(R.id.editText2);
			rightIop = leftip.getText().toString() +"`"+leftcomments.getText().toString()+"~";
		//	rightIop = leftip.getText().toString();
			
			imgpathright1= forimage1;
			imgpathright2= forimage2;

			RadioGroup ppal=(RadioGroup)findViewById(R.id.radioPPA);
			RadioButton radioppal = (RadioButton)ppal.findViewById(ppal.getCheckedRadioButtonId()); 
			rightppal = radioppal.getText().toString();
			
			RadioGroup ppas=(RadioGroup)findViewById(R.id.radioPPAS);
			RadioButton radioppas = (RadioButton)ppas.findViewById(ppas.getCheckedRadioButtonId()); 
			rightppas = radioppas.getText().toString();
			
			RadioGroup rnfll=(RadioGroup)findViewById(R.id.radioRNFL);
			RadioButton radiornfll = (RadioButton)rnfll.findViewById(rnfll.getCheckedRadioButtonId()); 
			rightrnfll = radiornfll.getText().toString();
			
			RadioGroup rnfls=(RadioGroup)findViewById(R.id.radioRNFLS);
			RadioButton radiornfls = (RadioButton)rnfls.findViewById(rnfls.getCheckedRadioButtonId()); 
			rightrnfls = radiornfls.getText().toString();
			
			RadioGroup gluc=(RadioGroup)findViewById(R.id.radioRIGHT);
			RadioButton radiogluc = (RadioButton)gluc.findViewById(gluc.getCheckedRadioButtonId()); 
			decessionright = radiogluc.getText().toString();
			CheckBox hamarege=(CheckBox) findViewById(R.id.checkBox1);
			if(hamarege.isChecked())
			{
				rightblocked="yes";
			}
			else
			{
				rightblocked="no";
			}
	 			
			return null;	 		
	 	}
	
	 
	 public void setdata(String dd)
	 	{
	 		String string = dd;
			String[] parts = string.split(";");
			System.out.println(dd);
			String[] temp;
	 		EditText leftip = (EditText)findViewById(R.id.editText1);
	 		System.out.println(leftip);
	 		temp=parts[15].split(":");
	 		EditText leftcomments = (EditText)findViewById(R.id.editText2);
	 		if(temp.length==1)
			{
				leftip.setText("");
				leftcomments.setText("");
			}
			else
			{
				temp=temp[1].split("`");
				if(temp.length==1)
				{
					leftip.setText("");
					leftcomments.setText("");
				}
				else
				{
				leftip.setText(temp[0]);
				leftcomments.setText( temp[1].substring(0, temp[1].length()-1));;
				}
			}
			RadioGroup ppal=(RadioGroup)findViewById(R.id.radioPPA);
			temp=parts[18].split(":");
			if(temp[1].contains("P"))
			{
				ppal.check(R.id.radioButton1);
			}
			else
			{
				ppal.check(R.id.radioButton2);
			}
			System.out.println(parts.length);
			
			RadioGroup ppas=(RadioGroup)findViewById(R.id.radioPPAS);
			temp=parts[19].split(":");
			if(temp[1].contains("P"))
			{
				ppas.check(R.id.radioButton3);
			}
			else
			{
				ppas.check(R.id.radioButton4);
			}
			
			
			
			
			RadioGroup rnfll=(RadioGroup)findViewById(R.id.radioRNFL);
			temp=parts[20].split(":");
			if(temp[1].contains("P"))
			{
				rnfll.check(R.id.radioButton5);
			}
			else
			{
				rnfll.check(R.id.radioButton6);
			}
			
			RadioGroup rnfls=(RadioGroup)findViewById(R.id.radioRNFLS);
			
			temp=parts[21].split(":");
			if(temp[1].contains("P"))
			{
				rnfls.check(R.id.radioButton7);
			}
			else
			{
				rnfls.check(R.id.radioButton8);
			}
			
			System.out.println("done");
			RadioGroup gluc=(RadioGroup)findViewById(R.id.radioRIGHT);
			temp=parts[22].split(":")
					;
			if(temp[1].contains("P"))
			{
				gluc.check(R.id.radioButton9);
			}
			else
			{
				gluc.check(R.id.radioButton10);
			}
			
			CheckBox hamarege=(CheckBox) findViewById(R.id.checkBox1);
			temp=parts[23].split(":");
			if(temp[1].contains("y"))
			{
				hamarege.setChecked(true);
			}
			else
			{
				hamarege.setChecked(false);
			}
				
			
			temp=parts[16].split(":");
			if(temp.length==1)
			{
				
			}
			else
			{
				File imgFile = new  File(temp[1]);
				if(imgFile.exists()){
					forimage1=temp[1];
				    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
				    ImageView myImage = (ImageView) findViewById(R.id.imgView2);
				    myImage.setImageBitmap(myBitmap);
				    System.out.println(temp[1]);
				}
				
			}
			
			
			temp=parts[17].split(":");
			if(temp.length==1)
			{
				
			}
			else
			{
				File imgFile = new  File(temp[1]);
				if(imgFile.exists()){
					forimage2=temp[1];
				    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
				    ImageView myImage = (ImageView) findViewById(R.id.imgView21);
				    myImage.setImageBitmap(myBitmap);
				}
				
			}
			
			
			
			
	 	}
	 	
	 	
	 
	 public String generateNoteOnSD(String sFileName ) throws IOException{
		     File root = new File(Environment.getExternalStorageDirectory(), "Notes");
		        if (!root.exists()) {
		            root.mkdirs();
		        }
		        boolean fgh=false;
		        root = new File(Environment.getExternalStorageDirectory(), "Notes/"+patient);
		        if (!root.exists()) {
		            root.mkdirs();
		            fgh=true;
		        }
		        
		        root = new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/Left");
		        if (!root.exists()) {
		            root.mkdirs();
		        }
		        
		        int i=0;
		        String ext="";
		        
		        // copying the Left images
		        
		         i = imgpathleft1.lastIndexOf('.');
				if (i >= 0) {
				    ext = imgpathleft1.substring(i+1);
				}
		        File leftpic1=new File(imgpathleft1);
		        if(leftpic1.exists())
		        {
		        	File desleftpic1=new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/Left/LeftPic1."+ext);
		        	if(!leftpic1.getAbsolutePath().equals(desleftpic1.getAbsolutePath()))
		        	{
		        		copyImageFiles(leftpic1,desleftpic1);
		        		imgpathleft1=desleftpic1.getAbsolutePath();
		        	}
		        }
		        else
		        {
		        	imgpathleft1="";
		        }
		        
		        i = imgpathleft2.lastIndexOf('.');
				if (i >= 0) {
				    ext = imgpathleft2.substring(i+1);
				}
				File leftpic2=new File(imgpathleft2);
				if(leftpic2.exists())
				{
					
					File desleftpic2=new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/Left/LeftPic2."+ext);
					if(!leftpic2.getAbsolutePath().equals(desleftpic2.getAbsolutePath()))
					{
						copyImageFiles(leftpic2,desleftpic2);
						imgpathleft2=desleftpic2.getAbsolutePath();
					}
				}
				 else
			        {
			        	imgpathleft2="";
			        }
		        
		        root = new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/Right");
		        if (!root.exists()) {
		            root.mkdirs();
		        }
		        
		        

		         i = imgpathright1.lastIndexOf('.');
				if (i >= 0) {
				    ext = imgpathright1.substring(i+1);
				}
		        File rightpic1=new File(imgpathright1);
		        if(rightpic1.exists())
		        {
		        	File desrightpic1=new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/Right/RightPic1."+ext);
		        	if(!rightpic1.getAbsolutePath().equals(desrightpic1.getAbsolutePath()))
		        	{
		        		copyImageFiles(rightpic1,desrightpic1);
		        		imgpathright1=desrightpic1.getAbsolutePath();
		        	}
		        }
		        else
		        {
		        	imgpathright1="";
		        }
		        
		        i = imgpathright2.lastIndexOf('.');
				if (i >= 0) {
				    ext = imgpathright2.substring(i+1);
				}
		        File rightpic2=new File(imgpathright2);
		        if(rightpic2.exists())
		        {
		        	File desrightpic2=new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/Right/RightPic2."+ext);
		        	if(!rightpic2.getAbsolutePath().equals(desrightpic2.getAbsolutePath()))
		        	{
		        		copyImageFiles(rightpic2,desrightpic2);
		        		imgpathright2=desrightpic2.getAbsolutePath();
		        	}
		        }
		        else
		        {
		        	imgpathright2="";
		        }
		        
		        root = new File(Environment.getExternalStorageDirectory(), "Notes/"+patient);
		        File data = new File(root,"data.txt");
		        File gpxfile = new File(root, sFileName+".txt");
		        FileWriter writer = new FileWriter(gpxfile);
		        FileWriter w1=new FileWriter(data);
		        final String sBody = "Doctor"+":"+doctor+";"+ "Patient"+":"+patient+";"+ "Family"+":"+family+";"+ "Age"+":"+age+";"+ "Hamerage"+":"+blocked+";"+ "Gender"+":"+gender+";";	 
		      //  String sLeft = "LeftIop : " + leftIop + ";" + "imgpathleft1 : " + imgpathleft1 + ";" + "imgpathleft2 : " + imgpathleft2 + ";" + "leftppal : "+leftppal  + ";"+ "leftppas : " + leftppas + ";" + "leftrnfll : "+ leftrnfll + ";" + "leftrnfls : " + leftrnfls + ";" + "decession : " + decession +";"+"" ;
		      //  String sRight = "rightIop : " + rightIop + ";" + "imgpathright1 : " + imgpathright1 + ";" + "imgpathright2 : " + imgpathright2 + ";" + "rightppal : "+rightppal  + ";"+ "rightppas : " + rightppas + ";" + "rightrnfll : "+ rightrnfll + ";" + "rightrnfls : " + rightrnfls + ";" + "decessionright : " + decessionright +";" ;	
		        final String sLeft = "LeftIop :" + leftIop + ";" + "imgpathleft1 :" + imgpathleft1 + ";" + "imgpathleft2 :" + imgpathleft2 + ";" + "leftppal :"+leftppal  + ";"+ "leftppas :" + leftppas + ";" + "leftrnfll :"+ leftrnfll + ";" + "leftrnfls :" + leftrnfls + ";" + "decession :" + decession +";"+ "leftblocked :"+leftblocked+";" ;
		        final String sRight = "rightIop :" + rightIop + ";" + "imgpathright1 :" + imgpathright1 + ";" + "imgpathright2 :" + imgpathright2 + ";" + "rightppal :"+rightppal  + ";"+ "rightppas :" + rightppas + ";" + "rightrnfll :"+ rightrnfll + ";" + "rightrnfls :" + rightrnfls + ";" + "decessionright :" + decessionright +";"+"rightblocked :"+rightblocked+";";	        		
		        writer.append(sBody+sLeft+sRight);
		        writer.flush();
		        writer.close();
		        
		        w1.append(sBody+sLeft+sRight);
		        w1.flush();
		        w1.close();
		        
		        //Toast.makeText(this, sBody, Toast.LENGTH_SHORT).show();
		        System.out.println(sBody);
		        System.out.println(sLeft); 
		       return sBody+sLeft+sRight;
		        
		   } 
	 
	 
	 public void copyImageFiles(File sourceFile, File destinationDir) throws IOException {

		    FileInputStream fis = new FileInputStream(sourceFile); 
		    FileOutputStream fos = new FileOutputStream(destinationDir);  
		    FileChannel srcChannel = fis.getChannel();  
		    FileChannel destChannel = fos.getChannel();  
		    srcChannel.transferTo(0, sourceFile.length(), destChannel); 
		    srcChannel.close();  
		    destChannel.close();  
		    fis.close();  
		    fos.close();      
		}
	 
	  public void startlink()
	    {
		   mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(), appKey, appSecret);
	try {
				
		DbxFileSystem dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr.getLinkedAccount());
				File folder = new File(Environment.getExternalStorageDirectory(), "Notes/");
				 // System.out.println(folder);
				 // System.out.println(folder.listFiles());
				  File[] listOfFiles = folder.listFiles(); 
				  ArrayList<String> results = new ArrayList<String>();
				  for (int i = 0; i < listOfFiles.length; i++) 
				  {
					  if (false )
					  {
						  String files = patient;
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
					  
					  if(true)
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
					  
					  break;
					  
				 }
				
				
			} catch (DbxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    	
	    	
	    	
	    }
	 
	 
	 
	 
	 
}
