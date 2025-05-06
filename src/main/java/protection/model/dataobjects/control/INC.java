package protection.model.dataobjects.control;

import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;

/** Управляемое целочисленное состояние**/
public class INC extends GenDataObject {

    private GenDataAttribute<Integer> stVal = new GenDataAttribute<>(0);

    private GenDataAttribute<Integer> ctlVal = new GenDataAttribute<>(0);
    private Quality q = new Quality();

    private Timestamp t = new Timestamp();







    public GenDataAttribute<Integer> getStVal() {
        return stVal;
    }

    public void setStVal(GenDataAttribute<Integer> stVal) {
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

    public GenDataAttribute<Integer> getCtlVal() {
        return ctlVal;
    }

    public void setCtlVal(GenDataAttribute<Integer> ctlVal) {
        this.ctlVal = ctlVal;
    }
}
