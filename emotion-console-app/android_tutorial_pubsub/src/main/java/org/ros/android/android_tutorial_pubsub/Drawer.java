package org.ros.android.android_tutorial_pubsub;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Drawer extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    public Listener mylistener = new Listener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void preparePlot(CharSequence mTitle){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        SimpleXYPlotFragment fragmentPlot = new SimpleXYPlotFragment();
        ArrayList<Double> points = new ArrayList<Double>();

        points = mylistener.getDistances(mTitle.toString().toCharArray()[0]);
        fragmentPlot = SimpleXYPlotFragment.newInstance(mTitle);
        transaction.replace(R.id.container, fragmentPlot);

        fragmentPlot.setYValues(points);
        transaction.commit();
    }

    public void onSectionAttached(int number) {



        switch (number) {
            case 1:
                mTitle = getString(R.string.A);
                preparePlot(mTitle);
                break;
            case 2:
                mTitle = getString(R.string.B);
                preparePlot(mTitle);
                break;
            case 3:
                mTitle = getString(R.string.C);
                preparePlot(mTitle);
                break;
            case 4:
                mTitle = getString(R.string.D);
                preparePlot(mTitle);
                break;
            case 5:
                mTitle = getString(R.string.E);
                preparePlot(mTitle);
                break;
            case 6:
                mTitle = getString(R.string.F);
                preparePlot(mTitle);
                break;
            case 7:
                mTitle = getString(R.string.G);
                preparePlot(mTitle);
                break;
            case 8:
                mTitle = getString(R.string.H);
                preparePlot(mTitle);
                break;
            case 9:
                mTitle = getString(R.string.I);
                preparePlot(mTitle);
                break;
            case 10:
                mTitle = getString(R.string.J);
                preparePlot(mTitle);
                break;
            case 11:
                mTitle = getString(R.string.K);
                preparePlot(mTitle);
                break;
            case 12:
                mTitle = getString(R.string.L);
                preparePlot(mTitle);
                break;
            case 13:
                mTitle = getString(R.string.M);
                preparePlot(mTitle);
                break;
            case 14:
                mTitle = getString(R.string.N);
                preparePlot(mTitle);
                break;
            case 15:
                mTitle = getString(R.string.O);
                preparePlot(mTitle);
                break;
            case 16:
                mTitle = getString(R.string.P);
                preparePlot(mTitle);
                break;
            case 17:
                mTitle = getString(R.string.Q);
                preparePlot(mTitle);
                break;
            case 18:
                mTitle = getString(R.string.R);
                preparePlot(mTitle);
                break;
            case 19:
                mTitle = getString(R.string.S);
                preparePlot(mTitle);
                break;
            case 20:
                mTitle = getString(R.string.T);
                preparePlot(mTitle);
                break;
            case 21:
                mTitle = getString(R.string.U);
                preparePlot(mTitle);
                break;
            case 22:
                mTitle = getString(R.string.V);
                preparePlot(mTitle);
                break;
            case 23:
                mTitle = getString(R.string.W);
                preparePlot(mTitle);
                break;
            case 24:
                mTitle = getString(R.string.X);
                preparePlot(mTitle);
                break;
            case 25:
                mTitle = getString(R.string.Y);
                preparePlot(mTitle);
                break;
            case 26:
                mTitle = getString(R.string.Z);
                preparePlot(mTitle);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.drawer, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_drawer, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((Drawer) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}