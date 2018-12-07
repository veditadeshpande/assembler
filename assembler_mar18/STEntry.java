package assembler_mar18;

public class STEntry {

char relocation='R' ;

public String name;public int length;public int value; 
   
  public STEntry() {
  	
  }
  
  
  
  public STEntry(String name , int value , int length ) {
    	this.name = name ;
    	this.value = value ; 
    	this.length = length ; 
    }
  
  public void print() {
	  System.out.println(name+"\t"+value+"\t"+length+"\t"+relocation+"\n");
  }
   
}
