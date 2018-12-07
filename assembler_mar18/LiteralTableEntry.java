package assembler_mar18;

public class LiteralTableEntry {
public	String name  ;public char relocation ='R' ; public int value , length ; 

public void print() {
	System.out.println(name+"\t"+value+"\t"+length+"\t"+relocation+"\n");
	
}



}
