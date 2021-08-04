package id.co.bca.magenta.api.merchantcare.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

public class ListFromJSON {
	private List<GenericClass> list;
	private int issuccess;
	private int affectedrow;
	private String message;

	public ListFromJSON(String err_msg) {
		// *****CONVERT OUTPUT JSON TO OBJECT*****
		JSONObject jsonObj = new JSONObject(err_msg);
		List<GenericClass> list = new ArrayList<GenericClass>();

		// *****GET DETAIL INFO*****
		JSONObject json_array = jsonObj.getJSONObject(StaticVariable.ERR_MSG);
		Iterator<?> keys = json_array.keys();
		while (keys.hasNext()) {
			GenericClass JSONinfo = new GenericClass();
			String key = (String) keys.next();
			JSONinfo.setName(key);
			JSONinfo.setValue(json_array.get(key));
			list.add(JSONinfo);
		}

		this.setList(list);
		this.setIssuccess(jsonObj.getJSONObject(StaticVariable.ERR_MSG).getInt(StaticVariable.ISSUCCESS));
		this.setAffectedrow(jsonObj.getJSONObject(StaticVariable.ERR_MSG).getInt(StaticVariable.AFFECTEDROW));
		this.setMessage(jsonObj.getJSONObject(StaticVariable.ERR_MSG).getString(StaticVariable.MESSAGE));
	}

	public List<GenericClass> getList() {
		return list;
	}

	public void setList(List<GenericClass> list) {
		this.list = list;
	}

	public int getIssuccess() {
		return issuccess;
	}

	public void setIssuccess(int issuccess) {
		this.issuccess = issuccess;
	}

	public int getAffectedrow() {
		return affectedrow;
	}

	public void setAffectedrow(int affectedrow) {
		this.affectedrow = affectedrow;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
