package org.techno;

import java.util.List;

import android.R.string;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class Questions extends Activity implements SensorListener{

	SensorManager sensorManager;
	int sensor=SensorManager.SENSOR_ORIENTATION;
	TextView tv;
	protected void onCreate (Bundle ref123) {
    super.onCreate(ref123);	
 	setContentView(R.layout.activity);
 	sensorManager=( SensorManager)getSystemService(SENSOR_SERVICE);
 	tv=(TextView)findViewById(R.id.textview);
 	WifiManager wifimanager=(WifiManager)getSystemService(Context.WIFI_SERVICE);
 	WifiInfo info=wifimanager.getConnectionInfo();
 	tv.setText(info.getIpAddress()+" "+info.getMacAddress()+" "+info.getSSID()+" "+info.getHiddenSSID()+" "+info.getNetworkId());
 	List<WifiConfiguration> list =wifimanager.getConfiguredNetworks();
 	for(WifiConfiguration data:list)
 	{
 		tv.append("\n"+data.SSID+" "+data.networkId);
 		
 		
 	}
}
	protected void onPause()
 	{
 	  super.onPause();	
 		sensorManager.unregisterListener(this,sensor);
 	}
	
	protected void onStart()
 	{
 	  super.onStart();	
 		sensorManager.registerListener(this,sensor);
 	}
@Override
public void onAccuracyChanged(int arg0, int arg1) {
	// TODO Auto-generated method stub
	
}

@Override
public void onSensorChanged(int arg0, float[] arg1) {
	// TODO Auto-generated method stub
	float pitch=Math.round(arg1[0]);
	float roll=Math.round(arg1[1]);
	float azimuth=Math.round(arg1[2]);
    String data=String.format("pitch : %f \n Roll:%f \nAzimuth:%f", pitch,roll,azimuth);
    tv.setText(pitch+" "+roll+" "+azimuth);
	
}
}
