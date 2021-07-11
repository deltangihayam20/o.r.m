package link.orm1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ormController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/save")
    public String save (@RequestParam("name")String name , @RequestParam("email") String email){
//        Person p = new Person();
//        p.name = name;
//        p.email = email;
//        System.out.println(p.name +" " + p.email);

        jdbcTemplate.update("insert into person values (null,?,?)",name,email);


        return "redirect:/success.html";
    }

    @GetMapping("/all")
        public ModelAndView all (){
        ModelAndView modelAndView = new ModelAndView("persons");

        List<Person>personList =
                jdbcTemplate.query("select * from person",new PersonRowMapper());
        modelAndView.addObject("persons",personList);
        return  modelAndView;
    }
    @GetMapping("/allForid")
    public ModelAndView allForId(){
        ModelAndView modelAndView = new ModelAndView("persons");
        List<Person> personList =
                jdbcTemplate.query("select * from person where id>2", new PersonRowMapper());
        modelAndView.addObject("persons", personList);
        return modelAndView;
    }
}

