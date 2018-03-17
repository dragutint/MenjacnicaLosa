package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterface;

public class Menjacnica implements MenjacnicaInterface{
	private String naziv;
	private LinkedList<Valuta> valute;

	@Override
	public String toString() {
		return "Menjacnica [naziv=" + naziv + ", valute=" + valute + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((valute == null) ? 0 : valute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menjacnica other = (Menjacnica) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (valute == null) {
			if (other.valute != null)
				return false;
		} else if (!valute.equals(other.valute))
			return false;
		return true;
	}

	@Override
	public void dodajKursValute(Valuta valuta, Kurs kurs) {
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).equals(valuta)) {
				valute.get(i).getKursevi().addLast(kurs);
				break;
			}
		}
	}

	@Override
	public void obrisiKursValute(Valuta valuta, GregorianCalendar datum) {
		for (int i = 0; i < valute.size(); i++) {
			if( valute.get(i).equals(valuta)) {
				for (int j = 0; j < valute.get(i).getKursevi().size(); j++) {
					if( valute.get(i).getKursevi().get(j).getDatum().equals(datum)) {
						valute.get(i).getKursevi().remove(j);
						return;
					}
				}
			}
		}
	}

	@Override
	public Kurs vratiKursNaDan(Valuta valuta, GregorianCalendar datum) {
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).equals(valuta)) {
				for (int j = 0; j < valute.get(i).getKursevi().size(); j++) {
					if(valute.get(i).getKursevi().get(j).getDatum().equals(datum)) {
						return valute.get(i).getKursevi().get(j);
					}
				}
			}
		}
		return null;
	}

}
