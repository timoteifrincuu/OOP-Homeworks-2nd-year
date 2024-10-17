package ro.emanuel.usb.java;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.usb.dao.UsbDao;
import ro.emanuel.usb.pojo.Usb;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		// luam usb-urile si le afisam
		List<Usb> usbs = UsbDao.getUsbs();
        System.out.println("Lista usb-urilor:");
        for (Usb usb : usbs) {
            System.out.println(usb);
        }        
        System.out.println("=====================");
        
        //creem un usb nou
        Usb newUsb = new Usb("SONY", 258, "It can fly");
        int rowsInserted = UsbDao.createUsb(newUsb);
        System.out.println("Usb nou a fost creat. Rinduri inserate: " + rowsInserted);
        System.out.println("=====================");

        // luam usb dupa id si afisam
        Usb nUsb = UsbDao.getById(1);
        System.out.println("Usb gasit dupa ID: " + nUsb);
        System.out.println("=====================");

        // update la un usb
        Usb usbToUpdate = new Usb(2, "SONY", 128, "It can't fly");
        int rowsUpdated = UsbDao.updateUsb(usbToUpdate);
        System.out.println("Usb a fost actualizat. Rinduri updatate: " + rowsUpdated);
        nUsb = UsbDao.getById(2);
        System.out.println("Usb actualizat: " + nUsb);
        System.out.println("=====================");
        
        // stergem usb cu id..
        int rowsDeleted = UsbDao.deleteUsb(3);
        System.out.println("Usb a fost sters. Rinduri sterse: " + rowsDeleted);
        nUsb = UsbDao.getById(3);
        System.out.println(nUsb);
        
	}

}
