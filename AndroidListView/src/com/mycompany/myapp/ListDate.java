package com.mycompany.myapp;

public class ListDate
{
	private String name=null;
	private int age;
	private String sex="未知";

	public ListDate(String name, int age, String sex)
	{
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString()
	{
		// TODO: Implement this method
		return getName();
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

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getSex()
	{
		return sex;
	}
}
