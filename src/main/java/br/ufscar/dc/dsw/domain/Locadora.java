package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import br.ufscar.dc.dsw.validation.UniqueCNPJ;



@Entity
@Table(name = "Locadora")
public class Locadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, unique = true)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;

	@NotBlank
    @UniqueCNPJ (message = "{Unique.editora.CNPJ}")
	@Size(min = 18, max = 18 /*,message = "{Size.editora.CNPJ}"*/)
    private String CNPJ;

    @Column(nullable = false, length = 60)
	private String nome;

    @Column(nullable = false, length = 60)
	private String cidade;

    public Long getId() {
		return id;
	}
    public void setId(Long id) {
		this.id = id;
	}
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
