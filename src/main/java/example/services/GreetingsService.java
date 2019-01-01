package example.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingsService {

    private final HelperService helperService;

    @Inject
    public GreetingsService(HelperService helperService){
        this.helperService = helperService;
    }


    public String hello(){
        return helperService.hello();
    }
}
