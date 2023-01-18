

function kakaoPay() {

    // getter
    var IMP = window.IMP;
    IMP.init('imp76771008');
    // var money = $('ticket-price').val();
    // console.log(money);
    // var money = $("#ticket-price").val();

    IMP.request_pay({
        pg: 'kakaopay',
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '주문명 : 패캠박스',
        amount: allMoney,
        buyer_email: 'iamport@siot.do',
        buyer_name: '구매자이름',
        buyer_tel: '010-1234-5678',
        buyer_addr: '서울시 강남구 역삼로',
        buyer_postcode: '123-456'
    }, function (rsp) {
        console.log(rsp);
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;
            $.ajax({
                type: "POST",
                url: "/payKakao", //충전 금액값을 보낼 url 설정
                data: {
                    "amount" : allMoney,
                    "uid" : rsp.imp_uid
                },
                success:function(resp){
                    alert(resp);
                    document.location.href="/complete.do"; //alert창 확인 후 이동할 url 설정
                }
            });
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;

            alert(msg);
            document.location.href="/ticket";
        }
    });
};