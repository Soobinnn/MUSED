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
	

	private List<productVO> list = new ArrayList<productVO>();
	private productVO resultClass = new productVO(); //���� ��� ���� ������ ��ü
	
	private String searchKeyword;
	private int searchNum;
	private int num =0;
	private String sort="0";
	HashMap map = new HashMap();
	 
	private int currentPage=1;	//���� ������
	private int totalCount;		
	private int blockCount=25;   //5*5 �̹��� ����
	private int blockPage=5;
	private String pagingHtml;
	private pagingAction page;
	

	public ListAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception
	{
		

	    //���� : if ��
		    if(getSort().equals("0")) {
		    	map.put("sort", "product_no desc");  // �ֽż�
		    }
		    else if(getSort().equals("1")) {
		    	map.put("sort", "readhit desc");  // �α��
		    }
		    else if(getSort().equals("2")) {
		    	map.put("sort", "product_price asc");  // ������
		    }
		    else if(getSort().equals("3")) {
		    	map.put("sort", "product_price desc");  // ����
		    }
			System.out.println("list:"+map);

	    
		list=sqlMapper.queryForList("product.selectAll",map);

		totalCount = list.size();
		
		page=new pagingAction(currentPage,totalCount,blockCount,blockPage, num, "");
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount) {
			lastCount=page.getEndCount()+1;
		}
		list=list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}


	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public HashMap getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}

	public productVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(productVO resultClass) {
		this.resultClass = resultClass;
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
