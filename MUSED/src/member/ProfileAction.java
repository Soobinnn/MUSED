package member;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import org.apache.struts2.interceptor.SessionAware;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

import java.awt.Image;
import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiUtils;

public class ProfileAction extends ActionSupport implements SessionAware {

	public static Reader reader; // ���� ��Ʈ���� ���� reader
	public static SqlMapClient sqlMapper; // SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü

	private MemberVO paramClass; // �Ķ���͸� ������ ��ü
	private MemberVO resultClass; // ���� ��� ���� ������ ��ü

	private String id;
	private String file_orgName; // ���ε� ������ ���� �̸�
	private String file_savName; // ������ ������ ���ε� ������ �̸�. ���� ��ȣ�� �����Ѵ�.

	private File[] upload; // ���� ��ü
	private String[] uploadContentType; // ������ Ÿ��
	private String[] uploadFileName; // ���� �̸�
	private String fileUploadPath = "C:\\Java\\upload\\"; // ���ε� ���

	private Map session;

	String filePath = "C:\\Java\\upload\\";

	public ProfileAction() throws Exception {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����
		reader.close();
	}

	public String execute() throws Exception {

		paramClass = new MemberVO();
		resultClass = new MemberVO();

		if (upload.length > 0) {

			resultClass = (MemberVO) sqlMapper.queryForObject("member.selectOne", (String) session.get("ID"));
			for (int i = 0; i < upload.length; i++) {

				// ���� ������ ����� ���� �̸��� Ȯ���� ����
				String file_name = "file_" + resultClass.getId();
				String file_ext = getUploadFileName()[i].substring(getUploadFileName()[i].lastIndexOf('.') + 1,
						getUploadFileName()[i].length());

				// ������ ���� ����
				File destFile = new File(fileUploadPath + file_name + "." + file_ext);
				FileUtils.copyFile(getUpload()[i], destFile);

				// ���� ���� �Ķ���� ����
				paramClass.setId(resultClass.getId());
				paramClass.setFile_orgname(getUploadFileName()[i]);
				paramClass.setFile_savname(file_name + "." + file_ext);
			}
			// ���� ���� ������Ʈ
			sqlMapper.update("member.updateProfile", paramClass);
			
			//����� �����
			String orgImg = filePath + "file_" + resultClass.getId() + ".jpg";// ��������
			String thumbImg = filePath + "thum_" + resultClass.getId() + ".jpg";// ���������
			int thumbWidth = 160;// ����� ����
			int thumbHeight = 160;// ����� ����
			Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// ����� ����
			Jimi.putImage(thumbnail, thumbImg);// ����� ����
			
		}

		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		ProfileAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		ProfileAction.sqlMapper = sqlMapper;
	}

	public MemberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(MemberVO paramClass) {
		this.paramClass = paramClass;
	}

	public MemberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(MemberVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getFile_orgName() {
		return file_orgName;
	}

	public void setFile_orgName(String file_orgName) {
		this.file_orgName = file_orgName;
	}

	public String getFile_savName() {
		return file_savName;
	}

	public void setFile_savName(String file_savName) {
		this.file_savName = file_savName;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

}
