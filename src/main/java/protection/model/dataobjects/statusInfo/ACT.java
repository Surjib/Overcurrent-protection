package protection.model.dataobjects.statusInfo;

import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
import protection.model.common.Timestamp;

/** Информация о срабатывани защиты **/
public class ACT extends GenDataObject {


    private GenDataAttribute<Boolean> general = new GenDataAttribute<>(); // Общее


    private GenDataAttribute<Boolean> phsA = new GenDataAttribute<>(); // Срабатывание в фазе А


    private GenDataAttribute<Boolean> phsB = new GenDataAttribute<>(); // Срабатывание в фазе В


    private GenDataAttribute<Boolean> phsC = new GenDataAttribute<>(); // Срабатывание в фазе С


    private Timestamp t = new Timestamp();





    public GenDataAttribute<Boolean> getGeneral() {
        return general;
    }

    public void setGeneral(GenDataAttribute<Boolean> general) {
        this.general = general;
    }

    public GenDataAttribute<Boolean> getPhsA() {
        return phsA;
    }

    public void setPhsA(GenDataAttribute<Boolean> phsA) {
        this.phsA = phsA;
    }

    public GenDataAttribute<Boolean> getPhsB() {
        return phsB;
    }

    public void setPhsB(GenDataAttribute<Boolean> phsB) {
        this.phsB = phsB;
    }

    public GenDataAttribute<Boolean> getPhsC() {
        return phsC;
    }

    public void setPhsC(GenDataAttribute<Boolean> phsC) {
        this.phsC = phsC;
    }

    public Timestamp getT() {
        return t;
    }

    public void setT(Timestamp t) {
        this.t = t;
    }
}
