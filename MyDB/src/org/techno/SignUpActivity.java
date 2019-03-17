package org.techno;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class SignUpActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle ref){
		super.onCreate(ref);
		setContentView(R.layout.signup);
		 
		
			final EditText uId=(EditText)findViewById(R.id.uid);
			final EditText pas=(EditText)findViewById(R.id.pass);
			final EditText username=(EditText)findViewById(R.id.uname);
			final EditText contactInfo=(EditText)findViewById(R.id.contact);
			final EditText addressInfo=(EditText)findViewById(R.id.address);
			final Spinner cityInfo= (Spinner)findViewById(R.id.city);
			final DatePicker doba=(DatePicker)findViewById(R.id.dob);
			
			final RadioGroup genderInfo=(RadioGroup)findViewById(R.id.rg);
			final RadioButton maleInfo=(RadioButton)findViewById(R.id.male);
			final RadioButton femaleInfo=(RadioButton)findViewById(R.id.female);
			
			final CheckBox swimInfo=(CheckBox)findViewById(R.id.swim);
			final CheckBox sportsInfo=(CheckBox)findViewById(R.id.sports);
			final CheckBox gymInfo=(CheckBox)findViewById(R.id.gym);
			
			Button Submit=(Button)findViewById(R.id.submit);
			Button Reset=(Button)findViewById(R.id.reset);
			String cities[]={"Indore","Bhopal","Jabalpur","Delhi","Gwalior","Jodhpur"};
			ArrayAdapter<String> adapter=new
      			ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cities);
		cityInfo.setAdapter(adapter);
		Submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String uid1=uId.getText().toString();
				String pass1=pas.getText().toString();
				String uname1=username.getText().toString();
				String contact1=contactInfo.getText().toString();
				String address1=addressInfo.getText().toString();
				String city1=cityInfo.getSelectedItem().toString();
				String dob1=doba.getDayOfMonth()+" "+doba.getMonth()+" "+doba.getYear();
				String gender1="";
				if(genderInfo.getCheckedRadioButtonId()==R.id.female)
					 gender1="female";
				if(genderInfo.getCheckedRadioButtonId()==R.id.male)
					 gender1="male";
				String extra1="";
				if(swimInfo.isSelected())
                   extra1="swimming";
				if(sportsInfo.isSelected())
	                   extra1="Sports";
				if(gymInfo.isSelected())
	                   extra1="Gym";					
                 
				SQLiteDatabase sdb=openOrCreateDatabase("hamaradb.db",MODE_PRIVATE , null);
				//db.execSQL("create table usertableinfo(userid varchar2(12) primary key,username varchar2(20) ,password varchar2(20),contact varchar2(20),address varchar2(20),city varchar2(20),dob varchar2(20),gender varchar2(20),extra varchar2(20))");
			sdb.execSQL("insert into hamaritable values('"+uid1+"','"+uname1+"','"+pass1+"','"+contact1+"','"+address1+"','"+city1+"','"+dob1+"','"+gender1+"','"+extra1+"')");
			sdb.close();
			Toast.makeText(SignUpActivity.this,"Done", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
			startActivity(intent);
			
			}
		});
	}

}
