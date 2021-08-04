package id.co.bca.magenta.api.merchantcare.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class ApiMerchantCareUtility {
	private static final Logger logger = LoggerFactory.getLogger(ApiMerchantCareUtility.class);

	private String propName = StaticVariable.PROPERTIES_PATH;
	private Properties props;
	private String key = "mms_bo_app KeyEnc ";
	private String CHARSET = "ISO-8859-1";
	private static ApiMerchantCareUtility _instance;
	private File propFile = null;

	@Autowired
	ApplicationContext applicationContext;

	public class SortedProperties extends Properties {
		/**
		 * Overrides, called by the store method.
		 */
		@Override
		@SuppressWarnings("unchecked")
		public synchronized Enumeration keys() {
			Enumeration keysEnum = super.keys();
			Vector keyList = new Vector();
			while(keysEnum.hasMoreElements()){
				keyList.add(keysEnum.nextElement());
			}
			//            Collections.sort(keyList);
			return keyList.elements();
		}
	}

	private String getEncryptedData(String key, String data) throws Exception {
		if (data.startsWith("{3DES}")) {
			data = decrypt(data.substring(6));
		} else {
			String encrypted = "{3DES}" + encrypt(data.trim());
			props.put(key, encrypted);
			FileOutputStream out = new FileOutputStream(propFile);
			SortedProperties sortedProps = new SortedProperties();
			sortedProps.putAll(props);
			sortedProps.store(out, null);
			out.close();
		}

		return data;
	}

	private String decrypt(String data) throws Exception {
		DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
		SecretKeySpec skeySpec = new SecretKeySpec(spec.getKey(), "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(data.getBytes(CHARSET));
		return new String(decrypted, CHARSET);
	}

	private String encrypt(String data) throws Exception {
		DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
		SecretKeySpec skeySpec = new SecretKeySpec(spec.getKey(), "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(data.getBytes(CHARSET));
		return new String(encrypted, CHARSET);
	}

	private ApiMerchantCareUtility() {
		props = loadData();
		Enumeration enums = props.keys();
		while (enums.hasMoreElements()) {
			String key = (String)enums.nextElement();
			//            System.out.println(key + "=" + getProperty(key));

		}
	}

	public static ApiMerchantCareUtility getInstance() {
		if (_instance == null) {
			synchronized (ApiMerchantCareUtility.class) {
				if (_instance == null) {
					_instance = new ApiMerchantCareUtility();
				}
			}
		}
		return _instance;
	}

	public String getProperty(String key) {
		String value = resolveValueWithEnvVars(props.getProperty(key));
		/*if(key.toUpperCase().indexOf("PASSWORD")!=-1)
            try {
                value = getEncryptedData(key,value);
            } catch (Exception e) { }*/
		return value;
	}

	public void reload() throws Exception {
		synchronized (ApiMerchantCareUtility.class) {
			_instance = new ApiMerchantCareUtility();

			//            ReloadConfigUtil configUtil = new ReloadConfigUtil();
			//            configUtil.reloadIfNotLoaded();
		}

		logger.info("---- ApiMerchantCareUtility: reload()");
		System.out.println("---- ApiMerchantCareUtility: reload()");
	}

	public String getProperty(String key, String defaults) {
		String value = resolveValueWithEnvVars(props.getProperty(key,defaults));
		/*if(key.toUpperCase().indexOf("PASSWORD")!=-1)
            try {
                value = getEncryptedData(key,value);
            } catch (Exception e) { }*/
		return value;
	}

	public void setProperty(String key, String data) throws Exception {
		props.put(key, data);
		FileOutputStream out = new FileOutputStream(propFile);
		SortedProperties sortedProps = new SortedProperties();
		sortedProps.putAll(props);
		sortedProps.store(out, null);
		out.close();
	}

	private String resolveValueWithEnvVars(String value) {
		if (null == value) {
			return null;
		}

		Pattern p = Pattern.compile("\\$\\{([\\w\\.]+)\\}|\\$([\\w\\.]+)"); // |\\$([\\w\\.]+)
		Matcher m = p.matcher("~"+value);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			String envVarName = StringUtils.isBlank(m.group(1)) ? m.group(2) : m.group(1);
			String envVarValue = getProperty(envVarName);
			m.appendReplacement(sb, null == envVarValue ? "" : Matcher.quoteReplacement(envVarValue));
		}
		m.appendTail(sb);
		String resolvedStr = sb.toString().substring(1);

		return resolvedStr;
	}

	private Properties loadData() {
		Properties prop = null;
		try {
			try {
				propFile = new File(propName);
			} catch (Exception e1) {
				propFile = null;
			}

			if (propFile == null) {
				throw new Exception("File " + propName +
						" was not found. You need to copy file " +
						propName +
						" to the spesific path.");
			}
			prop = new Properties();
			FileInputStream in = new FileInputStream(propFile);
			prop.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("");
			System.out.println("Properties file reading error. \n".concat(String.valueOf(e.getMessage())));
			System.out.println("");
			System.out.println("");
		}
		return prop;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println(System.getProperty("user.dir")); //user.dir
		try {
			ApiMerchantCareUtility.getInstance().setProperty("user.userA.username", "name of userA");
			ApiMerchantCareUtility.getInstance().setProperty("user.userA.role", "role of userA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">>>>" + ApiMerchantCareUtility.getInstance().getProperty("user.userA.username", "") + "<<<<");
		System.out.println(">>>>" + ApiMerchantCareUtility.getInstance().getProperty("user.userA.role", "") + "<<<<");
	}
}