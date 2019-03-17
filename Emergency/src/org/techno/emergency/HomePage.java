package org.techno.emergency;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class HomePage extends Activity {
 protected void onCreate(Bundle ref) {
	super.onCreate(ref);
	setContentView(R.layout.home);
	ImageView pol=(ImageView)findViewById(R.id.police);
	ImageView fire=(ImageView)findViewById(R.id.fire);
	ImageView amb=(ImageView)findViewById(R.id.ambulance);
	ImageView tp=(ImageView)findViewById(R.id.tp);
	ImageView corr=(ImageView)findViewById(R.id.corrup);
	ImageView asp=(ImageView)findViewById(R.id.aspatal);
	ImageView air=(ImageView)findViewById(R.id.air);
	ImageView train=(ImageView)findViewById(R.id.train);
	ImageView road=(ImageView)findViewById(R.id.road);
	ImageView tra=(ImageView)findViewById(R.id.traffic);
	ImageView dis=(ImageView)findViewById(R.id.disaster);
	ImageView wom=(ImageView)findViewById(R.id.women);
	ImageView airl=(ImageView)findViewById(R.id.airlines);

	pol.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:100"));
		     startActivity(intent);
		}
	});
	fire.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:101"));
		     startActivity(intent);
		}
	});
	amb.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:102"));
		     startActivity(intent);
		}
	});
	tp.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:103"));
		     startActivity(intent);
		}
	});
	corr.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:1031"));
		     startActivity(intent);
		}
	});
	asp.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:104"));
		     startActivity(intent);
		}
	});
	air.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:1071"));
		     startActivity(intent);
		}
	});
	train.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:1072"));
		     startActivity(intent);
		}
	});
	road.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:1073"));
		     startActivity(intent);
		}
	});
	tra.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:9753057542"));
		     startActivity(intent);
		}
	});
	dis.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:108"));
		     startActivity(intent);
		}
	});
	wom.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:1091"));
		     startActivity(intent);
		}
	});
	airl.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     Intent intent =new Intent(Intent.ACTION_CALL);
		     intent.setData(Uri.parse("tel:1407"));
		     startActivity(intent);
		}
	}); 
 }
}
