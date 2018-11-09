package product;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import product.pagingAction;

public class ListAction extends ActionSupport
{
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private List first = new ArrayList();
	private List<productVO> list = new ArrayList<productVO>();
	private productVO resultClass = new productVO(); //쿼리 결과 값을 저장할 객체
	
	private int currentPage=1;	//현재 페이지
	private int totalCount;		
	private int blockCount=25;   //5*5 이미지 정렬
	private int blockPage=5;
	private String pagingHtml;
	private pagingAction page;
	private String a[];
	public ListAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		list=sqlMapper.queryForList("product.selectAll");
/*		for(int i= 0 ; i <  list.size();i++) { 
			resultClass = list.get(i);
		    a = resultClass.getProduct_image().split(",");   
		    
		    first.add("/MUSED/product/img/"+a[0]);
		}
		for(int i= 0 ; i <  list.size();i++) { 
		System.out.println(first.get(i));
		}
*/		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}

	public List<String> getFirst() {
		return first;
	}

	public void setFirst(List<String> first) {
		this.first = first;
	}

	public productVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(productVO resultClass) {
		this.resultClass = resultClass;
	}

	public String[] getA() {
		return a;
	}

	public void setA(String[] a) {
		this.a = a;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		ListAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ListAction.sqlMapper = sqlMapper;
	}

	public List<productVO> getList() {
		return list;
	}

	public void setList(List<productVO> list) {
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
	
}
