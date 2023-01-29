package kutyak;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Feladatok {

	public void AtlagEletkortSzamol(List<Kutyak> kutyak) {

		double osszeg = 0.0;
		double atlag;

		for (Kutyak item : kutyak) {
			osszeg += item.getEletKor();
		}
		atlag = osszeg / kutyak.size();

		String atlagSzoveg = String.format("%.2f", atlag);

		JOptionPane.showMessageDialog(null, "A kutyák átlagéletkora: " + atlagSzoveg, "6. feladat",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void KikeresLegidosebbet(List<Kutyak> kutyak, List<KutyaNevek> kutyaNevek, List<KutyaFajtak> kutyaFajtak) {

		int legidosebb = 0;

		for (int i = 0; i < kutyak.size(); i++) {
			if (kutyak.get(i).getEletKor() > kutyak.get(legidosebb).getEletKor()) {
				legidosebb = i;
			}
		}

		int kutyaNev = 0;
		int kutyaFajtaja = 0;

		for (int i = 0; i < kutyaNevek.size(); i++) {
			for (int j = 0; j < kutyaFajtak.size(); j++) {
				if (kutyak.get(legidosebb).getId() == kutyaNevek.get(i).getId()
						&& (kutyak.get(legidosebb).getId() == kutyaFajtak.get(j).getId())) {

					kutyaNev = i;
					kutyaFajtaja = j;
				}
			}
		}

		JOptionPane.showMessageDialog(null, "A legidősebb kutya neve és fajtája: "
				+ kutyaNevek.get(kutyaNev).getKutyaNeve() + ", " + kutyaFajtak.get(kutyaFajtaja).getNev(), "7. feladat",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void DatumraKeres(List<Kutyak> kutyak, List<KutyaFajtak> kutyaFajtak) {

		LocalDate keresettDatum = LocalDate.parse("2018-01-10");
		Map<KutyaFajtak, Integer> keresettKutya = new HashMap<KutyaFajtak, Integer>();

		for (Kutyak kutya : kutyak) {
			for (KutyaFajtak fajta : kutyaFajtak) {
				if (kutya.getUtolsoVizsgalat().isEqual(keresettDatum) && kutya.getFajtaId() == fajta.getId()) {
					keresettKutya.put(fajta, 0);
				}

			}
		}

		for (Kutyak kutya : kutyak) {
			for (Map.Entry<KutyaFajtak, Integer> item : keresettKutya.entrySet()) {
				if (kutya.getUtolsoVizsgalat().isEqual(keresettDatum) && kutya.getFajtaId() == item.getKey().getId()) {
					item.setValue((item.getValue() + 1));
				}
			}
		}

		StringBuilder kiiras = new StringBuilder();

		for (Map.Entry<KutyaFajtak, Integer> item : keresettKutya.entrySet()) {
			kiiras.append((item.getKey().getNev() + ": " + item.getValue() + " kutya\n"));
		}

		JOptionPane.showMessageDialog(null, "Január 10-én vizsgált kutya fajták:\n" + kiiras, "8. feladat",
				JOptionPane.PLAIN_MESSAGE);

	}

	public void LeglatogatottabNap(List<Kutyak> kutyak) {

		Map<LocalDate, Integer> keresettNap = new HashMap<LocalDate, Integer>();
		List<Integer> latogatasSzamok = new ArrayList<Integer>();

		for (Kutyak item : kutyak) {
			keresettNap.put(item.getUtolsoVizsgalat(), 0);
		}

		for (Kutyak kutya : kutyak) {
			for (Map.Entry<LocalDate, Integer> item : keresettNap.entrySet()) {
				if (item.getKey().isEqual(kutya.getUtolsoVizsgalat())) {
					item.setValue((item.getValue() + 1));
				}
			}
		}

		for (Map.Entry<LocalDate, Integer> item : keresettNap.entrySet()) {
			latogatasSzamok.add(item.getValue());
		}

		int max = 0;

		for (int i = 0; i < latogatasSzamok.size(); i++) {
			if (latogatasSzamok.get(i) > latogatasSzamok.get(max)) {
				max = i;
			}
		}
		LocalDate keresettDatum = null;

		for (Map.Entry<LocalDate, Integer> item : keresettNap.entrySet()) {
			if (item.getValue().compareTo(latogatasSzamok.get(max)) == 0) {
				keresettDatum = item.getKey();
			}
		}

		JOptionPane.showMessageDialog(null, "Legjobban leterhelt nap: " + (keresettDatum.toString()).replace("-", ".")
				+ ": " + latogatasSzamok.get(max) + "kutya", "9. feladat", JOptionPane.PLAIN_MESSAGE);
	}

	public void NevStatisztika(List<Kutyak> kutyak, List<KutyaNevek> kutyaNevek) {

		Map<String, Integer> statisztika = new HashMap<String, Integer>();

		for (KutyaNevek kutyaNev : kutyaNevek) {
			statisztika.put(kutyaNev.getKutyaNeve(), 0);
		}

		for (Kutyak kutya : kutyak) {
			for (KutyaNevek kutyaNevek2 : kutyaNevek) {
				for (Map.Entry<String, Integer> item : statisztika.entrySet()) {
					if (kutya.getNevId() == kutyaNevek2.getId() && kutyaNevek2.getKutyaNeve().equals(item.getKey())) {
						item.setValue((item.getValue() + 1));
					}
				}
			}
		}

		StringBuilder szoveg = new StringBuilder();

		statisztika.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(f -> szoveg.append(f.getKey() + ";" + f.getValue() + "\n"));
		;

		FajlKezeles fajl = new FajlKezeles();
		fajl.FajlbaIras(szoveg, "F:\\Kurs\\Feladatok\\Kutyak\\nevstatisztika.txt");
	}

}
