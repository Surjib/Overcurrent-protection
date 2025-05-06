package protection.model.dataobjects.measurements;

import protection.model.common.AnalogueValue;
import protection.model.common.GenDataObject;
import protection.model.common.Quality;
import protection.model.common.Timestamp;

/** Измеряемое значение **/
public class MV extends GenDataObject {


    private AnalogueValue instMag = new AnalogueValue();


    private Quality q = new Quality();


    private Timestamp t = new Timestamp();






    public AnalogueValue getInstMag() {
        return instMag;
    }

    public void setInstMag(AnalogueValue instMag) {
        this.instMag = instMag;
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
