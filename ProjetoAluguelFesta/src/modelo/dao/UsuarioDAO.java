package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Usuario;

public class UsuarioDAO {

	private EntityManager manager;

	public UsuarioDAO() {
		super();
		this.manager = JPAUtil.getEntityManager();
	}

	public Usuario salvar(Usuario usuario) {
		this.manager.getTransaction().begin();
		Usuario novo = this.manager.merge(usuario);
		this.manager.getTransaction().commit();
		return novo;
	}

	public void excluir(Usuario usuario) {
		this.manager.getTransaction().begin();
		this.manager.remove(usuario);
		this.manager.getTransaction().commit();
	}

	public Usuario obter(Integer idUsuario) {
		return this.manager.find(Usuario.class, idUsuario);
	}
	

	public List<Usuario> listar() {
		String jpql = "from Usuario u order by u.nome";
		List<Usuario> lista = this.manager.createQuery(jpql, Usuario.class).getResultList();
		return lista;
	}

}
