<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SOUND TAG ADMIN</title>
        <meta name="author" content="" />
        <meta name="description" content="" />
        <meta name="keywords"  content="" />

        <!-- 파비콘  -->
        <link rel="shortcut icon" href="/static/images/favicon.ico" type="image/x-icon">

        <!-- css -->
        <link rel="stylesheet" href="/static/css/reset.css">
        <link rel="stylesheet" href="/static/css/common.css">
        <link rel="stylesheet" href="/static/css/content.css">
        <link rel="stylesheet" href="/static/swiper/css/swiper.css">

        <!-- script -->
        <script src="/static/scripts/jquery-3.1.1.min.js"></script>
        <script src="/static/swiper/js/swiper.js"></script>

        <!-- 퍼블리셔 커스텀 js -->
        <script src="/static/scripts/script.js"></script>

        <script src="/static/js/jquery.js"></script>
        <script src="/static/js/jquery.form.min.js"></script>
        <script src="/static/js/jquery-ui.min.js"></script>
        <script src="/static/js/common.js"></script>

        <%-- table sorter --%>
        <script type="text/javascript" src="/static/js/jquery.tablesorter.min.js"></script>
        <link rel="stylesheet" href="/static/css/theme.default.min.css">


      <%--  <!-- datepicker -->
        <link type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" />
        <link rel="stylesheet" href="/static/css/datepicker.css">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>--%>

     <%--datepicker--%>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



    </head>
    <body>
        <div class="content_wrapper">
            <tiles:insertAttribute name="adminMenu" />  <!-- 왼쪽 사이드메뉴 -->
            <div class="right_wrapper">   <!-- 오른쪽 Wrapper -->
                <tiles:insertAttribute name="adminHeader" />     <!-- 헤더 -->
                <tiles:insertAttribute name="body" />            <!-- 콘텐츠 -->
            </div>
        </div>
    </body>
</html>
