package utils.filters;

import protection.model.dataobjects.measurements.CMV;
import protection.model.dataobjects.measurements.MV;

/** Абстрактный класс для создания фильтров **/
public abstract class Filter {

    public abstract void process(MV instMag, CMV result);
}
