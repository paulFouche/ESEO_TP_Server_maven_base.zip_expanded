package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;

public class JDBCConfigure {

	static ResourceBundle info = ResourceBundle.getBundle("application");
	
	@Bean
	public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(info.getString("jdbc.url"), info.getString("jdbc.login"), info.getString("jdbc.login"));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
            return null;
        }
	}
}
