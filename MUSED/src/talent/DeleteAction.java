package talent;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

public class DeleteAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private talentVO paramClass; //�Ķ���͸� ������ ��ü
	private talentVO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage;	//���� ������
	
	private String fileUploadPath = "C:\\Users\\bogiy\\OneDrive\\���� ȭ��\\�ڹ�\\MUSED\\MUSED\\WebContent\\talent\\img\\";
	
	private int talent_no;		
	private List<String> image = new ArrayList();
	private String[] a;

	
	// ������
	public DeleteAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	// �Խñ� �� ����
	public String execute() throws Exception {
		
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new talentVO();
		resultClass = new talentVO();
		
		// �ش� ��ȣ�� ���� �����´�.
		resultClass = (talentVO) sqlMapper.queryForObject("talent.selectOne", getTalent_no());

		//���� ���� ����
		File deleteFile = new File(fileUploadPath + resultClass.getMain_img());
		deleteFile.delete();
		
		
		a=resultClass.getTalent_image().split(",");		
		for(int i= 0 ; i < a.length;i++) {
			File deleteFile1 = new File(fileUploadPath+a[i]);
			deleteFile1.delete();
		}
				
		// ������ �׸� ����.
		paramClass.setTalent_no(getTalent_no());
				
		// ���� ���� ����.
		sqlMapper.update("talent.deleteTalent", paramClass);

		return SUCCESS;
	}


	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		DeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		DeleteAction.sqlMapper = sqlMapper;
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

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
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
