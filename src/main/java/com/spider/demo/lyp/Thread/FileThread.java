package com.spider.demo.lyp.Thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.spider.demo.lyp.LinkTypeData.LinkTypeData;
import com.spider.demo.lyp.Util.TextUtil;

public class FileThread extends Thread {
	private LinkTypeData li;
	private String home;

	public void setHome(String home) {
		this.home = home;
	}

	public void setLi(LinkTypeData li) {
		this.li = li;
	}

	public FileThread(LinkTypeData li, String home) {
		this.setLi(li);
		this.setHome(home);
	}

	@Override
	public void run() {
		String oppositeurl = TextUtil.toWindowsName(li.getText()) + ".html";
		FileOutputStream out = null;
		InputStream is = null;
		int responsecode = 0;
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(li.getHref()).openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			responsecode = conn.getResponseCode();

			is = conn.getInputStream();
			out = new FileOutputStream(home + oppositeurl);

			int a = 0;
			while ((a = is.read()) != -1) {
				out.write(a);
			}
			out.flush();

		} catch (Exception e) {
			System.out.println("ResponseCode:" + responsecode);
			System.out.println(li.getText());
			System.out.println(e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
			try {
				out.close();
			} catch (IOException e) {
			}

		}
	}
}