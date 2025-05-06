package protection.model.dataobjects.statusInfo;

import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;

/** Целочисленное состояние**/
public class INS extends GenDataObject {

    private GenDataAttribute<Integer> stVal = new GenDataAttribute<>(0);

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
}
