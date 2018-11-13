
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
 <!-- 썸네일 관련 import -->
<%@page import="java.awt.Image"%>
<%@page import="com.sun.jimi.core.Jimi"%>
<%@page import="com.sun.jimi.core.JimiException"%>
<%@page import="com.sun.jimi.core.JimiUtils"%>
 <!-- 썸네일 관련 import -->
<%
        String filePath = "C:\\Java\\upload\\";
 
        String orgImg = filePath+"file_sdk6789.jpg";//원본파일
        String thumbImg = filePath+"thum_sdk6789.jpg";//썸네일파일
        int thumbWidth = 160 ;//썸네일 가로
        int thumbHeight = 160 ;//썸네일 세로
 
        Image thumbnail = JimiUtils.getThumbnail(orgImg, thumbWidth, thumbHeight, Jimi.IN_MEMORY);// 썸네일 설정
        Jimi.putImage(thumbnail, thumbImg);// 썸네일 생성
%>
