package com.kitchensink.viewpager;

import java.util.ArrayList;
import java.util.List;

import com.kitchensink.util.LoremIpsum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ArticleCollectionPagerAdapter extends FragmentStatePagerAdapter {

	protected List<Article> articles = new ArrayList<Article>();

	public ArticleCollectionPagerAdapter(FragmentManager fm) {
		super(fm);
		// Create 10 articles ...
		LoremIpsum loremIpsum = new LoremIpsum();

		for (int i = 0; i < 10; i++) {
			articles.add(new Article(loremIpsum.words(5, true), loremIpsum.paragraphs(6)));
		}
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = new ArticleFragment();
		Bundle args = new Bundle();
		args.putSerializable("article", articles.get(i));
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return articles.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return articles.get(position).getTitle();
	}
}
