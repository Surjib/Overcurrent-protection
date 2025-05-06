package protection.model.dataobjects.control;

import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;

/** Управляемая двухпозиционное состояние (Controllable double-point)  */
public class DPC extends GenDataObject {

    private GenDataAttribute<Codedenum> stVal = new GenDataAttribute<Codedenum>(); // Значение состояния

    private GenDataAttribute<Boolean> ctVal = new GenDataAttribute<>(true); // Значение для управления

    private Quality q = new Quality();

    private Timestamp t = new Timestamp();

    //Перечисление состояний выключателя
    public enum Codedenum {
        INTERMEDIATE,
        OFF,
        ON,
        BAD
    }





    public GenDataAttribute<Codedenum> getStVal() {
        return stVal;
    }

    public void setStVal(GenDataAttribute<Codedenum> stVal) {
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
