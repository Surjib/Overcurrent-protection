package protection.model.logicalnodes.control;


import protection.model.dataobjects.control.DPC;
import protection.model.dataobjects.statusInfo.ACT;
import protection.model.logicalnodes.common.LN;

/** Узел управления выключателями */
public class CSWI extends LN {

    private ACT OpOpn = new ACT(); //  Команда отключить выключатель


    private ACT OpCls = new ACT(); // Команда включить выключатель

    private DPC Pos = new DPC(); // Состояние выключателя общий

    /** Переключение Выключателя**/
    @Override
    public void process() {

        if (!OpOpn.getGeneral().getValue()){
            Pos.getCtVal().setValue(false);
            Pos.getStVal().setValue(DPC.Codedenum.OFF);

        }
        else if (!OpCls.getGeneral().getValue()){
            Pos.getCtVal().setValue(true);
            Pos.getStVal().setValue(DPC.Codedenum.ON);
        }
    }





    public ACT getOpOpn() {
        return OpOpn;
    }

    public void setOpOpn(ACT opOpn) {
        OpOpn = opOpn;
    }

    public ACT getOpCls() {
        return OpCls;
    }

    public void setOpCls(ACT opCls) {
        OpCls = opCls;
    }

    public DPC getPos() {
        return Pos;
    }

    public void setPos(DPC pos) {
        Pos = pos;
    }
}