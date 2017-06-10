package listas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class ListaDoblementeEnlazada implements Serializable{
	private Nodo cabeza;
	private Nodo cola;
	private int tamaño;
	private File f;
	
	
	public ListaDoblementeEnlazada() {
		super();
		this.cabeza = null;
		this.cola = null;
		this.tamaño = 0;
		this.f = null;
	}

	public Nodo getCabeza() {
		return cabeza;
	}
	
	public Nodo getCola() {
		return cola;
	}
	
	public int getTamaño() {
		return tamaño;
	}

	public void setFile(File f) {
		this.f = f;
	}
	
	public String toString(){
		String lista="";
		Nodo aux=cabeza;
		while (aux!=null){
			lista = lista + aux.toString() + "\n";
			aux=aux.getSiguiente();
		}
		return lista;
	}

	public void insertarCola(Nodo n){
		if(cabeza==null){
			this.cabeza=n;
			this.cola=n;
		} else {
			n.setAnterior(cola);
			cola.setSiguiente(n);
			cola=n;
		}
		tamaño++;
	}
	public void guardar() throws FileNotFoundException, IOException{
		ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new
                    BufferedOutputStream(new FileOutputStream(f)));
 
            out.writeObject(cabeza);
            out.writeObject(cola);
            out.writeObject(tamaño);
            
        } catch(Exception e) {
        	
        	System.out.print(e); 
        	
        } finally {
            out.close();
        }
	}
	
	public void cargar() throws FileNotFoundException, IOException{
		ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
 
 
            cabeza = (Nodo) in.readObject();
            cola = (Nodo) in.readObject();
            tamaño = (int) in.readObject();
                
            } catch (EOFException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
				e.printStackTrace();
        } finally {
            in.close();
        }
	}
	
}
