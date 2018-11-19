package talent;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


import java.util.*;

import java.io.Reader;
import java.io.IOException;

import talent.pagingAction;

public class SearchAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<talentVO> list = new ArrayList<talentVO>();
	private talentVO resultClass = new talentVO(); //쿼리 결과 값을 저장할 객체
	private talentVO paramClass = new talentVO();

	private String category1;
	private String category2;
	private String category3;
	private String category4;
	private String category5;
	private String category6;
	private String priceA;
	private String priceB;
	private String sido;
	private String gogon;
	private String searchKeyword;
	private String sort;
	
	private int currentPage=1;	//현재 페이지
	private int totalCount;		
	private int blockCount=25;   //5*5 이미지 정렬
	private int blockPage=5;
	private String pagingHtml;

	private pagingAction page;
	private int num =0;
	
	HashMap map = new HashMap();
	
	public SearchAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception{
		System.out.println(getCategory1());
		System.out.println(getCategory2());
		System.out.println(getCategory3());
		System.out.println(getCategory4());
		System.out.println(getCategory5());
		System.out.println(getCategory6());
		System.out.println(getPriceA());
		System.out.println(getPriceB());
		System.out.println(getSido());
		System.out.println(getGogon());
		System.out.println(getSearchKeyword());

	
		if(getCategory1()=="") {
			map.put("talent_category1", "null");
			}else {map.put("talent_category1", getCategory1());}
		if(getCategory2()=="") {
			map.put("talent_category2", "null");
			}else {map.put("talent_category2", getCategory2());}
		if(getCategory3()=="") {
			map.put("talent_category3", "null");
			}else {map.put("talent_category3", getCategory3());}
		if(getCategory4()=="") {
			map.put("talent_category4", "null");
			}else {map.put("talent_category4", getCategory4());}
		if(getCategory5()=="") {
			map.put("talent_category5", "null");
			}else {map.put("talent_category5", getCategory5());}
		if(getCategory6()=="") {
			map.put("talent_category6", "null");
			}else {map.put("talent_category6", getCategory6());}
		
		
	    System.out.println(map);
	    if(getPriceA().equals("")&&getPriceB().equals("")) {
	    	map.put("talent_priceA", "null");
		    map.put("talent_priceB", "null");
	    }else if(getPriceA().equals("")) {
	    	map.put("talent_priceA", "0");
		    map.put("talent_priceB", getPriceB());
	    }else if(getPriceB().equals("")) {
	    	map.put("talent_priceA", getPriceA());
	    	map.put("talent_priceB", "1000000000000000");
	    }	else{
		    map.put("talent_priceA", getPriceA());
		    map.put("talent_priceB", getPriceB());
	    }
	    
	    
	    if(getSido().equals("시도선택")) {
	    	map.put("talent_sido","null");
	    }else {
	    	map.put("talent_sido", getSido());
	    }
	    if(getGogon().equals("시군구선택")) {
	    	map.put("talent_gogon","null");
	    }else {
	    	map.put("talent_gogon", getGogon());
	    }
	    if(getSearchKeyword().equals("")) {
	    	map.put("searchKeyword", "null"); 	
	    }else {
	    	map.put("searchKeyword", "%"+getSearchKeyword()+"%");
	    }
	    

	    //정렬 : if 문
	    if(getSort().equals("0")) {
	    	map.put("sort", "talent_no desc");  // 최신순
	    }
	    if(getSort().equals("1")) {
	    	map.put("sort", "readhit desc");  // 인기순
	    }
	    if(getSort().equals("2")) {
	    	map.put("sort", "talent_price asc");  // 저가순
	    }
	    if(getSort().equals("3")) {
	    	map.put("sort", "talent_price desc");  // 고가순
	    }
	    
	    System.out.println(map);
		list=sqlMapper.queryForList("talent.detailSearch", map);
		
	
		
		//페이징
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

	public void setMap(HashMap map) {
		this.map = map;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getCategory4() {
		return category4;
	}

	public void setCategory4(String category4) {
		this.category4 = category4;
	}

	public String getCategory5() {
		return category5;
	}

	public void setCategory5(String category5) {
		this.category5 = category5;
	}

	public String getCategory6() {
		return category6;
	}

	public void setCategory6(String category6) {
		this.category6 = category6;
	}


	public HashMap<String, Object> getMap() {
		return map;
	}

	public talentVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(talentVO paramClass) {
		this.paramClass = paramClass;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		SearchAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		SearchAction.sqlMapper = sqlMapper;
	}

	public List<talentVO> getList() {
		return list;
	}

	public void setList(List<talentVO> list) {
		this.list = list;
	}

	public talentVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(talentVO resultClass) {
		this.resultClass = resultClass;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPriceA() {
		return priceA;
	}

	public void setPriceA(String priceA) {
		this.priceA = priceA;
	}

	public String getPriceB() {
		return priceB;
	}

	public void setPriceB(String priceB) {
		this.priceB = priceB;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGogon() {
		return gogon;
	}

	public void setGogon(String gogon) {
		this.gogon = gogon;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	
	
}
