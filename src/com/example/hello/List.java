package com.example.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends ListActivity{

	String name="";
	String ref="";
	String classes[]={"cases"};
	int count=0;
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
		          if(!fol.exists())
		          {
		        	  results.add(files);
		          }
		     }
		  }
		  
		  File counttext=new File(Environment.getExternalStorageDirectory(), "Notes/"+name+".count");
			 if(!counttext.exists())
			 {
				 try {
					FileWriter writer = new FileWriter(counttext);
					count=0;
					writer.append("1");
			        writer.flush();
			        writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
			 else
			 {
				 FileReader inputFile;
				try {
					inputFile = new FileReader(counttext);
					BufferedReader bufferReader = new BufferedReader(inputFile);
					String line;
					line= bufferReader.readLine();
					
					count=Integer.parseInt(line);
					 if(count>=results.size())
					 {
						 count=0;
					 }
					  
					FileWriter writer = new FileWriter(counttext);
					writer.write(String.valueOf(count+1));
			        writer.flush();
			        writer.close();
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
			 
		
			 File toread = new File(Environment.getExternalStorageDirectory(), "Notes"+"/"+results.get((int)count)+"/"+"data.txt");
				System.out.println(toread);
				String path1=toread.getAbsolutePath();
				String data="";
				
				FileReader inputFile;
				try {
					inputFile = new FileReader(path1);
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
						
					Intent ne = new Intent("com.example.hello.IPAGE0");
					
					ne.putExtra("datagoing",pp);
					ne.putExtra("name", name);
					
					startActivity(ne);
			
					}
				
				};
				th.start();

				finish();
			
		  
		
		
		setListAdapter(new ArrayAdapter<String>(List.this,android.R.layout.simple_list_item_1,results));
		
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		
		File toread = new File(Environment.getExternalStorageDirectory(), "Notes"+"/"+results.get((int) id)+"/"+"data.txt");
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
				
			Intent ne = new Intent("com.example.hello.IPAGE0");
			
			ne.putExtra("datagoing",pp);
			ne.putExtra("name", name);
			
			startActivity(ne);
	
			}
		
		};
		th.start();

		
	}

	
	

}
