package efinal2_pa2_p4_dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import efinal2_pa2_p4_dl.modelo.Estudiante;
import efinal2_pa2_p4_dl.service.IEstudianteService;
@Controller
@RequestMapping("/estudiantes")

public class EstudianteController {
	@Autowired
	private IEstudianteService iEstudianteService;

	@GetMapping("/iniciarRegistro")
	public String inicarRegistro(Estudiante estudiante) {
		return "vistaRegistroEstudiante";
	}

	@PostMapping("/registrar")
	public String registrar(Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		return "redirect:/estudiantes/iniciarRegistro";
	}

}
