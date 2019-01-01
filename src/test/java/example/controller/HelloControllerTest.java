package example.controller;

import example.controllers.HelloController;
import example.services.GreetingsService;
import example.services.HelperService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Application;

public class HelloControllerTest extends JerseyTest {

    @Mock
    private HelperService helperService;

    @InjectMocks
    private GreetingsService greetingsService;

    @Override
    protected Application configure() {
        MockitoAnnotations.initMocks(this);
        return new ResourceConfig(HelloController.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(helperService).to(HelperService.class);
                    }
                });
    }

    @Test
    public void testHello(){
        String mockResponse = "Hello from mocked helper service!";
        Mockito.when(helperService.hello()).thenReturn(mockResponse);
        String entity = target("/hello").request().get(String.class);
        Assert.assertEquals("Wrong response", mockResponse, entity);
    }
}
