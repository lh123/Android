import java.io.*;
import java.net.*;
import org.json.*;

public class Main
{
	public static void main(String[] args)
	{
		HttpConnect connect=new HttpConnect();
		connect.getWeatherStatus();
	}
}


