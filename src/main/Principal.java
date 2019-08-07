package main;

import java.io.BufferedWriter;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import org.apache.commons.codec.digest.DigestUtils;

public class Principal {
	protected String user_mail_principal;
	private String pass_principal_entry;
	public int validate_conections;
	
	public Principal() {	
		new Thread(new Runnable() {
			public void run() {
				try {
				while(true) {
					validate_conections = valida_conexion();
					System.out.println(validate_conections);
					Thread.sleep(500); // valida la conexion cada milisegundo
					}//while
				}catch(Exception a) {}
			}
		}).start();
	}//fin del constructor
	
	public int valida_conexion(){
	    try {
	        final URL url = new URL("https://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        conn.getInputStream().close();
			System.out.println("OK");
	        return 1;
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return 0;
	    }
	}
	
	protected void login_access_system() {
		user_mail_principal = "boodah21@protonmail.com";   //ejemplo
		pass_principal_entry = "1234567";				   //ejemplo
		try {
			Thread.sleep(1000);
			valide_access_system(user_mail_principal);
		} catch (Exception e) {
			System.out.println("Error en la validacion de acceso al sistema!");
			e.printStackTrace();
		}
		
	}
	
	protected void registry_to_system() {
		
	}
	
	protected void valide_access_system(String mail_user) throws Exception {
		switch(validate_conections) {
			case 1:	{
				System.out.println("Conectado a internet, validando con base de datos... Esto puede tomar unos segundos extras!");
				List<String> stellar = new ArrayList<>();
				servidor.Server_connect s = new servidor.Server_connect(); // se comunica con el servidor
				stellar = s.getUserByEmail(mail_user); //capta la data
			    Path path = Paths.get(".stellarobject");
			    try (BufferedWriter br = Files.newBufferedWriter(path,
			        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
			         for (String line : stellar) {
			        	if(line.equals(null)==false)
//			            br.write(line);
//			            br.newLine();
			        		System.out.println(line);
			        	else {
			        		continue;
			        	}
			         } 
			      } catch (Exception e) {
			         e.printStackTrace();
			      }finally {
				     s = null;
				     System.gc();
			      }
			    
//				List<String> listuser = new ArrayList<>();
//				  servidor.Server_connect s = new servidor.Server_connect(); // se comunica con el servidor
//				  listuser = s.listAllUsers(); // Este devuelve la lista de usuarios creados en la base de datos en firebase
//			    Path path = Paths.get(".outputfile");
//			    try (BufferedWriter br = Files.newBufferedWriter(path,
//			        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
//			         for (String line : listuser) {
//			            br.write(line);
//			            br.newLine();
//			         } 
//			      } catch (Exception e) {
//			         e.printStackTrace();
//			      }finally {
//				     s = null;
//				     System.gc();
//			      }
				break;
			}
			case 0:	{
				System.out.println("No conectado");
//				String[] file = base_data_user_global.split("file:/"); //Le quito el file que me coloca obtener el path con el class get resources
//				Stream<String> stream = Files.lines(Paths.get(file[1])); // se crea una coleccion de String asociados a un archivo, file[1] es el resultado del split donde 1 es el path limpio
//				List<String> resultFilter = new ArrayList<>();// lista de Strinf donde almacenará los datos de coleccion
//				stream.forEach((s)->{ 
//					if (s!=null) {
//						String[] data = s.split(" ");
//						for(int i = 0; i < data.length;i++) {
//							resultFilter.add(data[i]);
//						}//end for
//					}	
//				});
//		        for(int i = 0; i<resultFilter.size();i++) {
//		            System.out.println("\t\t#"+i+" "+resultFilter.get(i));
//		        }  
				break;
			}
		}//fin del switch
	}
	
	public static void main(String args[]) {
		Principal p = new Principal();
//		String textoEncriptadoConSHA=DigestUtils.sha1Hex("Faustino"); 
//		System.out.println("Texto Encriptado con SHA : "+textoEncriptadoConSHA);
		p.login_access_system();
	}
}
