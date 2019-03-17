package org.techno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MenuActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menufile);
		
		Button show=(Button)findViewById(R.id.showall);
		Button log=(Button)findViewById(R.id.logout);
		show.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) 
			{
				Intent intent=new Intent(MenuActivity.this,ShowAllRecordsActivity.class);
				startActivity(intent);
				
			}
		});

	}
}
