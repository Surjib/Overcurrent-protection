package utils.filters;

import protection.model.dataobjects.measurements.CMV;
import protection.model.dataobjects.measurements.MV;

/** RMS фильтр**/
public class RMS extends Filter {

    public static int size = 80;  // Размер буфера/выборки

    private final double[] buffer = new double[size]; // Цикличный буфер

    private int count = 0; // Счетчик для обхода по буферу

    private double sum = 0;

    @Override
    public void process(MV instMag, CMV Out) {

        double value = Math.pow(instMag.getInstMag().getF().getValue(), 2);

        sum += value - buffer[count];

        buffer[count] = value;

        count++;
        if(count >= size) count = 0;

        Out.getcVal().getMag().getF().setValue(Math.sqrt(sum / size));
    }
}
