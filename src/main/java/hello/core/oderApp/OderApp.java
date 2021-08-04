package hello.core.oderApp;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.order.Order;

public class OderApp {
    public static void main(String[] args) {
        MemberService memberService= new MemberServiceImpl();
        OrderService oderService= new OrderServiceImpl();

        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order oder= oderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = "+ oder);
        System.out.println("order.calculatePrice = "+ oder.calculatePrice());
    }
}
