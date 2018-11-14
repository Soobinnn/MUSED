package main;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import product.pagingAction;
import product.productVO;
import talent.talentVO;

public class mainSearchAction extends ActionSupport
{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	/*product*/
	private List<productVO> list_p = new ArrayList<productVO>();
	private productVO resultClass_p =  new productVO();
	
	/*talent*/
	private List<talentVO> list_t = new ArrayList<talentVO>();
	private talentVO resultClass_t = new talentVO(); 
	
	private String searchKeyword;
	private int searchNum;
	private int num =0;
	
	private int currentPage=1;	//현재 페이지
	private int totalCount;		
	private int blockCount=5;   //5*5 이미지 정렬
	private int blockPage=5;
	private String pagingHtml;
	private pagingAction page;
	
	public mainSearchAction() throws IOException
	{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception
	{
		if(getSearchKeyword() != null)
		{
			return search();
		}
		
		list_p=sqlMapper.queryForList("product.selectAll");
		list_t=sqlMapper.queryForList("talent.selectAll");
		
		totalCount = list_p.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage, num, "");
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) 
		{
			lastCount=page.getEndCount()+1;
		}
		
		list_p=list_p.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
	
	public String search() throws Exception
	{
		if(searchNum == 0)
		{
			list_p = sqlMapper.queryForList("product.main_selectSearch", "%"+getSearchKeyword()+"%");
			list_t = sqlMapper.queryForList("talent.main_selectSearch", "%"+getSearchKeyword()+"%");
		}
		
		totalCount = list_p.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list_p = list_p.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public List<productVO> getList_p() {
		return list_p;
	}

	public void setList_p(List<productVO> list_p) {
		this.list_p = list_p;
	}

	public productVO getResultClass_p() {
		return resultClass_p;
	}

	public void setResultClass_p(productVO resultClass_p) {
		this.resultClass_p = resultClass_p;
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

	public List<talentVO> getList_t() {
		return list_t;
	}

	public void setList_t(List<talentVO> list_t) {
		this.list_t = list_t;
	}

	public talentVO getResultClass_t() {
		return resultClass_t;
	}

	public void setResultClass_t(talentVO resultClass_t) {
		this.resultClass_t = resultClass_t;
	}
	
}
