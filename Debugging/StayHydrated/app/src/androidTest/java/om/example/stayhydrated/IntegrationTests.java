package om.example.stayhydrated;


import android.widget.ProgressBar;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class IntegrationTests {
    // Define the activity to be tested
    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void ExampleAssertInDataInHistory() {
        onData(anything()) // Select all elements in a list
                .inAdapterView(withId(R.id.historyListView)) // Only in the historyListViewAdapter
                .atPosition(0)  // Select the element at index 0
                .onChildView(withId(R.id.historyDataText))  // Select the view historyDataText in the element
                .check(matches(withText("[TEMP_TEXT]")));  // Assertion
    }

    @Test
    public void ExampleAssertProgressBar(){
        ProgressBar progressBar = activity.getActivity().findViewById(R.id.progressBar);
        assertThat(progressBar.getProgress(), equalTo(50));
    }

    @Test
    public void clickDroplet(){
        /*assertThat(onData(anything()).inAdapterView(withId(R.id.historyListView))
                .atPosition(0).onChildView(withId(R.id.historyDataText)));*/
    }
}
