<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <%--    부트스트랩--%>
    <!-- CSS only -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<form name="frm"  id="frm" action="">
    <div class="img_wrapper">
        <img class="mb-4" src="/static/img/logo.PNG" alt="" width="72" height="72"/>
    </div>
    <label for="userId" class="login_input">아이디</label>
    <input  type="text" id="userId" class="form-control" name="userId"
                placeholder="아이디를 입력해주세요"/>
    <label for="secretNum" class="login_input">비밀번호</label>
    <input type="password" id="secretNum" name="secretNum"
                class="form-control"/>
    <button id="login_btn" class="btn btn-lg btn-primary btn-block" type="button">로그인</button>
    <p class="mt-5 mb-3 text-muted">© 2017-2022</p>
</form>
<script>
    $(document).ready(function() {
      $("#userId").focus();

      $("#login_btn").on("click", function() {
        const userId = $("userId").val();
        const password = $("#secretNum").val();

        if (userId === "") {
          alert("사용자 ID를 입력해주세요.");
          $("#userId").focus();
          return false;
        }

        if (password === "") {
          alert("비밀번호를 입력해주세요.");
          $("#secretNum").focus();
          return false;
        }

        const frm = $("#frm");

        $.ajax({
          type: 'post',
          url: "/system/loginProc",
          headers: {
            "AJAX": "true"
          },
          data: frm.serialize(),
          success: function (result) {
            const resultCd = result.resultCd;

            if(resultCd === "0000") {
              location.href = "/userList";
            } else {
              alert(result.resultMsg);
            }
          },
          error: function (error) {
            alert("로그인에 실패했습니다.");
            console.log(error);
            console.log(error.status);
          }
        })
      });
    });
</script>
<script src="https://cdn.tailwindcss.com"></script>


</body>
</html>