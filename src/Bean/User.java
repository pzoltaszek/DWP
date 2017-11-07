package pz.strona.Bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String loginp;
	private String passwordp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginp() {
		return loginp;
	}

	public void setLoginp(String loginp) {
		this.loginp = loginp;
	}

	public String getPasswordp() {
		return passwordp;
	}

	public void setPasswordp(String passwordp) {
		this.passwordp = passwordp;
	}

	// private String filePatch2 =
	// "/home/pitek/Documents/workspace/Strona/WebContent/Nowy/";



	public void wczytajPlik(String FilePatch) throws IOException {
		FileReader f = new FileReader(FilePatch);
		BufferedReader br = new BufferedReader(f);
		String tekst = br.readLine();

		String aaa[] = tekst.split(" ");
		for (int i = 0; i < aaa.length; i++) {
			String aa = aaa[0];
			String bb = aaa[1];
			System.out.println(aa);
			System.out.println(bb);
			System.out.println(aa + " && " + bb);
			br.close();
		}
	}

	public void zapiszPlik(String filePatch, String do_zapisu) throws IOException {
		FileWriter fr = new FileWriter(filePatch);
		BufferedWriter bw = new BufferedWriter(fr);
		try {
			bw.write(do_zapisu);
		} finally {
			bw.close();
		}
	}

	public String modyfikuj(String inpt) {
		String gg = inpt + "1";
		return gg;
	}
}