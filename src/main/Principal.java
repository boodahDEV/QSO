package main;

import java.io.BufferedWriter;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
//import org.apache.commons.codec.digest.DigestUtils;

public class Principal {
	protected String user_mail_principal__login;
	private String pass_principal_entry__login;
	protected String user_email_r;
	private String user_pass_r;
	protected String user_cip_r;
	protected String user_namecomplete_r;
	
	
	public int validate_conections = 1; //1 si tengo internet; 0 si no tengo
	
	
	public Principal() {
		
//		new Thread(new Runnable() {
//			public void run() {
//				try {
//				while(true) {
//					validate_conections = valida_conexion();
//					//System.out.println(validate_conections);
//					Thread.sleep(600000); // valida la conexion cada milisegundo
//					}//while
//				}catch(Exception a) {}
//			}
//		}).start();
		
	}//fin del constructor
	
	public int valida_conexion(){
	    try {
	        final URL url = new URL("https://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        conn.getInputStream().close();
	        return 1;
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return 0;
	    }
	}
	
	protected void login_access_system() {
		user_mail_principal__login = "boodah21@protonmail.com";   //ejemplo
		pass_principal_entry__login = "1234567";				   //ejemplo
		try {
			Thread.sleep(1000);
			valide_access_system(user_mail_principal__login);
		} catch (Exception e) {
			System.out.println("Error en la validacion de acceso al sistema!");
			//e.printStackTrace();
		}
		
	}
	
	protected void registry_to_system() {
		List<String> registro = new ArrayList <>();
		user_email_r = "boodah21@protonmail.com"; registro.add(user_email_r);
		user_pass_r  = "12345678"; 			  	  registro.add(user_pass_r);//confirmar en 2 pasos
		user_cip_r   = "8-8888-8888"; 		 	  registro.add(user_cip_r);
		user_namecomplete_r = "boo dah";		  registro.add(user_namecomplete_r);
		
		//Esto permite crear un maximo de 3 objetos estelares, mas de eso remplazarà el ultimo objeto
		Path path = Paths.get(".stellarobject");
    	if (Files.exists(path)) {
    			path = Paths.get(".stellarobject_u2");
    		if(Files.exists(path)){
    				path = Paths.get(".stellarobject_u3");
    		}
    	}
    	/**/

    	try (BufferedWriter br = Files.newBufferedWriter(path,
	        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
	    	for (String line : registro) {
	            br.write(servidor.Codec_data_flow.Encriptar(line, servidor.Codec_data_flow.pass));
	            br.newLine();
	         } 
	         br.newLine();
	         br.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
		     registro = null;
		     System.gc();
	      }
	}
	
	protected void valide_access_system(String mail_user) throws Exception {
//		switch(validate_conections) {
//			case 1:	{
//				System.out.println("Conectado a internet, validando con base de datos... Esto puede tomar unos segundos extras!");
//				List<String> stellar = new ArrayList<>();
//				servidor.Server_connect s = new servidor.Server_connect(); // se comunica con el servidor
//				stellar = s.getUserByEmail(mail_user); //capta la data
//			    Path path = Paths.get(".stellarobject");
//			    try (BufferedWriter br = Files.newBufferedWriter(path,
//			        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
//			       for(int i = 0; i< stellar.size();i++) {
//			        	if(stellar.get(i)!=null) {
//			            br.write(stellar.get(i));
//			            br.newLine();
//			        	//System.out.println(stellar.get(i));
//			        	}else 
//			        		continue;
//			         } 
//			      } catch (Exception e) {
//			         e.printStackTrace();
//			      }finally {
//				     s = null; //mato el objeto servidor
//				     System.gc();
//			      }
//			    
////				List<String> listuser = new ArrayList<>();
////				  servidor.Server_connect s = new servidor.Server_connect(); // se comunica con el servidor
////				  listuser = s.listAllUsers(); // Este devuelve la lista de usuarios creados en la base de datos en firebase
////			    Path path = Paths.get(".outputfile");
////			    try (BufferedWriter br = Files.newBufferedWriter(path,
////			        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
////			         for (String line : listuser) {
////			            br.write(line);
////			            br.newLine();
////			         } 
////			      } catch (Exception e) {
////			         e.printStackTrace();
////			      }finally {
////				     s = null;
////				     System.gc();
////			      }
//				break;
//			}
//			case 0:	{
//				System.out.println("No conectado");
				Path path = Paths.get(".stellarobject_u3");
					if(Files.notExists(path)){
		    			path = Paths.get(".stellarobject_u2");
		        		if(Files.notExists(path)){
		        				path = Paths.get(".stellarobject");
		        		if(Files.notExists(path))
		        			System.out.println("No hay usuarios registrados en el sistema");
		        	}
				}
				Stream<String> stream = Files.lines(path);
				List<String> resultFilter = new ArrayList<>();
				stream.forEach((s)->{ 
					if (s!=null) {
							resultFilter.add(servidor.Codec_data_flow.Desencriptar(s, servidor.Codec_data_flow.pass));
					}	
				});
		        for(int i = 0; i<resultFilter.size();i++) {
		            System.out.println("\t\t#"+i+" "+resultFilter.get(i)); //aqui filtro
		        }  
//				break;
//			}
//		}//fin del switch
	}
	
	public static void main(String args[]) {
		Principal p = new Principal();
//		String textoEncriptadoConSHA=DigestUtils.sha1Hex("Faustino"); 
//		System.out.println("Texto Encriptado con SHA : "+textoEncriptadoConSHA);
		p.registry_to_system();
		p.login_access_system();
	}
}
