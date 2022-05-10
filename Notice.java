package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {

	//VO클래스
	
	//필드부
	private int noticeNO;  //NOTICE_NO NUMBER PRIMARY KEY,
    private String noticeTitle;	//NOTICE_TITLE VARCHAR2(100) NOT NULL,
	private String noticeContent; //NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
	private String noticeWriter;//NOTICE_WRITER NUMBER NOT NULL,=> int지만 화면으로는 문자이기에 String
	private int count;//COUNT NUMBER DEFAULT 0,
	private Date createDate;//CREATE_DATE DATE DEFAULT SYSDATE NOT NULL,
	private String status;//STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N'))
	
	
	//생성자부
	public Notice() {
		super();
	} 
	public Notice(int noticeNO, String noticeTitle, String noticeContent, String noticeWriter, int count,
			Date createDate, String status) {
		super();
		this.noticeNO = noticeNO;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}
	// 공지사항 전체조회용 생성자
	public Notice(int noticeNO, String noticeTitle, String noticeWriter, int count, Date createDate) {
		super();
		this.noticeNO = noticeNO;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.count = count;
		this.createDate = createDate;
	}
	
	// 공지사항 상세보기용 생성자
	public Notice(int noticeNO, String noticeTitle, String noticeContent, String noticeWriter, Date createDate) {
		super();
		this.noticeNO = noticeNO;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
		this.createDate = createDate;
	}
	
	//메소드부
	public int getNoticeNO() {
		return noticeNO;
	}
	
	
	public void setNoticeNO(int noticeNO) {
		this.noticeNO = noticeNO;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notice [noticeNO=" + noticeNO + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", count=" + count + ", createDate=" + createDate + ", status="
				+ status + "]";
	}	
}
