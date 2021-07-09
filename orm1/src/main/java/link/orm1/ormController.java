package link.orm1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RestController
@RequestMapping
public class ormController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/save")
    public String save (@RequestParam("name")String name , @RequestParam("email") String email){
        Person p = new Person();
        p.name = name;
        p.email = email;
        System.out.println(p.name +" " + p.email);

        jdbcTemplate.update("insert into person values (null,?,?)",name,email);


        return "redirect/:save.html";
    }
}
