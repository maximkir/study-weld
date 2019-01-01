package example.utils;


import example.services.HelperService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class HelperServiceProducer {

    @Produces
    public HelperService createHelperService(){
        return new HelperService();
    }
}
