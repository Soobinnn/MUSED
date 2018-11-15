package talent;

import com.opensymphony.xwork2.ActionSupport;

import product.product_cVO;

import com.ibatis.common.resources.Resources;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;



public class DetailAction extends ActionSupport{
	//ibatis사용하기 위해
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	//객체 전달을 위해
	private talentVO paramClass=new talentVO();
	//처리된 결과 전달을 위해
	private talentVO resultClass=new talentVO();
	private List<talentVO> Mainlist = new ArrayList<talentVO>();
		//현재 페이지 번호
	
	private List<talent_cVO> TcommentList = new ArrayList<talent_cVO>();
	
	private talent_cVO cClass = new talent_cVO();
	private talent_cVO cResult = new talent_cVO();
	
	
	
	private int currentPage;
	private int c_contnum;
	//글 번호
	private int talent_no;
	private List<String> image = new ArrayList();
	private String[] a;
	//비밀번호 체크
	private int c_no;
	private String c_id;
		
	//생성자 -> ibatis에 정의한 내용을 가져다 사용할 수 있음
	public DetailAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");	
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	//상세보기
	public String execute() throws Exception{
		paramClass.setTalent_no(getTalent_no());
		// paramClass의 글번호 넣어주기
				
		sqlMapper.update("talent.updateReadHit", paramClass);
		
		resultClass=(talentVO) sqlMapper.queryForObject("talent.selectOne",getTalent_no());	//해당 글 번호의 정보 한줄 가져오기

		TcommentList=sqlMapper.queryForList("talent.TcommentSelectAll", getTalent_no());
		
		Mainlist=sqlMapper.queryForList("talent.TselectMainImg", getTalent_no());	

		//main_img 경로 추가
		resultClass.setMain_img("/MUSED/talent/img/"+resultClass.getMain_img());

		//image - split으로 나누기
		a=resultClass.getTalent_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			image.add("/MUSED/talent/img/"+a[i]);
			System.out.println(a[i]);
		}
		
		return SUCCESS;
	}

	public String commentDelete() throws Exception{
		cClass = new talent_cVO();
		cResult = new talent_cVO();

		cClass.setC_no(getC_no());
		cClass.setC_id(getC_id());
		sqlMapper.update("talent.deleteTComment",cClass);

		return SUCCESS;
	}
	
	
	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public List<talent_cVO> getTcommentList() {
		return TcommentList;
	}

	public void setTcommentList(List<talent_cVO> tcommentList) {
		TcommentList = tcommentList;
	}

	public List<talent_cVO> getCommentList() {
		return TcommentList;
	}

	public void setCommentList(List<talent_cVO> TcommentList) {
		this.TcommentList = TcommentList;
	}

	public talent_cVO getcClass() {
		return cClass;
	}

	public void setcClass(talent_cVO cClass) {
		this.cClass = cClass;
	}

	public talent_cVO getcResult() {
		return cResult;
	}

	public void setcResult(talent_cVO cResult) {
		this.cResult = cResult;
	}

	public int getC_contnum() {
		return c_contnum;
	}

	public void setC_contnum(int c_contnum) {
		this.c_contnum = c_contnum;
	}

	public List<talentVO> getMainlist() {
		return Mainlist;
	}

	public void setMainlist(List<talentVO> mainlist) {
		Mainlist = mainlist;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		DetailAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		DetailAction.sqlMapper = sqlMapper;
	}

	public talentVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(talentVO paramClass) {
		this.paramClass = paramClass;
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

	public int getTalent_no() {
		return talent_no;
	}

	public void setTalent_no(int talent_no) {
		this.talent_no = talent_no;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String[] getA() {
		return a;
	}

	public void setA(String[] a) {
		this.a = a;
	}

}
