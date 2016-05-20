import java.io.*;
import java.net.*;
import org.json.*;
import java.util.*;

public class HttpConnect
{
	protected HttpURLConnection getConnect(String path) throws MalformedURLException, IOException
	{
		URL url=new URL(path);
		return (HttpURLConnection)url.openConnection();
	}

	public void getWeatherStatus()
	{
		try
		{
			HttpURLConnection connect=getConnect("http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=101200801&device=aries&miuiVersion=5.6.11&modDevice=&source=miuiWeatherApp");
			InputStream is=connect.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			JSONObject city=new JSONObject(br.readLine());
			//JSONObject city=info.getJSONObject("aqi");
			Iterator<String> v= city.keys();
			while(v.hasNext())
			{
				String n=v.next();
				Object current=city.get(n);
				if(current instanceof JSONObject)
				{
					JSONObject temp=(JSONObject) current;
					Iterator<String> i=temp.keys();
					while(i.hasNext())
					{
						String s=i.next();
						System.out.println(n+"."+s+":"+temp.get(s));
					}
				}
				else if(current instanceof JSONArray)
				{
					System.out.println("array");
				}
				else if(current instanceof String)
				{
					System.out.println(n+":"+(String)current);
				}
			}
			System.out.println(city.toString());
		}
		catch (Exception e)
		{}
	}
}
