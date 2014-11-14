/**
 * @author Marcos Vinicius Berté
 *
 */

import java.io.File;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\usuario\\Desktop\\assembly\\ass.txt");

		Assembler ass = new Assembler(file);
		ass.compile();
		ass.printTest();
	}

}
