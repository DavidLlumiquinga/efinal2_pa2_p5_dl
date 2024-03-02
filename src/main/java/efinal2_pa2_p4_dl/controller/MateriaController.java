package efinal2_pa2_p4_dl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import efinal2_pa2_p4_dl.modelo.Materia;
import efinal2_pa2_p4_dl.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping("/iniciarRegistro")
	public String inicarRegistro(Materia materia) {
		return "vistaRegistroMateria";
	}

	@PostMapping("/registrar")
	public String registrar(Materia materia) {
		this.iMateriaService.guardar(materia);
		return "redirect:/materias/iniciarRegistro";
	}
}
