package assembler_mar18;

public class Instruction {
	
	public int b , d , i,id ; char reg;  String name ; String code ; 
	
	public Instruction() {
		
	}
public Instruction(int base , int disp , int index) {
		b= base ; i = index; d = disp ; 
	}
	public void print() {
		System.out.println(name+" " +reg +"," +d + "("+i +","+b+")");
	}
	
}
