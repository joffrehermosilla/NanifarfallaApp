package nanifarfalla.app.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.awt.Image;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

/*
import org.marvinproject.image.transform.scale.Scale;

import marvin.image.MarvinImage;*/

import org.imgscalr.Scalr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import net.coobird.thumbnailator.Thumbnails;

public class Utileria {

	/**
	 * Metodo que regresa una Lista de Strings con las fechas siguientes, segun el
	 * parametro count
	 * 
	 * @param count
	 * @return
	 */
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Today's Date
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); // Next N days from now
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}

	public static List<String> cuentaObjetos(Object object) {

		int cont = 0;
		List<String> cuentaobjetos = new ArrayList<String>();
		while (!(object == null)) {
			cuentaobjetos.add("" + cont++);

		}

		return cuentaobjetos;

	}

	public static List<String> getPastDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Today's Date
		Date start = new Date();
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DAY_OF_MONTH, count); // Next N days from now
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> pastDays = new ArrayList<String>();
		while (gcal.getTime().before(endDate)) {
			Date d = gcal.getTime();

			gcal.add(Calendar.DATE, 1);
			pastDays.add(sdf.format(d));
		}
		return pastDays;
	}

	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		// concatenar la linea y los padres del usuario
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(rutaFinal + nombreFinal);
			System.out.println(imageFile.getAbsolutePath());
			// Aqui se guarda fisicamente el archivo en el disco duro
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}

	public static String guardarImagenPlus(MultipartFile multiPart, HttpServletRequest request, String ruta) {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		// concatenar la linea y los padres del usuario
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		// String rutaFinal =
		// request.getServletContext().getRealPath("/resources/images/");
		String rutaFinal = request.getServletContext().getRealPath(ruta);

		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro

			File creardirectorio = new File(rutaFinal);
			creardirectorio.mkdirs();
			File imageFile = new File(rutaFinal + nombreFinal);

			/*
			 * File crearthumbnail = new File(nombreOriginal); Thumbnails.of(crearthumbnail)
			 * .size(160, 160) .scale(0.25) .outputFormat("png") .toFile(nombreOriginal);
			 */

			System.out.println("Mostrar Path Absoluto: " + imageFile.getAbsolutePath());
			System.out.println("Generar Ruta Absulta: " + imageFile.mkdirs());
			System.out.println("Mostrar la Ruta" + imageFile.getPath());
			// Aqui se guarda fisicamente el archivo en el disco duro

			multiPart.transferTo(imageFile);

			BufferedImage originalImage = ImageIO.read(imageFile);
			BufferedImage outputImage = resizeImage(originalImage, 200, 200);
			ImageIO.write(outputImage, "jpg", imageFile);

			/*
			 * COre Java BufferedImage originalImage = ImageIO.read(new
			 * File("src/main/resources/images/sampleImage.jpg")); BufferedImage outputImage
			 * = resizeImageGraphics2d(originalImage, 200, 200); ImageIO.write(outputImage,
			 * "jpg", new
			 * File("src/main/resources/images/sampleImage-resized-graphics2d.jpg"));
			 * 
			 */

			/*
			 * Core Java BufferedImage originalImage = ImageIO.read(new
			 * File("src/main/resources/images/sampleImage.jpg")); BufferedImage outputImage
			 * = resizeImageScalade(originalImage, 200, 200); ImageIO.write(outputImage,
			 * "jpg", new
			 * File("src/main/resources/images/sampleImage-resized-scaledinstance.jpg"));
			 * 
			 * 
			 */

			/*
			 * ImageScaler BufferedImage originalImage = ImageIO.read(new
			 * File("src/main/resources/images/sampleImage.jpg")); BufferedImage outputImage
			 * = resizeImageScalr(originalImage, 200, 200); ImageIO.write(outputImage,
			 * "jpg", new
			 * File("src/main/resources/images/sampleImage-resized-imgscalr.jpg"));
			 */

			/*
			 * 
			 * BufferedImage originalImage = ImageIO.read(new
			 * File("src/main/resources/images/sampleImage.jpg")); BufferedImage
			 * outputImageMarvin = resizeImage(originalImage, 200, 200);
			 * ImageIO.write(outputImage, "jpg", new
			 * File("src/main/resources/images/sampleImage-resized-marvin.jpg"));
			 */

			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}

	public static String remakePicture(String rutaFinal, File creardirectorio) {
		Path thumbnailPath = Paths.get(rutaFinal).getParent();
		Path fileName = Paths.get(rutaFinal).getFileName();

		String thumbnailFullPath = thumbnailPath + File.separator + "thumbnail" + File.separator + fileName;

		try {
			Thumbnails.of(creardirectorio).size(160, 160).outputFormat("png").outputQuality(0.60)
					.toFile(thumbnailFullPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return thumbnailFullPath;
	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Thumbnails.of(originalImage).size(targetWidth, targetHeight).outputFormat("jpg").outputQuality(0.90)
				.toOutputStream(outputStream);
		byte[] data = outputStream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		return ImageIO.read(inputStream);
	}

	// Metodo para generar una cadena de longitud N de caracteres aleatorios.
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}

	public static BufferedImage resizeImageGraphics2d(BufferedImage originalImage, int targetWidth, int targetHeight) {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}

	static BufferedImage resizeImageScalade(BufferedImage originalImage, int targetWidth, int targetHeight) {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
		BufferedImage bufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		return bufferedImage;
	}

	public static BufferedImage simpleResizeImage(BufferedImage originalImage, int targetWidth) {
		return Scalr.resize(originalImage, targetWidth);
	}

	public static BufferedImage resizeImageScalr(BufferedImage originalImage, int targetWidth, int targetHeight) {
		return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight,
				Scalr.OP_ANTIALIAS);
	}

	/*
	 * static BufferedImage resizeImageMarvin(BufferedImage originalImage, int
	 * targetWidth, int targetHeight) { MarvinImage image = new
	 * MarvinImage(originalImage); Scale scale = new Scale(); scale.load();
	 * scale.setAttribute("newWidth", targetWidth); scale.setAttribute("newHeight",
	 * targetHeight); scale.process(image.clone(), image, null, null, false); return
	 * image.getBufferedImageNoAlpha(); }
	 */

	public static String consumoram() {

		int dataSize = 1024 * 1024;

		  Runtime runtime = Runtime.getRuntime();
		  
		   System.out.println ("Memoria máxima: " + runtime.maxMemory() / dataSize + "MB");
		   System.out.println ("Memoria total: " + runtime.totalMemory() / dataSize + "MB");
		   System.out.println ("Memoria libre: " + runtime.freeMemory() / dataSize + "MB");
		   System.out.println ("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");
		
		
		
		
		return "Memoria máxima: " + runtime.maxMemory() / dataSize + " MB " +
				"Memoria total: " + runtime.totalMemory() / dataSize + " MB "+
				"Memoria libre: " + runtime.freeMemory() / dataSize + " MB "+
				"Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + " MB";

	}
	
	public static DateFormat getLocalFormat() {
		DateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault());
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}

	public static String printPrettyJSONString(Object o) {
		try {
			return new ObjectMapper()
					.setDateFormat(getLocalFormat())
					.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
							false).writerWithDefaultPrettyPrinter()
					.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return null;
		}
	}	

}