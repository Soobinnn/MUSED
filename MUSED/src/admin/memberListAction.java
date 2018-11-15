package admin;


import com.opensymphony.xwork2.ActionSupport;

import report.pagingAction;
import member.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class memberListAction extends ActionSupport
{
	public static Reader reader; //���� ��Ʈ���� ���� reader
	public static SqlMapClient sqlMapper; ////SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.
	private List<MemberVO> list =  new ArrayList<MemberVO>();
	
	private int currentPage = 1;	//���� ������
	private int totalCount;			//�� �Խù��� ��
	private int blockCount = 10;	//�� �������� �Խù��� ��
	private int blockPage = 5;		//�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;		//����¡�� ������ HTML
	private pagingAction page;		//����¡ Ŭ����
	
	public memberListAction() throws IOException
	{
		// sqlMapConfig.xml������ ���������� ������
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); 
						
		// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
						
		reader.close();	
	}
	
}
