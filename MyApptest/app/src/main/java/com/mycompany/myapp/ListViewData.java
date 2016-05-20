package com.mycompany.myapp;

public class ListViewData
{
	private String name;
	private String detail;
	private int iconId=0;

	public ListViewData(String name, String detail, int iconId)
	{
		this.name = name;
		this.detail = detail;
		this.iconId = iconId;
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

	public void setIconId(int iconId)
	{
		this.iconId = iconId;
	}

	public int getIconId()
	{
		return iconId;
	}
}
