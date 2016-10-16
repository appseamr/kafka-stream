package api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HealthCheckController {

    @RequestMapping("/")
    public String index() {
        return "1";
    }

}