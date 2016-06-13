package com.xhanfei.onetomatodemo01.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.xhanfei.onetomatodemo01.entity.TomatoClockInfo;

/**
 * Created by xhanfei on 16/6/13.
 */
public class CountDownTimerService extends Service{

    public static final String EXTRA_TOMATOCLOCK_INFO = "extra_tomatoclock_info";

    public static final String ACTION_START = "com.xhanfei.tomato:action_download";
    public static final String ACTION_CANCEL = "com.xhanfei.tomato:action_cancel";

    public static void intentStart(Context context, TomatoClockInfo tomatoClockInfo){
        Intent intent = new Intent(context,CountDownTimerService.class);
        intent.putExtra(EXTRA_TOMATOCLOCK_INFO,tomatoClockInfo);
        intent.setAction(ACTION_START);
    }

    public static void intentCancel(Context context){
        Intent intent = new Intent(context,CountDownTimerService.class);
        intent.setAction(ACTION_CANCEL);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent!=null) {
            String action = intent.getAction();

            switch(action) {
                case ACTION_START:
                    TomatoClockInfo tomatoClockInfo = (TomatoClockInfo) intent.getSerializableExtra(EXTRA_TOMATOCLOCK_INFO);
                    startCountDownTimer(tomatoClockInfo);
                    break;
                case ACTION_CANCEL:
                    cancelCountDownTimer();
                    break;
                default:
                    break;
            }
        }


        return super.onStartCommand(intent, flags, startId);
    }


    private void startCountDownTimer(TomatoClockInfo tomatoClockInfo){

    }


    private void cancelCountDownTimer() {

    }


}
