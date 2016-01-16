package com.kitchensink.musicplayer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kitchensink.R;
import com.kitchensink.util.KitchenSinkActivity;

public abstract class AbstractMusicPlayerActivity extends KitchenSinkActivity {
	
	protected String[] songs = new String[]{"guitar.mp3", "piano.mp3"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_music_player);
        final ListView listView = findListViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs));
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				play(songs[position]);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.abstract_music_player, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
	    	case R.id.action_pause: pause(); break;
	    	case R.id.action_stop: stop(); break;
	    	case R.id.action_current_position: showCurrentPosition();
    	}
    	
    	return true;
    }
    
    public void showCurrentPosition() {
    	toast("Current position: " + getCurrentPosition());
    }
    
    public abstract void play(String song);
    
    public abstract void pause();
    
    public abstract void stop();
    
    public abstract int getCurrentPosition();
}
