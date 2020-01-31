package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void craetion() {
        User user = User.builder()
                .email("tester@eample.com")
                .name("테스터")
                .level(100L)
                .build();

        assertThat(user.getName(), is("테스터"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deactivate();

        assertThat(user.isActive(), is(false));
    }
}