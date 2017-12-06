package com.example.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List2 extends ListActivity{

	String name="";
	String classes[]={"cases"};
	ArrayList<String> results;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		String path = "./"; 
		 
		  String files;
		  name=getIntent().getStringExtra("name");
		 // File folder = new File(path);
		  File folder = new File(Environment.getExternalStorageDirectory(), "Notes/");
		  System.out.println(folder);
		  System.out.println(folder.listFiles());
		  File[] listOfFiles = folder.listFiles(); 
		  results = new ArrayList<String>();
		  for (int i = 0; i < listOfFiles.length; i++) 
		  {
		 
		   if (listOfFiles[i].isDirectory()) 
		   {
		   files = listOfFiles[i].getName();
		   System.out.println(files);
		          System.out.println(files);
		          File fol = new File(Environment.getExternalStorageDirectory(), "Notes/"+files+"/"+name+".txt");
		          if(fol.exists())
		          {
		        	  results.add(files);
		          }
		     }
		  }
		
		
		
		setListAdapter(new ArrayAdapter<String>(List2.this,android.R.layout.simple_list_item_1,results));
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		File toread = new File(Environment.getExternalStorageDirectory(), "Notes"+"/"+results.get((int) id)+"/"+name+".txt");
		System.out.println(toread);
		String path=toread.getAbsolutePath();
		String data="";
		
		FileReader inputFile;
		try {
			inputFile = new FileReader(path);
			 BufferedReader bufferReader = new BufferedReader(inputFile);
			 String line;
			 data+= bufferReader.readLine(); 
			 System.out.println(data);
			 bufferReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
		System.out.println(data);
		final String pp=data;
		Thread th =new Thread()
		{
			public void run()
			{
				
			Intent ne = new Intent("com.example.hello.PAGE0");
			
			ne.putExtra("datagoing",pp);
			ne.putExtra("report","}");
			startActivity(ne);
	
			}
		
		};
		th.start();

		
	}

	
	

}
