package assembler_mar18;

import java.util.Vector;

public class LiteralTable {

	String name ; int value ;
	
	Vector<LiteralTableEntry > db ;
	
	public LiteralTable(){
		db = new Vector<LiteralTableEntry>();
	}
	
	
}
