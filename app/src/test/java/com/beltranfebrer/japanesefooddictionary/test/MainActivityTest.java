package com.beltranfebrer.japanesefooddictionary.test;

import com.beltranfebrer.japanesefooddictionary.MainActivity;
import com.beltranfebrer.japanesefooddictionary.MainActivityPresenter;
import com.beltranfebrer.japanesefooddictionary.MainActivityView;
import com.beltranfebrer.japanesefooddictionary.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by miquel on 11.01.16.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivityView mockView;
    MainActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        mockView = mock(MainActivityView.class);
        presenter = new MainActivityPresenter(mockView);
    }

    @Test
    public void testAddTabs() throws Exception {
        verify(mockView).addTab("Categories");
        verify(mockView).addTab("Search");
    }

    @Test
    public void testOptionsItemSelect() throws Exception {
        assertFalse(presenter.onOptionsItemSelected(0));
        assertTrue(presenter.onOptionsItemSelected(R.id.action_about_us));
        verify(mockView, times(1)).showAboutUs();
    }
}
