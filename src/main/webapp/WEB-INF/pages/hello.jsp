<%--
  Created by IntelliJ IDEA.
  @autorh miroslavkopecky
  Date: 5/23/14

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Miko Spring-Birt with Neo4j Example App</title>
</head>
<body>
    <h1>${message}</h1>
    fake "CarService" = ${cars}

    <h1>BIRT Report</h1>
    <p>
        <a href="<c:url value="/reports">
            <c:param name="ReportName" value="TopNPercent.rptdesign"/>
            </c:url>">
            1. BIRT Report
        </a><br>

        <a href="<c:url value="/reports">
            <c:param name="ReportName" value="SampleSpring.rptdesign"/>
            </c:url>">
            2. BIRT Report with FakeSpringService
        </a><br>

        <a href="<c:url value="/reports">
            <c:param name="ReportName" value="SampleNeoSpring.rptdesign"/>
            </c:url>">
            3. BIRT Report with SpringService and Neo
        </a><br>

        <a href="<c:url value="/reports">
            <c:param name="ReportName" value="SampleNeoCarGarage.rptdesign"/>
            </c:url>">
            3. BIRT Report with SpringService and Neo: Car Ford and Garage
        </a><br>

    </p>
    <%= new java.util.Date() %>

</body>
</html>
