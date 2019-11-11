package org.d3ifcool.fitme;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void clickOnYourNavigationDrawer_ShowToYourScree(){
        try {
            onView(withId(R.id.txt_tinggi)).perform(typeText("172"));
            closeSoftKeyboard();
            Thread.sleep(1000);
            onView(withId(R.id.txt_berat)).perform(typeText("65"));
            Thread.sleep(1000);
            closeSoftKeyboard();
            Thread.sleep(1000);

            onView(withId(R.id.btn_hitung)).perform(click());
            Thread.sleep(1000);


            onView(withId(R.id.btn_save)).perform(click());
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
