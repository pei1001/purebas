package es.ubu.lsi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Cliente remoto.
 */
public class Cliente {

	/**
	 * Constructor oculto,
	 */
    private Cliente() {}


	/**
	 * Método raíz.
	 *
	 * @param args host con el registro
	 */
    public static void main(String[] args) {

    	 String host = (args.length < 1) ? null : args[0];
         try {
             Registry registro = LocateRegistry.getRegistry(host);
             Servidor servidor = (Servidor) registro.lookup("Servidor");
             String[] nombresObjetos = servidor.obtenerNombresObjetos();
             System.out.println("Objetos remotos disponibles:");
             for (String nombre : nombresObjetos) {
                 System.out.println(nombre);
             }
         } catch (Exception e) {
             System.err.println("Excepción en cliente: " + e.toString());
         }
    } // main
} // Cliente