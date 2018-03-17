package menjacnica;

import java.util.LinkedList;

public class Valuta {
	private String naziv;
	private String skracenica;
	private LinkedList<Kurs> kursevi;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) throws Exception {
		if(naziv.isEmpty() || naziv == null) {
			throw new Exception("Greska pri unosu naziva valute");
		} else {
			this.naziv = naziv;
		}
	}

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) throws Exception {
		if(skracenica.isEmpty() || skracenica == null || skracenica.length() > 3) {
			throw new Exception("Skracenica valute je lose uneta");
		} else {
			this.skracenica = skracenica;
		}
	}

	public LinkedList<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(LinkedList<Kurs> kursevi) throws Exception {
		if(kursevi == null) {
			throw new Exception("Kursevi lose uneti");
		} else {
			this.kursevi = kursevi;
		}
	}

	@Override
	public String toString() {
		return "Valuta [naziv=" + naziv + ", skracenica=" + skracenica + ", kursevi=" + kursevi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kursevi == null) ? 0 : kursevi.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((skracenica == null) ? 0 : skracenica.hashCode());
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
		Valuta other = (Valuta) obj;
		if(other.getNaziv().equals(this.getNaziv())) {
			return true;
		}
		return false;
	}

}
