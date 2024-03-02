package efinal2_pa2_p4_dl.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import efinal2_pa2_p4_dl.modelo.Estudiante;
import efinal2_pa2_p4_dl.modelo.Materia;
import efinal2_pa2_p4_dl.modelo.Matricula;
import efinal2_pa2_p4_dl.modelo.dto.MatriculaDto;
import efinal2_pa2_p4_dl.repository.IEstudianteRepository;
import efinal2_pa2_p4_dl.repository.IMateriaRepository;
import efinal2_pa2_p4_dl.repository.IMatriculaRepository;
import efinal2_pa2_p4_dl.service.to.MatriculaTo;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Autowired
	private IEstudianteRepository iEstudianteRepository;


	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<MatriculaDto> reporteTodos() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarTodos();
	}
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricular(MatriculaTo matriculaTO) {
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		Matricula matri1 = new Matricula();
		matri1.setFechaMatricula(LocalDateTime.now());
		Materia mate1 = new Materia();
		mate1.setCodigo(matriculaTO.getCodigoMateria1());
		matri1.setMateria(mate1);

		Matricula matri2 = new Matricula();
		matri2.setFechaMatricula(LocalDateTime.now());
		Materia mate2 = new Materia();
		mate2.setCodigo(matriculaTO.getCodigoMateria2());
		matri2.setMateria(mate2);

		Matricula matri3 = new Matricula();
		matri3.setFechaMatricula(LocalDateTime.now());
		Materia mate3 = new Materia();
		mate3.setCodigo(matriculaTO.getCodigoMateria3());
		matri3.setMateria(mate3);

		Matricula matri4 = new Matricula();
		matri4.setFechaMatricula(LocalDateTime.now());
		Materia mate4 = new Materia();
		mate4.setCodigo(matriculaTO.getCodigoMateria3());
		matri4.setMateria(mate4);

		List<Matricula> matriculas = new ArrayList<>();

		matriculas.add(matri1);
		matriculas.add(matri2);
		matriculas.add(matri3);
		matriculas.add(matri4);

		matriculas.parallelStream().forEach(matricula -> {
			String hilo = Thread.currentThread().getName();
			matricula.setNombreDelHilo(hilo);
		});
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula) {
		System.out.println("2 " + codigo + TransactionSynchronizationManager.isActualTransactionActive());

		Estudiante estudiante = this.iEstudianteRepository.seleccionarPorCedula(cedula);
		Materia materia = this.iMateriaRepository.seleccionarPorCodigo(codigo);

		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFechaMatricula(LocalDateTime.now());
		this.iMatriculaRepository.insertar(matricula);

	}

}
