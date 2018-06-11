package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_temas")
@SequenceGenerator(name = "TEMAS_PK", sequenceName = "SEQ_TEMAS_PK", allocationSize = 1)
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMAS_PK")
	private Integer id;

	@Column(name = "cor_toalha")
	private String corDaToalha;

	@Column(name = "valor", length = 7)
	private Float valor;

	@Column(name = "nome", length = 120)
	private String nome;

	@Column(length = 10)
	private String status;

	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Item> item;

	public Tema() {
		super();
	}

	public Tema(Integer id, String corDaToalha, Float valor, String nome, String status, List<Item> item) {
		super();
		this.id = id;
		this.corDaToalha = corDaToalha;
		this.valor = valor;
		this.nome = nome;
		this.status = status;
		this.item = item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorDaToalha() {
		return corDaToalha;
	}

	public void setCorDaToalha(String corDaToalha) {
		this.corDaToalha = corDaToalha;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corDaToalha == null) ? 0 : corDaToalha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (corDaToalha == null) {
			if (other.corDaToalha != null)
				return false;
		} else if (!corDaToalha.equals(other.corDaToalha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
