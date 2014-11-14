/**
 * @author Marcos Vinicius Berté
 *
 */

public class JType extends Types {
	private String addr;

	public JType(String op, int pc, int target) {
		super(op);
		this.addr = getNewAddress(pc, target, 26);
	}

	public String getAddr() {
		return addr;
	}

	public String toString() {
		return Exchange.getOperations(getOp()) + getAddr();
	}
}
