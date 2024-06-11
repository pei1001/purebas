package es.ubu.lsi;
	
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 * Servidor remoto.
 *
 */	
public class Servidor implements HolaMundo, ObjetoRemoto1, ObjetoRemoto2, ObjetoRemoto3 {
    
	 private List<String> nombresObjetos = new ArrayList<String>();

	  public Servidor() {
	      nombresObjetos.add("Objeto1");
	      nombresObjetos.add("Objeto2");
	      nombresObjetos.add("Objeto3");
	  }

	
	/**
	 * {@inheritDoc}.
	 *
	 * @return {@inheritDoc}
	 */
    public String decirHola() {
		return "Hola mundo!";
    }
    public String[] obtenerNombresObjetos() {
        return nombresObjetos.toArray(new String[0]);
    }

    
	
	/**
	 * Método raíz.
	 *
	 * @param args argumentos
	 */
    public static void main(String args[]) {
	
		try {
			 Servidor obj = new Servidor();
	            
	            HolaMundo stubHola = (HolaMundo) UnicastRemoteObject.exportObject(obj, 0);
	            ObjetoRemoto1 stub1 = (ObjetoRemoto1) UnicastRemoteObject.exportObject(obj, 0);
	            ObjetoRemoto2 stub2 = (ObjetoRemoto2) UnicastRemoteObject.exportObject(obj, 0);
	            ObjetoRemoto3 stub3 = (ObjetoRemoto3) UnicastRemoteObject.exportObject(obj, 0);
	            
	            Registry registro = LocateRegistry.getRegistry();
	            registro.bind("Hola", stubHola);
	            registro.bind("Objeto1", stub1);
	            registro.bind("Objeto2", stub2);
	            registro.bind("Objeto3", stub3);
	            
	            System.out.println("Servidor preparado");
	        }
		catch (Exception e) {
		    System.err.println("Excepción de servidor: " + e.toString());
		}
    } // main
    
} // Servidor