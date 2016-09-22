package com.desperado.eventsample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/*
 *
 *
 * 版 权 :@Copyright 北京******科技有限公司版权所有
 *
 * 作 者 :desperado
 *
 * 版 本 :1.0
 *
 * 创建日期 :2016/9/22  19:00
 *
 * 描 述 :自定义的子类
 *
 * 修订日期 :
 */

public class CustomerChild extends TextView {
    private static final String Tag = CustomerChild.class.getSimpleName();

    public CustomerChild(Context context) {
        super(context);
    }

    public CustomerChild(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerChild(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /****
     * 事件响应
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(Tag, "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
