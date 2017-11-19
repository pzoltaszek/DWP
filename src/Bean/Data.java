package pz.strona.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAktualnaData() {

		Date da = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String biezacaData = sdf.format(da);
		return biezacaData;

	}

}
