package br.com.lelo.example.clientjws;

import java.io.IOException;
import java.net.URL;

public class ClientMain {

	public static void main(String[] args) {

		System.out.println("Start");
		while (true) {
			try {
				System.out.println("Gooo!");
				String url = "http://127.0.0.1:8080/clientserverjws/services/fila-impressao/Main/version/"
						+ getVersion();
				new URL(url).openConnection().getContent();
				System.out.println("Deu bom");
			} catch (Exception e) {
				System.out.println("Deu ruim");
			} finally {
				sleepQuiet(10);
			}
		}
	}

	public static String getVersion() throws IOException {
		return ClientMain.class.getPackage().getImplementationVersion();
	}

	private static void sleepQuiet(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
