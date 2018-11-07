package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;

import member.MemberVO;

public class CheckIdAction extends ActionSupport {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private MemberVO resultClass;
	
	//transfer data
	private String id;
	private int chkNo;

	
	public CheckIdAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		
		resultClass = new MemberVO();
		
		if(getId() != null) {
			resultClass = (MemberVO) sqlMapper.queryForObject("member.chkId",getId());
		}
		
		if(resultClass == null) {
			chkNo = 0;
		}else {
			chkNo = 1;
		}
	
		return SUCCESS;
	}


	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getChkNo() {
		return chkNo;
	}

	public void setChkNo(int chkNo) {
		this.chkNo = chkNo;
	}
	
	

}
