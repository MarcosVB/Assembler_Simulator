/**
 * @author Marcos Vinicius Berté
 *
 */

public class RType extends Types {
	private String rd;
	private String rs;
	private String rt;

	public RType(String op, String rd, String rs, String rt) {
		super(op);
		this.rd = rd;
		this.rs = rs;
		this.rt = rt;
	}

	public String getRd() {
		return rd;
	}

	public String getRs() {
		return rs;
	}

	public String getRt() {
		return rt;
	}

	public String getFunc() {
		return Exchange.getFunctions(getOp());
	}

	public String toString() {
		return Exchange.getOperations(getOp()) + Exchange.getRegisters(rs) + Exchange.getRegisters(rt)
				+ Exchange.getRegisters(rd) + Exchange.getShamt("shamt") + Exchange.getFunctions(getOp());
	}

}
