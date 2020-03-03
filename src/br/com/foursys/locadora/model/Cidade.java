package br.com.foursys.locadora.model;

public class Cidade {

private String nome;

public Cidade() {
	
}

public Cidade(String nome) {
	
	this.nome = nome;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}

}
