package com.lh.weather;
import android.content.*;
import java.net.*;
import java.io.*;
import org.json.*;

public class httpConnect
{
	private Context context;
	
	protected HttpURLConnection getConnect(String path) throws MalformedURLException, IOException
	{
		URL url=new URL(path);
		return (HttpURLConnection)url.openConnection();
	}
	
	public void getWeatherStatus()
	{
		try
		{
			HttpURLConnection connect=getConnect("http://weatherapi.market.xiaomi.com/wtr-v2/weather/apart?cityId=101200801&device=aries&miuiVersion=5.6.11&modDevice=&source=miuiWeatherApp");
			InputStream is=connect.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			JSONObject info=new JSONObject(br.readLine());
		}
		catch (Exception e)
		{}
	}
}
