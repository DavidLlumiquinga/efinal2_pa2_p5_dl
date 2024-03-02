package efinal2_pa2_p4_dl.repository;

import efinal2_pa2_p4_dl.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante );
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);
}
