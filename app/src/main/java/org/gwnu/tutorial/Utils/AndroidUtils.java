package org.gwnu.tutorial.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;


public class AndroidUtils {

	public static String m_strNetName;
	/**
	 * Converts the number in dips to the number in pixels
	 */
	public static int convertToPix(Context context, int sizeInDips) {

		DisplayMetrics displayMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(displayMetrics);
		float density = displayMetrics.density;

		float size = sizeInDips * density +0.5f;
		return (int) size;
	}

	public static int DPFromPixel(int pixel, float density_scale) {
		return (int) (pixel / density_scale);
	}

	public static int PixelFromDP(int dp, Context context) {

		DisplayMetrics displayMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(displayMetrics);
		float density = displayMetrics.density;
		return (int) (dp * density+0.5);
	}
	
	public static int PixelFromDP(int dp, float density_scale) {
		return (int) (dp * density_scale+0.5);
	}

	public static int getFullWidth(Context context){
		DisplayMetrics displayMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.widthPixels;

	}
	public static float getDensity(Activity activity) {
		DisplayMetrics mOutMetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(mOutMetrics);
		return mOutMetrics.density;
	}
	
	public static int getVersionCode(Context context){
		int nVersionCode = 1;
		PackageManager manager ;
		manager = context.getPackageManager();
		try {
		   	PackageInfo packInfo = manager.getPackageInfo(context.getPackageName(), 0);
			nVersionCode = packInfo.versionCode; 
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return nVersionCode;
	}
	
	public static String getBuildVersion(Context context)
	{
		String strBuildVersion = null;
		PackageManager manager = context.getPackageManager();
		try {
		   	PackageInfo packInfo = manager.getPackageInfo(context.getPackageName(), 0);
		   	strBuildVersion =  packInfo.versionName; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strBuildVersion;
	}

	public static String getLocalServerIp() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()
							&& !inetAddress.isLinkLocalAddress()
							&& inetAddress.isSiteLocalAddress())
						return inetAddress.getHostAddress().toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isConnState(Context context) {
		return ((ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE))
				.getActiveNetworkInfo() != null;
	}
	
	// IP 및 인터페이스 명 가져오기
	String _networkIp;
	String _networkName;

	public static String getIp() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)
			{
				NetworkInterface intf = en.nextElement();
				if (intf.isUp()) 
				{
					for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
					{
						InetAddress inetAddress = enumIpAddr.nextElement();
						if (!inetAddress.isLoopbackAddress()) 
						{
							if (inetAddress instanceof Inet4Address)
							{ // only want ipv4
								m_strNetName = intf.getName();	// address
								//System.out.println("ip = " + inetAddress.getHostAddress().toString());
								return inetAddress.getHostAddress().toString();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	/*
	 * Get the STB MacAddress
	 */
	public static String getMacAddress() {
		try {


			List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
			for (NetworkInterface intf : interfaces) {
				if (m_strNetName != null) {
					if (!intf.getName().equalsIgnoreCase(m_strNetName)) continue;
				}
				byte[] mac = intf.getHardwareAddress();

				if (mac==null) return null;
				StringBuilder buf = new StringBuilder();
				for (int idx=0; idx<mac.length; idx++)
					buf.append(String.format("%02X:", mac[idx]));
				if (buf.length()>0) buf.deleteCharAt(buf.length()-1);
				String macStr = buf.toString();
				macStr = macStr.replaceAll(":","");

				return macStr;
			}
			/*
			if(iPlayType == Constants.PLAYER_TYPE_TV)
			{
				return loadFileAsString("/sys/class/net/"+m_strNetName+"/address")
						.toUpperCase().substring(0, 17);
			}
			else
			{
				String strFile = loadFileAsString("/sys/class/net/"+m_strNetName+"/address");
				//String strFile = loadFileAsString("/sys/class/net/eth0/address");
				
				if(strFile != null && !strFile.equalsIgnoreCase("\n"))
				{
					String[] strMac = strFile.toUpperCase().substring(0, 17).split("\\:");
					if(strMac != null && strMac.length > 0)
					{
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < strMac.length; i++)
							sb.append(strMac[i]);
						
						return sb.toString();
					}					
				}
				//String[] strMac = loadFileAsString("/sys/class/net/"+m_strNetName+"/address")
			}

			 */
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 안드로이드 6.0 이상 버전 mac address 추출
	 * */
	public static String getMACAddress(String interfaceName) {
		try {
			List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
			for (NetworkInterface intf : interfaces) {
				if (interfaceName != null) {
					if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
				}
				byte[] mac = intf.getHardwareAddress();
				if (mac==null) return "";
				StringBuilder buf = new StringBuilder();
				for (int idx=0; idx<mac.length; idx++)
					buf.append(String.format("%02X:", mac[idx]));
				if (buf.length()>0) buf.deleteCharAt(buf.length()-1);
				String macStr = buf.toString();
				macStr = macStr.replaceAll(":","");
				return macStr;
			}
		} catch (Exception ex) { } // for now eat exceptions
		return "";
	}

	/*
	 * Load file content to String
	 */
	public static String loadFileAsString(String filePath)
			throws IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
		}
		reader.close();
		return fileData.toString();
	}

	// GW IP 가져오기
	private static String getRoute() {
		String gatewayIp = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/proc/net/route"));
			String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				String[] tokens = line.split("\t");
				if (tokens.length > 1 && tokens[1].equals("00000000")) {
					String gateway = tokens[2]; // 0102A8C0
					if (gateway.length() == 8) {
						String[] s4 = new String[4];
						s4[3] = String.valueOf(Integer.parseInt(
								gateway.substring(0, 2), 16));
						s4[2] = String.valueOf(Integer.parseInt(
								gateway.substring(2, 4), 16));
						s4[1] = String.valueOf(Integer.parseInt(
								gateway.substring(4, 6), 16));
						s4[0] = String.valueOf(Integer.parseInt(
								gateway.substring(6, 8), 16));
						gatewayIp = s4[0] + "." + s4[1] + "." + s4[2] + "."
								+ s4[3];
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return gatewayIp;
	}

	// ARP 테이블 IP 별 MAC 가져오기
	private static String getMacFromArpCache(String ip) {
		String mac = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/proc/net/arp"));
			String line;
			while ((line = br.readLine()) != null) {
				// Log.v("WifiStaticArp", "LINE:" + line);
				String[] splitted = line.split(" +");
				if (splitted != null && splitted.length >= 4 && ip.equals(splitted[0])) {
					// Basic sanity check
					mac = splitted[3];
					if (mac.matches("..:..:..:..:..:..")) {
					} else {
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mac;
	}

	public static String getApMac(Context context){
		try{
			WifiManager wifiMan = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
			WifiInfo wifiInfo = wifiMan.getConnectionInfo();
			String bssid = wifiInfo.getBSSID();
			bssid = bssid.replaceAll(":","");
			return bssid;
		}catch(Exception e){

		}
		return null;
	}

	
	public static String getGateWayMac()
	{
		String gwIp = getRoute();
		
		if(gwIp != null)
		{
			String strArp = getMacFromArpCache(gwIp);
			
			if(strArp != null)
			{
				String[] strGWMac = strArp.split("\\:");
				
				if(strGWMac != null && strGWMac.length > 0)
				{
					StringBuilder sb = new StringBuilder();
					for(int i = 0; i < strGWMac.length; i++)
						sb.append(strGWMac[i]);
					return sb.toString();
				}				
			}
			//String[] strGWMac = getMacFromArpCache(gwIp).split("\\:");			
			//return getMacFromArpCache(gwIp);
		}		
		//return null;
		// 2018.09.11 게이트웨이맥 못뽑을경우 더미값 처리
		return "100000000000";
	}
	
}
