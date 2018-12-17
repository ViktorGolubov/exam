package tech.bts.exam.controller;


import com.github.jknack.handlebars.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.exam.model.Counter;
import tech.bts.exam.service.CounterService;
import tech.bts.exam.util.HandlebarsUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping()
public class ExamWebController {

    private CounterService counterService;

    @Autowired
    public ExamWebController(CounterService counterService) {
        this.counterService = counterService;

    }

    @RequestMapping(method = GET, path = "/increment")
    public void incrementCounter(HttpServletResponse response) throws IOException {


        counterService.incrementCounter(1);
        response.sendRedirect("/");

    }

    @RequestMapping (method = GET)
    public String getCounter() throws IOException {

        Template template = HandlebarsUtil.compile("counter");

        Map<String, Object> values = new HashMap<>();
        values.put("counter", counterService.getCounter());

        return template.apply(values);

    }
}
