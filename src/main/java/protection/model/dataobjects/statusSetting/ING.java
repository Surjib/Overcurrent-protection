package protection.model.dataobjects.statusSetting;

import protection.model.common.GenDataAttribute;
import protection.model.common.GenDataObject;
/** Целочисленное параметр**/
public class ING extends GenDataObject {

    private GenDataAttribute<Integer> setVal = new GenDataAttribute<>(); //Значение параметра




    public GenDataAttribute<Integer> getSetVal() {
        return setVal;
    }

    public void setSetVal(GenDataAttribute<Integer> setVal) {
        this.setVal = setVal;
    }
}
