/**
 * @author Marcos Vinicius Berté
 *
 */

import java.util.HashMap;

public class Exchange {
	private static HashMap<String, String> registers;
	private static HashMap<String, String> operations;
	private static HashMap<String, String> functions;
	private static HashMap<String, String> signals;
	private static HashMap<String, String> checkType;
	private static HashMap<String, String> shiftAmount;

	static {
		registers = new HashMap<String, String>();
		operations = new HashMap<String, String>();
		functions = new HashMap<String, String>();
		signals = new HashMap<String, String>();
		checkType = new HashMap<String, String>();
		shiftAmount = new HashMap<String, String>();

		// REGISTERS
		registers.put("$zero", "00000");
		registers.put("$at", "00001");
		registers.put("$v0", "00010");
		registers.put("Sv1", "00011");
		registers.put("$a0", "00100");
		registers.put("$a1", "00101");
		registers.put("$a2", "00110");
		registers.put("$a3", "00111");
		registers.put("$t0", "01000");
		registers.put("$t1", "01001");
		registers.put("$t2", "01010");
		registers.put("$t3", "01011");
		registers.put("$t4", "01100");
		registers.put("$t5", "01101");
		registers.put("$t6", "01110");
		registers.put("$t7", "01111");
		registers.put("$s0", "10000");
		registers.put("$s1", "10001");
		registers.put("$s2", "10010");
		registers.put("$s3", "10011");
		registers.put("$s4", "10100");
		registers.put("$s5", "10101");
		registers.put("$s6", "10110");
		registers.put("$s7", "10111");
		registers.put("$t8", "11000");
		registers.put("$t9", "11001");
		registers.put("$k0", "11010");
		registers.put("$k1", "11011");
		registers.put("$gp", "11100");
		registers.put("$sp", "11101");
		registers.put("$fp", "11110");
		registers.put("$ra", "11111");

		// OPERATIONS
		operations.put("add", "000000");
		operations.put("sub", "000000");
		operations.put("and", "000000");
		operations.put("or", "000000");
		operations.put("not", "000000");
		operations.put("nor", "000000");
		operations.put("slt", "000000");
		operations.put("addi", "001000");
		operations.put("subi", "001000");
		operations.put("andi", "001100");
		operations.put("ori", "001101");
		operations.put("slti", "001010");
		operations.put("beq", "000100");
		operations.put("lw", "100011");
		operations.put("sw", "101011");
		operations.put("j", "000010");

		// FUNCTIONS
		functions.put("add", "100000");
		functions.put("sub", "100010");
		functions.put("and", "100100");
		functions.put("or", "100101");
		functions.put("nor", "100111");
		functions.put("slt", "101010");

		// CHECKTYPE
		checkType.put("add", "R");
		checkType.put("sub", "R");
		checkType.put("and", "R");
		checkType.put("or", "R");
		checkType.put("not", "R");
		checkType.put("slt", "R");
		checkType.put("addi", "I");
		checkType.put("subi", "I");
		checkType.put("andi", "I");
		checkType.put("ori", "I");
		checkType.put("slti", "I");
		checkType.put("beq", "I");
		checkType.put("lw", "I");
		checkType.put("sw", "I");
		checkType.put("j", "J");

		// SHAMT
		shiftAmount.put("shamt", "00000");

		// SIGNALS
		signals.put("000000add",  "add          | 000000 |  1 |  1 |  0 | 0 |  0 |  0 |  10   | 0"); // R-Type
		signals.put("000000sub",  "sub          | 000000 |  1 |  1 |  0 | 0 |  0 |  0 |  10   | 0"); // R-Type
		signals.put("000000and",  "and          | 000000 |  1 |  1 |  0 | 0 |  0 |  0 |  10   | 0"); // R-Type
		signals.put("000000or",   "or              | 000000 |  1 |  1 |  0 | 0 |  0 |  0 |  10   | 0"); // R-Type
		signals.put("000000nor",  "nor           | 000000 |  1 |  1 |  0 | 0 |  0 |  0 |  10   | 0"); // R-Type
		signals.put("000000slt",  "slt             | 000000 |  1 |  1 |  0 | 0 |  0 |  0 |  10   | 0"); // R-Type
		signals.put("001000addi", "addi         | 001000 |  1 |  1 |  0 | 0 |  0 |  0 |  00   | 0"); // I-Type
		signals.put("001000subi", "addi         | 001000 |  1 |  1 |  0 | 0 |  0 |  0 |  00   | 0"); // I-Type
		signals.put("001100andi", "andi         | 001100 |  1 |  1 |  0 | 0 |  0 |  0 |  00   | 0"); // I-Type
		signals.put("001101ori",  "ori            | 001101 |  1 |  1 |  0 | 0 |  0 |  0 |  00   | 0"); // I-Type
		signals.put("001010slti", "slti           | 001010 |  1 |  1 |  0 | 0 |  0 |  0 |  00   | 0"); // I-Type
		signals.put("000100beq",  "beq          | 000100 |  0 |  x |  0 | 1 |  0 |  x |  01   | 0"); // I-TYPE
		signals.put("100011lw",   "lw             | 100011 |  1 |  0 |  1 | 0 |  0 |  1 |  00   | 0"); // I-TYPE
		signals.put("101011sw",   "sw            | 101011 |  0 |  x |  1 | 0 |  1 |  x |  00   | 0"); // I-TYPE
		signals.put("000010j",    "j            | 000010 |  0 |  x |  x | x |  0 |  x |  xx   | 1"); // J-TYPE
	}

	public static String getRegisters(String register) {
		return registers.get(register);
	}

	public static String getOperations(String operation) {
		return operations.get(operation);
	}

	public static String getFunctions(String function) {
		return functions.get(function);
	}

	public static String getCheckType(String type) {
		return checkType.get(type);
	}

	public static String getShamt(String shamt) {
		return shiftAmount.get(shamt);
	}

	public static String getSignals(String signal) {
		return signals.get(signal);
	}

}
