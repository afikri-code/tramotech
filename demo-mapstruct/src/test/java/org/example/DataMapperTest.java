package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataMapperTest {
    @Test
    void transferData() {
        MyDto myDto = new MyDto("example");
        MyDomain myDomain = new MyDomain();

        DataMapper.instance.transferData(myDto, myDomain);

        assertThat(myDto.getText()).isEqualTo(myDomain.getText());
    }
}
