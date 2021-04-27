package day3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class ApacheIOApp {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://img3.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202104/23/starnews/20210423112754112hbgp.jpg");
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("src/day3/제니.jpg");

		IOUtils.copy(in, out);
	}
}
