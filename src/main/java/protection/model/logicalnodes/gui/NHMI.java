package protection.model.logicalnodes.gui;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.Series;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import protection.model.common.GenDataAttribute;
import protection.model.logicalnodes.common.LN;
import protection.model.logicalnodes.gui.other.NHMISignal;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/** Узел для построения графиков (временных последовательностей) */
public class NHMI extends LN {

	private final HashMap<XYSeries, GenDataAttribute<?>> datasets = new HashMap<>();
	private final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new NumberAxis("Время"));;
	private final JFrame frame = new JFrame();

	private int notifyCount = 0, updatePoint = 10; // счетчик и период обновления графиков
	private double currentTime = 0.0;


	/** Создание полтна при создании экземпляра класса */
	public NHMI(){
		JFreeChart chart = new JFreeChart("", plot);
		chart.setBorderPaint(Color.black);
		chart.setBorderVisible(true);
		chart.setBackgroundPaint(Color.white);
		chart.setAntiAlias(true);
		ChartPanel chartPanel = new ChartPanel(chart);

		frame.setTitle("Токовая защита");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(chartPanel);
		frame.setSize(1280,720);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}


	/** Построение графика*/
	public void process(){
		if(!frame.isVisible()) frame.setVisible(true);

		currentTime += 1;
		datasets.forEach((series, rawData) -> {
			if(rawData.getValue() instanceof Number) series.add(currentTime, (Number) rawData.getValue(), false);
			else if(rawData.getValue() instanceof Boolean) series.add(currentTime, (Boolean) rawData.getValue() ? 1 : 0, false);
		});

		/* Период обновления */
		if(notifyCount++ > updatePoint) {
			notifyCount = 0;
			datasets.keySet().forEach(Series::fireSeriesChanged);
		}
	}


	/**
	 * Добавить группу сигналов
	 * @param name - название  группы сгналов
	 * @param signals - группа сигналов
	 */
	public void addSignals(String name, NHMISignal... signals){
		addSignals(name, Arrays.asList(signals));
	}

	/**
	 * Добавить группу сигналов
	 * @param name - название  группы сгналов
	 * @param signals - группа сигналов
	 */
	public void addSignals(String name, List<NHMISignal> signals){
		XYSeriesCollection dataset = new XYSeriesCollection();
		NumberAxis rangeAxis = new NumberAxis(name);
		rangeAxis.setAutoRangeIncludesZero(false);
		rangeAxis.setLabelAngle(45);

//		rangeAxis.setLabelFont(new Font("Impact", Font.ITALIC, 10));
		XYPlot subplot = new XYPlot(dataset, null, rangeAxis, new StandardXYItemRenderer());
		subplot.setBackgroundPaint(Color.BLACK);
		subplot.setDomainGridlinesVisible(false);
		subplot.setDomainCrosshairVisible(true);
		subplot.setRangeCrosshairVisible(true);
		plot.add(subplot, 5);

		/* Добавить дифференциал, если есть дискрет */
		signals.stream().filter(s -> s.getDataY().getValue() instanceof Boolean || s.getDataY().getValue() instanceof Byte).findFirst().ifPresent(s -> {
			subplot.setRenderer(0, new XYDifferenceRenderer());
			subplot.setWeight(1);
		});

		for(NHMISignal s: signals){
			XYSeries series = new XYSeries(s.getName());
			dataset.addSeries(series);
			datasets.put(series, s.getDataY());
		}

		process();
	}



	/**
	 * Добавить группу сигналов
	 * @param signals - группа сигналов
	 */
	public void addSignals(NHMISignal... signals){
		String name = Arrays.stream(signals)
				.map(NHMISignal::getName)
				.collect(Collectors.joining(", "));
		addSignals(name, signals);
	}


}