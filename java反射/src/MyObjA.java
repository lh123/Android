public class MyObjA
{
	public String value;
	private int intvalue;

	public MyObjA(String value)
	{
		this.value = value;
		//this.intvalue = intvalue;
	}
	public  void callMe(String msg)
	{
		System.out.println("我是"+this.toString()+"内的方法");
	}
}
