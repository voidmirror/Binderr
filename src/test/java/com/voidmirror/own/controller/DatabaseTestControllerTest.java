package com.voidmirror.own.controller;

import com.voidmirror.own.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.voidmirror.own.model.Remote;
import org.voidmirror.own.service.RemoteService;
import reactor.core.publisher.Flux;

import java.util.UUID;

//When the test requires a Spring Test Context ( to autowire a bean / use of @MockBean ) along with JUnit 5's Jupiter programming model use @ExtendWith(SpringExtension.class). This will support Mockito annotations as well through TestExecutionListeners.
//When the test uses Mockito and needs JUnit 5's Jupiter programming model support use @ExtendWith(MockitoExtension.class)

@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)    // to use MockBean
public class DatabaseTestControllerTest extends BaseTest {

    private final String remoteIp = "10.148.216.91";
    private final String remoteControlSum = "567138391373902";

    @Mock
    private RemoteService remoteService;

//    @BeforeEach
//    public void before() {
//        remoteService = Mockito.mock(RemoteService.class);
//    }

    @Test
    public void test() {
        System.out.println("Test executed");
    }

    @BeforeAll
    static void setup() {
        System.out.println("Before all executed");
    }

    @Test
    public void getAllRemotesTest() {
        Remote remote = new Remote(UUID.randomUUID(), remoteIp, remoteControlSum, true);
        Mockito.when(remoteService.getAllRemotes()).thenReturn(Flux.just(remote));

        Assertions.assertEquals(remote, remoteService.getAllRemotes().blockFirst());
        Assertions.assertEquals(remote, remoteService.getAllRemotes().blockLast());
    }

}
