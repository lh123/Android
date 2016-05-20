package com.mycompany.myapp2;
import java.io.*;

public class Mydata implements Serializable
{
	private String name=null;
	private String detail=null;

	public Mydata(String name, String detail)
	{
		this.name = name;
		this.detail = detail;
	}


	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	public String getDetail()
	{
		return detail;
	}

	@Override
	public String toString()
	{
		return String.format("name=%s   detail=%s",getName(),getDetail());
	}
	
}
