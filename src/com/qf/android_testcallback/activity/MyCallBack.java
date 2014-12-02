package com.qf.android_testcallback.activity;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.os.Message;

public class MyCallBack  {
	private ICallBack iCallBack;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			JSONObject jsonObject = (JSONObject) msg.obj;
			iCallBack.execute(jsonObject);
		}
	};
	public void getURLJSONContent(final String url,final ICallBack iCallBack){
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					HttpEntity httpEntity = null;
					HttpClient client = new DefaultHttpClient();
					HttpParams params = client.getParams();
					HttpConnectionParams.setConnectionTimeout(params, 5000);
					HttpGet httpGet = new HttpGet(url);
					HttpResponse response = client.execute(httpGet);
					if(response!=null&&response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
						httpEntity = response.getEntity();
						JSONObject jsonObject = new JSONObject(EntityUtils.toString(httpEntity));
						Message message = Message.obtain();
						message.obj=jsonObject;
						handler.sendMessage(message);
					}
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}).start();
	}
	public interface ICallBack{
		public void execute(JSONObject jsonObject);
	}
	
}
