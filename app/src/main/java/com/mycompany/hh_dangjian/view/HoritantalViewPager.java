package com.mycompany.hh_dangjian.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.view
 * 文件名:HoritantalViewPager
 * 创建者：zhuli
 * 创建时间: 2018/1/28  11:41
 * 描述:  TODO
 */
public class HoritantalViewPager extends ViewPager {
    private float startX;
    private float startY;
    public HoritantalViewPager(Context context) {
        super(context);
    }

    public HoritantalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                //把事件传给当前控件
                getParent().requestDisallowInterceptTouchEvent(true);
                //记录起始坐标
               startX=ev.getX();
                startY=ev.getY();
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:
                float endX=ev.getX();
                float endY=ev.getY();
                float offSetX=startX-endX;
                float offSetY=startY-endX;
                if (Math.abs(offSetX)>Math.abs(offSetY)){
                    //水平滑动
                    if (getCurrentItem()==0&&offSetX>0){
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }else if (getCurrentItem()==(getAdapter().getCount()-1)&&offSetX<0  ){
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else{
                      getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }else{
                    //竖直滑动
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
