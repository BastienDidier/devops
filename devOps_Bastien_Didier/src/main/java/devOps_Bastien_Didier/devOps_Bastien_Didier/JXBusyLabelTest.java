package devOps_Bastien_Didier.devOps_Bastien_Didier;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXBusyLabel;

/**
 * Class JXBusyLabelTest main class of the application
 * a JXBusyLabelTest is composed of:
 * @see JComboBox
 * @see JButton
 * and inherit @see JFrame and implements @see ActionListener
 */
public class JXBusyLabelTest extends JFrame implements ActionListener {

  JXBusyLabel bLabel1;
	JComboBox comboBackground, comboForeground;
	JButton btnStart, btnStop;
	Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW};
	
	/**
	 * Constructor of JXBusyLabelTest
	 * initialize JXBusyLabelTest
	 */
	public JXBusyLabelTest() {
		bLabel1 = new JXBusyLabel(new Dimension(60, 60));
		bLabel1.setBusy(true);

		String[] colorsName = {"Choose a color", "BLACK", "WHITE", "RED", "BLUE", "GREEN", "GRAY", "YELLOW"};
		comboBackground = new JComboBox(colorsName);
		comboForeground = new JComboBox(colorsName);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");

		comboBackground.addActionListener(this);
		comboForeground.addActionListener(this);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);

		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		panelSouth.add(new JLabel("Background"));
		panelSouth.add(comboBackground);
		panelSouth.add(new JLabel("Foreground"));
		panelSouth.add(comboForeground);
		panelNorth.add(btnStart);
		panelNorth.add(btnStop);

		add(panelNorth, BorderLayout.NORTH);
		add(bLabel1, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		setSize(400, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * event listener of a JXBusyLabelTest
	 * if the source of the event is the background the base color change
	 * else if it s the foreground the highlight color change
	 * else if the button start is the source then the label is set to busy
	 * else if the button stop is the source then the label is free
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBackground) {
			bLabel1.getBusyPainter().setBaseColor(colors[comboBackground.getSelectedIndex()-1]);
		} else if (e.getSource() == comboForeground) {
			bLabel1.getBusyPainter().setHighlightColor(colors[comboForeground.getSelectedIndex()-1]);
		} else if (e.getSource() == btnStart) {
			bLabel1.setBusy(true);
		} else if (e.getSource() == btnStop) {
			bLabel1.setBusy(false);
		}
	}

	/**
	 * main method of JXBusyLabelTest
	 */
	public static void main(String[] args) {
		new JXBusyLabelTest();
	}

}