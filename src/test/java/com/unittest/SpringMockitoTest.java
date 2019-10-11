package com.unittest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unittest.ApiService;

import static org.mockito.Mockito.when;

/**
 * @author haze
 * @date created at 2019/9/23 10:59 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringMockitoTest {

    @Mock
    private ApiService mockApiService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        when(mockApiService.test()).thenReturn("ok");
    }

    @Test
    public void should_success_when_testApiService() {
        String result = mockApiService.test();
        Assert.assertEquals("ok", result);
    }
}
