package org.techno;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowAllRecordsActivity extends ListActivity {

	protected void  onCreate(Bundle ref2) {
		super.onCreate(ref2);
		ListView data=getListView();
		SQLiteDatabase db=openOrCreateDatabase("hamaradb.db", MODE_PRIVATE,null);
		Cursor result=db.rawQuery("select * from hamaritable", null);
		ArrayList list=new ArrayList();
		while(result.moveToNext())
		{
			list.add(result.getString(0)+" "+result.getString(1)+" "+result.getString(2));
		}
		ArrayAdapter<String> completeData =new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,list);
		data.setAdapter(completeData);
	   // completeData.getView(BIND_AUTO_CREATE, convertView, parent);
	}
}
