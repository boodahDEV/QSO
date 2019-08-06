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
	protected String user_name_principal;
	protected String pass_principal_entry;
	protected String base_data_user_global = String.valueOf(Principal.class.getResource("dgbu.dll"));
	
	public Principal() {

	}
	
	public void valide_access_system() throws Exception {
		switch(valida_conexion()) {
			case 1:	{
				System.out.println("Conectado");
				List<String> listuser = new ArrayList<>();
				  servidor.Server_connect s = new servidor.Server_connect();
				  listuser = s.listAllUsers();
			    Path path = Paths.get(".outputfile");
			    try (BufferedWriter br = Files.newBufferedWriter(path,
			        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
			         for (String line : listuser) {
			            br.write(line);
			            br.newLine();
			         } 
			      } catch (Exception e) {
			         e.printStackTrace();
			      }finally {
				     s = null;
				     System.gc();
			      }
//				new Thread(new Runnable() {
//					public void run() {
//						try {
//						while(true) {
//							System.out.println("ok t");
//							Thread.sleep(1000);
//							}//while
//						}catch(Exception a) {}
//					}
//				}).start();
				break;
			}
			case 0:	{
				System.out.println("No conectado");
				break;
			}
		}
		
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
	}
	
	public int valida_conexion(){
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        conn.getInputStream().close();
	        return 1;
	    } catch (Exception e) {
	        return 0;
	    }
	}

	public static void main(String args[]) {
		Principal p = new Principal();
		try {
//			servidor.Server_connect s= new servidor.Server_connect(); 
//			s.createUser("test@gmail.com", false, "1q2w3e4r5t6y", "boodah", false);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
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
