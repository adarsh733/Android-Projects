package org.techno;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;

public class FlashActivity extends Activity 
{
	MediaPlayer md;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.flash);
	md=MediaPlayer.create(this, R.raw.kiki);
	md.start();
	
TimerTask tt=new TimerTask() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(FlashActivity.this,LoginActivity.class);
		startActivity(intent);
		
	}
	
};
Timer timer=new Timer();
timer.schedule(tt,2000);
	SQLiteDatabase db=openOrCreateDatabase("hamaradb.db",MODE_PRIVATE ,null);
	File path=getApplicationContext().getDatabasePath("hamaradb.db");
	if(!path.exists())
	{
		db.execSQL("create table hamaritable(userid varchar2(12) primary key,username varchar2(20) ,password varchar2(20),contact varchar2(20),address varchar2(200),city varchar2(20),dob varchar2(20),gender varchar2(20),extra varchar2(20))");
		db.close();
		
	}
	//db.execSQL("create table hamaritable(userid varchar2(12) primary key,username varchar2(20) ,password varchar2(20),contact varchar2(20),address varchar2(200),city varchar2(20),dob varchar2(20),gender varchar2(20),extra varchar2(20))");
//	ImageView img=(ImageView)findViewById(R.id.imageView);
//	img.setOnLongClickListener(new OnLongClickListener() {
//		
//		@Override
//		public boolean onLongClick(View arg0) {
//			// TODO Auto-generated method stub
//			Intent intent=new Intent(FlashActivity.this,LoginActivity.class);
//			startActivity(intent);
//			return false;
//			
//		}
//	});
}
	@Override
	protected void onStop(){
		
		super.onStop();
		md.stop();
		
		
	}
}