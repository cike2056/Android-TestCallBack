package com.qf.android_testcallback.activity;

import org.json.JSONObject;

import com.qf.android_testcallback.R;
import com.qf.android_testcallback.activity.MyCallBack.ICallBack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MyCallBack mCallBack = new MyCallBack();
		mCallBack.getURLJSONContent("http://news-at.zhihu.com/api/3/stories/latest ", new ICallBack() {
			public void execute(JSONObject response) {
				Log.i("MainActivity", response.toString());
			}
		});
	}
}
