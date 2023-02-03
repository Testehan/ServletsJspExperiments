package com.testehan.openliberty.servlet.primeFaces;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bubble.BubbleChartDataSet;
import org.primefaces.model.charts.bubble.BubbleChartModel;
import org.primefaces.model.charts.data.BubblePoint;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AreaChart {

    private LineChartModel areaModel;
    private BubbleChartModel bubbleModel;
    private DonutChartModel donutModel;

    @PostConstruct
    public void init(){
        createLineChartModel();
        createBubbleChartModel();
        createDonutModel();
    }

    private void createDonutModel() {
        donutModel = new DonutChartModel();
        ChartData data = new ChartData();

        DonutChartDataSet dataSet = new DonutChartDataSet();

        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);

        donutModel.setData(data);
    }

    private void createBubbleChartModel() {
        bubbleModel = new BubbleChartModel();
        ChartData data = new ChartData();

        BubbleChartDataSet dataSet = new BubbleChartDataSet();
        List<BubblePoint> values = new ArrayList<>();
        values.add(new BubblePoint(10, 10, 10));
        values.add(new BubblePoint(20, 30, 15));
        values.add(new BubblePoint(40, 10, 100));
        values.add(new BubblePoint(30, 20, 40));

        dataSet.setData(values);
        dataSet.setBackgroundColor("rgb(255, 99, 132)");
        dataSet.setLabel("First Dataset");

        data.addChartDataSet(dataSet);
        bubbleModel.setData(data);
    }

    private void createLineChartModel() {
        areaModel = new LineChartModel();

        LineChartDataSet javaDataSet = new LineChartDataSet() ;
        List<Object> javaValues = new ArrayList<>();
        javaValues.add(15);
        javaValues.add(2);
        javaValues.add(10);
        javaValues.add(25);
        javaValues.add(19);
        javaValues.add(23);

        javaDataSet.setData(javaValues);
        javaDataSet.setFill(true);
        javaDataSet.setLabel("JAVA");

        LineChartDataSet pythonDataset = new LineChartDataSet() ;
        List<Object> pythonValues = new ArrayList<>();
        pythonValues.add(30);
        pythonValues.add(55);
        pythonValues.add(87);
        pythonValues.add(110);
        pythonValues.add(99);
        pythonValues.add(78);

        pythonDataset.setData(pythonValues);
        pythonDataset.setFill(true);
        pythonDataset.setLabel("Python");

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");


        LineChartOptions lineChartOptions = new LineChartOptions();
        Title chartTitle = new Title();
        chartTitle.setText("Programming");
        chartTitle.setDisplay(true);
        lineChartOptions.setTitle(chartTitle);

        ChartData chartData = new ChartData();

        chartData.setLabels(labels);
        chartData.addChartDataSet(javaDataSet);
        chartData.addChartDataSet(pythonDataset);
        areaModel.setOptions(lineChartOptions);
        areaModel.setData(chartData);
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(LineChartModel areaModel) {
        this.areaModel = areaModel;
    }

    public BubbleChartModel getBubbleModel() {
        return bubbleModel;
    }

    public void setBubbleModel(BubbleChartModel bubbleModel) {
        this.bubbleModel = bubbleModel;
    }

    public DonutChartModel getDonutModel() {
        return donutModel;
    }

    public void setDonutModel(DonutChartModel donutModel) {
        this.donutModel = donutModel;
    }
}
