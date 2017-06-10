package listas;

import java.io.Serializable;

public class Nodo implements Serializable{
	private Object info;
	private Nodo anterior;
	private Nodo siguiente;
	
	public Nodo(Object info) {
		super();
		this.info = info;
		this.anterior=null;
		this.siguiente=null;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public Nodo getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public String toString(){
		return info.toString(); 
	}
	
	
}
