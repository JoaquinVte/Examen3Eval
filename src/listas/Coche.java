package listas;

import java.io.Serializable;

public class Coche implements Serializable{
	
	private String marca;
	private String modelo;
	private int caballos;
	private String matricula;
	private String tipo;
	private String propietario;
	
	public Coche(String marca, String modelo, int caballos, String matricula, String tipo, String propietario) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.caballos = caballos;
		this.matricula = matricula;
		this.tipo = tipo;
		this.propietario = propietario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCaballos() {
		return caballos;
	}
	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	@Override
	public String toString() {
		return "Coche [bastidor="  + ", marca=" + marca + ", modelo=" + modelo + ", color=" 
				+ ", caballos=" + caballos + ", matricula=" + matricula + ", tipo=" + tipo + ", propietario="
				+ propietario + "]";
	}


	
}
