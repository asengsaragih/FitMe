package org.d3ifcool.fitme;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class DataDriven {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void dataDriven()  throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFile("data.csv")));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(",");

            String tinggi = str[1].toString();
            String berat = str[2].toString();

            onView(withId(R.id.txt_tinggi)).perform(typeText(tinggi),closeSoftKeyboard());
            onView(withId(R.id.txt_berat)).perform(typeText(berat),closeSoftKeyboard());

            onView(withId(R.id.btn_hitung)).perform(click());

            onView(withId(R.id.txt_tinggi)).perform(clearText(),closeSoftKeyboard());
            onView(withId(R.id.txt_berat)).perform(clearText(),closeSoftKeyboard());
        }
    }

    private InputStream openFile(String filename) throws IOException {
        return getClass().getClassLoader().getResourceAsStream(filename);
    }
}

