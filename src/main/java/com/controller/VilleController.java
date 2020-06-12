package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET
	@RequestMapping(value = "/villes", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList villes() {
		System.out.println("Appel GET");

		return villeBLOService.getInfoVilles();
	}

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList ville(@RequestParam(value = "codePostal") String name) {
		System.out.println("Appel GET");

		return villeBLOService.getInfoVille(name);
	}

	// Methode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public String createVille(@RequestBody Ville ville) {
		System.out.println(ville.getCode_postal());

		String reponse = villeBLOService.postVille(ville);
		return reponse;
	}

	// Methode PUT
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public String modifyVille(@RequestBody Ville ville) {
		System.out.println(ville.getCode_postal());

		String reponse = villeBLOService.modifyVille(ville);
		return reponse;
	}

	// Methode DELETE
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteVille(@RequestParam(value = "codeINSEE") String code) {
		String reponse = villeBLOService.deleteVille(code);
		return reponse;
	}
}
