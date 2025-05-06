package protection.model.dataobjects.measurements;


import protection.model.common.GenDataObject;

/** Фазные измеряемые значения трехфазной системы (Phase to ground/neutral related measured values of a three-phase system)**/
public class WYE extends GenDataObject {


    private CMV phsA = new CMV();

    private CMV phsB = new CMV();

    private CMV phsC = new CMV();

    private CMV neut = new CMV();






    public CMV getPhsA() {
        return phsA;
    }

    public void setPhsA(CMV phsA) {
        this.phsA = phsA;
    }

    public CMV getPhsB() {
        return phsB;
    }

    public void setPhsB(CMV phsB) {
        this.phsB = phsB;
    }

    public CMV getPhsC() {
        return phsC;
    }

    public void setPhsC(CMV phsC) {
        this.phsC = phsC;
    }

    public CMV getNeut() {
        return neut;
    }

    public void setNeut(CMV neut) {
        this.neut = neut;
    }
}
