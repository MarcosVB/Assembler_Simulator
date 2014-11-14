/**
 * @author Marcos Vinicius Berté
 *
 */

public class Types {
	private String op;
	private String type;

	public Types(String op) {
		this.op = op;
		this.type = Exchange.getCheckType(op);
	}

	public static String doBin(int n, int size) {
		String r = "";
		r = Integer.toBinaryString(n);

		while (r.length() > size) {
			r = r.substring(1);
		}
		while (r.length() < size) {
			r = insert(r, "0");
		}
		return r;
	}

	public static String insert(String r, String string) {
		return string += r;
	}

	public String getNewAddress(int pc, int target, int size) {
		return doBin(((pc + 4) - target) / 4, size);

	}

	public String getOp() {
		return op;
	}

	public String getType() {
		return type;
	}

}
