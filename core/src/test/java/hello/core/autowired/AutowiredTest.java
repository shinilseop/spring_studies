package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        var ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        /**
         * Member는 스프링 빈이 아니기에 주입을 해줄 수 없어서 에러가 난다.
         * 이를 방지하기 위해서는 파라미터에 Nullable이나 Optional을 통해서 빈값이 가능하도록 해야한다.
         */
        @Autowired(required = false)
        public void setNoBean1(Member isNotBean) {
            System.out.println("setNoBean1 = " +isNotBean);
        }

        @Autowired
        public void setBeanNullable(@Nullable Member isABean) {
            System.out.println("setBeanNullable =  " +isABean);
        }

        @Autowired
        public void setBeanOptional(Optional<Member> optionalMember) {
            System.out.println("setBeanOptional =  " +optionalMember);
        }
    }
}
