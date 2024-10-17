package ro.emanuel.rc.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import ro.emanuel.rc.dao.RubicksCubeDao;
import ro.emanuel.rc.pojo.RubicksCube;

//Is there any problem with having all these imports? here or on the other files?


//I have a problem: Everything seems to be working just fine here on Eclipse IDE,
//but when I switch to phpMyAdmin/MySQL DB, the table is empty, its without any data, 
//except for the id, brand, weight and sides "titles", no records tho
//whats the problem?


public class Main {

	public static void main(String[] args) throws SQLException {
		
		// Creaza tabela RubicksCube
		RubicksCubeDao.createTable();
	    System.out.println("=====================");
	    
		// Creem un cub nou (a row in the table)
	    RubicksCube newRC = new RubicksCube("MoYu", 85, 6);
	    RubicksCube newRC2 = new RubicksCube("GANCube", 66, 6);
	    RubicksCube newRC3 = new RubicksCube("WrongCube", 3, 10);
	    RubicksCubeDao.createRubicksCube(newRC);
	    RubicksCubeDao.createRubicksCube(newRC2);
	    int rIns = RubicksCubeDao.createRubicksCube(newRC3);
	    System.out.println("Cubul a fost creat. Randuri inserate: " + rIns);
	    System.out.println("=====================");
	    
		// Luam toate cuburile si le afisam
		List<RubicksCube> rbC = RubicksCubeDao.getRubickCube();
		for(RubicksCube rb: rbC) {
			System.out.println(rb);
		}
	    System.out.println("=====================");
	    
		// Luam un cub dupa ID si il afisam
	    RubicksCube rbCb = RubicksCubeDao.getById(46);
	    System.out.println("Cubul gasit dupa ID: " + rbCb);
	    System.out.println("=====================");
	    
	    
		// Facem update la un cub dupa ID
	    RubicksCube cubeToUpdate = new RubicksCube(45, "Megaminx", 143, 12); 	    // NU actualizeaza cubul cu noile informatii
        int rowsUpdated = RubicksCubeDao.updateRubicksCube(cubeToUpdate);
        System.out.println("Cubul a fost actualizat. Rinduri updatate: " + rowsUpdated);
        // iau cubul cu id-ul specificat din db folosind dao, si verific daca s-a actualizat
        rbCb = RubicksCubeDao.getById(45);
        System.out.println("Cubul actualizat: " + rbCb);
	    System.out.println("=====================");
	    
	    
		// Stergem un cub dupa ID
        int rowsDeleted = RubicksCubeDao.deleteRubicksCube(50);
        System.out.println("Cubul a fost sters. Rinduri sterse: " + rowsDeleted);
//        //whats with the code from below? i dont get it, why it results in null?
//        rbCb = RubicksCubeDao.getById(2);
//        System.out.println(rbCb);
	}

}
