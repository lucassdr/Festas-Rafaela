package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_usuarios")
@SequenceGenerator(name = "USUARIO_PK", sequenceName = "SEQ_USUARIO_PK", allocationSize = 1)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_PK")
	private Integer idUsuario;

	@Column(name = "NOME_DE_USUARIO", length = 20, nullable = false, unique = true)
	private String nomeUsuario;

	@Column(name = "SENHA", length = 255, nullable = false)
	private String senha;

	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;

	@Column(name = "SOBRENOME", length = 255, nullable = false)
	private String sobrenome;

	@Column(name = "CPF", length = 14, unique = true)
	private String cpf;

	public Usuario() {
		super();
	}

	public Usuario(Integer idUsuario, String nomeUsuario, String senha, String nome, String sobrenome, String cpf) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
