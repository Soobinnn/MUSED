package util;

import java.util.HashMap;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.GenerateCertNumber;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.MemberVO;

public class SmsAction extends ActionSupport {
	
	private String api_key;
	private String api_secret;
	private Coolsms coolsms;
	private String authNum;
	private String phone;
	private GenerateCertNumber tempNum;
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	
	
	public SmsAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		tempNum = new GenerateCertNumber();
		authNum = tempNum.executeGenerate();
			
		api_key = "NCSBZXPOIHJQ9DLG";
		api_secret = "LDM9UTPY7PQIYHEDZF2LNWRRFDRAKZDW";
		coolsms = new Coolsms(api_key, api_secret);
		
		HashMap<String,String> set = new HashMap<String, String>();
		set.put("to", phone);
		set.put("from", "01027565694");
		set.put("text", "안녕하세요. MUSED입니다. 고객님의 본인인증 번호는 " + authNum + " 입니다.");
		set.put("type", "sms");
		
		JSONObject result = coolsms.send(set);
		
		if((Boolean)result.get("status") == true) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getApi_secret() {
		return api_secret;
	}

	public void setApi_secret(String api_secret) {
		this.api_secret = api_secret;
	}

	public Coolsms getCoolsms() {
		return coolsms;
	}

	public void setCoolsms(Coolsms coolsms) {
		this.coolsms = coolsms;
	}

	public String getAuthNum() {
		return authNum;
	}

	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		SmsAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		SmsAction.sqlMapper = sqlMapper;
	}
	
}
