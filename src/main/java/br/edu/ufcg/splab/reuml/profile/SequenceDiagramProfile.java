package br.edu.ufcg.splab.reuml.profile;

/**
 * Created by gustavo on 23/04/15.
 */
public class SequenceDiagramProfile extends UMLProfile {

    double NL;

    double PAM;

    double PRM;

    double PCM;

    double PDM;

    double PCoCF;

    double PItCF;

    double PBCF;

    double PCuCF;

    double PWCF;

    double PSCF;

    double PNCF;

    double PCrCF;

    double PIgCF;

    double PCsCF;

    double PACF;

    double PIU;

    double PAc;

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
        return this.NL;
    }

    public void setNL(double NL) {
        this.NL = NL;
    }

    public double getPAM() {
        return this.PAM;
    }

    public void setPAM(double PAM) {
        this.PAM = PAM;
    }

    public double getPRM() {
        return this.PRM;
    }

    public void setPRM(double PRM) {
        this.PRM = PRM;
    }

    public double getPCM() {
        return this.PCM;
    }

    public void setPCM(double PCM) {
        this.PCM = PCM;
    }

    public double getPDM() {
        return this.PDM;
    }

    public void setPDM(double PDM) {
        this.PDM = PDM;
    }

    public double getPCoCF() {
        return this.PCoCF;
    }

    public void setPCoCF(double PCoCF) {
        this.PCoCF = PCoCF;
    }

    public double getPItCF() {
        return this.PItCF;
    }

    public void setPItCF(double PItCF) {
        this.PItCF = PItCF;
    }

    public double getPBCF() {
        return this.PBCF;
    }

    public void setPBCF(double PBCF) {
        this.PBCF = PBCF;
    }

    public double getPCuCF() {
        return this.PCuCF;
    }

    public void setPCuCF(double PCuCF) {
        this.PCuCF = PCuCF;
    }

    public double getPWCF() {
        return this.PWCF;
    }

    public void setPWCF(double PWCF) {
        this.PWCF = PWCF;
    }

    public double getPSCF() {
        return this.PSCF;
    }

    public void setPSCF(double PSCF) {
        this.PSCF = PSCF;
    }

    public double getPNCF() {
        return this.PNCF;
    }

    public void setPNCF(double PNCF) {
        this.PNCF = PNCF;
    }

    public double getPCrCF() {
        return this.PCrCF;
    }

    public void setPCrCF(double PCrCF) {
        this.PCrCF = PCrCF;
    }

    public double getPIgCF() {
        return this.PIgCF;
    }

    public void setPIgCF(double PIgCF) {
        this.PIgCF = PIgCF;
    }

    public double getPCsCF() {
        return this.PCsCF;
    }

    public void setPCsCF(double PCsCF) {
        this.PCsCF = PCsCF;
    }

    public double getPACF() {
        return this.PACF;
    }

    public void setPACF(double PACF) {
        this.PACF = PACF;
    }

    public double getPIU() {
        return this.PIU;
    }

    public void setPIU(double PIU) {
        this.PIU = PIU;
    }

    public double getPAc() {
        return this.PAc;
    }

    public void setPAc(double PAc) {
        this.PAc = PAc;
    }

    public double getPSI() {
        return this.PSI;
    }

    public void setPSI(double PSI) {
        this.PSI = PSI;
    }

    @Override
    public String toString() {
        return "SequenceDiagramProfile{" +
                "NL=" + this.NL +
                ", PAM=" + this.PAM +
                ", PRM=" + this.PRM +
                ", PCM=" + this.PCM +
                ", PDM=" + this.PDM +
                ", PCoCF=" + this.PCoCF +
                ", PItCF=" + this.PItCF +
                ", PBCF=" + this.PBCF +
                ", PCuCF=" + this.PCuCF +
                ", PWCF=" + this.PWCF +
                ", PSCF=" + this.PSCF +
                ", PNCF=" + this.PNCF +
                ", PCrCF=" + this.PCrCF +
                ", PIgCF=" + this.PIgCF +
                ", PCsCF=" + this.PCsCF +
                ", PACF=" + this.PACF +
                ", PIU=" + this.PIU +
                ", PAc=" + this.PAc +
                ", PSI=" + this.PSI +
                '}';
    }
}
