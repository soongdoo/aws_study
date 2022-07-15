package com.songdo.aws_study.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        // Junit 보다 assertj의 assertThat이 더 좋은 이유
        // CoreMatchers와 달리 추가적으로 라이브러리를 필요로하지 않음
        // 자동완성이 좀 더 확실하게 지원된다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
