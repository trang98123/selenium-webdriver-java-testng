package javaForTest;

import java.util.Random;

public class Topic_01_Random_Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt());
		System.out.println(rand.nextInt());
		//random nó sẽ chạy từ 0>>999999(khi mình muốn lấy 1000000)
		System.out.println("autotesting" + rand.nextInt(999999) + "@hotmail.com");
		System.out.println("autotesting" + rand.nextInt(999999) + "@gmail.com");
		System.out.println("autotesting" + rand.nextInt(999999) + "@live.com");
	}

}
