package com.smartdengg.clickdebounce;

import android.view.View;

import com.smartdengg.clickdebounce.library.R;


/**
 * 创建时间:  2018/03/09 12:10 <br>
 * 作者:  SmartDengg <br>
 * 描述:
 */
public class DebouncedPredictorEx {

  public static long FROZEN_WINDOW_MILLIS = 1000L;

  private static final String TAG = DebouncedPredictor.class.getSimpleName();

  public static boolean shouldDoClick(View target) {

    long curTimeStamp = System.currentTimeMillis();
    long lastClickTimeStamp = 0;
    Object o = target.getTag(R.id.last_click_time);
    if (o == null){
      target.setTag(R.id.last_click_time, curTimeStamp);
      return true;
    }
    lastClickTimeStamp = (Long) o;
    boolean isInvalid = curTimeStamp - lastClickTimeStamp < FROZEN_WINDOW_MILLIS;
    if (!isInvalid)
      target.setTag(R.id.last_click_time, curTimeStamp);
    return !isInvalid;

  }
}
