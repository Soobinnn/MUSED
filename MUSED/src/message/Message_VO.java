package message;

import java.util.Date;


public class Message_VO {

	private int msg_no; // ��ȣ
	private String msg_wrt_id; // ������ ��� id
	private String msg_rec_id; // �޴� ��� id
	private String msg_content; // ����
	private Date msg_regdate; // ������ ��¥
	
	public int getMsg_no() {
		return msg_no;
	}
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	public String getMsg_wrt_id() {
		return msg_wrt_id;
	}
	public void setMsg_wrt_id(String msg_wrt_id) {
		this.msg_wrt_id = msg_wrt_id;
	}
	public String getMsg_rec_id() {
		return msg_rec_id;
	}
	public void setMsg_rec_id(String msg_rec_id) {
		this.msg_rec_id = msg_rec_id;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getMsg_regdate() {
		return msg_regdate;
	}
	public void setMsg_regdate(Date msg_regdate) {
		this.msg_regdate = msg_regdate;
	}
	

}
