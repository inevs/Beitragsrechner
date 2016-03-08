package de.itagile.beitragsrechner;

public class PkwVertrag {

    private static final double AUFSCHLAGSATZ_FUER_FRAUEN = 0.10;

    private static final double VERSICHERUNGSSTEUERSATZ = 0.19;

    private final int leistungInKw;

    public PkwVertrag(int leistungInKw) {
        this.leistungInKw = leistungInKw;
    }

    public double berechneGrundbeitragProMonat() {
        return (leistungInKw * 1.3);
    }

    public double berechneEndbeitrag() {
        double versicherungssteuer = berechneGrundbeitragProMonat()
                * VERSICHERUNGSSTEUERSATZ;
        return berechneGrundbeitragProMonat() + versicherungssteuer;
    }

    public double berechneEndbeitragFuerFrau() {
        double aufpreis = berechneGrundbeitragProMonat()
                * AUFSCHLAGSATZ_FUER_FRAUEN;
        return berechneEndbeitrag() + aufpreis;
    }
}
