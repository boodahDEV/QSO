package main;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Principal {
	protected String user_name_principal;
	protected String pass_principal_entry;
	protected String base_data_user_global = String.valueOf(Principal.class.getResource("dgbu.dll"));
	
	public void valide_access_system() throws Exception {
		String[] file = base_data_user_global.split("file:/");
		Stream<String> stream = Files.lines(Paths.get(file[1]));
		List<String> resultFilter = new ArrayList<>();
		stream.forEach((s)->{ 
			if (s!=null) {
				System.out.println("-"+s);	
					
					String[] data = s.split(" ");
					for(int i = 0; i < data.length;i++) {
						resultFilter.add(data[i]);
						System.out.println("\t#"+i+" :"+data[i]);
					}//end for
					
			}	
		});
        for(int i = 0; i<resultFilter.size();i++) {
            System.out.println("\t\t#"+i+" "+resultFilter.get(i));
        }  
//		if(user_name_principal.equals(""))
//			System.out.println(user_name_principal+" Inicio al sistema.");
	}//fin metodo
	
	
	public static void main(String args[]) {
		Principal p = new Principal();
		try {
			p.valide_access_system();
		} catch (Exception e) {
			System.out.println("Error:  ");
			e.printStackTrace();
		}
	}
}
