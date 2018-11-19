package talent;

import com.opensymphony.xwork2.ActionSupport;

import talent.talentVO;
import talent.pagingAction;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import java.io.Reader;
import java.io.IOException;

public class ListAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private List<talentVO> list = new ArrayList<talentVO>();
	private talentVO resultClass = new talentVO(); //���� ��� ���� ������ ��ü
	
	private String searchKeyword;
	private int searchNum;
	private int num =0;
	private String sort;
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
	
	public String execute() throws Exception{
		System.out.println("list:"+map);

	    //���� : if ��
		    if(getSort().equals("0")) {
		    	map.put("sort", "talent_no desc");  // �ֽż�
		    }
		    else if(getSort().equals("1")) {
		    	map.put("sort", "readhit desc");  // �α��
		    }
		    else if(getSort().equals("2")) {
		    	map.put("sort", "talent_price asc");  // ������
		    }
		    else if(getSort().equals("3")) {
		    	map.put("sort", "talent_price desc");  // ����
		    }
		 
	    System.out.println(map);
	    
		
		list=sqlMapper.queryForList("talent.selectAll",map);
		
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

	public String search() throws Exception
	{
		if(searchNum == 0)
		{
			list = sqlMapper.queryForList("talent.selectSearchW", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 1)
		{
			list = sqlMapper.queryForList("talent.selectSearchS", "%"+getSearchKeyword()+"%");
		}
		if(searchNum == 2)
		{
			list = sqlMapper.queryForList("talent.selectSearchC", "%"+getSearchKeyword()+"%");	
		}
		
		totalCount = list.size();
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public talentVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(talentVO resultClass) {
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

	public List<talentVO> getList() {
		return list;
	}

	public void setList(List<talentVO> list) {
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
