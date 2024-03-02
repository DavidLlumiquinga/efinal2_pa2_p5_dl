package efinal2_pa2_p4_dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import efinal2_pa2_p4_dl.modelo.dto.MatriculaDto;
import efinal2_pa2_p4_dl.service.IMatriculaService;
import efinal2_pa2_p4_dl.service.to.MatriculaTo;
@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService iMatriculaService;

	@GetMapping("/iniciarReporte")
	public String iniciarReporte(MatriculaDto matriculaDTO, Model model) {
		List<MatriculaDto> matriculas = this.iMatriculaService.reporteTodos();
		model.addAttribute("reporteModel", matriculas);
		return "vistaReporteMatriculas";
	}

	@GetMapping("/iniciarMatricula")
	public String iniciarMatricula(MatriculaTo matriculaTo) {
		return "vistaRegistroMatricula";
	}

	@PostMapping("/matricular")
	public String matricular(MatriculaTo matriculaTo) {
		this.iMatriculaService.matricular(matriculaTo);
		return "redirect:/matriculas/iniciarMatricula";
	}
}
