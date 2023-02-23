package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Qualifier("mainDiscountPolicy")
//@Primary
@MainDiscountPolicy // 한방에 어노테이션 넣기
@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        return price * discountPercent / 100;
    }
}
