import javax.imageio.ImageIO;
import javax.swing.*;

import com.leapmotion.leap.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

public class GUI {
	JFrame frmLeapInstrument;
	public LeapVisualizerPanel visualizerPanel;
	MyListener buttonlistener = new MyListener();

	private JButton btnPiano;
	private JButton btnBass;
	private JButton btnGuitar;
	private JButton btnDrum;
	private JButton btnStop;

	boolean P = true;
	boolean B = true;
	boolean G = true;
	boolean D = true;

	JPanel panel;
	JPanel Dpanel;
	JLabel label;
	JLabel Dlabel;
	ImageIcon Piano = new ImageIcon("image/pianoPannel.gif");
	ImageIcon Guitar = new ImageIcon("image/guitarPannel.gif");
	ImageIcon Bass = new ImageIcon("image/bassPannel.gif");
	ImageIcon Drum = new ImageIcon("image/drumPannel.gif");

	ImageIcon piano = new ImageIcon("image/piano.gif");
	ImageIcon guitar = new ImageIcon("image/guitar.gif");
	ImageIcon bass = new ImageIcon("image/bass.gif");
	ImageIcon drum = new ImageIcon("image/drum.gif");
	ImageIcon stop = new ImageIcon("image/stop.gif");

	public GUI() {
		initialize();
	}

	private void initialize() {
		frmLeapInstrument = new JFrame(); // JFrame
		frmLeapInstrument.setTitle("Motion Band");
		frmLeapInstrument.setResizable(false);
		frmLeapInstrument.setBounds(100, 100, 800, 600);
		frmLeapInstrument.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeapInstrument.getContentPane().setLayout(null);

		JLabel lblLeapInstrument = new JLabel("Motion Band"); // JLabel
		// "leap Instrument"
		lblLeapInstrument.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblLeapInstrument.setBounds(330, 6, 187, 45);
		frmLeapInstrument.getContentPane().add(lblLeapInstrument);

		visualizerPanel = new LeapVisualizerPanel(); // visualizer
		visualizerPanel.setBounds(-18, 131, 800, 393);
		
		frmLeapInstrument.getContentPane().add(visualizerPanel);

		btnPiano = new JButton(piano);
		btnPiano.setBounds(11, 70, 156, 100);
		frmLeapInstrument.getContentPane().add(btnPiano);
		btnPiano.addActionListener(buttonlistener);

		btnBass = new JButton(bass);
		btnBass.setBounds(167, 70, 156, 100);
		frmLeapInstrument.getContentPane().add(btnBass);
		btnBass.addActionListener(buttonlistener);

		btnGuitar = new JButton(guitar);
		btnGuitar.setBounds(323, 70, 156, 100);
		frmLeapInstrument.getContentPane().add(btnGuitar);
		btnGuitar.addActionListener(buttonlistener);

		btnDrum = new JButton(drum);
		btnDrum.setBounds(479, 70, 156, 100);
		frmLeapInstrument.getContentPane().add(btnDrum);
		btnDrum.addActionListener(buttonlistener);

		btnStop = new JButton(stop);
		btnStop.setBounds(635, 70, 148, 100);
		frmLeapInstrument.getContentPane().add(btnStop);
		btnStop.addActionListener(buttonlistener);

		panel = new JPanel();
		panel.setBounds(0, 176, 800, 347);
		frmLeapInstrument.getContentPane().add(panel);

		label = new JLabel();
		panel.add(label);

		Dpanel = new JPanel();
		Dpanel.setBounds(0,400,800,100);
		frmLeapInstrument.getContentPane().add(Dpanel);
		
		Dlabel= new JLabel();
		Dpanel.add(Dlabel);
	}

	public class MyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Thread p = new Thread(new PThread());
			Thread g = new Thread(new GThread());
			Thread d = new Thread(new DThread());
			Thread b = new Thread(new BThread());

