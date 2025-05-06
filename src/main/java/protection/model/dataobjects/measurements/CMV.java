package protection.model.dataobjects.measurements;

import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;
import protection.model.common.Vector;

/** Комплексное измеряемое значение **/
public class CMV extends GenDataObject {

    private Vector cVal = new Vector();

    private Quality q = new Quality();

    private Timestamp t = new Timestamp();





    public Vector getcVal() {
        return cVal;
    }

    public void setcVal(Vector cVal) {
        this.cVal = cVal;
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


