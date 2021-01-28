package javaForTest;

public class Topic_04_Getter_Setter {
   String carName;
	
	public static void main(String []args)
	{
		Topic_04_Getter_Setter topic_04=new Topic_04_Getter_Setter();
		topic_04.getCarName();
		topic_04.SetCarName("Mada 3");
	}
	//lay ra du lieu cua 1 bien (getter)
	public String getCarName()
	{
		return carName;
	}
	//Gan du lieu ms vao cho bien
	public void SetCarName(String car)
	{
		carName=car;
	}
	
}
