package kutyak;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class KutyakFeladat {

	private JFrame frmKutyak;
	private JList lstKiiras;
	private FajlKezeles fajl = new FajlKezeles();
	private List<Kutyak> kutyak;
	private List<KutyaFajtak> kutyaFajtak;
	private List<KutyaNevek> kutyaNevek;
	private DefaultListModel<Kutyak> kutyakModel;
	private DefaultListModel<KutyaFajtak> kutyaFajtakModel;
	private DefaultListModel<KutyaNevek> kutyaNevekModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					KutyakFeladat window = new KutyakFeladat();
					window.frmKutyak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KutyakFeladat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKutyak = new JFrame();
		frmKutyak.getContentPane().setFont(new Font("Verdana", Font.BOLD, 11));
		frmKutyak.getContentPane().setBackground(new Color(240, 255, 255));
		frmKutyak.getContentPane().setLayout(null);

		kutyak = new ArrayList<Kutyak>();
		kutyaFajtak = new ArrayList<KutyaFajtak>();
		kutyaNevek = new ArrayList<KutyaNevek>();

		kutyakModel = new DefaultListModel<Kutyak>();
		kutyaFajtakModel = new DefaultListModel<KutyaFajtak>();
		kutyaNevekModel = new DefaultListModel<KutyaNevek>();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 373, 491);
		frmKutyak.getContentPane().add(scrollPane);

		lstKiiras = new JList();
		lstKiiras.setForeground(new Color(0, 0, 0));
		lstKiiras.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lstKiiras.setBackground(new Color(245, 255, 250));
		scrollPane.setViewportView(lstKiiras);

		BeolvasKutyaListat();
		BeolvasKutyaFajtakat();
		BeolvasKutyaNeveket();

		JButton btnKutyakLista = new JButton("Kutyák listája");
		btnKutyakLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KutyaListaFeltoltes();

			}
		});
		btnKutyakLista.setBackground(new Color(248, 248, 255));
		btnKutyakLista.setForeground(new Color(0, 0, 128));
		btnKutyakLista.setFont(new Font("Verdana", Font.BOLD, 12));
		btnKutyakLista.setBounds(390, 20, 130, 30);
		frmKutyak.getContentPane().add(btnKutyakLista);

		JButton btnKutyaFajtak = new JButton("Kutyafajták");
		btnKutyaFajtak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KutyaFajtaListaFeltoltes();

			}
		});
		btnKutyaFajtak.setForeground(new Color(0, 0, 128));
		btnKutyaFajtak.setFont(new Font("Verdana", Font.BOLD, 12));
		btnKutyaFajtak.setBackground(new Color(248, 248, 255));
		btnKutyaFajtak.setBounds(390, 72, 130, 30);
		frmKutyak.getContentPane().add(btnKutyaFajtak);

		JButton btnKutyaNevek = new JButton("Kutyák nevei");
		btnKutyaNevek.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KutyaNevekListaFeltoltes();

			}
		});
		btnKutyaNevek.setForeground(new Color(0, 0, 128));
		btnKutyaNevek.setFont(new Font("Verdana", Font.BOLD, 12));
		btnKutyaNevek.setBackground(new Color(248, 248, 255));
		btnKutyaNevek.setBounds(390, 125, 130, 30);
		frmKutyak.getContentPane().add(btnKutyaNevek);

		JButton btnHarmadikF = new JButton("3. feladat");
		btnHarmadikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HarmadikFeladat();
			}
		});
		btnHarmadikF.setBackground(new Color(255, 255, 255));
		btnHarmadikF.setForeground(new Color(0, 51, 153));
		btnHarmadikF.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 12));
		btnHarmadikF.setBounds(410, 182, 100, 25);
		frmKutyak.getContentPane().add(btnHarmadikF);

		JButton btnHatodikF = new JButton("6. feladat");
		btnHatodikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HatodikFeladat();

			}
		});
		btnHatodikF.setForeground(new Color(0, 51, 153));
		btnHatodikF.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 12));
		btnHatodikF.setBackground(Color.WHITE);
		btnHatodikF.setBounds(410, 237, 100, 25);
		frmKutyak.getContentPane().add(btnHatodikF);

		JButton btnHetedikF = new JButton("7. feladat");
		btnHetedikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HetedikFeladat();
			}
		});
		btnHetedikF.setForeground(new Color(0, 51, 153));
		btnHetedikF.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 12));
		btnHetedikF.setBackground(Color.WHITE);
		btnHetedikF.setBounds(410, 286, 100, 25);
		frmKutyak.getContentPane().add(btnHetedikF);

		JButton btnNyolcadikF = new JButton("8. feladat");
		btnNyolcadikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				NyolcadikFeladat();

			}
		});
		btnNyolcadikF.setForeground(new Color(0, 51, 153));
		btnNyolcadikF.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 12));
		btnNyolcadikF.setBackground(Color.WHITE);
		btnNyolcadikF.setBounds(410, 338, 100, 25);
		frmKutyak.getContentPane().add(btnNyolcadikF);

		JButton btnKilencedikF = new JButton("9. feladat");
		btnKilencedikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				KilencedikFeladat();

			}
		});
		btnKilencedikF.setForeground(new Color(0, 51, 153));
		btnKilencedikF.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 12));
		btnKilencedikF.setBackground(Color.WHITE);
		btnKilencedikF.setBounds(410, 388, 100, 25);
		frmKutyak.getContentPane().add(btnKilencedikF);

		JButton btnTizedikF = new JButton("10. feladat");
		btnTizedikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TizedikFeladat();

			}
		});
		btnTizedikF.setForeground(new Color(0, 51, 153));
		btnTizedikF.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 12));
		btnTizedikF.setBackground(Color.WHITE);
		btnTizedikF.setBounds(410, 436, 100, 25);
		frmKutyak.getContentPane().add(btnTizedikF);
		frmKutyak.setBackground(new Color(240, 255, 255));
		frmKutyak.setTitle("Kutyák vizsgafeladat");
		frmKutyak.setBounds(100, 100, 550, 550);
		frmKutyak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void TizedikFeladat() {

		Feladatok feladat = new Feladatok();
		feladat.NevStatisztika(kutyak, kutyaNevek);

	}

	private void KilencedikFeladat() {

		Feladatok feladat = new Feladatok();
		feladat.LeglatogatottabNap(kutyak);

	}

	private void NyolcadikFeladat() {

		Feladatok feladat = new Feladatok();
		feladat.DatumraKeres(kutyak, kutyaFajtak);

	}

	private void HetedikFeladat() {

		Feladatok feladat = new Feladatok();
		feladat.KikeresLegidosebbet(kutyak, kutyaNevek, kutyaFajtak);

	}

	private void HatodikFeladat() {

		Feladatok feladat = new Feladatok();
		feladat.AtlagEletkortSzamol(kutyak);

	}

	private void HarmadikFeladat() {

		JOptionPane.showMessageDialog(frmKutyak, "A kutyanevek száma: " + String.valueOf(kutyaNevek.size()),
				"3. feldat", JOptionPane.PLAIN_MESSAGE);

	}

	private void BeolvasKutyaNeveket() {

		kutyaNevek = fajl.BeolvasKutyaNeveket("F:\\Kurs\\Feladatok\\Kutyak\\KutyaNevek.csv", ";");

	}

	private void BeolvasKutyaFajtakat() {

		kutyaFajtak = fajl.BeolvasKutyaFajtakat("F:\\Kurs\\Feladatok\\Kutyak\\KutyaFajtak.csv", ";");

	}

	private void BeolvasKutyaListat() {

		kutyak = fajl.BeolvasKutyaListat("F:\\Kurs\\Feladatok\\Kutyak\\Kutyak.csv", ";");

	}

	private void KutyaListaFeltoltes() {

		for (Kutyak kutya : kutyak) {
			kutyakModel.addElement(kutya);
		}
		lstKiiras.setModel(kutyakModel);
	}

	private void KutyaFajtaListaFeltoltes() {

		for (KutyaFajtak kutyaFajta : kutyaFajtak) {
			kutyaFajtakModel.addElement(kutyaFajta);
		}
		lstKiiras.setModel(kutyaFajtakModel);
	}

	private void KutyaNevekListaFeltoltes() {

		for (KutyaNevek kutyaNev : kutyaNevek) {
			kutyaNevekModel.addElement(kutyaNev);
		}
		lstKiiras.setModel(kutyaNevekModel);
	}
}
