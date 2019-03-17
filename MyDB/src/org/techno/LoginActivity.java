package org.techno;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity{
	@Override
	protected void onCreate(Bundle ref1)
	{
         	super.onCreate(ref1);	
		setContentView(R.layout.login);
	
    final EditText uid=(EditText)findViewById(R.id.uid);
	final EditText pass=(EditText)findViewById(R.id.pass);
	 	Button btn1=(Button)findViewById(R.id.button1);
	 	Button signUpButton=(Button)findViewById(R.id.signupfor);
	 	
	 	
	 	final ImageView image=(ImageView)findViewById(R.id.clickimage);
	 	final EditText contact=(EditText)findViewById(R.id.number);
	 	Button btn=(Button)findViewById(R.id.callbtn);
		Button openCamera=(Button)findViewById(R.id.camera);
		Button openVideo=(Button)findViewById(R.id.video);
		Button openAudio=(Button)findViewById(R.id.audio);
		Button openEmail=(Button)findViewById(R.id.email);
		Button SMS=(Button)findViewById(R.id.sms);
		Button next=(Button)findViewById(R.id.nextpage);
		final WebView view=(WebView)findViewById(R.id.webview);
		//view.loadUrl("http://www.google.co.in/");
		
		view.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	//		   view.setData(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.co.in/")));	
               Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.co.in/"));		
			}
		});
		
	
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(LoginActivity.this,Questions.class);
				startActivity(intent);
					
			}
		});
	
		openCamera.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivity(intent);
					
			}
		});

		openVideo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
				startActivity(intent);
					
			}
		});
		openAudio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
				startActivity(intent);
					
			}
		});
		openEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_SEND);
				startActivity(intent);
					
			}
		});

		SMS.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_NEW_OUTGOING_CALL);
				startActivity(intent);
					
			}
		});

		 	image.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
				     Intent intent =new Intent(Intent.ACTION_CALL);
				     intent.setData(Uri.parse("tel:9753057542"));
				     startActivity(intent);
				}
			});
	 	
	btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
	
					
					Intent intent =new Intent(Intent.ACTION_CALL);
				     intent.setData(Uri.parse("tel:"+contact.getText().toString()));
				     startActivity(intent);
				}
			});
	 	
	 	
	btn1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String userId=uid.getText().toString();
			String passwd=pass.getText().toString();
			SQLiteDatabase db=openOrCreateDatabase("hamaradb.db",MODE_PRIVATE ,null);
			Cursor result=db.rawQuery("select * from hamaritable where userid='"+userId+"' and password='"+passwd+"'", null);
			
			if(result.moveToNext())
			{
				Intent intent= new Intent(LoginActivity.this,MenuActivity.class);
				startActivity(intent);
			}
			else
			{
	
				Toast t=Toast.makeText(LoginActivity.this,"invalid id/pass",Toast.LENGTH_SHORT);
				t.show();
			}
			
	}
	});
   signUpButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	    Intent intent =new Intent(LoginActivity.this,SignUpActivity.class);
	    startActivity(intent);
	}
});
 	
	
	}
	public boolean onCreateOptionsMenu(Menu menu)
	 {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.inflate,menu);
		 return super.onCreateOptionsMenu(menu);
	 }
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
		case R.id.changepassword:
			 Intent intent=new Intent(LoginActivity.this,ChangePassword.class);
			 startActivity(intent);
			break;
		case R.id.aboutus:
			Toast.makeText(LoginActivity.this, "Call Me at 9479918338 or email at adi2011n@gmail.com", Toast.LENGTH_LONG).show(); 
			break;
		case R.id.delete:
			 Intent intent1=new Intent(LoginActivity.this,DeleteActivity.class);
			 startActivity(intent1);
			 break;
		case R.id.search:
			 Intent intent2=new Intent(LoginActivity.this,SearchActivity.class);
			 startActivity(intent2);
			break;

		default:
			 return super.onOptionsItemSelected(item);
		}
		

		return true;
		
		
	}

	}
