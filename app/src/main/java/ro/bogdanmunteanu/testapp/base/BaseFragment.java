package ro.bogdanmunteanu.testapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Bogdan on 3/6/2018.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.getClass().getSimpleName(),"fragment created");
    }

    //here we can do additional stuff when implementing a new fragment
    //eg. listeners

    /**
     * allows access to the base activity methods
     *
     * @return the base activity or null if the activity cannot be accessed or is not a instance of BaseActivity
     */
    @Nullable
    protected final BaseActivity getBaseActivity() {
        if (getActivity() instanceof BaseActivity) {
            return (BaseActivity) getActivity();
        }
        return null;
    }


    /**
     *initialise toolbar
     *
     * @param toolbar           the toolbar to be set as the activity toolbar
     * @param toolbarTitle      the textview that should display the toolbar title
     * @param toolbarTitleText  the string to be displayed as the screen title
     * @param setHasOptionsMenu true if toolbar has options menu
     */
    protected final void initToolbar(Toolbar toolbar, TextView toolbarTitle, String toolbarTitleText, boolean setHasOptionsMenu) {
        if (getBaseActivity() == null) {
            Log.e(this.getClass().getSimpleName(),"tying to set actionbar with no activity attached, or on a activity that doesn't inherit BaseActivity");
            return;
        }
        toolbar.setTitle("");
        getBaseActivity().setSupportActionBar(toolbar);
        toolbarTitle.setText(toolbarTitleText);
        setHasOptionsMenu(setHasOptionsMenu);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
