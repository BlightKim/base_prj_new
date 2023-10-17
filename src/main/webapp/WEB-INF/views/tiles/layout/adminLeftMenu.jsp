<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div class="left_sidebar">
    <div class="left_sidebar_sticky">
        <div class="logo">
            <img src="/static/images/logo.svg" alt="로고">
        </div>
        <ul class="gnb_list">
            <li class="user_menu_wrap">
                <div class="user_menu">
                    <a href="#none">
                        <div class="txt">
                            <i style="background: url(/static/images/i_user.svg); background-size: cover;"></i>
                            <p>${mngrVo.mngrName}님</p>
                        </div>
                        <div class="gnb_arrow">
                            <img src="/static/images/gnb_arrow.svg" alt="">
                        </div>
                    </a>
                </div>
            </li>





            <c:set var="preDepth" value="0"/>
            <c:set var="preCate" value="0"/>

            <c:forEach items="${authMenuList}" var="authMenuList">

                <c:if test="${authMenuList.depth eq '1' }">
                    <c:if test="${preDepth eq '1' }"></li></c:if>
                    <c:if test="${preDepth eq '2' }"></ul></c:if>

                    <c:if test="${authMenuList.mainMenu eq 'Y' or pageUrl eq authMenuList.linkUrl}"><li class="depth on"></c:if>
                    <c:if test="${authMenuList.mainMenu eq 'N'}"><li class="depth "></c:if>
                        <div class="gnb_depth1">
                            <a href="#none">
                                <div class="txt">
                                    <i><img src="/static/images/gnb_icon1.svg" alt="사용자 아이콘"></i>
                                    <p>${authMenuList.menuName}</p>
                                </div>
                                <div class="gnb_arrow">
                                    <img src="/static/images/gnb_arrow.svg" alt="">
                                </div>
                            </a>
                        </div>
                    </c:if>
                    <c:if test="${authMenuList.depth ne '1' }">
                        <c:if test="${preDepth == 1 }"><ul class="gnb_depth2"></c:if>

                            <c:if test="${authMenuList.currMenu eq 'Y' or pageUrl eq authMenuList.linkUrl}"><li class="on"></c:if>
                            <c:if test="${authMenuList.currMenu eq 'N' }"><li class=""></c:if>

                                <a href="${authMenuList.linkUrl}">
                                    <p>${authMenuList.menuName}</p>
                                </a>
                            </li>
                    </c:if>
                    <c:set var="preDepth" value="${authMenuList.depth}"/>

            </c:forEach>
        </ul>
    </div>
</div>