package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/adresy").setViewName("adresy");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Autowired
    private AdresyDAO dao;

    @RequestMapping("/adresy")
    public String viewHomePage(Model model) {
        List<Adresy> listAdresy = dao.list();
        model.addAttribute("listAdresy", listAdresy);
        return "adresy";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Adresy adresy = new Adresy();
        model.addAttribute("adresy", adresy);
        return "new_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("adresy") Adresy adresy) {
        dao.save(adresy);
        return "redirect:/adresy";
    }

    @RequestMapping("/edit/{id_adresu}")
    public ModelAndView showEditForm(@PathVariable(name = "id_adresu") int id_adresu) {
        ModelAndView mav = new ModelAndView("edit_form");
        Adresy adresy = dao.get(id_adresu);
        mav.addObject("adresy", adresy);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("adresy") Adresy adresy) {
        dao.update(adresy);
        return "redirect:/adresy";
    }

    @RequestMapping("/delete/{id_adresu}")
    public String delete(@PathVariable(name = "id_adresu") int id_adresu) {
        dao.delete(id_adresu);
        return "redirect:/adresy";
    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }

        }
    }
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}