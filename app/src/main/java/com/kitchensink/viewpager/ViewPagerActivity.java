package com.kitchensink.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.kitchensink.R;

public class ViewPagerActivity extends FragmentActivity {

	ArticleCollectionPagerAdapter articleCollectionPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        articleCollectionPagerAdapter =
                new ArticleCollectionPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(articleCollectionPagerAdapter);
    }

}
