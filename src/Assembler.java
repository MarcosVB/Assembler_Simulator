/**
 * @author Marcos Vinicius Berté
 *
 */

import java.io.File;
import java.io.IOException;

public class Assembler {
	private String[] addresses;
	private Types[] types;
	private int numElements;
	private String[] lines;
	private File file;

	public Assembler(File file) {
		this.file = file;
		this.types = new Types[(int) (file.length() / 2)];
		this.addresses = setAddresses();
		this.numElements = 0;
	}

	public void compile() throws IOException {
		Reader r = new Reader();
		this.lines = r.readFile(file);
		for (int i = 0; i < lines.length; i++) {
			createType(lines[i], i);
		}
	}

	private void createType(String temp, int i) {
		String line = temp.replaceAll(",", "");
		line = line.replaceAll("[)(]", " ");
		String[] aux = line.split(" ");
		if (!(Exchange.getOperations(aux[0]) == null)) {
			if (Exchange.getCheckType(aux[0]).equals("R")) {
				switch (aux[0]) {
				case "not": {
					types[numElements] = new RType("nor", aux[1], aux[1], "$zero");
					numElements++;
					break;
				}
				default: {
					types[numElements] = new RType(aux[0], aux[1], aux[2], aux[3]);
					numElements++;
					break;
				}
				}
			} else {
				if (Exchange.getCheckType(aux[0]).equals("I")) {
					switch (aux[0]) {
					case "subi": {
						types[numElements] = new IType(aux[0], aux[1], aux[2], -1 * (Integer.parseInt(aux[3])));
						numElements++;
						break;
					}
					case "lw": {
						types[numElements] = new IType(aux[0], aux[3], aux[1], Integer.parseInt(aux[2]));
						numElements++;
						break;
					}
					case "sw": {
						types[numElements] = new IType(aux[0], aux[3], aux[1], Integer.parseInt(aux[2]));
						numElements++;
						break;
					}
					case "beq": {
						types[numElements] = new IType(aux[0], aux[1], aux[2], Integer.parseInt(addresses[i]
								.substring(2)), Integer.parseInt(findTarget(aux[3]).substring(2), 16));
						numElements++;
						break;
					}
					default: {
						types[numElements] = new IType(aux[0], aux[1], aux[2], Integer.parseInt(aux[3]));
						numElements++;
						break;
					}

					}

				} else {
					if (Exchange.getCheckType(aux[0]).equals("J")) {
						types[numElements] = new JType(aux[0], Integer.parseInt(addresses[i].substring(2)),
								Integer.parseInt(findTarget(aux[2])));
						numElements++;
					}
				}
			}
		}
	}

	private String findTarget(String target) {
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith(target)) {
				return addresses[i];
			}
		}
		return null;
	}

	private String[] setAddresses() {
		String[] nAddr = new String[types.length];
		String aux = "";
		for (int i = 0; i < types.length; i++) {
			aux = Integer.toHexString(i * 4);
			while (aux.length() < 8) {
				aux = insert(aux, "0");
			}
			aux = insert(aux, "0x");
			nAddr[i] = aux;
		}
		return nAddr;
	}

	private static String insert(String r, String string) {
		return string += r;
	}

	public void printTest() {
		for (int i = 0; i < numElements; i++) {
			System.out.println("[" + addresses[i] + "]" + "    " + types[i].toString() + "    #    " + lines[i]);
		}
	}

	public String print() {
		String aux = "";
		for (int i = 0; i < numElements; i++) {
			aux += ("[" + addresses[i] + "]" + "     " + types[i].toString() + "     #     " + lines[i] + "\n");
		}
		return aux;
	}

	public String printBinary() {
		String aux = "";
		for (int i = 0; i < numElements; i++) {
			aux += (types[i].toString() + "\n");
		}
		return aux;
	}

	public String printSignals() {
		String aux = "";
		for (int i = 0; i < numElements; i++) {
			aux += (Exchange.getSignals(Exchange.getOperations(types[i].getOp()) + types[i].getOp()) + "\n");
		}
		return aux;
	}
}
