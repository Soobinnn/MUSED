package talent;

import com.opensymphony.xwork2.ActionSupport;
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
	private List<talentVO> list = new ArrayList<talentVO>();
		//현재 페이지 번호
	private int currentPage;
	
	//글 번호
	private int talent_no;
	private List<String> image = new ArrayList();
	private String[] a;
	//비밀번호 체크
	private String password;
		
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
				
		resultClass=(talentVO) sqlMapper.queryForObject("talent.selectOne",getTalent_no());	//해당 글 번호의 정보 한줄 가져오기

		list=sqlMapper.queryForList("talent.selectAll");	//list 출력을 위해

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

	
	public List<talentVO> getList() {
		return list;
	}

	public void setList(List<talentVO> list) {
		this.list = list;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
