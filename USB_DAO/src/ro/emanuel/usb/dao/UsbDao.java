package ro.emanuel.usb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ro.emanuel.usb.helper.DBHelper;
import ro.emanuel.usb.pojo.Usb;

public class UsbDao {
	
	
	// Takes all usbs from db n puts it into a list
    public static List<Usb> getUsbs() throws SQLException {
        List<Usb> usbL = new ArrayList<>();
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from usb");
        while(rs.next()) {
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            int storage = rs.getInt("storage");
            String spec_feature = rs.getString("spec_feature");
            Usb usb = new Usb(id, brand, storage, spec_feature);
            usbL.add(usb);
        }
        DBHelper.closeConnection();        
        return usbL;
    }
    
    // Sterge un usb din bd in functie de id
    public static int deleteUsb(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        int deletedRows = stmt.executeUpdate("delete from usb where id = " + id);
        DBHelper.closeConnection();
        return deletedRows; 
    }
    
    // Adauga un usb nou in bd
    public static int createUsb(Usb usbToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into usb (brand, storage, spec_feature) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, usbToCreate.getBrand()); 
        ps.setInt(2, usbToCreate.getStorage());
        ps.setString(3, usbToCreate.getSpec_feature());
        int affectedRows = ps.executeUpdate();
        DBHelper.closeConnection();
        return affectedRows; 
    }
    
    // Update la un usb existent
    public static int updateUsb(Usb usb) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update usb set brand = ?, storage = ?, spec_feature = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, usb.getBrand());
        ps.setInt(2, usb.getStorage());
        ps.setString(3, usb.getSpec_feature());
        ps.setInt(4, usb.getId());
        int rowsUpdated = ps.executeUpdate();
        DBHelper.closeConnection();
        return rowsUpdated; 
    }
    
    // Ia un usb in functie de ID
    public static Usb getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        List<Usb> usb = getUsbs();
        for(Usb u : usb) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    
}
