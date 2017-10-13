package cn.answering.tablayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondTabActivity extends AppCompatActivity {

    private String[] titles = new String[]{"微信","通讯录","发现","我"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FragmentAdapter2 fragmentAdapter;
    private List<Fragment> mFragments;
    private List<String> mTitles;

    private int[] mImgs = new int[]{R.drawable.num1,R.drawable.num2,R.drawable.num3,R.drawable.num4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_tab);

        mViewPager = (ViewPager) findViewById(R.id.viewpager2);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout2);
        mTitles = new ArrayList<>();
        for (int i = 0;i < titles.length;i++){
            mTitles.add(titles[i]);
        }

        mFragments = new ArrayList<Fragment>();
        for (int i = 0; i < mTitles.size();i++){
            mFragments.add(TabFragment.newInstance(i));
        }

        fragmentAdapter = new FragmentAdapter2(getSupportFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setSelectedTabIndicatorHeight(0);

        for (int i = 0; i < mTitles.size(); i++){
            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null){
                itemTab.setCustomView(R.layout.item_tab);
                TextView textView = (TextView) itemTab.getCustomView().findViewById(R.id.tv_name);
                textView.setText(mTitles.get(i));
                ImageView imageView = (ImageView) itemTab.getCustomView().findViewById(R.id.iv_img);
                imageView.setImageResource(mImgs[i]);
            }
        }

        mTabLayout.getTabAt(0).getCustomView().setSelected(true);



    }
}
