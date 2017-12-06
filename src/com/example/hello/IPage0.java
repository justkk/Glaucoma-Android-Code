package com.example.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;





public class IPage0 extends Activity {
	
	Button leftbutton;
	Button rightbutton;
	
	String doctor;
	String patient;
	String age;
	String gender;
	String blocked;
	String family;
	final Context context = this;
	int count=0;
	
	
	@SuppressLint("NewApi") protected void onCreate(Bundle savedInstanceState) {
		 
		 
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.testingnew2);
		 
		 final String returndata=getIntent().getStringExtra("datagoing");
		 doctor=getIntent().getStringExtra("name");
		 String report="";
		 
		
		 
		 
		 System.out.println(returndata);
		 final Boolean ff = returndata.contains("{");
		 if(ff==false)
		 {
			 setdata(returndata);
			 EditText editdoctor = (EditText)findViewById(R.id.editText1);
				editdoctor.setEnabled(false);
				EditText editpatient = (EditText)findViewById(R.id.editText2);
				editpatient.setEnabled(false); 
		 }
		 
		 
		 
		 
		 System.out.println(returndata);
		 
		 

		  leftbutton = (Button) findViewById(R.id.buttoneyeleft);
	      leftbutton.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					
					String tt=getdata();
					check(returndata);
					
					
				}

			
			});
	      
	      rightbutton = (Button) findViewById(R.id.buttoneyeright);
	      rightbutton.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					
					Thread th =new Thread()
					{
						public void run()
						{
							String data = getdata();	
						Intent ne = new Intent("com.example.hello.MIDDLE");
						/*ne.putExtra("way","r");
						ne.putExtra("doctor",doctor);
						ne.putExtra("patient",patient);
						ne.putExtra("family",family);
						ne.putExtra("age",age);
						ne.putExtra("gender",gender);
						ne.putExtra("blocked",blocked);
						ne.putExtra("datagoing",returndata);*/
						
						startActivity(ne);
				
						}
					
					};
					th.start();
				}
			});
		
		}
		public void setdata(String dd)
		{	String string = dd;
			String[] parts = string.split(";");
			String[] temp;
			EditText editdoctor = (EditText)findViewById(R.id.editText1);
			temp=parts[0].split(":");
			editdoctor.setText(doctor);
			if(temp.length==1)
			{
				//editdoctor.setText("");
			}
			else
			{
				//editdoctor.setText(temp[1]);
			}
			
			EditText editpatient = (EditText)findViewById(R.id.editText2);
			
			temp=parts[1].split(":");
			
			
			if(temp.length==1)
			{
				editpatient.setText("");
			}
			else
			{
				editpatient.setText(temp[1]);
			}
			
			EditText editage = (EditText)findViewById(R.id.editText3);
			
			temp=parts[3].split(":");
			
			if(temp.length==1)
			{
				editage.setText("");
			}
			else
			{
				editage.setText(temp[1]);
			}
			
			
			
			//editage.setText(temp);
			
			CheckBox familyhistory=(CheckBox) findViewById(R.id.checkBox1);
			temp=parts[2].split(":");
			if(temp[1].contains("y"))
			{
				familyhistory.setChecked(true);
			}
			else
			{
				familyhistory.setChecked(false);
			}
		//	editdoctor.setText(temp);
			
			CheckBox hamarege=(CheckBox) findViewById(R.id.checkBox2);
			temp=parts[4].split(":");
			if(temp[1].contains("y"))
			{
				hamarege.setChecked(true);
			}
			else
			{
				hamarege.setChecked(false);
			}
			RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
			RadioButton radiovalue = (RadioButton)rg.findViewById(rg.getCheckedRadioButtonId()); 
			temp=parts[5].split(":");
			if(temp[1].contains("M"))
			{
				
				rg.check(R.id.radioButton1);
			}
			else
			{
				rg.check(R.id.radioButton2);
			}
			System.out.println(temp);
			
		}
		public String getdata()
		{
			EditText editdoctor = (EditText)findViewById(R.id.editText1);
			doctor = editdoctor.getText().toString();
			EditText editpatient = (EditText)findViewById(R.id.editText2);
			patient = editpatient.getText().toString();
			EditText editage = (EditText)findViewById(R.id.editText3);
			age = editage.getText().toString();
			CheckBox familyhistory=(CheckBox) findViewById(R.id.checkBox1);
			if(familyhistory.isChecked())
			{
				family="yes";
			}
			else
			{
				family="no";
			}
			
			CheckBox hamarege=(CheckBox) findViewById(R.id.checkBox2);
			if(hamarege.isChecked())
			{
				blocked="yes";
			}
			else
			{
				blocked="no";
			}
			
			RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
			RadioButton radiovalue = (RadioButton)rg.findViewById(rg.getCheckedRadioButtonId()); 
			gender = radiovalue.getText().toString();
			
			
			return null;
		
		}
		public void check(final String returndata) {
			
			
			 File root = new File(Environment.getExternalStorageDirectory(), "Notes/"+patient+"/"+doctor+".txt");
		        if (root.exists()) {
		           
		        	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
		    				context);
		     
		    			// set title
		    			alertDialogBuilder.setTitle("Alert Patient Case already filed");
		     
		    			// set dialog message
		    			alertDialogBuilder
		    				.setMessage("Over Ride the existing Data Case!")
		    				.setCancelable(false)
		    				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
		    					public void onClick(DialogInterface dialog,int id) {
		    					
		    						
		    						Thread th =new Thread()
		    						{
		    							public void run()
		    							{
		    								String data = getdata();	
		    							Intent ne = new Intent("com.example.hello.IPAGE1");
		    							ne.putExtra("way","l");
		    							
		    							ne.putExtra("doctor",doctor);
		    							ne.putExtra("patient",patient);
		    							ne.putExtra("family",family);
		    							ne.putExtra("age",age);
		    							ne.putExtra("gender",gender);
		    							ne.putExtra("blocked",blocked);
		    							ne.putExtra("datagoing",returndata);
		    							startActivity(ne);
		    							}
		    						
		    						};
		    						th.start();
		    						
		    						
		    						
		    					}
		    				  })
		    				.setNegativeButton("No",new DialogInterface.OnClickListener() {
		    					public void onClick(DialogInterface dialog,int id) {
		    						
		    						dialog.cancel();
		    						
		    						
		    					}
		    				});
		     
		    				
		    				AlertDialog alertDialog = alertDialogBuilder.create();
		    				alertDialog.show();
		        	
		        }
		        else
		        {
		        	
		        	Thread th =new Thread()
					{
						public void run()
						{
						
						String data = getdata();	
						Intent ne = new Intent("com.example.hello.IPAGE1");
						ne.putExtra("way","l");
						
						ne.putExtra("doctor",doctor);
						ne.putExtra("patient",patient);
						ne.putExtra("family",family);
						ne.putExtra("age",age);
						ne.putExtra("gender",gender);
						ne.putExtra("blocked",blocked);
						ne.putExtra("datagoing",returndata);
						startActivity(ne);
						}
					};
					th.start();
		        	
		        }
			
		}
	
}
