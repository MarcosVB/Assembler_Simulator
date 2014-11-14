/**
 * @author Marcos Vinicius Berté
 *
 */

import java.awt.*;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class TextFrame {

	public static void main(String[] args) throws PrinterException, IOException {
		JFrame frame = new JFrame();
		JFrame frame2 = new JFrame();
		JFrame frame3 = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(new Dimension(300, 500));
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(new FlowLayout());
		frame2.setSize(new Dimension(500, 500));
		frame2.setLocationRelativeTo(null);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setLayout(new FlowLayout());
		frame3.setSize(new Dimension(300, 500));
		frame.setLocation(frame2.getX() - 300, frame2.getY());
		frame3.setLocation(frame2.getX() + 500, frame2.getY());

		String local = JOptionPane.showInputDialog(null,
				"Enter the location of the assembly file \n EX: C:\\Users\\usuario\\Desktop\\ass.txt", "Assembler", 1);

		while (local.equals("")) {
			JOptionPane.showMessageDialog(null, "Location uninformed");
			local = JOptionPane.showInputDialog(null,
					"Enter the location of the assembly file \n EX: C:\\Users\\usuario\\Desktop\\ass.txt", "Assembler",
					1);
		}

		File file;
		file = new File(local);

		Assembler ass = new Assembler(file);
		ass.compile();

		frame.setTitle("Signals for ALU");
		frame2.setTitle("Result");
		frame3.setTitle("Binary Only");

		JTextArea areaSig = new JTextArea();
		JTextArea areaRes = new JTextArea();
		JTextArea areaBin = new JTextArea();
		frame.add(areaSig);
		frame2.add(areaRes);
		frame3.add(areaBin);

		areaSig.insert(ass.printSignals(), 0);
		areaRes.insert(ass.print(), 0);
		areaBin.insert(ass.printBinary(), 0);

		frame.setVisible(true);
		frame2.setVisible(true);
		frame3.setVisible(true);
	}
}