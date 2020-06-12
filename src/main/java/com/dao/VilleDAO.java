package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList findAllVilles();
	
	public ArrayList findVille(String name);
	
	public String createVille(Ville ville);
	
	public String modifyVille(Ville ville);
	
	public String deleteVille(String code);

}