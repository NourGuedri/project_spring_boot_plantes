package com.nour.plantes.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nour.plantes.entities.Plante;
import com.nour.plantes.entities.Type;
import com.nour.plantes.service.PlanteService;

import jakarta.validation.Valid;

@Controller
public class PlanteController {
	@Autowired
	PlanteService planteService;

	@RequestMapping("/ListePlantes")
	public String listePlantes(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Page<Plante> pls = planteService.getAllPlantesParPage(page, size);
		modelMap.addAttribute("plantes", pls);
		 modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePlantes";

	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	List<Type> types = planteService.getAllTypes();
	modelMap.addAttribute("plante", new Plante());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("types", types);
	return "formPlante";
	}
	@RequestMapping("/modifierPlante")
	public String editerPlante(@RequestParam("id") Long id,ModelMap modelMap ,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	Plante p= planteService.getPlante(id);
	List<Type> types = planteService.getAllTypes();
	modelMap.addAttribute("plante", p);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("types", types);
	modelMap.addAttribute("page", page);
	modelMap.addAttribute("size", size);
	return "formPlante";
	}


	 @RequestMapping("/savePlante")
	 public String savePlante(@Valid Plante plante, BindingResult bindingResult,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size",defaultValue = "2") int size)
	 {
	 int currentPage;
	 boolean isNew = false;
	 if (bindingResult.hasErrors()) return "formPlante"; 
	 if (plante.getIdPlante()==null) //ajout
	 isNew=true;
	 planteService.savePlante(plante);
	 if (isNew) //ajout
	 {
	 Page<Plante> pls = planteService.getAllPlantesParPage(page, size);
	 currentPage = pls.getTotalPages()-1;
	 }
	 else //modif
	 currentPage=page;
	 return ("redirect:/ListePlantes?page="+currentPage+"&size="+size);
	 }


	@RequestMapping("/supprimerPlante")
	public String supprimerPlante(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		planteService.deletePlanteById(id);
		Page<Plante> pls = planteService.getAllPlantesParPage(page,
				size);
				modelMap.addAttribute("plantes", pls);
				modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

		return "listePlantes";
	}

//	@RequestMapping("/modifierPlante")
//	public String editerPlante(@RequestParam("id") Long id, ModelMap modelMap) {
//		Plante p = planteService.getPlante(id);
//		modelMap.addAttribute("plante", p);
//		return "editerPlante";
//	}

	@RequestMapping("/updatePlante")
	public String updatePlante(@ModelAttribute("plante") Plante plante, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateRendezVous = dateformat.parse(String.valueOf(date));
		plante.setDateRendezVous(dateRendezVous);

		planteService.updatePlante(plante);
		List<Plante> pls = planteService.getAllPlantes();
		modelMap.addAttribute("plantes", pls);
		return "listePlantes";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}
	
	/*
	 * @RequestMapping("/modifierPlante") public String
	 * editerPlante(@RequestParam("id") Long id,ModelMap modelMap ,
	 * 
	 * @RequestParam (name="page",defaultValue = "0") int page,
	 * 
	 * @RequestParam (name="size", defaultValue = "2") int size) { Plante p=
	 * planteService.getPlante(id); List<Type> types = planteService.getAllTypes();
	 * Page<Plante> pls = planteService.getAllPlantesParPage(page, size);
	 * modelMap.addAttribute("plantes", pls); modelMap.addAttribute("pages", new
	 * int[pls.getTotalPages()]); modelMap.addAttribute("currentPage", page);
	 * modelMap.addAttribute("size", size); return "editerPlante"; }
	 */

	
}