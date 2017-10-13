package cn.answering.tablayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by HP on 2017/10/13.
 */

public class FragmentAdapter2 extends FragmentStatePagerAdapter {

    public List<Fragment> list;
    private List<String> titles;

    public FragmentAdapter2(FragmentManager fm, List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.list = fragments;
        this.titles = titles;

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
