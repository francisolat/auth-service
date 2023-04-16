package org.bj.config.securite;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class SignUpForm {
	
	@NotBlank
    @Size(min = 3, max = 50)
    private String nom;
	
	@NotBlank
    @Size(min = 3, max = 50)
    private String prenom;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
 
    private String password;
    
    private String confirmePassword;
    
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
}
