package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class BicicletaMvcApplication {

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(BicicletaMvcApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(IUsuarioDAO dao, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setUsername("user@gmail.com");
			u1.setPassword(encoder.encode("user"));
			u1.setRole("ROLE_USER");
			u1.setCPF("424.644.608-42");
			u1.setNome("Vitor Kasai Tanoue");
			u1.setTelefone("(14) 98154-8623");
			u1.setSexo("M");
			u1.setDataNascimento("2002-10-12");

			u1.setEnabled(true);
			dao.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("admin@gmail.com");
			u2.setPassword(encoder.encode("admin"));
			u2.setRole("ROLE_ADMIN");
			u2.setCPF("170.355.188-51");
			u2.setNome("Leonardo da Silva Lopes");
			u2.setTelefone("(14) 98189-1207");
			u2.setSexo("M");
			u2.setDataNascimento("2000-01-23");

			u2.setEnabled(true);
			dao.save(u2);
			
			
			Usuario u3 = new Usuario();
			u3.setUsername("malu@gmail.com");
			u3.setPassword(encoder.encode("user"));
			u3.setRole("ROLE_USER");
			u3.setCPF("175.365.588-99");
			u3.setNome("Maria Luiza Edwards");
			u3.setTelefone("(14) 98889-9997");
			u3.setSexo("F");
			u3.setDataNascimento("1999-04-24");

			u3.setEnabled(true);
			dao.save(u3);	
		};
	}
}
