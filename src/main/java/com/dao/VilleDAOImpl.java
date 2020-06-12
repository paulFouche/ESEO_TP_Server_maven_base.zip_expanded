package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigure;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	public ArrayList findAllVilles() {
		Ville ville = null;
		Connection conn = JDBCConfigure.getConnection();
		ArrayList<Ville> villes = new ArrayList();
		try {
			String query = "SELECT * FROM ville_france";

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				ville = new Ville();
				ville.setNom_commune(rs.getString("Nom_Commune"));
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setCode_postal(rs.getString("Code_postal"));
				villes.add(ville);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return villes;
	}
	
	public ArrayList findVille(String name) {
		ArrayList villes = new ArrayList();
		Connection conn = JDBCConfigure.getConnection();
		try {
			String query = "SELECT * FROM ville_france WHERE Code_postal="+name;
			System.out.println(name);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setNom_commune(rs.getString("Nom_Commune"));
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setCode_postal(rs.getString("Code_postal"));
				villes.add(ville);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return villes;
	}
	
	public String createVille(Ville ville) {
		Connection conn = JDBCConfigure.getConnection();
		String reponse = "echec";
		try {
			String query = "INSERT INTO ville_france VALUES('"+ville.getCode_commune_INSEE()+"', '"+ville.getNom_commune()+"', '"+ville.getCode_postal()+"', '"+ville.getLibelle_acheminement()+"', '"+ville.getLigne_5()+"', '"+ville.getLatitude()+"', '" +ville.getLongitude()+"')";                                                 
			Statement st = conn.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reponse;
		}
	}
	
	public String modifyVille(Ville ville) {
		Connection conn = JDBCConfigure.getConnection();
		String reponse = "echec";
		try {
			String query = "UPDATE ville_france SET Nom_commune='"+ville.getNom_commune()+"', Code_postal='"+ville.getCode_postal()+"', Libelle_acheminement='"+ville.getLibelle_acheminement()+"', Ligne_5='"+ville.getLigne_5()+"', Latitude='"+ville.getLatitude()+"', Longitude='"+ville.getLongitude()+"' WHERE Code_commune_INSEE='"+ville.getCode_commune_INSEE()+"'";
			Statement st = conn.createStatement();
			System.out.println(query);
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reponse;
		}
	}
	
	public String deleteVille(String code) {
		Connection conn = JDBCConfigure.getConnection();
		String reponse = "echec";
		try {
			String query = "DELETE FROM ville_france WHERE Code_commune_INSEE="+code;
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			reponse = "reussite";
			return reponse;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reponse;
		}
	}
}
