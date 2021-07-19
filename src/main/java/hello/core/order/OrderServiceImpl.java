package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    private  final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        /*
        emberRepository.findById(memberId) 반환되는 객체를
        Member get set에서 처리후 member 변수안에 객체를 담아놓는다.
         */
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return  new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
