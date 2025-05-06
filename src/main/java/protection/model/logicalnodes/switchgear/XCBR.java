package protection.model.logicalnodes.switchgear;


import protection.model.dataobjects.control.DPC;
import protection.model.dataobjects.control.SPC;
import protection.model.dataobjects.statusInfo.INS;
import protection.model.dataobjects.statusInfo.SPS;
import protection.model.logicalnodes.common.LN;

/** Узел выключателей */
public class XCBR extends LN {

    private SPS Loc = new SPS(); // Local Control Behaviour

    private INS OpCnt = new INS(); // Счетчик срабатывания
    private DPC Pos = new DPC(); //Положение выключателя

    private SPC BlkOpn = new SPC();  //Блокировка на выключение

    private SPC BlkCl = new SPC(); //Блокировка на включение

    /** Переключение состояния выключателя*/
    @Override
    public void process() {
        int count = 0;

        if(Pos.getCtVal().getValue() && !BlkOpn.getCtVal().getValue()){ // (Если включен и не запрещено выключение)
            count++;
            Pos.getStVal().setValue(DPC.Codedenum.OFF); // Отключение Выключателя
            OpCnt.getStVal().setValue(count);

        }
    }






    public SPS getLoc() {
        return Loc;
    }

    public void setLoc(SPS loc) {
        Loc = loc;
    }

    public INS getOpCnt() {
        return OpCnt;
    }

    public void setOpCnt(INS opCnt) {
        OpCnt = opCnt;
    }

    public DPC getPos() {
        return Pos;
    }

    public void setPos(DPC pos) {
        Pos = pos;
    }

    public SPC getBlkOpn() {
        return BlkOpn;
    }

    public void setBlkOpn(SPC blkOpn) {
        BlkOpn = blkOpn;
    }

    public SPC getBlkCl() {
        return BlkCl;
    }

    public void setBlkCl(SPC blkCl) {
        BlkCl = blkCl;
    }
}