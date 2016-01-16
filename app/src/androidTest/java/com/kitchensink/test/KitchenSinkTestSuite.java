package com.kitchensink.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.kitchensink.test.musicplayer.BoundMusicPlayerServiceTests;
import com.kitchensink.test.scrapbook.ScrapbookInFileActivityTests;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	BoundMusicPlayerServiceTests.class,
	ScrapbookInFileActivityTests.class
})
public class KitchenSinkTestSuite extends TestSuite {

}
