package nanifarfalla.app.pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

	context.close();
	}

}
