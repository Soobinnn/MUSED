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
	
	private int zzim_no;
	private String zzim_memid;
	private String zzim_indexno;
	private int zzim_contno;
	
	private Map session;
	
	
	
	/*»ý¼ºÀÚ*/
	public ZzimAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	public String execute() throws Exception {
		paramClass = new ZzimVO();
		paramClass.setZzim_contno(getZzim_contno());
		paramClass.setZzim_memid((String)session.get("ID"));
		paramClass.setZzim_indexno(getZzim_indexno());
		
		sqlMapper.insert("zzim.insertZzim",paramClass);
		return SUCCESS;
	}
	
	
	
	
	public int getZzim_no() {
		return zzim_no;
	}
	public void setZzim_no(int zzim_no) {
		this.zzim_no = zzim_no;
	}
	public String getZzim_memid() {
		return zzim_memid;
	}
	public void setZzim_memid(String zzim_memid) {
		this.zzim_memid = zzim_memid;
	}
	public String getZzim_indexno() {
		return zzim_indexno;
	}
	public void setZzim_indexno(String zzim_indexno) {
		this.zzim_indexno = zzim_indexno;
	}
	public int getZzim_contno() {
		return zzim_contno;
	}
	public void setZzim_contno(int zzim_contno) {
		this.zzim_contno = zzim_contno;
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
