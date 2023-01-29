package kutyak;

public class KutyaFajtak {

	private int id;
	private String nev;
	private String eredetiNev;

	public KutyaFajtak(int id, String nev, String eredetiNev) {
		this.id = id;
		this.nev = nev;
		this.eredetiNev = eredetiNev;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getEredetiNev() {
		return eredetiNev;
	}

	public void setEredetiNev(String eredetiNev) {
		this.eredetiNev = eredetiNev;
	}

	@Override
	public String toString() {
		return "Kutya azonosító: " + this.id + ", fajta neve: " + this.nev + ", a fajta eredeti neve: "
				+ this.eredetiNev;
	}

}
