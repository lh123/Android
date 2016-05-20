import java.util.*;
import java.lang.reflect.*;

public class Main
{
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException
	{
		Class a= Main.class.getClassLoader().loadClass("MyObjA");
		//Method m= a.getMethod("callMe",a);
		//m.invoke(a.newInstance(),null);
		Method[] list= a.getMethods();
		Field[] file= a.getDeclaredFields();
		for(Method m:list)
		{
			System.out.println(m.getName());
		}
		for(Field f:file)
		{
			System.out.println(f.getName());
		}
		Method m=a.getMethod("callMe",String.class);
		Constructor<MyObjA> c= a.getConstructor(String.class);
		MyObjA ab= c.newInstance("string");
		ab.callMe("hhh");
		m.invoke(ab,"gggf|");
		Field f= a.getDeclaredField("value");
		System.out.println(f.getChar(ab));
		//m.invoke(ab,"ggg");
	}
}
