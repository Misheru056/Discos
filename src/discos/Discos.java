/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discos;

import java.util.Scanner;

/**
 *
 * @author Michelle
 */
public class Discos {

  // N determina el tamaño del array
  static int N = 100;
  
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      
      
    //Crea el array de discos
    Disco[] album = new Disco[N];

    // Crea todos los discos que van en cada una de
    // las celdas del array
    for(int i = 0; i < N; i++) {
      album[i] = new Disco();
    }

    int opcion;
    String codigoIntroducido;
    String autorIntroducido;
    String tituloIntroducido;
    String generoIntroducido;
    String duracionIntroducidaString;
    int duracionIntroducida;
    int primeraLibre;
    int i=0;
    
do {
      System.out.println("\n\nCOLECCIÓN DE DISCOS");
      System.out.println("===================");
      System.out.println("1. Listado");
      System.out.println("2. Nuevo disco");
      System.out.println("3. Modificar");
      System.out.println("4. Borrar");
      System.out.println("5. Salir");
      System.out.print("Introduzca una opción: ");
      opcion = Integer.parseInt(entrada.nextLine());
      
      switch (opcion) {
      case 1:
                Listado(i, album, false);
        break;
        
      case 2:
                Nuevo_disco(album, entrada);
        
        break;
        
      case 3:
                Modificar_Disco(entrada, album);
        
        break;
        
      case 4:
                Borrar_Disco(entrada, album);
        
        break;
        
      default:
      
      } // switch
    } while (opcion != 5);
  }

    /**
     *
     * @param i
     * @param album
     * @param orden
     */
    public static void Listado(int i, Disco[] album, boolean orden) {
        System.out.println("\nLISTADO");
        System.out.println("=======");
        for(i = 0; i < N; i++) {
            if (!album[i].codigo.equals("LIBRE")) {
                System.out.println(album[i]);
            }
        }
    }

    public static void Borrar_Disco(Scanner entrada, Disco[] album) {
        String codigoIntroducido;
        int i;
        System.out.println("\nBORRAR");
        System.out.println("======");
        System.out.print("Por favor, introduzca el código del disco que desea borrar: ");
        codigoIntroducido = entrada.nextLine();
        i = -1;
        do {
            i++;
        } while (!((album[i].codigo.equals(codigoIntroducido))));
        album[i].setCodigo("LIBRE");
        System.out.println("Album borrado.");
    }

    public static void Modificar_Disco(Scanner entrada, Disco[] album) throws NumberFormatException {
        String codigoIntroducido;
        int i;
        String autorIntroducido;
        String tituloIntroducido;
        String generoIntroducido;
        String duracionIntroducidaString;
        System.out.println("\nMODIFICAR");
        System.out.println("===========");
        System.out.print("Por favor, introduzca el código del disco cuyos datos desea cambiar: ");
        codigoIntroducido = entrada.nextLine();
        i = -1;
        do {
            i++;
        } while (!((album[i].codigo.equals(codigoIntroducido))));
        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");
        System.out.println("Código: " + album[i].getCodigo());
        System.out.print("Nuevo código: ");
        codigoIntroducido = entrada.nextLine();
        if (!codigoIntroducido.equals("")) {
            album[i].setCodigo(codigoIntroducido);
        }
        System.out.println("Autor: " + album[i].getAutor());
        System.out.print("Nuevo autor: ");
        autorIntroducido = entrada.nextLine();
        if (!autorIntroducido.equals("")) {
            album[i].setAutor(autorIntroducido);
        }
        System.out.println("Título: " + album[i].getTitulo());
        System.out.print("Nuevo título: ");
        tituloIntroducido = entrada.nextLine();
        if (!tituloIntroducido.equals("")) {
            album[i].setTitulo(tituloIntroducido);
        }
        System.out.println("Género: " + album[i].getGenero());
        System.out.print("Nuevo género: ");
        generoIntroducido = entrada.nextLine();
        if (!generoIntroducido.equals("")) {
            album[i].setGenero(generoIntroducido);
        }
        System.out.println("Duración: " + album[i].getDuracion());
        System.out.print("Duración: ");
        duracionIntroducidaString = entrada.nextLine();
        if (!duracionIntroducidaString.equals("")) {
            album[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
        }
    }

    public static void Nuevo_disco(Disco[] album, Scanner entrada) throws NumberFormatException {
        int primeraLibre;
        String codigoIntroducido;
        String autorIntroducido;
        String tituloIntroducido;
        String generoIntroducido;
        int duracionIntroducida;
        System.out.println("\nNUEVO DISCO");
        System.out.println("===========");
        // Busca la primera posición libre del array
        primeraLibre = -1;
        do {
            primeraLibre++;
        } while (!((album[primeraLibre].codigo.equals("LIBRE"))));
        System.out.println("Por favor, introduzca los datos del disco.");
        System.out.print("Código: ");
        codigoIntroducido = entrada.nextLine();
        album[primeraLibre].setCodigo(codigoIntroducido);
        System.out.print("Autor: ");
        autorIntroducido = entrada.nextLine();
        album[primeraLibre].setAutor(autorIntroducido);
        System.out.print("Título: ");
        tituloIntroducido = entrada.nextLine();
        album[primeraLibre].setTitulo(tituloIntroducido);
        System.out.print("Género: ");
        generoIntroducido = entrada.nextLine();
        album[primeraLibre].setGenero(generoIntroducido);
        System.out.print("Duración: ");
        duracionIntroducida = Integer.parseInt(entrada.nextLine());
        album[primeraLibre].setDuracion(duracionIntroducida);
    }
}
