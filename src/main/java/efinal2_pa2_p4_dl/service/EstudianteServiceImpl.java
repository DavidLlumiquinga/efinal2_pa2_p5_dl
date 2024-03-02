package efinal2_pa2_p4_dl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import efinal2_pa2_p4_dl.modelo.Estudiante;
import efinal2_pa2_p4_dl.repository.IEstudianteRepository;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar(estudiante);
	}
	
}
