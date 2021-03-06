package com.xgr.wonderful.ui;

//import net.youmi.android.AdManager;
//import net.youmi.android.offers.OffersManager;
import cn.bmob.v3.Bmob;

import com.example.emoji.FaceConversionUtil;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;
import com.xgr.wonderful.R;
import com.xgr.wonderful.ui.base.BaseActivity;
import com.xgr.wonderful.utils.Constant;
import com.xgr.wonderful.utils.LogUtils;
import com.xgr.wonderful.utils.Sputil;
import com.xgr.wonderful.utils.UmengStat;

import android.os.Bundle;
import android.os.Handler;

/**
 * @author kingofglory email: kingofglory@yeah.net blog: http:www.google.com
 * @date 2014-2-21 TODO 闪屏界面，根据指定时间进行跳转
 *       在activity_splash.xml中加入background属性并传入图片资源ID即可
 */
public class SplashActivity extends BaseActivity {

	private static final long DELAY_TIME = 2000L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// Bmob SDK初始化--只需要这一段代码即可完成初始化
		// 请到Bmob官网(http://www.bmob.cn/)申请ApplicationId,具体地址:http://docs.bmob.cn/android/faststart/index.html?menukey=fast_start&key=start_android
		Bmob.initialize(this, "9cad8689be006d6f1b7c2e9cc107b43e");
        oyx_MyApplication.getInstance().ClearFragment();
		LogUtils.i(TAG, TAG + " Launched ！");
		MobclickAgent
				.openActivityDurationTrack(UmengStat.IS_OPEN_ACTIVITY_AUTO_STAT);
		FeedbackAgent agent = new FeedbackAgent(this);
		agent.sync();
		redirectByTime();
		if (sputil.getValue("isPushOn", true)) {
			PushAgent mPushAgent = PushAgent.getInstance(mContext);
			mPushAgent.enable();
			LogUtils.i(
					TAG,
					"device_token:"
							+ UmengRegistrar.getRegistrationId(mContext));
		} else {
			PushAgent mPushAgent = PushAgent.getInstance(mContext);
			mPushAgent.disable();
		}
		//初始化表情添加
				new Thread(new Runnable() {
		            @Override
		            public void run() {
		                FaceConversionUtil.getInstace().getFileText(getApplication());
		            }
		        }).start();
//		AdManager.getInstance(mContext).init("67daabfc8ffec9c7",
//				"7748a02fe32d6532", false);
//		OffersManager.getInstance(mContext);
	}

	/**
	 * 根据时间进行页面跳转
	 */
	private void redirectByTime() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (sputil.isFirstInstall(SplashActivity.this)) {
					redictToActivity(SplashActivity.this, GuideActivity.class,
							null);
					finish();
				} else {
					redictToActivity(SplashActivity.this, MainActivity.class,
							null);
					finish();
				}
			}
		}, DELAY_TIME);
	}
}
