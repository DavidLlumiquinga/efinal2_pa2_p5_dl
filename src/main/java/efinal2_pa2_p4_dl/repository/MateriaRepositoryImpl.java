package efinal2_pa2_p4_dl.repository;

import org.springframework.stereotype.Repository;

import efinal2_pa2_p4_dl.modelo.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> myQuery= this.entityManager.createQuery("select m from Materia m where m.codigo=:codigo",Materia.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
	}
}
