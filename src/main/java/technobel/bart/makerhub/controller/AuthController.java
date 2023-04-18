package technobel.bart.makerhub.controller;

import org.springframework.web.bind.annotation.*;
import technobel.bart.makerhub.models.dto.AuthDTO;
import technobel.bart.makerhub.models.form.LoginForm;
import technobel.bart.makerhub.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form){
        return authService.login(form);
    }

    @GetMapping("/refresh")
    public AuthDTO refreshToken(@RequestHeader("X-Refresh-Token") String refreshToken){
        return authService.refreshJWT(refreshToken);
    }

}
