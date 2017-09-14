<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
    <body>
	    <!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.hovertable {
font-family: verdana,arial,sans-serif;
font-size:12px;
color:#333333;
border-width: 1px;
border-color: #999999;
border-collapse: collapse;
}
table.hovertable th {
background-color:#009688;
border-width: 1px;
padding: 10px;
border-style: solid;
border-color: #a9c6c9;
width: 80px;
heigth: 30px;
}
table.hovertable tr {
background-color:#B2EBF2;

heigth: 30px;
}
table.hovertable td {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
width: 120px;
heigth: 30px;

}
td:hover
{ 
background-color:yellow;
}
</style>


<!-- Table goes in the document BODY -->
<table class="hovertable">
	<tr>
	<th>syllabus</th><th>星期日</th><th>星期一 </th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th><th>星期六</th>
	</tr>
		
	<tr onmouseover="this.style.backgroundColor='#FF4081';" onmouseout="this.style.backgroundColor='#B2DFDB';">
		<td>1-2</td>
		<td></td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='1-2' }">
					<c:if test="${st.classWeek=='星期一' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='1-2' }">
					<c:if test="${st.classWeek=='星期二' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='1-2' }">
					<c:if test="${st.classWeek=='星期三' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='1-2' }">
					<c:if test="${st.classWeek=='星期四' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='1-2' }">
					<c:if test="${st.classWeek=='星期五' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td></td>
		
	</tr>
	<tr onmouseover="this.style.backgroundColor='#FF4081';" onmouseout="this.style.backgroundColor='#B2DFDB';">
		<td>3-4</td>
		<td></td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='3-4' }">
					<c:if test="${st.classWeek=='星期一' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='3-4' }">
					<c:if test="${st.classWeek=='星期二' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='3-4' }">
					<c:if test="${st.classWeek=='星期三' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='3-4' }">
					<c:if test="${st.classWeek=='星期四' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='3-4' }">
					<c:if test="${st.classWeek=='星期五' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td></td>
		
	</tr>
	<tr onmouseover="this.style.backgroundColor='#FF4000';" onmouseout="this.style.backgroundColor='#D2DFDB';">
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr onmouseover="this.style.backgroundColor='#FF4081';" onmouseout="this.style.backgroundColor='#B2DFDB';">
		<td>5-6</td>
		<td></td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='5-6' }">
					<c:if test="${st.classWeek=='星期一' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='5-6' }">
					<c:if test="${st.classWeek=='星期二' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='5-6' }">
					<c:if test="${st.classWeek=='星期三' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='5-6' }">
					<c:if test="${st.classWeek=='星期四' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='5-6' }">
					<c:if test="${st.classWeek=='星期五' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td></td>
		
	</tr>
	<tr onmouseover="this.style.backgroundColor='#FF4081';" onmouseout="this.style.backgroundColor='#B2DFDB';">
		<td>7-8</td>
		<td></td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='7-8' }">
					<c:if test="${st.classWeek=='星期一' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='7-8' }">
					<c:if test="${st.classWeek=='星期二' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='7-8' }">
					<c:if test="${st.classWeek=='星期三' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='7-8' }">
					<c:if test="${st.classWeek=='星期四' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${syllabusTable }" var="st">
				<c:if test="${st.classTime=='7-8' }">
					<c:if test="${st.classWeek=='星期五' }">
						${st.subjectName }<br/>
						${st.teacherName }<br/>
						${st.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td></td>
	</tr>
	<tr onmouseover="this.style.backgroundColor='#FF4000';" onmouseout="this.style.backgroundColor='#D2DFDB';">
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr onmouseover="this.style.backgroundColor='#FF4081';" onmouseout="this.style.backgroundColor='#B2DFDB';">
		<td>9-10</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期日' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期一' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期二' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期三' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期四' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期五' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		<td>
			<c:forEach items="${selectTable }" var="ss">
				<c:if test="${ss.classTime=='9-10' }">
					<c:if test="${ss.classWeek=='星期六' }">
						${ss.subjectName }<br/>
						${ss.teacherName }<br/>
						${ss.locationName }/2节
					</c:if>
				</c:if>
			</c:forEach>
		</td>
		
	</tr>
	

</table>
    </body>
</html>