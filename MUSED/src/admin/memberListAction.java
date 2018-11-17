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
	public static Reader reader; //파일 스트림을 위한 reader
	public static SqlMapClient sqlMapper; ////SqlMapClient API를 사용하기 위한 sqlMapper 객체.
	
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
	
	private int currentPage = 1;	//현재 페이지
	private int totalCount;			//총 게시물의 수
	private int blockCount = 20;	//한 페이지의 게시물의 수
	private int blockPage = 5;		//한 화면에 보여줄 페이지 수
	private String pagingHtml;		//페이징을 구현한 HTML
	private pagingAction page;		//페이징 클래스
	
	public memberListAction() throws IOException
	{
		// sqlMapConfig.xml파일의 설정내용을 가져옴
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
						
		// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
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
	
		totalCount = list.size(); // 전체 글 갯수를 구한다.
	
		// pagingAction 객체 생성.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
				
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.
				
		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;
		
		// 현재 페이지의 마지막 글번호가 전체 마지막 글번호보다 작으면, lastCount를 +1번호로 설정
		if (page.getEndCount() < totalCount)
		{
			lastCount = page.getEndCount() + 1;
		}
				
		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
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

		totalCount = list.size(); // 전체 글 갯수를 구한다.
		
		// pagingAction 객체 생성.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, num, "");
		
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.
		
		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;
		
		// 현재 페이지의 마지막 글번호가 전체 마지막 글번호보다 작으면, lastCount를 +1번호로 설정
		if (page.getEndCount() < totalCount)
		{
			lastCount = page.getEndCount() + 1;
		}
		
		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
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
