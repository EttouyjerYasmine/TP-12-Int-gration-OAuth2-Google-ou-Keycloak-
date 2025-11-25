package ma.ens.security.oauth2_client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OAuth2User user) {
        model.addAttribute("name", user.getAttribute("name"));  // nom de l’utilisateur Google
        model.addAttribute("email", user.getAttribute("email"));
        return "home"; // src/main/resources/templates/home.html
    }
}
