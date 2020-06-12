package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;
@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList getInfoVilles() {
		ArrayList villes;
		
		villes = villeDAO.findAllVilles();
		return villes;
	}
	
	public ArrayList getInfoVille(String name) {
		ArrayList ville;
		
		ville = villeDAO.findVille(name);
		return ville;
	}
	
	public String postVille(Ville ville) {
		String reponse = villeDAO.createVille(ville);
		return reponse;
	}
	
	public String modifyVille(Ville ville) {
		String reponse = villeDAO.modifyVille(ville);
		return reponse;
	}
	
	public String deleteVille(String code) {
		String reponse = villeDAO.deleteVille(code);
		return reponse;
	}

}