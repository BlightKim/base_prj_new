<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>R-BAY</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,viewport-fit=cover, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <link rel="shortcut icon" href="/static/images/favicon.ico" />
    <link href="/static/css/font.css" rel="stylesheet" type="text/css" />
    <link href="/static/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="/static/css/common.css" rel="stylesheet" type="text/css" />
    <link href="/static/css/style_work.css" rel="stylesheet" type="text/css" />
    <script src="/static/js/jquery-1.12.4.js" type="text/javascript"></script>
    <script src="/static/js/comm.js" type="text/javascript"></script>
</head>
<body>
<article>
    <div>
        <tiles:insertAttribute name="emptyBody"/>

        <p> 데이터 처리 과정에서 문제가 발생하였습니다. </p>
        <p> 관리자에게 문의하여 주십시오. </p>
        <p>status : ${errorStatus}</p>
        <p>오류코드 : ${errorCode}</p>
        <p>메세지 : ${errorMessage}</p>
        <c:if test="${activeProfile eq 'local'}">
            <ul>
                <c:forEach items="${exception.getStackTrace()}" var="stack">
                    <li>${stack.toString()}</li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
</article>
</body>
</html>
