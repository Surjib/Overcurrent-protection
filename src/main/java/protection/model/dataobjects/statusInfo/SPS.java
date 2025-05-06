package protection.model.dataobjects.statusInfo;

import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;

/** Точечное состояние (Single-point status)**/
public class SPS extends GenDataObject {

    private GenDataAttribute<Boolean> stVal = new GenDataAttribute<>(true); //Значение состояния

    private Quality q = new Quality();

    private Timestamp t = new Timestamp();






    public GenDataAttribute<Boolean> getStVal() {
        return stVal;
    }

    public void setStVal(GenDataAttribute<Boolean> stVal) {
        this.stVal = stVal;
    }

    public Quality getQ() {
        return q;
    }

    public void setQ(Quality q) {
        this.q = q;
    }

    public Timestamp getT() {
        return t;
    }

    public void setT(Timestamp t) {
        this.t = t;
    }
}
