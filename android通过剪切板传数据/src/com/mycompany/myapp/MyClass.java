package com.mycompany.myapp;
import java.io.*;

public class MyClass implements Serializable
{
	private String name;
	private int age;

	MyClass(String name, int age)
	{
		this.setAge(age);
		this.setName(name);
	}

	@Override
	public String toString()
	{
		// TODO: Implement this method
		return "MyDate [ name:"+getName()+" age:"+getAge()+" ]";
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return age;
	}
}
