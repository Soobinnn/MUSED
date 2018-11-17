package admin;


import com.opensymphony.xwork2.ActionSupport;

import admin.pagingAction;
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
	
	public String execute() throws Exception
	{
		list = sqlMapper.queryForList("member.selectAll");
		
		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		
		// pagingAction ��ü ����.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage);
				
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.
				
		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;
		
		// ���� �������� ������ �۹�ȣ�� ��ü ������ �۹�ȣ���� ������, lastCount�� +1��ȣ�� ����
		if (page.getEndCount() < totalCount)
		{
			lastCount = page.getEndCount() + 1;
		}
				
		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}

	public List<MemberVO> getList() {
		return list;
	}

	public void setList(List<MemberVO> list) {
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
