package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "Usuario")
public class Usuario{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45, unique = true)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;
	
	@Size(min = 14, max = 14)
    @Column(nullable = false, length = 14)
    private String CPF;

	@Column(nullable = false, length = 60)
	private String nome;

	@Column(nullable = false, length = 60)
	private String telefone;
	
	@Size(min=1, max=1)
	@Column(nullable = false, length = 2)
	private String sexo;

    @Column(nullable = false, length = 45)
    private String role;

	@Size(min = 10, max = 10)
	@Column(nullable = false, length = 15)
	private String dataNascimento;

    @Column(nullable = false)
    private boolean enabled;

	@Column(nullable = false)
	
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone(){
		return telefone;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;
	}

	public String getSexo(){
		return sexo;
	}

	public void setSexo(String sexo){
		this.sexo = sexo;
	}

	public String getDataNascimento(){
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
}