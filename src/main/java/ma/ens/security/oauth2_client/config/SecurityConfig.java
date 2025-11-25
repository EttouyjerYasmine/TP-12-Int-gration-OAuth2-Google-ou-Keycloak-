package ma.ens.security.oauth2_client.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/public/**").permitAll()  // pages publiques
                        .anyRequest().authenticated()                    // toutes les autres ressources nécessitent l’authentification
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home", true)              // redirection après login réussi
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")                         // redirection après logout
                );

        return http.build();
    }
}
