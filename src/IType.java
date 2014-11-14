/**
 * @author Marcos Vinicius Berté
 *
 */

public class IType extends Types {
	private String rs;
	private String rt;
	private String imm;

	public IType(String op, String rs, String rt, int imm) {
		super(op);
		this.rs = rs;
		this.rt = rt;
		this.imm = doBin(imm, 16);
	}

	public IType(String op, String rs, String rt, int pc, int target) {
		super(op);
		this.rs = rs;
		this.rt = rt;
		this.imm = getNewAddress(pc, target, 16);
	}

	public String getRs() {
		return rs;
	}

	public String getRt() {
		return rt;
	}

	public String getImm() {
		return imm;
	}

	public String toString() {
		return Exchange.getOperations(getOp()) + Exchange.getRegisters(rs) + Exchange.getRegisters(rt) + getImm();
	}

}
