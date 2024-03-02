package efinal2_pa2_p4_dl.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import efinal2_pa2_p4_dl.modelo.Matricula;
import efinal2_pa2_p4_dl.modelo.dto.MatriculaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(matricula);
	}

	@Override
	public List<MatriculaDto> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDto> myQuery = this.entityManager.createQuery(" "
				+ "select new efinal2_pa2_p4_dl.modelo.dto.MatriculaDto(m.estudiante.cedula,m.materia.nombre,m.materia.cedulaProfesor,m.nombreDelHilo) "
				+ "from Matricula m", MatriculaDto.class);
		return myQuery.getResultList();
	}

}
