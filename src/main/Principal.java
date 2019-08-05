package main;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.*;
import org.apache.commons.codec.digest.DigestUtils;

public class Principal {
	protected String user_name_principal;
	protected String pass_principal_entry;
	protected String base_data_user_global = String.valueOf(Principal.class.getResource("dgbu.dll"));
	
	public void valide_access_system() throws Exception {
		String[] file = base_data_user_global.split("file:/"); //Le quito el file que me coloca obtener el path con el class get resources
		Stream<String> stream = Files.lines(Paths.get(file[1])); // se crea una coleccion de String asociados a un archivo, file[1] es el resultado del split donde 1 es el path limpio
		List<String> resultFilter = new ArrayList<>();// lista de Strinf donde almacenará los datos de coleccion
		stream.forEach((s)->{ 
			if (s!=null) {
					String[] data = s.split(" ");
					for(int i = 0; i < data.length;i++) {
						resultFilter.add(data[i]);
					}//end for
			}	
		});
//        for(int i = 0; i<resultFilter.size();i++) {
//            System.out.println("\t\t#"+i+" "+resultFilter.get(i));
//        }  
//		if(user_name_principal.equals(""))
//			System.out.println(user_name_principal+" Inicio al sistema.");
	}//fin metodo de validacion de acceso al sistema
	
	
	public static void main(String args[]) {
		Principal p = new Principal();
		
		
		try {
			servidor.Server_connect s= new servidor.Server_connect(); 
			s.createUser("test@gmail.com", false, "1q2w3e4r5t6y", "boodah", false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); }
		
		
		String textoEncriptadoConSHA=DigestUtils.sha1Hex("Faustino"); 
		System.out.println("Texto Encriptado con SHA : "+textoEncriptadoConSHA);
		try {
			p.valide_access_system();
		} catch (Exception e) {
			System.out.println("Error:  ");
			e.printStackTrace();
		}
	}
}
