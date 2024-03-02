package efinal2_pa2_p4_dl.repository;

import efinal2_pa2_p4_dl.modelo.Materia;

public interface IMateriaRepository {

	public void insertar(Materia materia );
	public void actualizar(Materia materia);
	public Materia seleccionarPorCodigo(String codigo);
	
}
