package dkat.tp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TpIndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
