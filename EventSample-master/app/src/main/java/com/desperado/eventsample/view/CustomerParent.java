package com.desperado.eventsample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/*
 *
 *
 * 版 权 :@Copyright 北京******科技有限公司版权所有
 *
 * 作 者 :desperado
 *
 * 版 本 :1.0
 *
 * 创建日期 :2016/9/22  18:59
 *
 * 描 述 :自定义的父类
 *
 * 修订日期 :
 */

public class CustomerParent extends LinearLayout {

    private static final String Tag = CustomerParent.class.getSimpleName();

    public CustomerParent(Context context) {
        super(context);
    }

    public CustomerParent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerParent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /***
     * 事件分发 onDispatchTouchEvent
     * 事件捕获过程中，如果dispatchTouc
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(Tag, "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    /****
     * 事件拦截
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(Tag, "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
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
