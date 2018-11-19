package admin;


import com.opensymphony.xwork2.ActionSupport;

import admin.pagingAction;
import member.MemberVO;
import report.reportVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class memberListAction extends ActionSupport
{
	public static Reader reader; //���� ��Ʈ���� ���� reader
	public static SqlMapClient sqlMapper; ////SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	
	private int score;
	private String grade;
	private String id;
	private String check;
	private int access_num;
	
	private MemberVO paramClass;
	private MemberVO resultClass;
	
	private List<MemberVO> list =  new ArrayList<MemberVO>();
	
	private String searchKeyword; 
	private	int searchNum;
	private int num = 1;
	
	private int currentPage = 1;	//���� ������
	private int totalCount;			//�� �Խù��� ��
	private int blockCount = 20;	//�� �������� �Խù��� ��
	private int blockPage = 5;		//�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;		//����¡�� ������ HTML
	private pagingAction page;		//����¡ Ŭ����
	
	public memberListAction() throws IOException
	{
		// sqlMapConfig.xml������ ���������� ������
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
						
		// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
						
		reader.close();	
	}
	
	public String execute() throws Exception
	{
		if(getSearchKeyword() != null)
		{
			return search();	
		}
		list = sqlMapper.queryForList("member.selectAll");
	
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
	
		// pagingAction ��ü ����.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
				
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.
				
		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;
		
		// ���� �������� ������ �۹�ȣ�� ��ü ������ �۹�ȣ���� ������, lastCount�� +1��ȣ�� ����
		if (page.getEndCount() < totalCount)
		{
			lastCount = page.getEndCount() + 1;
		}
				
		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
	public String test() throws Exception
	{
		paramClass = new MemberVO();
		if(getCheck()!=null)
		{
			String[] t = getCheck().split(", ");
		
			for (int i = 0; i < t.length; i++) 
			{
				paramClass.setId(t[i]);
				
				paramClass.setAccess_num(getAccess_num());
				sqlMapper.update("member.blackprocess",paramClass);
			}
		}
		if(getSearchKeyword() != null)
		{
			return search();	
		}
		
		list = sqlMapper.queryForList("member.selectAll");

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		
		// pagingAction ��ü ����.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
		
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.
		
		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;
		
		// ���� �������� ������ �۹�ȣ�� ��ü ������ �۹�ȣ���� ������, lastCount�� +1��ȣ�� ����
		if (page.getEndCount() < totalCount)
		{
			lastCount = page.getEndCount() + 1;
		}
		
		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);
		

		return SUCCESS;
	}
			
	public String search() throws Exception
	{
		 if(searchNum ==0) 
		 {
			  list = sqlMapper.queryForList("member.selectSearchI", "%"+getSearchKeyword()+"%");
		  }
		  if(searchNum ==1) 
		  {
			  list = sqlMapper.queryForList("member.selectSearchN", "%"+getSearchKeyword()+"%");
		  }
		  
		  totalCount = list.size(); 
		  page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
		  pagingHtml = page.getPagingHtml().toString();
		     
		  int lastCount = totalCount;
		    
		  if(page.getEndCount() < totalCount)
		     lastCount = page.getEndCount() +1;
		     
		  list= list.subList(page.getStartCount(), lastCount);
		    
		   return SUCCESS;
	}
	
	public List<MemberVO> getList() {
		return list;
	}

	public void setList(List<MemberVO> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}

	public void setPage(pagingAction page) {
		this.page = page;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccess_num() {
		return access_num;
	}

	public void setAccess_num(int access_num) {
		this.access_num = access_num;
	}
	
}
