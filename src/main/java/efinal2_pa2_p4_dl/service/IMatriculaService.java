package efinal2_pa2_p4_dl.service;

import java.util.List;

import efinal2_pa2_p4_dl.modelo.Matricula;
import efinal2_pa2_p4_dl.modelo.dto.MatriculaDto;
import efinal2_pa2_p4_dl.service.to.MatriculaTo;

public interface IMatriculaService {
	
	public List<MatriculaDto> reporteTodos();
	public void matricular(MatriculaTo matriculaTo);
	public void matricularConCedulaCodigo(String cedula, String codigo, Matricula matricula);
}
