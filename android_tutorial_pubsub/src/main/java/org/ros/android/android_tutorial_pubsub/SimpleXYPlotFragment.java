package org.ros.android.android_tutorial_pubsub;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;


public class SimpleXYPlotFragment extends Fragment {

    private XYPlot plot;
    ArrayList<Double> series1Numbers;
    ArrayList<Double> series2Numbers;

    public static SimpleXYPlotFragment newInstance(CharSequence name) {
        SimpleXYPlotFragment fragmentDemo = new SimpleXYPlotFragment();
        Bundle args = new Bundle();
        args.putCharSequence("name", name);
        fragmentDemo.setArguments(args);

        return fragmentDemo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.simple_xy_plot_example, container,
                false);
        //your plot would look like this:
        plot = (XYPlot) view.findViewById(R.id.mySimpleXYPlot);
        // allow the visualization of the values cutted in the borders
        plot.getGraphWidget().setGridPaddingRight(30);
        plot.getGraphWidget().setGridPaddingTop(50);
        plot.getGraphWidget().setGridPaddingLeft(30);
        plot.getGraphWidget().setGridPaddingBottom(10);
        // draw a domain line for every element plotted on the domain:
        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL, 1);

        // plots starting from 1 and get rid of the decimal place on the display:
        plot.setDomainValueFormat(new DecimalFormat("#") {
            @Override
            public StringBuffer format(double v, StringBuffer stringBuffer, FieldPosition fieldPosition) {
                return stringBuffer.append((v + 1) + "");
            }

            @Override
            public StringBuffer format(long l, StringBuffer stringBuffer, FieldPosition fieldPosition) {
                return null;
            }

            @Override
            public Number parse(String s, ParsePosition parsePosition) {
                return null;
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharSequence name = getArguments().getCharSequence("name");

    }

    @Override
    public void onStart() {
        super.onStart();

        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                series1Numbers,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Shape instance");                             // Set the display title of the series

        // same as above
        //XYSeries series2 = new SimpleXYSeries(series2Numbers, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getActivity().getApplicationContext(),
                R.xml.line_point_formatter_with_plf1);

        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);

        // same as above:
        //LineAndPointFormatter series2Format = new LineAndPointFormatter();
        //series2Format.setPointLabelFormatter(new PointLabelFormatter());
        //series2Format.configure(getActivity().getApplicationContext(),
        //R.xml.line_point_formatter_with_plf2);
        //plot.addSeries(series2, series2Format);

        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
    }

    public void setYValues(ArrayList<Double> values){
        series1Numbers = values;
    }

    public void setXValues(ArrayList<Double> values){
        series2Numbers = values;
    }



}