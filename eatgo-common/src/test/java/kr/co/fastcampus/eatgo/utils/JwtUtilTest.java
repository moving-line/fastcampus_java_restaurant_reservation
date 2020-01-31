package kr.co.fastcampus.eatgo.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;

public class JwtUtilTest {

    @Test
    public void createToken() {
        String secret = "12345678901234567890123456789012";
        JwtUtil jwtUtil = new JwtUtil(secret);

        String token = jwtUtil.createToken(1004L, "John");

        Assert.assertThat(token, containsString("."));
    }
}