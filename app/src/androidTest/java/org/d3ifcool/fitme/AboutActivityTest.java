package org.d3ifcool.fitme;

import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AboutActivityTest {
    @Rule
    public ActivityTestRule<AboutActivity> aboutActivityActivityTestRule = new ActivityTestRule<>(AboutActivity.class);

    @Test
    public void clickOnYourNavigationDrawer_ShowToYourScree(){
        try {
            onView(withId(R.id.about_drawer)).check(matches(isClosed(Gravity.LEFT))).perform(DrawerActions.open());
            Thread.sleep(1000);
            onView(withId(R.id.nv_about)).perform(NavigationViewActions.navigateTo(R.id.menu_about));
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
