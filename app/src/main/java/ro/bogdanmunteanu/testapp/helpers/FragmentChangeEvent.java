package ro.bogdanmunteanu.testapp.helpers;

/**
 * Event that handles fragment change in viewpager
 * Contains the number of the fragment required
 */

public class FragmentChangeEvent {
    public int fragmentToBeChanged;

    public FragmentChangeEvent(int fragmentToBeChanged) {
        this.fragmentToBeChanged = fragmentToBeChanged;
    }
}
