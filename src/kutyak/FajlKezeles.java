package kutyak;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FajlKezeles {

	public List<Kutyak> BeolvasKutyaListat(String fajlNev, String elvalaszto) {

		List<Kutyak> kutyaLista = new ArrayList<Kutyak>();

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlNev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] db = br.readLine().split(elvalaszto);

				Kutyak kutya = new Kutyak(Integer.parseInt(db[0]), Integer.parseInt(db[1]), Integer.parseInt(db[2]),
						Integer.parseInt(db[3]), LocalDate.parse((db[4]).replace(".", "-")));

				kutyaLista.add(kutya);

			}
			br.close();

		} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(null, "Helytelen kódolású fájl!", "Hiba történt!", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "A megadott fájl nem található!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok beolvasásakor!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		}

		return kutyaLista;
	}

	public List<KutyaFajtak> BeolvasKutyaFajtakat(String fajlNev, String elvalaszto) {

		List<KutyaFajtak> kutyaFajtaLista = new ArrayList<KutyaFajtak>();

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlNev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] db = br.readLine().split(elvalaszto);

				KutyaFajtak kutyaFajta = new KutyaFajtak(Integer.parseInt(db[0]), db[1], db[2]);

				kutyaFajtaLista.add(kutyaFajta);
			}

			br.close();

		} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(null, "Helytelen kódolású fájl!", "Hiba történt!", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "A megadott fájl nem található!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok beolvasásakor!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		}

		return kutyaFajtaLista;
	}

	public List<KutyaNevek> BeolvasKutyaNeveket(String fajlNev, String elvalaszto) {

		List<KutyaNevek> kutyaNevekLista = new ArrayList<KutyaNevek>();

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlNev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] db = br.readLine().split(elvalaszto);

				KutyaNevek kutyaNev = new KutyaNevek(Integer.parseInt(db[0]), db[1]);
				kutyaNevekLista.add(kutyaNev);

			}
			br.close();

		} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(null, "Helytelen kódolású fájl!", "Hiba történt!", JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "A megadott fájl nem található!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok beolvasásakor!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		}

		return kutyaNevekLista;
	}

	public void FajlbaIras(StringBuilder szoveg, String fajlNev) {

		try {

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlNev, false), "UTF-8");

			out.write(szoveg.toString());

			out.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépett fel az adatok fájlba mentésekor!", "Hiba történt!",
					JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "A statisztika fálba írása sikeresen megtörtént.", "10. feladat",
				JOptionPane.INFORMATION_MESSAGE);

	}

}
