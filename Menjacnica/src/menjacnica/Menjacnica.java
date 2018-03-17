package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterface;

public class Menjacnica implements MenjacnicaInterface {
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
		if (!valute.contains(valuta)) {
			return;
		}

		for (int i = 0; i < valute.size(); i++) {
			if (valute.get(i).equals(valuta)) {
				valute.get(i).getKursevi().addFirst(kurs);
			}
		}
	}

	@Override
	public void obrisiKursValute(Valuta valuta, GregorianCalendar datum) {
		if (!valute.contains(valuta)) {
			return;
		}
		
		Valuta v = new Valuta();
		for (int i = 0; i < valute.size(); i++) {
			if (valute.get(i).equals(valuta)) {
				v = valute.get(i);
				break;
			}
		}
		
		for (int i = 0; i < v.getKursevi().size(); i++) {
			if(v.getKursevi().get(i).getDatum().equals(datum)) {
				v.getKursevi().remove(i);
			}
		}
	}

	@Override
	public Kurs vratiKursNaDan(Valuta valuta, GregorianCalendar datum) {
		if (!valute.contains(valuta)) {
			return null;
		}

		Valuta v = new Valuta();
		for (int i = 0; i < valute.size(); i++) {
			if (valute.get(i).equals(valuta)) {
				v = valute.get(i);
				break;
			}
		}
		
		for (int i = 0; i < v.getKursevi().size(); i++) {
			if(v.getKursevi().get(i).getDatum().equals(datum)) {
				return v.getKursevi().get(i);
			}
		}

		return null;
	}

}
