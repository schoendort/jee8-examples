package jee.examples.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DataLoader {

	@PersistenceContext(name = "MY")
	private EntityManager em;

	public long getSumOfAll() {
		return em.createNamedQuery("selectAll", MyEntity.class).getResultList().stream().mapToLong(MyEntity::getSum)
				.sum();
	}
}
