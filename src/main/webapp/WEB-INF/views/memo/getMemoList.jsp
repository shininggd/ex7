<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<table>
		<tr>
			<td>NUM</td><td>CONTENTS</td><td>WRITER</td><td>DATE</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>${dto.contents}</td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
			</tr>
		</c:forEach>
	
	</table>
