package report;

import com.opensymphony.xwork2.ActionSupport;

import report.pagingAction;
import java.util.stream.*;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import report.reportVO;

public class listAction extends ActionSupport
{
	public static Reader reader; //���� ��Ʈ���� ���� reader
	public static SqlMapClient sqlMapper; ////SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	private List<reportVO> list =  new ArrayList<reportVO>();
	
	private reportVO paramClass; 
	private reportVO resultClass; 
	private String check;
	private String report_state;
	private String report_no;
	
	private List<String> check_no = new ArrayList();
	
	private String searchKeyword; 
	private	int searchNum;
	private int num = 1;
	
	private int currentPage = 1;	//���� ������
	private int totalCount;			//�� �Խù��� ��
	private int blockCount = 10;	//�� �������� �Խù��� ��
	private int blockPage = 5;		//�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;		//����¡�� ������ HTML
	private pagingAction page;		//����¡ Ŭ����
	
	
	public listAction() throws IOException
	{
		// sqlMapConfig.xml������ ���������� ������
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
				
		// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
				
		reader.close();		
	}
	public String admin_main() throws Exception
	{
		return SUCCESS;
	}

	public String execute() throws Exception
	{
		if(getSearchKeyword() != null)
		{
			return search();	
		}
		list = sqlMapper.queryForList("report.selectAll");

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
	
	public String process() throws Exception
	{
		if(getSearchKeyword() != null)
		{
			return search();	
		}
		
		list = sqlMapper.queryForList("report.selectAll");

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
		
		paramClass = new reportVO();
		
		if(getCheck()!=null)
		{
			String[] t = getCheck().split(", ");
		
		
			for (int i = 0; i < t.length; i++) 
			{
				int parse = Integer.parseInt(t[i]);
				paramClass.setReport_no(parse);
				paramClass.setReport_state(getReport_state());
				sqlMapper.update("report.checkprocess",paramClass);
			}
		}
		return SUCCESS;
	}
	
	public String search() throws Exception
	{
		 if(searchNum ==0) 
		 {
			  list = sqlMapper.queryForList("report.selectSearchR", "%"+getSearchKeyword()+"%");
		  }
		  if(searchNum ==1) 
		  {
			   list = sqlMapper.queryForList("report.selectSearchC", "%"+getSearchKeyword()+"%");
		  }
		  if(searchNum ==2) 
		  {
			   list = sqlMapper.queryForList("report.selectSearchS", "%"+getSearchKeyword()+"%");
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
	
	public List<reportVO> getList() {
		return list;
	}

	public void setList(List<reportVO> list) {
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
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public reportVO getParamClass() {
		return paramClass;
	}
	public void setParamClass(reportVO paramClass) {
		this.paramClass = paramClass;
	}
	public reportVO getResultClass() {
		return resultClass;
	}
	public void setResultClass(reportVO resultClass) {
		this.resultClass = resultClass;
	}
	public List<String> getCheck_no() {
		return check_no;
	}
	public void setCheck_no(List<String> check_no) {
		this.check_no = check_no;
	}
	public String getReport_state() {
		return report_state;
	}
	public void setReport_state(String report_state) {
		this.report_state = report_state;
	}
	public String getReport_no() {
		return report_no;
	}
	public void setReport_no(String report_no) {
		this.report_no = report_no;
	}
	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
	public static void setSqlMapper(SqlMapClient sqlMapper) {
		listAction.sqlMapper = sqlMapper;
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

}
