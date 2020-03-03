package br.com.foursys.locadora.model;

public class Vendedor {

	private String nome;
	private String areaVenda;
	private Cidade cidade;
	private Estado estado;
	private char sexo;
	private int idade;
	private int salario;

	public Vendedor() {

	}

	public Vendedor(String nome, String areaVenda, Cidade cidade, Estado estado, char sexo, int idade, int salario) {
		this.nome = nome;
		this.areaVenda = areaVenda;
		this.cidade = cidade;
		this.estado = estado;
		this.sexo = sexo;
		this.idade = idade;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaVenda() {
		return areaVenda;
	}

	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	

}
