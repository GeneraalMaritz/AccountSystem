package za.ac.nwu.ac.web.sb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.domain.service.GeneralResponse;


@RestController
public class DemoController {
    @GetMapping("/ping")
    public GeneralResponse<String> ping(@RequestParam(value = "echo", defaultValue = "pong") String echo){
        return new GeneralResponse<String>(true, echo);
    }

}