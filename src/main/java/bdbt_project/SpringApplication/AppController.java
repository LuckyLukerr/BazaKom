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
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/adresy").setViewName("adresy");
        registry.addViewController("/linie").setViewName("admin/linie");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    //LINIE
    @Autowired
    private LinieDAO daoLinie;

    @RequestMapping("/linie")
    public String viewLinie(Model model) {
        List<Linie> listLinie = daoLinie.list();
        model.addAttribute("listLinie", listLinie);
        return "admin/linie";
    }
    @RequestMapping(value = "/saveLinie", method = RequestMethod.POST)
    public String saveLinie(@ModelAttribute("linie") Linie linie) {
        try {
            daoLinie.saveLinie(linie);
            return "redirect:/linie";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/linie";
        }
    }
    
    @RequestMapping(value = "/editLinie", method = RequestMethod.POST)
    public String editLinie( @ModelAttribute("linie") Linie linie) {
        Linie existingLinie = daoLinie.get(linie.getId_lini());  // Pobierz istniejący rekord po ID

        // Zaktualizuj pola
        existingLinie.setId_lini(linie.getId_lini());
        existingLinie.setNazwa_linii(linie.getNazwa_linii());
        existingLinie.setTyp_linii(linie.getTyp_linii());
        existingLinie.setDni_dzialania(linie.getDni_dzialania());
        existingLinie.setGodzina_rozpoczecia(linie.getGodzina_rozpoczecia());
        existingLinie.setGodzina_zakonczenia(linie.getGodzina_zakonczenia());
        existingLinie.setId_centrali(linie.getId_centrali());
        existingLinie.setId_trasy(linie.getId_trasy());

        // Zaktualizuj rekord w bazie danych
        daoLinie.updateLinie(existingLinie);
        return "redirect:/linie"; // Przekierowanie do listy linii
    }

    @RequestMapping("/deleteLinie/{id_lini}")
    public String deleteLinie(@PathVariable(name = "id_lini") int id_lini) {
        daoLinie.deleteLinie(id_lini);
        return "redirect:/linie";
    }

    //PASAZEROWIE
    @Autowired
    private PasazerowieDAO daoPasazerowie;

    @RequestMapping(value = "/savePasazerowie", method = RequestMethod.POST)
    public String savePasazerowie(@ModelAttribute("pasazerowie") Pasazerowie pasazerowie) {
        try {
            daoPasazerowie.savePasazerowie(pasazerowie);
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/login";
        }
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