/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author steve
 */
public class ManejoZip {
    /**
    * metodo principal
     * Comprime el contenido de un directorio o archivo en un archivo ZIP.
     * @param fuente es la ruta del archivo o directorio que se va a comprimir.
     * @param direccionArchivoZip es la ruta donde se guardará el archivo ZIP.
     */
    public void comprimir(String fuente, String direccionArchivoZip) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(direccionArchivoZip))) {
            File archivoFuente = new File(fuente);
            comprimirArchivo(archivoFuente, archivoFuente.getName(), zipOut);
        }
    }

    /**
     * Comprime un archivo o directorio (recursivamente si es necesario).
     * @param archivo a comprimir
     * @param nombreBase nombre dentro del archivo ZIP
     * @param zipOut flujo de salida del archivo ZIP
     */
    private void comprimirArchivo(File archivo, String nombreBase, ZipOutputStream zipOut) throws IOException {
        if (archivo.isHidden()) {
            return; // Ignora archivos ocultos
        }
        if (archivo.isDirectory()) {
            // Si es un directorio y no está vacío, agrega sus archivos recursivamente
            if (nombreBase.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(nombreBase));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(nombreBase + "/"));
                zipOut.closeEntry();
            }
            File[] hijos = archivo.listFiles();
            for (File hijo : hijos) {
                comprimirArchivo(hijo, nombreBase + "/" + hijo.getName(), zipOut);
            }
            return;
        }
        // Agrega un archivo al ZIP
        try (FileInputStream fis = new FileInputStream(archivo)) {
            ZipEntry zipEntry = new ZipEntry(nombreBase);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[4096];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.closeEntry();
        }
    }
    /**
     * encuentra el path del escritorio usando la  variable path
     * @return 
     */
public String obtenerEscritorio() {
        // Obtiene el directorio home del usuario
        String userHome = System.getProperty("user.home");

        // Lista de posibles nombres para el directorio del escritorio en diferentes idiomas
        String[] possibleDesktopNames = {"Desktop", "Escritorio"};

        Path escritorioPath = null;
        for (String desktopName : possibleDesktopNames) {
            Path testPath = Paths.get(userHome, desktopName);
            if (new File(testPath.toString()).exists()) { // Verifica si el path existe
                escritorioPath = testPath;
                break;
            }
        }

        if (escritorioPath != null) {
            return escritorioPath.toString();  // Devuelve el path como String
        } else {
            System.out.println("No se pudo encontrar el directorio del escritorio.");
            return null;  // Devuelve null si no se encuentra el escritorio
        }
    }
    /**
     * 
     * @param path 
     */
    public void crearCarpetaSiNoExiste(String path) {
        File carpeta = new File(path);
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta creada: " + path);
            } else {
                System.out.println("No se pudo crear la carpeta: " + path);
            }
        }
    }
    //prueba
    
}
