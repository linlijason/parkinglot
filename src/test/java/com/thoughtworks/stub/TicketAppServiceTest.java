package com.thoughtworks.stub;


import org.junit.Ignore;
        import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = {"com.thoughtworks:parkinglot:0.0.1-SNAPSHOT:stubs:8081"}, //引入jar 包 parkinglot-0.0.1-SNAPSHOT-stubs.jar
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
//一定要将stub的jar包安装到本地，或者使用远程

public class TicketAppServiceTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    public void test() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.post("/tickets")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"car\":\"my car\",\"spotId\":1,\"lotId\":2}")
        ).andExpect(status().is(201));
    }
}
