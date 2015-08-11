package br.edu.ufcg.reuml.profiles;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by gustavo on 23/04/15.
 */
@Entity
public class SequenceDiagramProfile extends UMLProfile {
    @Column
    double NL;
    @Column
    double PAM;
    @Column
    double PRM;
    @Column
    double PCM;
    @Column
    double PDM;
    @Column
    double PCoCF;
    @Column
    double PItCF;
    @Column
    double PBCF;
    @Column
    double PCuCF;
    @Column
    double PWCF;
    @Column
    double PSCF;
    @Column
    double PNCF;
    @Column
    double PCrCF;
    @Column
    double PIgCF;
    @Column
    double PCsCF;
    @Column
    double PACF;
    @Column
    double PIU;
    @Column
    double PAc;
    @Column
    double PSI;

    public SequenceDiagramProfile() {
        super();
    }

    public SequenceDiagramProfile(double NL, double PAM, double PRM, double PCM, double PDM, double PCoCF,
                                  double PItCF, double PBCF, double PCuCF, double PWCF, double PSCF,
                                  double PNCF, double PCrCF, double PIgCF, double PCsCF, double PACF,
                                  double PIU, double PAc, double PSI) {
        super();
        this.NL = NL;
        this.PAM = PAM;
        this.PRM = PRM;
        this.PCM = PCM;
        this.PDM = PDM;
        this.PCoCF = PCoCF;
        this.PItCF = PItCF;
        this.PBCF = PBCF;
        this.PCuCF = PCuCF;
        this.PWCF = PWCF;
        this.PSCF = PSCF;
        this.PNCF = PNCF;
        this.PCrCF = PCrCF;
        this.PIgCF = PIgCF;
        this.PCsCF = PCsCF;
        this.PACF = PACF;
        this.PIU = PIU;
        this.PAc = PAc;
        this.PSI = PSI;
    }

    public double getNL() {
        return NL;
    }

    public void setNL(double NL) {
        this.NL = NL;
    }

    public double getPAM() {
        return PAM;
    }

    public void setPAM(double PAM) {
        this.PAM = PAM;
    }

    public double getPRM() {
        return PRM;
    }

    public void setPRM(double PRM) {
        this.PRM = PRM;
    }

    public double getPCM() {
        return PCM;
    }

    public void setPCM(double PCM) {
        this.PCM = PCM;
    }

    public double getPDM() {
        return PDM;
    }

    public void setPDM(double PDM) {
        this.PDM = PDM;
    }

    public double getPCoCF() {
        return PCoCF;
    }

    public void setPCoCF(double PCoCF) {
        this.PCoCF = PCoCF;
    }

    public double getPItCF() {
        return PItCF;
    }

    public void setPItCF(double PItCF) {
        this.PItCF = PItCF;
    }

    public double getPBCF() {
        return PBCF;
    }

    public void setPBCF(double PBCF) {
        this.PBCF = PBCF;
    }

    public double getPCuCF() {
        return PCuCF;
    }

    public void setPCuCF(double PCuCF) {
        this.PCuCF = PCuCF;
    }

    public double getPWCF() {
        return PWCF;
    }

    public void setPWCF(double PWCF) {
        this.PWCF = PWCF;
    }

    public double getPSCF() {
        return PSCF;
    }

    public void setPSCF(double PSCF) {
        this.PSCF = PSCF;
    }

    public double getPNCF() {
        return PNCF;
    }

    public void setPNCF(double PNCF) {
        this.PNCF = PNCF;
    }

    public double getPCrCF() {
        return PCrCF;
    }

    public void setPCrCF(double PCrCF) {
        this.PCrCF = PCrCF;
    }

    public double getPIgCF() {
        return PIgCF;
    }

    public void setPIgCF(double PIgCF) {
        this.PIgCF = PIgCF;
    }

    public double getPCsCF() {
        return PCsCF;
    }

    public void setPCsCF(double PCsCF) {
        this.PCsCF = PCsCF;
    }

    public double getPACF() {
        return PACF;
    }

    public void setPACF(double PACF) {
        this.PACF = PACF;
    }

    public double getPIU() {
        return PIU;
    }

    public void setPIU(double PIU) {
        this.PIU = PIU;
    }

    public double getPAc() {
        return PAc;
    }

    public void setPAc(double PAc) {
        this.PAc = PAc;
    }

    public double getPSI() {
        return PSI;
    }

    public void setPSI(double PSI) {
        this.PSI = PSI;
    }

    @Override
    public String toString() {
        return "SequenceDiagramProfile{" +
                "NL=" + NL +
                ", PAM=" + PAM +
                ", PRM=" + PRM +
                ", PCM=" + PCM +
                ", PDM=" + PDM +
                ", PCoCF=" + PCoCF +
                ", PItCF=" + PItCF +
                ", PBCF=" + PBCF +
                ", PCuCF=" + PCuCF +
                ", PWCF=" + PWCF +
                ", PSCF=" + PSCF +
                ", PNCF=" + PNCF +
                ", PCrCF=" + PCrCF +
                ", PIgCF=" + PIgCF +
                ", PCsCF=" + PCsCF +
                ", PACF=" + PACF +
                ", PIU=" + PIU +
                ", PAc=" + PAc +
                ", PSI=" + PSI +
                '}';
    }
}
