package dev.lucasliet.todoeyear.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

@SuppressWarnings("serial")
public class GenericDAO<T> implements Serializable {

	private final Class<T> classType;
	private EntityManager em;

	public GenericDAO(EntityManager manager, Class<T> classType) {
		this.em = manager;
		this.classType = classType;
	}

	public void add(T t) {
		em.persist(t);
	}

	public void remove(T t) {
		em.remove(em.merge(t));
	}

	public void update(T t) {
		em.merge(t);
	}

	public List<T> findAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classType);
		query.select(query.from(classType));

		List<T> list = em.createQuery(query).getResultList();

		return list;
	}
	
	public List<T> findAll(String expression1, Object expression2) {
		var criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(classType);
		Root<T> root = query.from(classType);
		query.select(root).where(criteriaBuilder.equal(root.get(expression1), expression2));

		List<T> list = em.createQuery(query).getResultList();

		return list;
	}

	public T findById(Integer id) {
		T instance = em.find(classType, id);
		return instance;
	}

}
