package kutyak;

import java.time.LocalDate;

public class Kutyak {

	private int id;
	private int fajtaId;
	private int nevId;
	private int eletKor;
	private LocalDate utolsoVizsgalat;

	public Kutyak(int id, int fajtaId, int nevId, int eletKor, LocalDate utolsoVizsgalat) {
		this.id = id;
		this.fajtaId = fajtaId;
		this.nevId = nevId;
		this.eletKor = eletKor;
		this.utolsoVizsgalat = utolsoVizsgalat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFajtaId() {
		return fajtaId;
	}

	public void setFajtaId(int fajtaId) {
		this.fajtaId = fajtaId;
	}

	public int getNevId() {
		return nevId;
	}

	public void setNevId(int nevId) {
		this.nevId = nevId;
	}

	public int getEletKor() {
		return eletKor;
	}

	public void setEletKor(int eletKor) {
		this.eletKor = eletKor;
	}

	public LocalDate getUtolsoVizsgalat() {
		return utolsoVizsgalat;
	}

	public void setUtolsoVizsgalat(LocalDate utolsoVizsgalat) {
		this.utolsoVizsgalat = utolsoVizsgalat;
	}

	@Override
	public String toString() {
		return "Kutya azonosító: " + this.id + ", fajta azonosító: " + this.fajtaId + ", név azonosító: " + this.nevId
				+ ", életkor: " + this.eletKor + ", utolsó viszgálat időpontja: "
				+ ((this.utolsoVizsgalat).toString()).replace("-", ".");
	}

}
