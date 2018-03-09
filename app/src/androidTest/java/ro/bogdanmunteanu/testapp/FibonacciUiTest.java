package ro.bogdanmunteanu.testapp;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;

import ro.bogdanmunteanu.testapp.main.MainActivity;
import ro.bogdanmunteanu.testapp.model.Element;

import static android.support.test.espresso.Espresso.onData;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * UI which will execute on an Android device.
 */
@RunWith(AndroidJUnit4.class)
public class FibonacciUiTest {

    public int testValue;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init()
    {
        testValue=8;
    }


    @Test
    public void checkFibonacciOnView() {
        onData(is(instanceOf(Element.class))).check(matches(hasDescendant(withText(testValue))));
    }
}
