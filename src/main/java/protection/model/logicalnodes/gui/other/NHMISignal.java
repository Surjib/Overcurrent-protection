package protection.model.logicalnodes.gui.other;

import protection.model.common.GenDataAttribute;

/** Сигнал для построения графиков */
public class NHMISignal{

    private final String name;
    private final GenDataAttribute<?> dataX, dataY;

    public NHMISignal(String name, GenDataAttribute<?> data) {
        this.name = name; this.dataX = null; this.dataY = data;
    }
    public NHMISignal(String name, GenDataAttribute<?> dataX, GenDataAttribute<?> dataY) {
        this.name = name; this.dataX = dataX; this.dataY = dataY;
    }

    public String getName() { return name; }
    public GenDataAttribute<?> getDataX() {
        return dataX;
    }

    public GenDataAttribute<?> getDataY() {
        return dataY;
    }
}
