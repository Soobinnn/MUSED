package main;

import com.opensymphony.xwork2.ActionSupport;

import board.free.boardVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import main.pagingAction;
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
	
	/*notice*/
	private List<boardVO> list_n = new ArrayList<boardVO>();
	
	/*freeboard*/
	private List<boardVO> list_f = new ArrayList<boardVO>();
	
	/*suggestion*/
	private List<boardVO> list_s = new ArrayList<boardVO>();
	
	private String searchKeyword;
	private int searchNum;
	private int num =0;
	
	private int currentPage=1;	//���� ������
	
	private int totalCount_p;
	private int totalCount_t;
	private int totalCount_f;
	private int totalCount_n;
	private int totalCount_s;	
	
	private int blockCount=25;   //5*5 �̹��� ����
	private int blockPage=5;
	private String pagingHtml;
	private pagingAction page_p;
	private pagingAction page_t;
	private pagingAction page_f;
	private pagingAction page_n;
	private pagingAction page_s;
	
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
		list_f = sqlMapper.queryForList("free.selectAll");
		list_n = sqlMapper.queryForList("notice.selectAll");
		list_s = sqlMapper.queryForList("sug.selectAll");

		totalCount_p = list_p.size();	//�ǹ̾���
		totalCount_t = list_t.size();	
		totalCount_f = list_f.size();
		totalCount_n = list_n.size();
		totalCount_s = list_s.size();	
		
		page_p=new pagingAction(currentPage,totalCount_p,blockCount,blockPage);
		page_t=new pagingAction(currentPage,totalCount_t,blockCount,blockPage);
		page_f=new pagingAction(currentPage,totalCount_f,blockCount,blockPage);
		page_s=new pagingAction(currentPage,totalCount_s,blockCount,blockPage);
		page_n=new pagingAction(currentPage,totalCount_n,blockCount,blockPage);

		pagingHtml = page_p.getPagingHtml().toString();
		
		int lastCount_p=totalCount_p;
		int lastCount_t=totalCount_t;
		int lastCount_f=totalCount_f;
		int lastCount_s=totalCount_s;
		int lastCount_n=totalCount_n;
		
		if(page_p.getEndCount()<totalCount_p) {lastCount_p=page_p.getEndCount()+1;}
		if(page_t.getEndCount()<totalCount_t) {lastCount_t=page_t.getEndCount()+1;}
		if(page_f.getEndCount()<totalCount_f) {lastCount_f=page_f.getEndCount()+1;}
		if(page_s.getEndCount()<totalCount_s) {lastCount_s=page_s.getEndCount()+1;}
		if(page_n.getEndCount()<totalCount_n) {lastCount_n=page_n.getEndCount()+1;}
	
		
		list_p=list_p.subList(page_p.getStartCount(), lastCount_p);
		list_t=list_t.subList(page_t.getStartCount(), lastCount_t);
		list_f=list_f.subList(page_f.getStartCount(), lastCount_f);
		list_s=list_s.subList(page_s.getStartCount(), lastCount_s);
		list_n=list_n.subList(page_n.getStartCount(), lastCount_n);

		return SUCCESS;
	}
	
	public String search() throws Exception
	{
		if(searchNum == 0)
		{
			list_p = sqlMapper.queryForList("product.main_selectSearch", "%"+getSearchKeyword()+"%");
			list_t = sqlMapper.queryForList("talent.main_selectSearch", "%"+getSearchKeyword()+"%");
			list_f = sqlMapper.queryForList("free.main_selectSearch", "%"+getSearchKeyword()+"%");
			list_s = sqlMapper.queryForList("sug.main_selectSearch", "%"+getSearchKeyword()+"%");
			list_n = sqlMapper.queryForList("notice.main_selectSearch", "%"+getSearchKeyword()+"%");
		}
	
		
		totalCount_p = list_p.size();	//�ǹ̾���
		totalCount_t = list_t.size();	
		totalCount_f = list_f.size();
		totalCount_n = list_n.size();
		totalCount_s = list_s.size();
		
		/*page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());*/
		page_p=new pagingAction(currentPage,totalCount_p,blockCount,blockPage);
		page_t=new pagingAction(currentPage,totalCount_t,blockCount,blockPage);
		page_f=new pagingAction(currentPage,totalCount_f,blockCount,blockPage);
		page_s=new pagingAction(currentPage,totalCount_s,blockCount,blockPage);
		page_n=new pagingAction(currentPage,totalCount_n,blockCount,blockPage);

		
		pagingHtml = page_p.getPagingHtml().toString();
		
		int lastCount_p=totalCount_p;
		int lastCount_t=totalCount_t;
		int lastCount_f=totalCount_f;
		int lastCount_s=totalCount_s;
		int lastCount_n=totalCount_n;
		
		if(page_p.getEndCount()<totalCount_p) {lastCount_p=page_p.getEndCount()+1;}
		if(page_t.getEndCount()<totalCount_t) {lastCount_t=page_t.getEndCount()+1;}
		if(page_f.getEndCount()<totalCount_f) {lastCount_f=page_f.getEndCount()+1;}
		if(page_s.getEndCount()<totalCount_s) {lastCount_s=page_s.getEndCount()+1;}
		if(page_n.getEndCount()<totalCount_n) {lastCount_n=page_n.getEndCount()+1;}
			
		list_p=list_p.subList(page_p.getStartCount(), lastCount_p);
		list_t=list_t.subList(page_t.getStartCount(), lastCount_t);
		list_f=list_f.subList(page_f.getStartCount(), lastCount_f);
		list_s=list_s.subList(page_s.getStartCount(), lastCount_s);
		list_n=list_n.subList(page_n.getStartCount(), lastCount_n);

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

	public List<boardVO> getList_n() {
		return list_n;
	}

	public void setList_n(List<boardVO> list_n) {
		this.list_n = list_n;
	}

	public List<boardVO> getList_f() {
		return list_f;
	}

	public void setList_f(List<boardVO> list_f) {
		this.list_f = list_f;
	}

	public List<boardVO> getList_s() {
		return list_s;
	}

	public void setList_s(List<boardVO> list_s) {
		this.list_s = list_s;
	}

	public int getTotalCount_p() {
		return totalCount_p;
	}

	public void setTotalCount_p(int totalCount_p) {
		this.totalCount_p = totalCount_p;
	}

	public int getTotalCount_t() {
		return totalCount_t;
	}

	public void setTotalCount_t(int totalCount_t) {
		this.totalCount_t = totalCount_t;
	}

	public int getTotalCount_f() {
		return totalCount_f;
	}

	public void setTotalCount_f(int totalCount_f) {
		this.totalCount_f = totalCount_f;
	}

	public int getTotalCount_n() {
		return totalCount_n;
	}

	public void setTotalCount_n(int totalCount_n) {
		this.totalCount_n = totalCount_n;
	}

	public int getTotalCount_s() {
		return totalCount_s;
	}

	public void setTotalCount_s(int totalCount_s) {
		this.totalCount_s = totalCount_s;
	}

	public pagingAction getPage_p() {
		return page_p;
	}

	public void setPage_p(pagingAction page_p) {
		this.page_p = page_p;
	}

	public pagingAction getPage_t() {
		return page_t;
	}

	public void setPage_t(pagingAction page_t) {
		this.page_t = page_t;
	}

	public pagingAction getPage_f() {
		return page_f;
	}

	public void setPage_f(pagingAction page_f) {
		this.page_f = page_f;
	}

	public pagingAction getPage_n() {
		return page_n;
	}

	public void setPage_n(pagingAction page_n) {
		this.page_n = page_n;
	}

	public pagingAction getPage_s() {
		return page_s;
	}

	public void setPage_s(pagingAction page_s) {
		this.page_s = page_s;
	}

}
