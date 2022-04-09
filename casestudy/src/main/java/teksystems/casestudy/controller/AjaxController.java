package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AjaxController {

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public ModelAndView ajaxView() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("ajax");

        return response;
    }
}
