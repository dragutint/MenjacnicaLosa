package menjacnica.interfejs;

import java.util.GregorianCalendar;

import menjacnica.Kurs;
import menjacnica.Valuta;

public interface MenjacnicaInterface {
	public void dodajKursValute(Valuta valuta, GregorianCalendar datum, Kurs kurs);
	public void obrisiKursValute(Valuta valuta, GregorianCalendar datum);
	public Kurs vratiKursNaDan(Valuta valuta, GregorianCalendar datum);
	
}
