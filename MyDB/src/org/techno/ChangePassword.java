package org.techno;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity {

	 protected void onCreate(Bundle ref) {
		super.onCreate(ref);
		setContentView(R.layout.changepassword);
		final EditText old=(EditText)findViewById(R.id.userid1);
		final EditText newp=(EditText)findViewById(R.id.newpass);
		Button submit=(Button)findViewById(R.id.changebtn);
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			String uid=old.getText().toString();
			String newPass=newp.getText().toString();
			SQLiteDatabase sdb=openOrCreateDatabase("hamaradb.db", MODE_PRIVATE, null);
			Cursor result=sdb.rawQuery("select * from hamaritable where userid='"+uid+"'", null);
			if(result.moveToNext())
			{
				SQLiteDatabase db=openOrCreateDatabase("hamaradb.db", MODE_PRIVATE, null);
				db.execSQL("update hamaritable set password='"+newPass+"' where userid='"+uid+"'")	;
				Toast.makeText(ChangePassword.this, "Password Changed SuccesFully", Toast.LENGTH_SHORT).show();
			    Intent intent =new Intent(ChangePassword.this,LoginActivity.class);
			    startActivity(intent);
			}
			else
			{
				Toast.makeText(ChangePassword.this, "You Entered Wrong User Id", Toast.LENGTH_LONG).show();
				
			}
			
			}
		});
	}
}
