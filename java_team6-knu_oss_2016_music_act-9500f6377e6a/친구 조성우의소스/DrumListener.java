import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Tool;

public class DrumListener extends Listener {
	Tool TestTool1;
	Tool TestTool2;

	Finger Lfinger;
	Finger Rfinger; // main finger that is pressing keys
	Frame frame;
	double volume = 1;
	
	Clip clip;
	File drum1 = new File("sounds/Drumkit_kick.wav");
	File drum2 = new File("sounds/Snare.wav");
	File drum3 = new File("sounds/Symbol_1.wav");
	File drum4 = new File("sounds/Symbol_2.wav");
	File drum5 = new File("sounds/Symbol_3.wav");

	ArrayList<Float> calibratingValues = new ArrayList<Float>();
	String state = "none";

	int number;
	boolean[] Ravail = { false, false, false, false, false };
	boolean[] Lavail = { false, false, false, false, false };
	AudioInputStream ais;
	int xAxisMin = -200;
	int xAxisMax = 200;
	int numTapAreas = 5;
	int tapAreaSize = (xAxisMax - xAxisMin) / numTapAreas;

	Thread t;

	double currentLFingerX = 0;
	double currentLFingerY = 0;
	double currentRFingerX = 0;
	double currentRFingerY = 0;

	public void onInit(Controller controller) {
		System.out.println("");
	}

	public void onDisConnect(Controller controller) {
		
	}

	public void onExit(Controller controller) {
	
	}

	public void onConnect(Controller controller) {
	


	}

	public void onFrame(Controller controller) {

		int i = 6;
		int j = 7;
		frame = controller.frame();

		TestTool1 = frame.tools().get(0);
		TestTool2 = frame.tools().get(1);

		Lfinger = frame.hands().get(0).fingers().get(0);

		Rfinger = frame.hands().get(1).fingers().get(0);

		MainClass.window.visualizerPanel.repaint();

		currentRFingerX = TestTool1.tipPosition().getX();
		currentRFingerY = TestTool1.tipPosition().getY();

		currentLFingerX = TestTool2.tipPosition().getX();
		currentLFingerY = TestTool2.tipPosition().getY();

		MainClass.window.visualizerPanel.setLFingerX((int) map((long) currentLFingerX,
				xAxisMin, xAxisMax, 0, 800));

		MainClass.window.visualizerPanel.setLFingerY(520 - (int) map((long) currentLFingerY,
				20, 250, 0, 520));

		MainClass.window.visualizerPanel.setRFingerX((int) map((long) currentRFingerX,
				xAxisMin, xAxisMax, 0, 800));

		MainClass.window.visualizerPanel.setRFingerY(520 - (int) map((long) currentRFingerY,
				20, 250, 0, 520));

		i = ((int) currentRFingerX + xAxisMax) / tapAreaSize;


		if (((currentRFingerY > 50 && currentRFingerY < 150))
				&& (currentRFingerY != 0) && (currentLFingerY != 0)) {

			switch (i) {
			case 0:

				if (!Ravail[i]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum1);

						clip = AudioSystem.getClip();

						clip.open(ais);

						clip.start();
						Ravail[i] = true;

					} catch (Exception e) {
					}
				}
				break;

			case 1:

				if (!Ravail[i]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum2);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Ravail[i] = true;

					} catch (Exception e) {
					}

				}
				break;
			case 2:
				if (!Ravail[i]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum3);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Ravail[i] = true;

					} catch (Exception e) {
					}
				}
				break;

			case 3:
				if (!Ravail[i]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum4);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Ravail[i] = true;

					} catch (Exception e) {
					}

				}
				break;
			case 4:
				if (!Ravail[i]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum5);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Ravail[i] = true;

					} catch (Exception e) {
					}
				}
				break;
			}

		}

		else
			Ravail[i] = false;

		j = ((int) currentLFingerX + xAxisMax) / tapAreaSize;

		if ((currentLFingerY > 50 && currentLFingerY < 150)
				&& currentLFingerY != 0 && currentRFingerY != 0) {

			switch (j) {
			case 0:

				if (!Lavail[j]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum1);

						clip = AudioSystem.getClip();

						clip.open(ais);

						clip.start();
						Lavail[j] = true;

					} catch (Exception e) {
					}
				}
				break;

			case 1:

				if (!Lavail[j]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum2);

						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Lavail[j] = true;

					} catch (Exception e) {
					}

				}
				break;
			case 2:
				if (!Lavail[j]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum3);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Lavail[j] = true;

					} catch (Exception e) {
					}
				}
				break;

			case 3:
				if (!Lavail[j]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum4);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Lavail[j] = true;

					} catch (Exception e) {
					}

				}
				break;
			case 4:
				if (!Lavail[j]) {
					try {
						ais = AudioSystem.getAudioInputStream(drum5);
						clip = AudioSystem.getClip();
						clip.open(ais);
						clip.start();
						Lavail[j] = true;

					} catch (Exception e) {
					}
				}
				break;
			}

		} else
			Lavail[j] = false;
	}

	public long map(long x, long in_min, long in_max, long out_min, long out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

}