			Object obj = e.getSource();
			if (obj.equals(btnPiano)) {
				label.setIcon(Piano);
				P = true;
				G = false;
				B = false;
				D = false;
				p.start();

			}
			if (e.getSource() == btnGuitar) {
				label.setIcon(Guitar);
				P = false;
				G = true;
				B = false;
				D = false;
				g.start();

			}
			if (e.getSource() == btnBass) {
				label.setIcon(Bass);
				P = false;
				G = false;
				B = true;
				D = false;
				b.start();

			}
			if (e.getSource() == btnDrum) {
				
				label.setIcon(Drum);
				
				P = false;
				G = false;
				B = false;
				D = true;
				d.start();

			}

			if (e.getSource() == btnStop) {
				label.setIcon(null);
				P = false;
				G = false;
				B = false;
				D = false;
				System.out.println("Stop");
			}

		}

		class PThread implements Runnable {
			public void run() {
				PianoListener Plistener = new PianoListener();
				Controller controller = new Controller();

				controller.addListener(Plistener);

				while (true) {
					System.out.printf("");
					if (P == false) {
						controller.removeListener(Plistener);
						break;
					}

				}
			}
		}

		class BThread implements Runnable {
			public void run() {
				BassListener Blistener = new BassListener();
				Controller controller = new Controller();

				controller.addListener(Blistener);

				while (true) {
					System.out.printf("");

					if (B == false) {
						controller.removeListener(Blistener);
						break;
					}

				}

			}
		}

		class GThread implements Runnable {
			public void run() {
				GuitarListener Glistener = new GuitarListener();
				Controller controller = new Controller();
				controller.addListener(Glistener);

				while (true) {
					System.out.printf("");
					if (G == false) {

						controller.removeListener(Glistener);
						break;
					}

				}

			}
		}

		class DThread implements Runnable {
			public void run() {
				DrumListener Dlistener = new DrumListener();
				Controller controller = new Controller();

				controller.addListener(Dlistener);

				while (true) {
					System.out.printf("");

					if (D == false) {

						controller.removeListener(Dlistener);
						break;
					}

				}

			}
		}

	}
}

class LeapVisualizerPanel extends JComponent { // component for drawing stuff
	private static final long serialVersionUID = 1337L;
	int LfingerX, LfingerY; // x and y coords for circle

	int RfingerX, RfingerY;

	public LeapVisualizerPanel() {
	}

	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
	
		ImageIcon Drum = new ImageIcon("image/drumPannel.gif");
		g2d.drawImage(Drum.getImage(),800,600,this);
		setOpaque(false);
		
		//g2d.setColor(Color.white);
		//g2d.fillRect(30, 50, 800, 600);

		Point2D center = new Point2D.Float(20, 20);
		float radius = 20;
		float[] distribution = { 0.0f, 1.0f };

		Color[] colors1 = { Color.black, Color.blue };

		Color[] colors2 = { Color.black, Color.red };

		RadialGradientPaint gradient1 = new RadialGradientPaint(center, radius,
				distribution, colors1);

		RadialGradientPaint gradient2 = new RadialGradientPaint(center, radius,
				distribution, colors2);

		if (!(LfingerX == 0 && LfingerY == 0)) {
			g2d.setPaint(gradient1);
			g2d.fillOval(LfingerX, LfingerY, 20, 20);
		}

		if (!(RfingerX == 0 && RfingerY == 0)) {
			g2d.setPaint(gradient2);
			g2d.fillOval(RfingerX, RfingerY, 20, 20);
		}
	}

	public int getLFingerX() {
		return LfingerX;
	}

	public void setLFingerX(int fingerX) {
		this.LfingerX = fingerX;
	}

	public int getLFingerY() {
		return LfingerY;
	}

	public void setLFingerY(int fingerY) {
		this.LfingerY = fingerY;
	}

	public int getRFingerX() {
		return RfingerX;
	}

	public void setRFingerX(int fingerX) {
		this.RfingerX = fingerX;
	}

	public int getRFingerY() {
		return RfingerY;
	}

	public void setRFingerY(int fingerY) {
		this.RfingerY = fingerY;
	}
}