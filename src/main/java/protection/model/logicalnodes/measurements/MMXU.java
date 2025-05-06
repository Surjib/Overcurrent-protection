package protection.model.logicalnodes.measurements;

import protection.model.dataobjects.measurements.MV;
import protection.model.dataobjects.measurements.WYE;
import protection.model.logicalnodes.common.LN;
import utils.filters.Filter;
import utils.filters.RMS;

/** Узел расчета токов**/
public class MMXU extends LN {

    /* Пофазно мгновенные значения на вход */
    public MV phsAInst = new MV();
    public MV phsBInst = new MV();
    public MV phsCInst = new MV();

    /* Рассчитанные значения на выход*/
    public final WYE A = new WYE();


    /* Экземпляры RMS фильтров для каждой фазы */

    private final Filter phsACurrent = new RMS();
    private final Filter phsBCurrent = new RMS();
    private final Filter phsCCurrent = new RMS();


    /** Фильтрация анлогового сигнала*/
    @Override
    public void process() {
        phsACurrent.process(phsAInst, A.getPhsA());
        phsBCurrent.process(phsBInst, A.getPhsB());
        phsCCurrent.process(phsCInst, A.getPhsC());
    }
}
