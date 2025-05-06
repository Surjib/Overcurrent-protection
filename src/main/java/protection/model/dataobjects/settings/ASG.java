package protection.model.dataobjects.settings;


import protection.model.common.AnalogueValue;
import protection.model.common.GenDataObject;

/** Параметр срабатывания (Уставка) **/
public class ASG extends GenDataObject {


    private final AnalogueValue setMag = new AnalogueValue(); // Значение уставки


    public AnalogueValue getSetMag() {
        return setMag;
    }
}
