package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Locacao;

@SpringBootApplication
public class BicicletaMvcApplication {

	public static void main(String[] args) throws Throwable{
		SpringApplication.run(BicicletaMvcApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, ILocadoraDAO locadoraDAO, ILocacaoDAO locacaoDAO) {
		return (args) -> {
			//Criando Usuários
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
			usuarioDAO.save(u1);
			
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
			usuarioDAO.save(u2);
			
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
			usuarioDAO.save(u3);
			
			//Criando Locadoras
			Locadora l1 = new Locadora();
			l1.setUsername("locadora1@gmail.com");
			l1.setPassword("locadora");
			l1.setCNPJ("55.789.390/0008-99");
			l1.setNome("Locadora A");
			l1.setCidade("São Carlos");
			locadoraDAO.save(l1);

			Locadora l2 = new Locadora();
			l2.setUsername("locadora2@gmail.com");
			l2.setPassword("locadora");
			l2.setCNPJ("32.106.536/0001-82");
			l2.setNome("Locadora B");
			l2.setCidade("Araraquara");
			locadoraDAO.save(l2);

			Locadora l3 = new Locadora();
			l3.setUsername("locadora3@gmail.com");
			l3.setPassword("locadora");
			l3.setCNPJ("71.150.470/0001-40");
			l3.setNome("Locadora C");
			l3.setCidade("Lins");
			locadoraDAO.save(l3);

			//Criando Locacoes Existentes
			Locacao L1 = new Locacao();
			L1.setUsuario(u1);
			L1.setLocadora(l1);
			L1.setDataLocacao("2022-07-29");
			L1.setHorarioLocacao("18:00:00");
			locacaoDAO.save(L1);
		};
	}
}
