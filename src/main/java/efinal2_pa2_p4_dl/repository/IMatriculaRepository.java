package efinal2_pa2_p4_dl.repository;

import java.util.List;

import efinal2_pa2_p4_dl.modelo.Matricula;
import efinal2_pa2_p4_dl.modelo.dto.MatriculaDto;

public interface IMatriculaRepository {

	public void insertar(Matricula matricula );
	public void actualizar(Matricula matricula);
	public List<MatriculaDto> seleccionarTodos();
}
