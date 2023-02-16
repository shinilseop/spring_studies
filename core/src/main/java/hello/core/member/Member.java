package hello.core.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private Grade grade;
}
