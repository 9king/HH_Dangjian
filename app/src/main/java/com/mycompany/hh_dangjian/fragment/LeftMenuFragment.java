package com.mycompany.hh_dangjian.fragment;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mycompany.hh_dangjian.MainActivity;
import com.mycompany.hh_dangjian.R;
import com.mycompany.hh_dangjian.base.BaseFragment;
import com.mycompany.hh_dangjian.pager.StudyPager;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian
 * 文件名:LeftMenuFragment
 * 创建者：zhuli
 * 创建时间: 2018/1/23  17:32
 * 描述:  TODO
 */
public class LeftMenuFragment extends BaseFragment {

    private TextView tvdateday;
    private TextView tvdateweek;
    private RadioGroup rgleftmenu;
    private int position;
    @Override
    public View initView() {
        rootView = View.inflate(context, R.layout.leftmenufragment, null);
        initialize(rootView);
        return rootView;
    }

    @Override
    public void initData() {
        super.initData();
        rgleftmenu.check(R.id.rb_knowledge);
        rgleftmenu.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }

    private void initialize(View rootView) {

        tvdateday = (TextView) rootView.findViewById(R.id.tv_date_day);
        tvdateweek = (TextView) rootView.findViewById(R.id.tv_date_week);
        rgleftmenu = (RadioGroup) rootView.findViewById(R.id.rg_leftmenu);
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb_knowledge:
                    position=0;
                    break;
                case R.id.rb_subject:
                    position=1;
                    break;
                case R.id.rb_vedio:
                    position=2;
                    break;
            }
            MainActivity mainActivity= (MainActivity) context;
            mainActivity.getSlidingMenu().toggle();
            switchPager(position);
        }
    }

    private  void switchPager(int position) {
        MainActivity mainActivity= (MainActivity) context;
        ContentFragment contentFragment=mainActivity.getContentFragment();
        StudyPager studyPager=contentFragment.getStudyPager();
        studyPager.switchPager(position);
    }

}
