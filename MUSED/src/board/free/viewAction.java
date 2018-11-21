package board.free;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.tiles.*;
import org.apache.tiles.access.*;




public class viewAction extends ActionSupport {
	  public static Reader reader;
	  public static SqlMapClient sqlMapper;
	  
	  private boardVO paramClass = new boardVO(); //boardVO�뿉�꽌 �깮�꽦�븳 parameter�뱾�쓣 ���옣�븷 媛앹껜 paramClass
	  private boardVO resultClass = new boardVO(); //泥섎━�맂 荑쇰━ 寃곌낵 媛믪쓣 ���옣�븯湲� �쐞�븳 媛앹껜
	  private List<cboardVO> commentlist = new ArrayList<cboardVO>();
	  
	  private cboardVO cClass = new cboardVO(); //cboardVO�뿉�꽌 �깮�꽦�븳 parameter瑜� ���옣�븷 媛앹껜 cClass
	  private cboardVO cResult = new cboardVO(); //泥섎━�맂 荑쇰━ 寃곌낵媛믪쓣 ���옣�븯湲� �쐞�븳 媛앹껜
	  
	  private int currentPage = 1;
	  
	  private int no;
	  private int originno;
	  
	  private int name;
	  
	  private String password;
	  
	  private String fileUploadPath = "c:\\Java\\upload\\";
	  
	  private InputStream inputStream;
	  private String contentDisposition; //�뙆�씪紐�?�뙆�씪 �냽�꽦怨� 愿��젴�맂 媛앹껜 �깮�꽦
	  private long contentLength;
	  
	  
	  
	  
	  //�깮�꽦�옄
	  public viewAction() throws IOException{
		   
		  reader = Resources.getResourceAsReader("sqlMapConfig.xml"); //sqlMapConfig.xml xml�뙆�씪�쓽 �꽕�젙 �궡�슜�쓣 媛��졇���꽌 reader 媛앹껜瑜� �깮�꽦�븳�떎.
		  sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);//sqilMapConfig.xml�쓽 �궡�슜�쓣 �쟻�슜�븳 sqlMapper媛앹껜 �깮�꽦
		  
