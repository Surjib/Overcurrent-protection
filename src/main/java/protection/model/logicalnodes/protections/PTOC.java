package protection.model.logicalnodes.protections;

import protection.model.common.GenDataAttribute;
import protection.model.dataobjects.measurements.WYE;
import protection.model.dataobjects.statusInfo.ACD;
import protection.model.dataobjects.statusInfo.ACT;
import protection.model.dataobjects.settings.ASG;
import protection.model.dataobjects.statusSetting.ING;
import protection.model.logicalnodes.common.LN;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** Узел токовых защит **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cfg")
public class PTOC extends LN {

    /*
     * Входы
     */
    public WYE A = new WYE(); // Замеренное значение тока

    @XmlElement
    public ASG StrVal = new ASG(); // Уставка по току
    @XmlElement
    public ING OpDlTmms = new ING(); // Уставка по времени

    /*
     * Выходы
     */
    public final ACD Str = new ACD(); // Пуск защиты
    public final ACT Op = new ACT(); // Срабатывание защиты

    public long StrTime = 0;


    /** Логика защиты*/
    @Override
    public void process() {

        /* Пуск защиты (превышение уставки по току) */
        Str.getPhsA().setValue(A.getPhsA().getcVal().getMag().getF().getValue() >
                StrVal.getSetMag().getF().getValue());
        Str.getPhsB().setValue(A.getPhsB().getcVal().getMag().getF().getValue() >
                StrVal.getSetMag().getF().getValue());
        Str.getPhsC().setValue(A.getPhsC().getcVal().getMag().getF().getValue() >
                StrVal.getSetMag().getF().getValue());

        Str.getGeneral().setValue(
                Str.getPhsA().getValue() || Str.getPhsB().getValue() || Str.getPhsC().getValue()
        );
        /* Пуск таймера срабатывания */
        if (Str.getGeneral().getValue()) {
            StrTime ++;
        }
        else StrTime = 0;

        /* Срабатывание защиты */
        Op.getGeneral().setValue(StrTime > OpDlTmms.getSetVal().getValue() && Str.getGeneral().getValue());

        Op.getPhsA().setValue(StrTime > OpDlTmms.getSetVal().getValue() && Str.getPhsA().getValue());
        Op.getPhsB().setValue(StrTime > OpDlTmms.getSetVal().getValue() && Str.getPhsB().getValue());
        Op.getPhsC().setValue(StrTime > OpDlTmms.getSetVal().getValue() && Str.getPhsC().getValue());

//        /* Пуск задержки по времени */
//        if (Str.getGeneral().getValue()) {
//            Op.getT().setValue(incrementTimer(Op.getT().getValue()));
//        }
//
//        /* Срабатывание защиты */
//        Op.getGeneral().setValue(Op.getT().getValue() > OpDlTmms.getSetVal().getValue());
//
//        Op.getPhsA().setValue(Op.getT().getValue() > OpDlTmms.getSetVal().getValue());
//        Op.getPhsB().setValue(Op.getT().getValue() > OpDlTmms.getSetVal().getValue());
//        Op.getPhsC().setValue(Op.getT().getValue() > OpDlTmms.getSetVal().getValue());
//
//
//
//    }
//
//    public long incrementTimer (long t) {
//        return t++;
  }
}
