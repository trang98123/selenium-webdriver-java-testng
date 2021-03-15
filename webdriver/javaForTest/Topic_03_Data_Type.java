package javaForTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class Topic_03_Data_Type {
	public static void main(String[] args) {
	// kiểu dữ liệu kí tự
	char a = 'A';

	// kiểu dữ liệu số nguyên
	byte first_num = -15;
	short second_num = 15456;
	int third_num = 468836;
	long fourth_num = 652365;

	// kiểu dữ liệu số thực
	float fifth_num = 145.69F;
	double six_num = 3456.55D;

	// kiểu dữ liệu boolean (true/false)
     boolean status =true ; 
     
	// kiểu dữ liệu chuỗi
	String fullname = "Hoang";
	
	// kiểu array (co dinh)
	String[] addresses = { "ha noi", "Ho chi minh" };
	
	// kiểu class
	Topic_03_Data_Type topic_03= new Topic_03_Data_Type();
	// kiểu Ọbiect

	// Kiểu Collection(rrayList/ HashMap)
	//Chua trung
	ArrayList<String> address= new ArrayList<String>();
    address.add("Ha Noi");
    address.add("Ho Chi Minh");
    
    
    // ko chứa trùng
	Set<String> add=new HashSet<String>();
	add.add("Ha Noi");
}
}