package de.itagile.beitragsrechner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

// Der monatliche Grundbeitrag berechnet sich aus kW * 1,3
// Versicherungssteuer = 19% des Grundbeitrags
// Endbeitrag = Grundbeitrag + Versicherungssteuer + eventuellen Aufpreis
// Frauen zahlen 10% Aufpreis auf den Grundbeitrag
public class PkwVertragTest {

    private final PkwVertrag golf = new PkwVertrag(100);
    private final PkwVertrag miniEnte = new PkwVertrag(5);

    @Test
    public void grundbeitragHaengtVonLeistungAb() throws Exception {
    	assertThat(golf.berechneGrundbeitragProMonat(), is(130.0));
    	assertThat(miniEnte.berechneGrundbeitragProMonat(), is(6.5));
    }

    @Test
    public void endbeitragHaengtVonLeistungAb() throws Exception {
    	assertThat(golf.berechneEndbeitrag(), is(154.7));
    	assertThat(miniEnte.berechneEndbeitrag(), is(7.735));
    }

    @Test
    public void endbeitragFuerFrauenIstHoeher() throws Exception {
    	assertThat(golf.berechneEndbeitragFuerFrau(), is(167.7));
    	assertThat(miniEnte.berechneEndbeitragFuerFrau(), is(8.385));
    }
}
