package javaForTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Topic_07_Loop_Statement {

	public static void main(String[] args) {
		String[] studentName= {"Trang", "Vân","Hiếu", "Quân","Quân1","Quân2","Quân3","Quân4"};
		
	for (int i = 0; i < 100; i++) {
		//System.out.println(i);
	}
		// In ra từ 1-100
		System.out.println();
           for (int i = 0; i < studentName.length; i++) {
			//System.out.println(studentName[i]);
			
		}
           List<String>  address=new ArrayList<String>();
           address.add("Trang");
           address.add("Trang1");
           address.add("Trang2");
           address.add("Trang3");
           for (Iterator iterator = address.iterator(); iterator.hasNext();) {
			//System.out.println(iterator.next());
			
		}
           for (String add : address) {
        	   System.out.println(add);
		}
 	}

}
