package product;

import com.opensymphony.xwork2.ActionSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


import java.util.*;

import java.io.Reader;
import java.io.IOException;

import product.pagingAction;

public class SearchAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<productVO> list = new ArrayList<productVO>();
	private productVO resultClass = new productVO(); //쿼리 결과 값을 저장할 객체
	private productVO paramClass = new productVO();
	
	private String category;
	private String[] cateList = new String[6];	//cateList[0]~[6]->product123456
	private String priceA;
	private String priceB;
	private String sido;
	private String gogon;
	private String searchKeyword;
	
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
		System.out.println(getCategory());
		System.out.println(getPriceA());
		System.out.println(getPriceB());
		System.out.println(getSido());
		System.out.println(getGogon());
		System.out.println(getSearchKeyword());

		cateList=getCategory().split(", ");	
		
		
		for(int i=0;i<6;i++) {
			System.out.println(cateList[i]);
		}
	
	/*	if(cateList[0]=="") {
			map.put("product_category1", "null");
			}else {map.put("product_category1", cateList[0]);}
		if(cateList[1]=="") {
		    map.put("product_category2", "null");
			}else {map.put("product_category2", cateList[1]);}
		if(cateList[2]=="") {
		    map.put("product_category3", "null");
			}else {map.put("product_category3", cateList[2]);}
		if(cateList[3]=="") {
		    map.put("product_category4", "null");
			}else {map.put("product_category4", cateList[3]);}
		if(cateList[4]=="") {
			map.put("product_category5", "null");
			}else {map.put("product_category5", cateList[4]);}
		if(cateList[5]=="") {
			map.put("product_category6", "null");
			}else {map.put("product_category6", cateList[5]);}*/

	    System.out.println(map);
	    if(getPriceA().equals("")&&getPriceB().equals("")) {
	    	map.put("product_priceA", "0");
		    map.put("product_priceB", "10000000000000000");
	    }else {
		    map.put("product_priceA", getPriceA());
		    map.put("product_priceB", getPriceB());
	    }
	    if(getSido().equals("시도선택")) {
	    	map.put("product_sido","null");
	    }else {
	    	map.put("product_sido", getSido());
	    }
	    if(getGogon().equals("시군구선택")) {
	    	map.put("product_gogon","null");
	    }else {
	    	map.put("product_gogon", getGogon());
	    }
	    if(getSearchKeyword().equals("")) {
	    	map.put("searchKeyword", "null"); 	
	    }else {
	    	map.put("searchKeyword", "%"+getSearchKeyword()+"%");
	    }
	    System.out.println(map);
		list=sqlMapper.queryForList("product.detailSearch", map);
		
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



	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public productVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(productVO paramClass) {
		this.paramClass = paramClass;
	}

	public String[] getCateList() {
		return cateList;
	}

	public void setCateList(String[] cateList) {
		this.cateList = cateList;
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

	public List<productVO> getList() {
		return list;
	}

	public void setList(List<productVO> list) {
		this.list = list;
	}

	public productVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(productVO resultClass) {
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

	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
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
