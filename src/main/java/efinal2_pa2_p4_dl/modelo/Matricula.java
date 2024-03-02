package efinal2_pa2_p4_dl.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula")
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Column(name = "matr_id")
	private Integer id;
	@Column(name = "matr_fecha_matricula")
	private LocalDateTime fechaMatricula;
	@Column(name = "matr_nombre_del_hilo")
	private String nombreDelHilo;

	@ManyToOne
	@JoinColumn(name = "matr_id_estudiante")
	private Estudiante estudiante;

	@ManyToOne
	@JoinColumn(name = "matr_id_materia")
	private Materia materia;

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getNombreDelHilo() {
		return nombreDelHilo;
	}

	public void setNombreDelHilo(String nombreDelHilo) {
		this.nombreDelHilo = nombreDelHilo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}
