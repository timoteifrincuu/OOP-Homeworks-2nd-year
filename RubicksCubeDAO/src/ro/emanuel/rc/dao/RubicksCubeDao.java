package ro.emanuel.rc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.rc.helper.DBHelper;
import ro.emanuel.rc.pojo.RubicksCube;

public class RubicksCubeDao {

	// METODA CARE IA TOATE CUBURILE DIN BD SI LE BAGA IN LISTA
	public static List<RubicksCube> getRubickCube() throws SQLException {
		List<RubicksCube> listRcs = new ArrayList<>();
		
		//Conexiunea la bd si executam un simplu query
		Connection conn = DBHelper.getConnection();
		Statement stmt = conn.createStatement();
		
		//Ia toate datele din tabela RubicksCube
		ResultSet rs = stmt.executeQuery("select * from RubicksCube");
        while(rs.next()) {
        	//Construirea fiecarui cub din randurile citite
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            double weight = rs.getDouble("weight");
            int sides = rs.getInt("sides");
            RubicksCube rc = new RubicksCube(id, brand, weight, sides);
            listRcs.add(rc); //Adauga in lista cubul
        }
        
        DBHelper.closeConnection();	//Inchide conexiunea
        
        return listRcs; //Return la lista cu cuburi
	}
	
	
	//METODA CARE STERGE 1 CUB DIN BD, IN FUNCTIE DE ID
	public static int deleteRubicksCube(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        // Stergem cubul cu id-ul specificat si primim nr de randuri sterse
        int deletedRows = stmt.executeUpdate("delete from RubicksCube where id > " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows; // Returnam nr de randuri afectate
	}
	

	// METODA CARE CREAZA/ADAUGA 1 CUB NOU IN BD (table)
	public static int createRubicksCube(RubicksCube rubicksCubeToCreate) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "insert into RubicksCube (brand, weight, sides) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		//Pune valorile cubului in query
		ps.setString(1, rubicksCubeToCreate.getBrand());
		ps.setDouble(2, rubicksCubeToCreate.getWeight());
		ps.setInt(3, rubicksCubeToCreate.getSides());
		//I dont truely understand the way this method works, specifically the 3 lines from above
		
        //Executa si primeste nr de randuri afectate
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows; //Return la nr de randuri afectate
	}

	
	// METODA CARE FACE UPDATE LA 1 CUB EXISTENT
	public static int updateRubicksCube(RubicksCube rbc) throws SQLException{
		Connection conn = DBHelper.getConnection();
		String query = "update RubicksCube set brand = ?, weight = ?, sides = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		//Pune noile valori in query
		ps.setString(1, rbc.getBrand());
		ps.setDouble(2, rbc.getWeight());
		ps.setInt(3, rbc.getSides());
		ps.setInt(4, rbc.getId());
		
		//Executarea si primirea nr de randuri afectate
		int rUpd = ps.executeUpdate();
		
		DBHelper.closeConnection(); 	
		
		return rUpd; //Return la nr de randuri afectate
	}
	
	
	// METODA CARE IA 1 CUB DUPA ID
	public static RubicksCube getById(int id) throws SQLException{
		Connection connection = DBHelper.getConnection();
		
		//Folosim metoda "getRubickCube()" sa luam toate cuburile si cautam id dorit
		List<RubicksCube> listRCs = getRubickCube();
		for(RubicksCube rc : listRCs) {
			if(rc.getId() == id) {
				return rc; // Daca gasim cubul, il returnam
			}
		}
		DBHelper.closeConnection();
		//Daca nu gasim un cub, returnam null
		return null;
	}
	
	
	//METODA CARE CREAZA O TABELA
	public static void createTable() throws SQLException{
		Connection conn = DBHelper.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("create table IF NOT EXISTS RubicksCube ("
				+ "id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "brand VARCHAR(255),"
				+ "weight DOUBLE(10,2),"
				+ "sides INT)");
		System.out.println("Table 'RubicksCube' created or already exists.");
		DBHelper.closeConnection();
	}
}

