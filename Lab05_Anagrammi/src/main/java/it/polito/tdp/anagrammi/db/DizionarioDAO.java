package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DizionarioDAO {
	
	public int paroleSimili(String word){
		
		int numero = 0;
		
		String sql = "SELECT nome FROM parola";		
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();			
			
			while(rs.next()) {
				if(rs.getString("nome").length()>=word.length() && rs.getString("nome").substring(0, word.length()).equals(word)) 
				numero++;
			}
			
			rs.close();
			st.close();
			conn.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		return numero;
	}
	
	public boolean parolaPresente(String word){
			
		String sql = "SELECT * FROM parola WHERE nome = ?";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, word);
			ResultSet rs = st.executeQuery();			
			
			if(rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return true;
			}else {
			
			rs.close();
			st.close();
			conn.close();
			return false;
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
