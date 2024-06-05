<%@page import="java.util.ArrayList"%>
<%@page import="test.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<MemberDto> members = new ArrayList<>();
members.add(new MemberDto(1, "김구라", "노량진"));
members.add(new MemberDto(2, "해골", "행신동"));
members.add(new MemberDto(3, "원숭이", "동물원"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list</title>
</head>
<body>
	<h3>회원목록</h3>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
			<%for(MemberDto tmp : members) {%>
			<tr>
				<td><% out.print(tmp.getNum()); %></td>
				<td><%=tmp.getName() %></td>
				<td><%=tmp.getAddr() %></td>
			</tr>
			<%} %>
		</thead>
	</table>
</body>
</html>