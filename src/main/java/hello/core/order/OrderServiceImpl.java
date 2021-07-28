package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    //private  final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    //인터페이스에 난 해당 클래스 사용할거라고 선언 방식 new RateDiscountPolicy();
    //private  final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //인터페이스 선언 후 자동으로 클래스 선언될 수 있도록 설정이 필요
    private  DiscountPolicy discountPolicy;

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
