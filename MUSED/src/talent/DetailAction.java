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
	//ibatis����ϱ� ����
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	//��ü ������ ����
	private talentVO paramClass=new talentVO();
	//ó���� ��� ������ ����
	private talentVO resultClass=new talentVO();
	private List<talentVO> list = new ArrayList<talentVO>();
		//���� ������ ��ȣ
	private int currentPage;
	
	//�� ��ȣ
	private int talent_no;
	private List<String> image = new ArrayList();
	private String[] a;
	//��й�ȣ üũ
	private String password;
		
	//������ -> ibatis�� ������ ������ ������ ����� �� ����
	public DetailAction() throws IOException{
		reader=Resources.getResourceAsReader("sqlMapConfig.xml");	
		sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	//�󼼺���
	public String execute() throws Exception{
		paramClass.setTalent_no(getTalent_no());
		// paramClass�� �۹�ȣ �־��ֱ�
				
		resultClass=(talentVO) sqlMapper.queryForObject("talent.selectOne",getTalent_no());	//�ش� �� ��ȣ�� ���� ���� ��������

		list=sqlMapper.queryForList("talent.selectAll");	//list ����� ����

		//main_img ��� �߰�
		resultClass.setMain_img("/MUSED/talent/img/"+resultClass.getMain_img());

		//image - split���� ������
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
