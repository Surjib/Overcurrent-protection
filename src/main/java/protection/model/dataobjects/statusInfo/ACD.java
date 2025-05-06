package protection.model.dataobjects.statusInfo;

import protection.model.common.GenDataAttribute;

/** Информация о пуске защиты по направлению **/
public class ACD extends ACT {
    
    private GenDataAttribute<Direction> dirGeneral = new GenDataAttribute<>();
    {
        dirGeneral.setName("dirGeneral");
        dirGeneral.setParent(this);
        this.getChildren().add(dirGeneral);
    }
    
    private GenDataAttribute<Direction> dirPhsA = new GenDataAttribute<>();
    
    private GenDataAttribute<Direction> dirPhsB = new GenDataAttribute<>();
    
    private GenDataAttribute<Direction> dirPhsC = new GenDataAttribute<>();

    /** Перечсление направлений */
    public enum Direction {
        FORWARD,
        BACKWARD,
        BOTH
    }






    public GenDataAttribute<Direction> getDirGeneral() {
        return dirGeneral;
    }

    public void setDirGeneral(GenDataAttribute<Direction> dirGeneral) {
        this.dirGeneral = dirGeneral;
    }

    public GenDataAttribute<Direction> getDirPhsA() {
        return dirPhsA;
    }

    public void setDirPhsA(GenDataAttribute<Direction> dirPhsA) {
        this.dirPhsA = dirPhsA;
    }

    public GenDataAttribute<Direction> getDirPhsB() {
        return dirPhsB;
    }

    public void setDirPhsB(GenDataAttribute<Direction> dirPhsB) {
        this.dirPhsB = dirPhsB;
    }

    public GenDataAttribute<Direction> getDirPhsC() {
        return dirPhsC;
    }

    public void setDirPhsC(GenDataAttribute<Direction> dirPhsC) {
        this.dirPhsC = dirPhsC;
    }
}
