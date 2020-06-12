package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList getInfoVilles();
	
	public ArrayList getInfoVille(String name);
	
	public String postVille(Ville ville);
	
	public String modifyVille(Ville ville);
	
	public String deleteVille(String code);
	
}
