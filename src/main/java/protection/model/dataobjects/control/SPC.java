package protection.model.dataobjects.control;


import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;

/** Управляемая Однопозиционное состояние (Controllable single-point) */
public class SPC extends GenDataObject {

    private GenDataAttribute<Boolean> stVal = new GenDataAttribute<>(true); // Значение состояния

    private GenDataAttribute<Boolean> ctVal = new GenDataAttribute<>(true); // Значение для управления

    private Quality q = new Quality();

    private Timestamp t = new Timestamp();






    public GenDataAttribute<Boolean> getStVal() {
        return stVal;
    }

    public void setStVal(GenDataAttribute<Boolean> stVal) {
        this.stVal = stVal;
    }

    public GenDataAttribute<Boolean> getCtVal() {
        return ctVal;
    }

    public void setCtVal(GenDataAttribute<Boolean> ctVal) {
        this.ctVal = ctVal;
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
