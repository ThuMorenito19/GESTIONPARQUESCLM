package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Json {
	
	public static void main(String[] args) throws Exception {
		Json json=new Json();
		
		String resultado=json.peticionHttpGet("https://datosabiertos.castillalamancha.es/sites/datosabiertos.castillalamancha.es/files/espacios%20naturales.json");
	Writer fw=null;
	try {
		File file =new File("files/parquesClM.json");
		fw=new FileWriter(file);
		fw.write(resultado);
		fw.flush();
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	System.out.println("Hemos pasado los datos del url a un fichero JSON");

		
	
	}

	public static String peticionHttpGet(String url) throws Exception {
		
		StringBuilder resultado = new StringBuilder();
		URL miurl = new URL(url);

		HttpURLConnection conexion = (HttpURLConnection) miurl.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Cuando el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();

		return resultado.toString();
	}
	
	
}
