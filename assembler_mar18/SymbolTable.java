package assembler_mar18;

import java.util.Vector;

public class SymbolTable {

	public Vector<STEntry> db;
	
	public SymbolTable(){
		
		this.db =new Vector<STEntry>();
	}
	
	public void print() {
		
		System.out.println("--------Symbol Table--------");
		System.out.println("Name "+"\tValue \tLength Relocation");
		for(STEntry temp : db)
			temp.print();
		
		
	}
	public void add(STEntry e) {
		db.addElement(e);
	}
	
	
}
