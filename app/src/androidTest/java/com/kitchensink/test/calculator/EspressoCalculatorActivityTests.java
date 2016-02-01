package com.kitchensink.test.calculator;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.kitchensink.R;
import com.kitchensink.calculator.CalculatorActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoCalculatorActivityTests {

    @Rule
    public ActivityTestRule<CalculatorActivity> rule = new ActivityTestRule<CalculatorActivity>(CalculatorActivity.class);

    @Test
    public void testEqualsButton() {
        onView(withId(R.id.firstNumberEditText)).perform(typeText("10"));
        onView(withId(R.id.secondNumberEditText)).perform(typeText("5"));
        onView(withId(R.id.equalsButton)).perform(click());
        onView(withId(R.id.resultEditText)).check(matches(withText("15")));
    }

}
