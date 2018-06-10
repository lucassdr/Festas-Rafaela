package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Item;


public class ItemDAO {
	
	private EntityManager manager;

	public ItemDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}

	public Item salvar(Item it) {
		this.manager.getTransaction().begin();
		Item novo = this.manager.merge(it);
		this.manager.getTransaction().commit();
		return novo;
	}

	public void excluir(Item it) {
		this.manager.getTransaction().begin();
		this.manager.remove(it);
		this.manager.getTransaction().commit();
	}

	public Item obter(Integer id) {
		return this.manager.find(Item.class, id);
	}

	public List<Item> listar() {
		
		String jpql = "from Item p where p.status='ativo' order by p.id ";

		List<Item> lista = this.manager.createQuery(jpql, Item.class).getResultList();

		return lista;
	}
	
	public List<Item> listarInativos() {
		
		String jpql = "from Item p where p.status='inativo' order by p.id ";

		List<Item> lista = this.manager.createQuery(jpql, Item.class).getResultList();

		return lista;
	}

}
