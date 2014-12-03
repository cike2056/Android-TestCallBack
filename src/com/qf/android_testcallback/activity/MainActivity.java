package com.qf.android_testcallback.activity;

import org.json.JSONObject;

import com.qf.android_testcallback.R;
import com.qf.android_testcallback.activity.MyCallBack.ICallBack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
/**�ӿڻص�/���̵߳������̵߳ķ��� /handler
 * ��������:
 * @author uaige
 *
 */
/*������������:
	1.���:��ָ������ public void getURLJSONContent(final String url,final ICallBack  callBack)��Ҫ��ֵiCallBack =callBack;
	2.���:url�Ĳ�����������.String�ж���һ���ո�.
	3.
private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			JSONObject jsonObject = (JSONObject) msg.obj;
			iCallBack.execute(jsonObject);*//**������ⲿ��ȥ��,��������.����,û�л�ý��.*//*
		}
	};*/
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MyCallBack mCallBack = new MyCallBack();
		mCallBack.getURLJSONContent("http://news-at.zhihu.com/api/3/stories/latest", new ICallBack() {
			public void execute(JSONObject response) {
				Log.i("MainActivity", response.toString());
				TextView tx = (TextView) findViewById(R.id.txtv);
				tx.setText(response.toString());
			}
		});
	}
}
