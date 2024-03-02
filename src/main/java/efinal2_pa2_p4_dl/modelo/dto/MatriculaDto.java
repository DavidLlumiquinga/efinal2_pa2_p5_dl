package efinal2_pa2_p4_dl.modelo.dto;

public class MatriculaDto {

	private String cedulaEstudiante;
	private String nombreMateria;
	private String cedulaProfesor;
	private String nombreDelHilo;

	public MatriculaDto() {
		super();
	}

	public MatriculaDto(String cedulaEstudiante, String nombreMateria, String cedulaProfesor, String nombreDelHilo) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.nombreMateria = nombreMateria;
		this.cedulaProfesor = cedulaProfesor;
		this.nombreDelHilo = nombreDelHilo;
	}

	// GET y SET
	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getNombreMateria() {
		return this.nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getCedulaProfesor() {
		return cedulaProfesor;
	}

	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}

	public String getNombreDelHilo() {
		return nombreDelHilo;
	}

	public void setNombreDelHilo(String nombreDelHilo) {
		this.nombreDelHilo = nombreDelHilo;
	}

	@Override
	public String toString() {
		return "MatriculaDto [cedulaEstudiante=" + cedulaEstudiante + ", NombreMateria=" + nombreMateria
				+ ", cedulaProfesor=" + cedulaProfesor + ", nombreDelHilo=" + nombreDelHilo + "]";
	}
}
