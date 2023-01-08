package com.himanshuhc.statistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner expenseSpinner;
    private List<SpendingPojo> spendingPojos;
    private SpendingAdapter spendingAdapter;
    private RecyclerView spendingRecyclerView;
    private ValueLineChart mCubicValueLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        lineChartData();

        settingSpinner();

        settingAdapter();
    }

    private void initView() {
        mCubicValueLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);
        expenseSpinner = findViewById(R.id.expense_SP);
        spendingRecyclerView = findViewById(R.id.spending_RV);
        spendingPojos = new ArrayList<>();
    }

    private void lineChartData() {
        ValueLineSeries series = new ValueLineSeries();
        series.setColor(getColor(R.color.teal_300));
        series.addPoint(new ValueLinePoint("Mar", 500.0f));
        series.addPoint(new ValueLinePoint("Apr", 860f));
        series.addPoint(new ValueLinePoint("May", 1250f));
        series.addPoint(new ValueLinePoint("Jun", 720f));
        series.addPoint(new ValueLinePoint("Jul", 1500f));
        series.addPoint(new ValueLinePoint("Aug", 1350f));
        series.addPoint(new ValueLinePoint("Sep", 1600f));

        mCubicValueLineChart.addSeries(series);
        mCubicValueLineChart.startAnimation();
    }

    private void settingSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.expense_spinner_array, androidx.appcompat.R.layout.select_dialog_item_material);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expenseSpinner.setAdapter(adapter);
    }

    private void settingAdapter() {
        SpendingPojo data1 = new SpendingPojo(R.drawable.starbucks_logo,"Starbucks","Jan 12, 2022",150.00);
        SpendingPojo data2 = new SpendingPojo(R.drawable.logo_facebook,"Transfer","Yesterday",85.00);
        SpendingPojo data3 = new SpendingPojo(R.drawable.youtube_logo,"Youtube","Jan 16, 2022",11.99);
        spendingPojos.add(data1);
        spendingPojos.add(data2);
        spendingPojos.add(data3);

        spendingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        spendingAdapter = new SpendingAdapter(spendingPojos,this);
        spendingRecyclerView.setAdapter(spendingAdapter);
    }
}