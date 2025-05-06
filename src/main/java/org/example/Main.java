package org.example;

import protection.model.logicalnodes.common.LN;
import protection.model.logicalnodes.control.CSWI;
import protection.model.logicalnodes.gui.NHMI;
import protection.model.logicalnodes.gui.other.NHMISignal;
import protection.model.logicalnodes.input.LCOM;
import protection.model.logicalnodes.measurements.MMXU;
import protection.model.logicalnodes.protections.PTOC;
import protection.model.logicalnodes.switchgear.XCBR;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**Инициализация очереди*/
    private final static List<LN> lnList = new ArrayList<>();

    public static void main(String[] args) {

        /** Создание LCOM узла и чтение из файла*/
        LCOM lcom = new LCOM();
        lnList.add(lcom);

        lcom.setFilePath(
                "E:\\DZ\\10sem\\Algorythmy RZA\\LR1\\LR1\\src\\main\\resources\\Опыты\\Начало линии\\",
                "PhA80"
        );

//        lcom.setFilePath(
//                "D:\\DZ\\10sem\\Algorythmy RZA\\LR1\\LR1\\src\\main\\resources\\Опыты\\Начало линии\\",
//                "PhAB80"
//        );

//        lcom.setFilePath(
//                "D:\\DZ\\10sem\\Algorythmy RZA\\LR1\\LR1\\src\\main\\resources\\Опыты\\Конец линии\\",
//                "PhABC80"
//        );

        /** Создание MMXU узла и фильтрация аналогового сигнала*/
        MMXU mmxu = new MMXU();
        lnList.add(mmxu);

        mmxu.phsAInst = lcom.OUT.get(0);
        mmxu.phsBInst = lcom.OUT.get(1);
        mmxu.phsCInst = lcom.OUT.get(2);

        /** Создание узла 1 ступени и задание параметров*/
        PTOC ptoc1 = new PTOC();
        lnList.add(ptoc1);
        ptoc1.StrVal.getSetMag().getF().setValue(4080.0);
        ptoc1.OpDlTmms.getSetVal().setValue(100);
        ptoc1.A = mmxu.A;

        /** Создание узла 2 ступени и задание параметров*/
        PTOC ptoc2 = new PTOC();
        lnList.add(ptoc2);
        ptoc2.StrVal.getSetMag().getF().setValue(3740.0);
        ptoc2.OpDlTmms.getSetVal().setValue(800);
        ptoc2.A = mmxu.A;

        /** Создание узла управления выключателями*/
        CSWI cswi = new CSWI();
        cswi.setOpOpn(ptoc1.Op);
        cswi.setOpOpn(ptoc2.Op);

        /** Создание узла выключателя выключателями*/
        XCBR xcbr = new XCBR();
        xcbr.setPos(cswi.getPos());

        /** Создание узла гарфики и задание сигналов*/
        NHMI nhmi = new NHMI();
        lnList.add(nhmi);
        nhmi.addSignals("Осциллограммы токов",
                new NHMISignal("InstValuePhsA", lcom.OUT.get(0).getInstMag().getF()),
                new NHMISignal("InstValuePhsB", lcom.OUT.get(1).getInstMag().getF()),
                new NHMISignal("InstValuePhsC", lcom.OUT.get(2).getInstMag().getF()));
        nhmi.addSignals("Действ. значение А и уставки",
                new NHMISignal("RmsValuePhsA", mmxu.A.getPhsA().getcVal().getMag().getF()),
                new NHMISignal("StrVal1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrVal2", ptoc2.StrVal.getSetMag().getF()));
        nhmi.addSignals("Действ. значение В и уставки",
                new NHMISignal("RmsValuePhsB", mmxu.A.getPhsB().getcVal().getMag().getF()),
                new NHMISignal("StrVal1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrVal2", ptoc2.StrVal.getSetMag().getF()));
        nhmi.addSignals("Действ. значение С и уставки",
                new NHMISignal("RmsValuePhsC", mmxu.A.getPhsC().getcVal().getMag().getF()),
                new NHMISignal("StrVal1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrVal2", ptoc2.StrVal.getSetMag().getF()));
        nhmi.addSignals(
                "Защита 1 ПО А", new NHMISignal("StrA1", ptoc1.Str.getPhsA()));
        nhmi.addSignals(
                "Защита 1 СО A", new NHMISignal("OpA1", ptoc1.Op.getPhsA()));
        nhmi.addSignals(
                "Защита 1 ПО B", new NHMISignal("StrB1", ptoc1.Str.getPhsB()));
        nhmi.addSignals(
                "Защита 1 СО B", new NHMISignal("OpB1", ptoc1.Op.getPhsB()));
        nhmi.addSignals(
                "Защита 1 ПО C", new NHMISignal("StrC1", ptoc1.Str.getPhsC()));
        nhmi.addSignals(
                "Защита 1 СО C", new NHMISignal("OpC1", ptoc1.Op.getPhsC()));



        nhmi.addSignals(
                "Защита 2 ПО А", new NHMISignal("StrA2", ptoc2.Str.getPhsA()));
        nhmi.addSignals(
                "Защита 2 СО A", new NHMISignal("OpA2", ptoc2.Op.getPhsA()));
        nhmi.addSignals(
                "Защита 2 ПО B", new NHMISignal("StrB2", ptoc2.Str.getPhsB()));
        nhmi.addSignals(
                "Защита 2 СО B", new NHMISignal("OpB2", ptoc2.Op.getPhsB()));
        nhmi.addSignals(
                "Защита 2 ПО C", new NHMISignal("StrC2", ptoc2.Str.getPhsC()));
        nhmi.addSignals(
                "Защита 2 СО C", new NHMISignal("OpC2", ptoc2.Op.getPhsC()));


        /** Запуск алгоритма, пока в .dat файле есть строки*/
        while (lcom.hasNextData()) {
            lnList.forEach(LN::process);
        }
    }
}