$(document).ready(function(){

    // 사이드 메뉴 토글
    if($('.depth').hasClass('on')) {
        $('.depth.on').find('.gnb_depth2').show();
    } 
    $(".gnb_depth1").click(function() {
        $(this).next(".gnb_depth2").stop().slideToggle(300);
        $(this).parents(".depth").toggleClass('on').siblings('.depth').removeClass('on');
        $(this).parents(".depth").siblings('.depth').find(".gnb_depth2").slideUp(300); 
        // $(this).parents().next().siblings(".gnb_depth2").slideUp(300); // 1개씩 펼치기
    });

    $('.user_menu_list').hide();

    $(".user_menu").click(function() {
        $(this).next(".user_menu_list").stop().slideToggle(300);
        $(this).parents(".user").toggleClass('on').siblings('.depth').removeClass('on');
        // $(this).parents(".depth").siblings('.depth').find(".gnb_depth2").slideUp(300); 
        // $(this).parents().next().siblings(".gnb_depth2").slideUp(300); // 1개씩 펼치기
    });

    // 햄버거버튼
    $('.menu_toggle').click(function(){
        if ($('.left_sidebar').hasClass('on')) {
            $('.left_sidebar').removeClass('on');
            $('.content_wrapper').removeClass('on');
        }else{
            $('.left_sidebar').addClass('on');
            $('.content_wrapper').addClass('on');
        }
    });

    $(".datepicker").focus(function() {
        $(this).addClass('on');
    });
    $(".datepicker").blur(function() {
        $(this).removeClass('on');
    });

    // 영역 외 클릭시 토글 닫힘
    $('body').on('click', function(e){
        var $tgPoint = $(e.target);
        var $btn1_1 = $tgPoint.is('.user_menu_wrap');
        var $btn1_2 = $tgPoint.is('.user_menu_wrap *');
        if (!$btn1_1 && !$btn1_2) {
            $('.user_menu_list').slideUp(300);
            $('li.user').removeClass('on');
        }
    });


    // 탑버튼
    $('#etc').hide();
    $(window).scroll(function() {

        if ($(this).scrollTop() > 2000) {
            $('#etc').fadeIn();
        } else {
            $('#etc').fadeOut();
        }
    });
    $("#top_btn").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });

    // datepicker
    $.datepicker.setDefaults({
        closeText: "닫기",
        prevText: "이전달",
        nextText: "다음달",
        closeText: '닫기', // 닫기 버튼 텍스트 변경
        showButtonPanel: true,	// 오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
        currentText: "오늘",
        monthNames: ["1월", "2월", "3월", "4월", "5월", "6월",
        "7월", "8월", "9월", "10월", "11월", "12월"
        ],
        monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월",
        "7월", "8월", "9월", "10월", "11월", "12월"
        ],
        dayNames: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
        dayNamesShort: ["일", "월", "화", "수", "목", "금", "토"],
        dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
        weekHeader: "주",
        dateFormat: "yy-mm-dd", // 날짜형태 예)yy년 m월 d일
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: "년"
    })

/*
    $(".datepicker").datepicker({
        minDate: 0
    })    
*/

    // 모달창 켜기1
    $('.modal_step_open').click(function(){
        var modal_step = $(this).attr('modal_step');

        $('.modal_step').addClass('hidden'); // 이전 모달창을 숨김
        
        $(this).addClass('current');
        $("."+ "modal_step" +modal_step).removeClass('hidden');
    })

    // 모달창 켜기2
    $('.modal_open').on("click", function() {
        $(this).next().removeClass("hidden");
    });

    // 모달창 끄기
    $('.cancerButton').on("click", function() {
        if ($(this).closest(".modal")) {
            $(this).closest(".modal").addClass("hidden");
        }
        else {
            $(this).closest(".modal").addClass("hidden");
        }
    });

    // 모든 모달창 끄기
    $('.allModalClose').on("click", function() {
        $('.modal').addClass("hidden");
    });

    // 첫번째 모달창 끄기
    $('.firstModalClose2').on("click", function() {
        $(this).closest('.modal').addClass("hidden");
        $(this).closest('.modal').next('.modal').removeClass("hidden");
    });   

});
