package kutyak;

public class KutyaNevek {

	private int id;
	private String kutyaNeve;

	public KutyaNevek(int id, String kutyaNeve) {
		this.id = id;
		this.kutyaNeve = kutyaNeve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKutyaNeve() {
		return kutyaNeve;
	}

	public void setKutyaNeve(String kutyaNeve) {
		this.kutyaNeve = kutyaNeve;
	}

	@Override
	public String toString() {
		return "Kutya azonosító: " + this.id + ", a kutya neve: " + this.kutyaNeve;
	}

}