		  reader.close();
	  }

	  //�떎�뻾 硫붿냼�뱶
	  public String execute() throws Exception{
		  
		   // �빐�떦 湲��쓽 議고쉶�닔 +1
		    paramClass.setNo(getNo()); //湲� 踰덊샇 �깮�꽦
		    sqlMapper.update("free.updateReadHit", paramClass); // 議고쉶�닔 利앷�
		    
		    //�빐�떦 踰덊샇�쓽 湲��쓣 媛��졇�삩�떎.
		    //queryForObect : DB濡쒕��꽣 1媛쒖쓽 �젅肄붾뱶瑜� 媛��졇�� ���옣�븳�떎. �몢媛� �씠�긽�쓽 �젅肄붾뱶媛� 諛섑솚�릺�뒗 寃쎌슦 �삁�쇅泥섎━�릺硫� 媛믪씠 �뾾�쓣 寃쎌슦 null�쓣 諛섑솚�븳�떎.
		    //queryForList : DB濡쒕��꽣 2媛� �씠�긽�쓽 �젅肄붾뱶瑜� 媛��졇�� �옄諛� 媛앹껜�쓽 List瑜� 留뚮뱶�뒗 �뜲 �궗�슜�븳�떎.
		    resultClass = (boardVO) sqlMapper.queryForObject("free.selectOne", getNo());
		    
		    commentlist = sqlMapper.queryForList("free.commentSelectAll", getNo());
		    
		    return SUCCESS;
	  }

       //泥⑤� �뙆�씪 �떎�슫濡쒕뱶
	  public String download() throws Exception{
		    
		  //�빐�떦 踰덊샇�쓽 �뙆�씪 �젙蹂대�� 媛��졇�삩�떎.
		  resultClass = (boardVO) sqlMapper.queryForObject("free.selectOne", getNo());
		  
		  //�뙆�씪 寃쎈줈�� �뙆�씪紐낆쓣 file媛앹껜�뿉 �꽔�뒗�떎.
		  File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());
		  
		  System.out.print(resultClass.getFile_savname());
		  
		  //�떎�슫濡쒕뱶 �뙆�씪 �젙蹂� �꽕�젙
		  setContentLength(fileInfo.length());
		  setContentDisposition("attachment;filename=" + URLEncoder.encode(resultClass.getFile_orgname(), "utf-8")); //�뙆�씪�씠 �븳湲��씤 寃쎌슦 源⑥��뒗 寃껋쓣 諛⑹�
		  setInputStream(new FileInputStream(fileUploadPath + resultClass.getFile_savname()));
		  
	      /*File fileInfo = new File(fileUploadPath + fileDownloadName);
	      setContentLength(fileInfo.length());
	      setContentDisposition("attachment; filename="+URLEncoder.encode(fileDownloadName, "utf-8"));
		  setInputStream(new FileInputStream(fileUploadPath + fileDownloadName));*/
		  
		  return SUCCESS;
	  }
	  
	   //鍮꾨�踰덊샇 泥댄겕 �뤌 -> checkPassword.jsp濡� �뿰寃곕맂�떎
	    public String checkForm() throws Exception{
	    	
	    	return SUCCESS;
	    }
	    
	    //鍮꾨�踰덊샇 泥댄겕 �븸�뀡 -> checkAction 硫붿냼�뱶�뒗 error由ы꽩 �떆 checkError.jsp濡� �뿰寃곕릺怨� success由ы꽩 �떆 checkSuccess.jsp濡� �뿰寃곕맂�떎.
	    public String checkAction() throws Exception{
	    	
	    	  // 鍮꾨�踰덊샇 �엯�젰媛� �뙆�씪誘명꽣 �꽕�젙
	    	paramClass.setNo(getNo()); //湲� 踰덊샇瑜� 諛쏅뒗�떎
	    	paramClass.setPassword(getPassword()); //鍮꾨�踰덊샇瑜� 諛쏅뒗�떎
	    	
	    	//�쁽�옱 湲��쓽 鍮꾨�踰덊샇 媛��졇�삤湲�
	    	resultClass = (boardVO) sqlMapper.queryForObject("free.selectPassword", paramClass);
	    	
	    	//�엯�젰 �떆 鍮꾨�踰덊샇媛� ��由щ㈃ ERROR 由ы꽩
	    	if(resultClass == null)
	    		return ERROR;
	    	
	    	return SUCCESS;
	    }

             // 肄붾찘�듃�엯�젰,�궘�젣�� �뿰愿��맂 硫붿냼�뱶. �쐞�� 留덉갔媛�吏�濡� error, success 由ы꽩 �떆 媛곴컖 �빐�떦 jsp濡� �뿰寃곕맂�떎.
	    public String checkAction2() throws Exception{
	    	
	    	
	    	
	    	
	    	cClass.setNo(getNo()); // boardVO�쓽 no�� �떎瑜� cboardVO�뿉�꽌 �깮�꽦�븳 �뙎湲��쓽 no
	    	/*cClass.setPassword(getPassword());*/
	    	cClass.setOriginno(getOriginno()); //�뙎湲��씠 �냽�븳 �썝 湲��쓽 踰덊샇瑜� 媛��졇�삩�떎.
	    	cResult = (cboardVO) sqlMapper.queryForObject("free.selectPassword2", cClass); // �쁽�옱 �뙎湲��쓽 鍮꾨�踰덊샇瑜� DB濡쒕��꽣 媛��졇�삩�떎.
	        if(cResult == null) //DB�뿉�꽌 媛��졇�삩 鍮꾨�踰덊샇�� �씪移섑븯�뒗 寃껋씠 �뾾�쑝硫� error, �씪移섑븯硫� success瑜� 由ы꽩
	    		    return ERROR;
	    	return SUCCESS;
	    }
	    
	    

		public static Reader getReader() {
			return reader;
		}

		public static void setReader(Reader reader) {
			viewAction.reader = reader;
		}

		public static SqlMapClient getSqlMapper() {
			return sqlMapper;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			viewAction.sqlMapper = sqlMapper;
		}

		public boardVO getParamClass() {
			return paramClass;
		}

		public void setParamClass(boardVO paramClass) {
			this.paramClass = paramClass;
		}

		public boardVO getResultClass() {
			return resultClass;
		}

		public void setResultClass(boardVO resultClass) {
			this.resultClass = resultClass;
		}

		public List<cboardVO> getCommentlist() {
			return commentlist;
		}

		public void setCommentlist(List<cboardVO> commentlist) {
			this.commentlist = commentlist;
		}

		public cboardVO getcClass() {
			return cClass;
		}

		public void setcClass(cboardVO cClass) {
			this.cClass = cClass;
		}

		public cboardVO getcResult() {
			return cResult;
		}

		public void setcResult(cboardVO cResult) {
			this.cResult = cResult;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public int getOriginno() {
			return originno;
		}

		public void setOriginno(int originno) {
			this.originno = originno;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFileUploadPath() {
			return fileUploadPath;
		}

		public void setFileUploadPath(String fileUploadPath) {
			this.fileUploadPath = fileUploadPath;
		}

		public InputStream getInputStream() {
			return inputStream;
		}

		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		public String getContentDisposition() {
			return contentDisposition;
		}

		public void setContentDisposition(String contentDisposition) {
			this.contentDisposition = contentDisposition;
		}

		public long getContentLength() {
			return contentLength;
		}

		public void setContentLength(long contentLength) {
			this.contentLength = contentLength;
		}

		public int getName() {
			return name;
		}

		public void setName(int name) {
			this.name = name;
		}



}