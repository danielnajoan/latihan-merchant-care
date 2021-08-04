package id.co.bca.magenta.api.merchantcare.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericJSON {
	public Map<String, Object> info = new HashMap<String, Object>();

	public void seIinfo(Map<String, Object> info) {
		this.info = info;
	}

	public Map<String, Object> getInfo() {
		return this.info;
	}

	public void setAdditionalProperty(List<GenericClass> list) {
		for (int i = 0; i < list.size(); i++) {
			this.info.put(list.get(i).name, list.get(i).value);
		}
	}
}
