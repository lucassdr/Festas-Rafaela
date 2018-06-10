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
	private Integer codigo;

	@Column(name = "cor_toalha")
	private String corDaToalha;

	@Column(name = "valor", length = 7)
	private Float valor;

	@Column(name = "nome", length = 120)
	private String nome;

	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Item> item;

	public Tema() {
		super();
	}

	public Tema(Integer codigo, String corDaToalha, Float valor, String nome, List<Item> item) {
		super();
		this.codigo = codigo;
		this.corDaToalha = corDaToalha;
		this.valor = valor;
		this.nome = nome;
		this.item = item;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((corDaToalha == null) ? 0 : corDaToalha.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (corDaToalha == null) {
			if (other.corDaToalha != null)
				return false;
		} else if (!corDaToalha.equals(other.corDaToalha))
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
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
