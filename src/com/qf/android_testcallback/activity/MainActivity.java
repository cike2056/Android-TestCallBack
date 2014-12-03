package com.qf.android_testcallback.activity;

import org.json.JSONObject;

import com.qf.android_testcallback.R;
import com.qf.android_testcallback.activity.MyCallBack.ICallBack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
/**接口回调/主线程调用子线程的方法 /handler
 * 几点问题:
 * @author uaige
 *
 */
/*可以正常运行:
	1.解决:空指针问题 public void getURLJSONContent(final String url,final ICallBack  callBack)中要赋值iCallBack =callBack;
	2.解决:url的参数不符问题.String中多了一个空格.
	3.
private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			JSONObject jsonObject = (JSONObject) msg.obj;
			iCallBack.execute(jsonObject);*//**如果把这部分去掉,可以运行.但是,没有获得结果.*//*
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
