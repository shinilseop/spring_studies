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
