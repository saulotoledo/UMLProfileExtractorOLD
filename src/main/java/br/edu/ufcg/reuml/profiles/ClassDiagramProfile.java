package br.edu.ufcg.reuml.profiles;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by gustavo on 27/03/15.
 */
@Entity
public class ClassDiagramProfile extends UMLProfile {
    @Column
    private double DIS;
    @Column
    private double PSA;
    @Column
    private double PDA;
    @Column
    private double PADV;
    @Column
    private double PATPS;
    @Column
    private double PSO;
    @Column
    private double PRI;
    @Column
    private double PASC;
    @Column
    private double PABC;
    @Column
    private double PTC;
    @Column
    private double PEN;
    @Column
    private double POQ;
    @Column
    private double POP;
    @Column
    private double PNAA;
    @Column
    private double PSHA;
    @Column
    private double PCOA;
    @Column
    private double PGS;
    @Column
    private double PRMAT;

    public ClassDiagramProfile() {
        super();
    }

    public ClassDiagramProfile(double DIS, double PSA, double PDA, double PADV, double PATPS, double PSO, double PRI,
                               double PASC, double PABC, double PTC, double PEN, double POQ, double POP, double PNAA,
                               double PSHA, double PCOA, double PGS, double PRMAT) {
        super();
        this.DIS = DIS;
        this.PSA = PSA;
        this.PDA = PDA;
        this.PADV = PADV;
        this.PATPS = PATPS;
        this.PSO = PSO;
        this.PRI = PRI;
        this.PASC = PASC;
        this.PABC = PABC;
        this.PTC = PTC;
        this.PEN = PEN;
        this.POQ = POQ;
        this.POP = POP;
        this.PNAA = PNAA;
        this.PSHA = PSHA;
        this.PCOA = PCOA;
        this.PGS = PGS;
        this.PRMAT = PRMAT;
    }

    public double getDIS() {
        return DIS;
    }

    public void setDIS(double DIS) {
        this.DIS = DIS;
    }

    public double getPSA() {
        return PSA;
    }

    public void setPSA(double PSA) {
        this.PSA = PSA;
    }

    public double getPDA() {
        return PDA;
    }

    public void setPDA(double PDA) {
        this.PDA = PDA;
    }

    public double getPADV() {
        return PADV;
    }

    public void setPADV(double PADV) {
        this.PADV = PADV;
    }

    public double getPATPS() {
        return PATPS;
    }

    public void setPATPS(double PATPS) {
        this.PATPS = PATPS;
    }

    public double getPSO() {
        return PSO;
    }

    public void setPSO(double PSO) {
        this.PSO = PSO;
    }

    public double getPRI() {
        return PRI;
    }

    public void setPRI(double PRI) {
        this.PRI = PRI;
    }

    public double getPASC() {
        return PASC;
    }

    public void setPASC(double PASC) {
        this.PASC = PASC;
    }

    public double getPABC() {
        return PABC;
    }

    public void setPABC(double PABC) {
        this.PABC = PABC;
    }

    public double getPTC() {
        return PTC;
    }

    public void setPTC(double PTC) {
        this.PTC = PTC;
    }

    public double getPEN() {
        return PEN;
    }

    public void setPEN(double PEN) {
        this.PEN = PEN;
    }

    public double getPOQ() {
        return POQ;
    }

    public void setPOQ(double POQ) {
        this.POQ = POQ;
    }

    public double getPOP() {
        return POP;
    }

    public void setPOP(double POP) {
        this.POP = POP;
    }

    public double getPNAA() {
        return PNAA;
    }

    public void setPNAA(double PNAA) {
        this.PNAA = PNAA;
    }

    public double getPSHA() {
        return PSHA;
    }

    public void setPSHA(double PSHA) {
        this.PSHA = PSHA;
    }

    public double getPCOA() {
        return PCOA;
    }

    public void setPCOA(double PCOA) {
        this.PCOA = PCOA;
    }

    public double getPGS() {
        return PGS;
    }

    public void setPGS(double PGS) {
        this.PGS = PGS;
    }

    public double getPRMAT() {
        return PRMAT;
    }

    public void setPRMAT(double PRMAT) {
        this.PRMAT = PRMAT;
    }

    @Override
    public String toString() {
        return "ClassDiagramProfile{" +
                "DIS=" + DIS +
                ", PSA=" + PSA +
                ", PDA=" + PDA +
                ", PADV=" + PADV +
                ", PATPS=" + PATPS +
                ", PSO=" + PSO +
                ", PRI=" + PRI +
                ", PASC=" + PASC +
                ", PABC=" + PABC +
                ", PTC=" + PTC +
                ", PEN=" + PEN +
                ", POQ=" + POQ +
                ", POP=" + POP +
                ", PNAA=" + PNAA +
                ", PSHA=" + PSHA +
                ", PCOA=" + PCOA +
                ", PGS=" + PGS +
                ", PRMAT=" + PRMAT +
                "} ";
    }
}
