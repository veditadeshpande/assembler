package assembler_mar18;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.Vector;
public class Test {
	public static SymbolTable st = new SymbolTable(); 
	static int initialloc =0 ; static int base ; static int basecontent ; 
	public static LiteralTable lt = new LiteralTable();
   public static Vector<Instruction> objectCode = new Vector<>();
	static int loc = 0 ; 
	
	public static void main(String[] args)  {
		
		String path="H:\\acode.txt" ; Reader in= null ; String line ; 
		// pass 1 
	try {
		in = new FileReader(path);
		BufferedReader p = new BufferedReader(in);
		while( (line= p.readLine()) != null    ) {
			interpret(line);
		}
		System.out.println("               PASS 1 ");
	st.print();
	
	pass2();
	System.out.println("               PASS 2 ");
	System.out.println("--------Base Table----------");
	System.out.println("name\tcontent\n"+base +"\t"+basecontent);
	System.out.println("--------Machine Code--------");
		for(Instruction s : objectCode)
			s.print();
	
		
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}	
	finally {
		if(in !=null)
			try {
				in.close(); 
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
		
		
}
public static void interpret(String line) {
	
	if(line.contains("START")) {
		int l = getIndex(0,(char)32,line);
		STEntry e = new STEntry();
	e.name= line.substring(0, l) ; e.length = 1 ;e.value=0 ; 
		st.add(e);
		
	}
	
	
	if(line.contains("DC") || line.contains("DS")) {
		// it is a symbol  
		
		int i = getIndex(0,' ',line); String name = line.substring(0,i); 
		STEntry e = new STEntry();
		e.name = name ;
		e.length= 4  ;  

		e.value = loc ; st.add(e);
		loc += 4; 
	}
	if(line.contains("USING"))
	{
		
		
		int i = getIndex(0,',',line);
		base = Integer.parseInt(line.substring(i+1)); 
		basecontent = loc ; 
		return ; 
	}
	if(line.startsWith("\t") && (!line.contains("="))) {
		line.trim();
		int i = getIndex(0,' ',line) ; 		
		String name = line.substring(0, i);
		
		Instruction s = new Instruction();
		s.name = name ; s.b = base ; s.i = 0 ; 
		
		if(Character.isDigit(line.charAt(i+1))) { 
			
			s.reg =line.charAt(i+1);
		}
		// have to search the code in symbol table in pass 2 
		String code = line.substring(i+3);
		s.code = code ;  s.id = loc ; 
		objectCode.addElement(s);
		 loc +=4 ; 
		 
	}

	
			
	

}

static int getIndex(int start ,char c ,String line ) {
	for(int i = start ; i<line.length() ; i++) {
		if(line.charAt(i)==c) {
			return i ; 
		}
	}
	return -1 ;  
}


static void pass2() {
		for(Instruction t : objectCode) {
			int ref = search(t.code);
			t.d = ref-basecontent ;
		}
}

static int search(String key) {
	for(STEntry e : st.db) {
		if(e.name.equalsIgnoreCase(key))
			return e.value ; 
		
	}
	return -1 ; 
}
}
