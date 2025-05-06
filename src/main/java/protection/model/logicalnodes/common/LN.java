package protection.model.logicalnodes.common;


import protection.model.common.GenDataObject;

/** Абстрактный класс для создания узлов **/
public abstract class LN extends GenDataObject {

    /** Основная функция узла **/
    public abstract void process();
}
