package ro.bogdanmunteanu.testapp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ro.bogdanmunteanu.testapp.R;

/**
 * Base activity for all stuff
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final int SIMPLE_ANIMATION = 0;
    private static final int LEFT_ANIMATION = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //here we could do some additional stuff before starting the activity (init crashlytics, firebase etc
    }

    /**
     * Helper method to return different layouts in different activities based on layout id
     * @return
     */
    public abstract int getLayoutId();

    //region FRAGMENTS

    /**
     * Set new fragment.
     *
     * @param fragment new fragment to be set
     */
    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .commitAllowingStateLoss();
    }

    /**
     * Set new fragment.
     *
     * @param fragment    new fragment to be set
     * @param containerId container of fragment
     */
    public void setFragment(Fragment fragment, int containerId) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commitAllowingStateLoss();
    }

    /**
     * Set new fragment with slide animation and add it to backstack.
     *
     * @param fragment new fragment to be set
     */
    public void changeFragmentSlideAnim(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(android.R.id.content, fragment, backStateName);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

    /**
     * Replace current fragment with new fragment, aand keep current backstack
     *
     * @param fragment new fragment to be set
     */
    public void replaceCurrentFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStackImmediate();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(android.R.id.content, fragment, backStateName);
        transaction.addToBackStack(backStateName);
        transaction.commit();
    }

    /**
     * Set new fragment with slide animation and clear backstack.
     *
     * @param fragment new fragment to be set
     */
    public void changeFragmentSlideAnimNewStack(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(android.R.id.content, fragment);
        transaction.commit();
    }

    /**
     * Replaces the fragment in the activity layout and adds it to backstack.
     *
     * @param fragment new fragment to be set
     */
    public void changeFragmentWithHistory(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment, backStateName)
                .addToBackStack(backStateName)
                .commitAllowingStateLoss();
    }

    /**
     * Set the fragment and clear backstack.
     *
     * @param fragment new fragment to be set
     */
    public void setFragmentOnNewStack(Fragment fragment) {
        popBackStack();
        setFragment(fragment);
    }

    /**
     * Set the fragment and clear backstack.
     *
     * @param fragment  new fragment to be set
     * @param container container of fragment
     */
    public void setFragmentOnNewStack(Fragment fragment, int container) {
        popBackStack();
        setFragment(fragment, container);
    }

    /**
     * Remove fragment from backstack.
     *
     * @param fragment fragment to be removed
     */
    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
    }

    /**
     * Clear all the fragments from back stack.
     */
    public void popBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = fm.getBackStackEntryCount(); i > 0; --i) {
            fm.popBackStack();
        }
    }

    /**
     * Navigates back to the first fragment on the stack
     */
    public void popFirstFragment() {
        FragmentManager manager = getSupportFragmentManager();
        while (manager.getBackStackEntryCount() > 0) {
            manager.popBackStackImmediate();
        }
    }

    /**
     * Pop first fragment from backstack and set the new fragment.
     *
     * @param fragment new fragment to be set
     */
    public void popToFirstAndAddOnTop(Fragment fragment) {
        popFirstFragment();
        changeFragmentSlideAnim(fragment);
    }

    /**
     * Resume fragment from backstack.
     *
     * @param fragment fragment to be resumed
     */
    public void popFragmentFromBackStack(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(android.R.id.content, fragment);
            ft.addToBackStack(backStateName);
            ft.commitAllowingStateLoss();
        }
    }

    /**
     * Clear fragments from backstack and keep only current fragment.
     */
    public void clearFragmentManagerBackstack() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            for (int index = 0; index < getSupportFragmentManager().getBackStackEntryCount(); index++) {
                final FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index);
                getSupportFragmentManager().popBackStack(backEntry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        }
    }
}
