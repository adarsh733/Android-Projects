package org.techno;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends Activity{
	 protected void onCreate(Bundle ref) {
			super.onCreate(ref);
			setContentView(R.layout.search);
			final EditText uid=(EditText)findViewById(R.id.userid2);
			Button submit=(Button)findViewById(R.id.searchbtn);
			//ListView data= getListView();//ListView widget
			
			submit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
				String user=uid.getText().toString();
				SQLiteDatabase sdb=openOrCreateDatabase("hamaradb.db", MODE_PRIVATE, null);
				Cursor result=sdb.rawQuery("select * from hamaritable where userid='"+user+"'", null);
				if(result.moveToNext())
				{
				
			//		ArrayList list=new ArrayList();
              //      list.add(result.getString(0)+" "+result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6)+" "+result.getString(7)+" "+result.getString(8));					
	              //	ArrayAdapter<String> allData =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
	            	//data.setAdapter(allData);
	            	Toast.makeText(SearchActivity.this, "Done", Toast.LENGTH_SHORT).show();
		             
				}
			 
				else
				{
					Toast.makeText(SearchActivity.this, "You Entered Wrong User Id", Toast.LENGTH_LONG).show();
					
				}
				
				}
			});
		}
}
