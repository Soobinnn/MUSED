package product;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class ZzimAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private ZzimVO paramClass;
	private ZzimVO resultClass;
	
	private Map session;
	
	
	
	public ZzimAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String execute() {
		return SUCCESS;
	}
	
	
	public ZzimVO getParamClass() {
		return paramClass;
	}
	public void setParamClass(ZzimVO paramClass) {
		this.paramClass = paramClass;
	}
	public ZzimVO getResultClass() {
		return resultClass;
	}
	public void setResultClass(ZzimVO resultClass) {
		this.resultClass = resultClass;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
}
