package com.kitchensink.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kitchensink.R;

public class ArticleFragment extends Fragment {
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
    	
        final View rootView = inflater.inflate(
                R.layout.fragment_article, container, false);
        Article article = (Article) getArguments().getSerializable("article");
        
        ((TextView) rootView.findViewById(R.id.titleTextView)).setText(article.getTitle());
        ((TextView) rootView.findViewById(R.id.contentTextView)).setText(article.getContent());
        
        return rootView;
    }
    
    
}