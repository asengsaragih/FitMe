package org.d3ifcool.fitme;

import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class WorkoutActivityTest {
    @Rule
    public ActivityTestRule<WorkoutActivity> mainActivityActivityTestRule = new ActivityTestRule<>(WorkoutActivity.class);

    @Test
    public void clickOnYourNavigationDrawer_ShowToYourScree(){
        try {
            onView(withId(R.id.workout_drawer)).check(matches(isClosed
                    (Gravity.LEFT)))
                    .perform(DrawerActions.open());
            Thread.sleep(1000);
            onView(withId(R.id.nv_workout)).perform(NavigationViewActions
                    .navigateTo
                    (R.id.menu_workout));
            Thread.sleep(3000);
            onView(withId(R.id.recyclerView)).perform(RecyclerViewActions
                    .actionOnItemAtPosition(0,click()));
            Thread.sleep(3000);
            onView(withId(R.id.mulai_button)).perform(click());
            Thread.sleep(7000);
            onView(withId(R.id.imageButton2)).perform(click());
            Thread.sleep(3000);
            onView(withId(R.id.selesai)).perform(click());
            Thread.sleep(3000);
            onView(withId(R.id.workout_drawer)).check(matches(isClosed
                    (Gravity.LEFT)))
                    .perform(DrawerActions.open());
            Thread.sleep(1000);
            onView(withId(R.id.nv_workout)).perform(NavigationViewActions
                    .navigateTo(R.id.menu_report));
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
