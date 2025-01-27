package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        registry.addViewController("/pojazdy").setViewName("admin/pojazdy");
        registry.addViewController("/pasazerowie").setViewName("admin/pasazerowie");
        registry.addViewController("/linie_user").setViewName("user/linie_user");

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
    @RequestMapping(value = "/updateLinie", method = RequestMethod.POST)
    public String updateLinie(@ModelAttribute("linie") Linie linie) {
        daoLinie.updateLinie(linie);
        return "redirect:linie";
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

    @RequestMapping("/pasazerowie")
    public String viewPasazerowie(Model model) {
        List<Pasazerowie> listPasazerowie = daoPasazerowie.list();
        model.addAttribute("listPasazerowie", listPasazerowie);
        return "admin/pasazerowie";
    }

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
    @RequestMapping(value = "/editPasazerowie", method = RequestMethod.POST)
    public String editPasazerowie( @ModelAttribute("pasazerowie") Pasazerowie pasazerowie) {
        Pasazerowie existingPasazerowie = daoPasazerowie.get(pasazerowie.getId_pasazera());  // Pobierz istniejący rekord po ID
        // Zaktualizuj pola
        existingPasazerowie.setId_pasazera(pasazerowie.getId_pasazera());
        existingPasazerowie.setImie(pasazerowie.getImie());
        existingPasazerowie.setNazwisko(pasazerowie.getNazwisko());
        existingPasazerowie.setNr_telefonu(pasazerowie.getNr_telefonu());
        existingPasazerowie.setEmail(pasazerowie.getEmail());
        existingPasazerowie.setLogin(pasazerowie.getLogin());
        existingPasazerowie.setHaslo(pasazerowie.getHaslo());
        // Zaktualizuj rekord w bazie danych
        daoPasazerowie.updatePasazerowie(existingPasazerowie);
        return "redirect:/pasazerowie"; // Przekierowanie do listy linii
    }
    @RequestMapping("/deletePasazerowie/{id_pasazera}")
    public String deletePasazerowie(@PathVariable(name = "id_pasazera") int id_pasazera) {
        daoPasazerowie.deletePasazerowie(id_pasazera);
        return "redirect:/pasazerowie";
    }

    //POJAZDY

    @Autowired
    private PojazdyDAO daoPojazdy;
    @RequestMapping("/pojazdy")
    public String viewPojazdy(Model model) {
        List<Pojazdy> listPojazdy = daoPojazdy.list();
        model.addAttribute("listPojazdy", listPojazdy);
        return "admin/pojazdy";
    }
    @RequestMapping(value = "/savePojazdy", method = RequestMethod.POST)
    public String savePojazdy(@ModelAttribute("pojazdy") Pojazdy pojazdy) {
        try {
            daoPojazdy.savePojazdy(pojazdy);
            return "redirect:/pojazdy";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/pojazdy";
        }
    }
    @RequestMapping(value = "/updatePojazdy", method = RequestMethod.POST)
    public String updatePojazdy(@ModelAttribute("pojazdy") Pojazdy pojazdy) {
        daoPojazdy.updatePojazdy(pojazdy);
        return "redirect:/pojazdy";
    }
    @RequestMapping(value = "/editPojazdy", method = RequestMethod.POST)
    public String editPojazdy( @ModelAttribute("pojazdy") Pojazdy pojazdy) {
        Pojazdy existingPojazdy = daoPojazdy.get(pojazdy.getId_pojazdu());  // Pobierz istniejący rekord po ID
        // Zaktualizuj pola
        existingPojazdy.setId_pojazdu(pojazdy.getId_pojazdu());
        existingPojazdy.setVin(pojazdy.getVin());
        existingPojazdy.setData_waznosci_przegladu(pojazdy.getData_waznosci_przegladu());
        existingPojazdy.setRodzaj_paliwa(pojazdy.getRodzaj_paliwa());
        existingPojazdy.setLiczba_miejsc_siedzacych(pojazdy.getLiczba_miejsc_siedzacych());
        existingPojazdy.setRodzaj_pojazdu(pojazdy.getRodzaj_pojazdu());
        existingPojazdy.setId_centrali(pojazdy.getId_centrali());
        // Zaktualizuj rekord w bazie danych
        daoPojazdy.updatePojazdy(existingPojazdy);
        return "redirect:/pojazdy"; // Przekierowanie do listy linii
    }
    @RequestMapping("/deletePojazdy/{id_pojazdu}")
    public String deletePojazdy(@PathVariable(name = "id_pojazdu") int id_pojazdu) {
        daoPojazdy.deletePojazdy(id_pojazdu);
        return "redirect:/pojazdy";
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