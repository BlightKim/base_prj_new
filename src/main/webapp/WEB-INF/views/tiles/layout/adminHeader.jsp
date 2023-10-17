<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- 헤더 -->
<div class="header">
    <div class="header_top ">
        <div class="header_top_left">
            <div class="header_title">
                <h4>
                    <c:forEach items="${authMenuList}" var="authMenuList">
                        <c:if test="${authMenuList.depth eq 1 && authMenuList.groupMenu eq 'Y'}">
                            ${authMenuList.menuName}
                        </c:if>
                    </c:forEach>

                </h4>
            </div>
        </div>
        <div class="header_top_right">
            <ul class="state_list">
                <li>
                    <p>안녕하세요. <span>${mngrVo.mngrName}</span>님</p>
                </li>
            </ul>
            <div class="login">
                <a href="/system/logout">
                    <p>로그아웃</p>
                </a>
            </div>
        </div>
    </div>

    <div class="shadow_box menu_toggle">
        <button type="button">
            <img src="/static/images/close.svg" alt="메뉴 닫기">
        </button>
    </div>
    <div class="header_top_mo ">
        <div class="header_menu_btn">
            <button type="button" class="menu_toggle">
                <img src="/static/images/menu.svg" alt="">
            </button>
        </div>
        <div class="header_title">
            현재페이지명
        </div>
        <div class="user_menu_wrap">
            <div class="user_menu">
                <a href="#none">
                    <div class="txt">
                        <i style="background: url(/static/images/i_user.svg); background-size: cover;"></i>
                    </div>
                </a>
            </div>
            <ul class="user_menu_list">
                <li>
                    <a href="">
                        내 정보 관리
                    </a>
                </li>
                <li>
                    <a href="">
                        로그아웃
                    </a>
                </li>
            </ul>
        </div>
    </div>


    <div class="header_nav">
        <ul>
        <c:forEach items="${authMenuList}" var="authMenuList">
            <c:if test="${authMenuList.depth ne 1 && authMenuList.groupMenu eq 'Y'}">
                <c:if test="${authMenuList.currMenu eq 'Y'}"><li class="on"></c:if>
                <c:if test="${authMenuList.currMenu ne 'Y'}"><li class=""></c:if>

                    <a href="${authMenuList.linkUrl}">
                            ${authMenuList.menuName}
                    </a>
                </li>
                <li>|</li>

            </c:if>
        </c:forEach>
        </ul>
           <%-- <li class="on">
                <a href="">
                    소속 관리
                </a>
            </li>
            <li>|</li>
            <li>
                <a href="">
                    학생 관리
                </a>
            </li>
            <li>|</li>
            <li>
                <a href="">
                    학부모 관리
                </a>
            </li>
            <li>|</li>
            <li>
                <a href="">
                    교사 관리
                </a>
            </li>--%>

    </div>
</div>
<!-- // 헤더 -->