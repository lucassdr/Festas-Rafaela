package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Tema;

public class TemaDAO {
	
	private EntityManager manager;

	public TemaDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}

	public Tema salvar(Tema tem) {
		this.manager.getTransaction().begin();
		Tema novo = this.manager.merge(tem);
		this.manager.getTransaction().commit();
		return novo;
	}

	public void excluir(Tema tem) {
		this.manager.getTransaction().begin();
		this.manager.remove(tem);
		this.manager.getTransaction().commit();
	}

	public Tema obter(Integer id) {
		return this.manager.find(Tema.class, id);
	}

	public List<Tema> listar() {
		
		String jpql = "from Tema t where t.status='ativo' order by t.corDaToalha";

		List<Tema> lista = this.manager.createQuery(jpql, Tema.class).getResultList();

		return lista;
	}
	
	public List<Tema> listarInativos() {
		
		String jpql = "from Tema t where t.status='inativo' order by t.corDaToalha";

		List<Tema> lista = this.manager.createQuery(jpql, Tema.class).getResultList();

		return lista;
	}

}
