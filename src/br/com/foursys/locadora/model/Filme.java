package br.com.foursys.locadora.model;

public class Filme {

	private int codigo;
	private String nome;
	private String genero;
	private Double valor;
	private boolean disponivel;
	private boolean promocao;
	private Double valorPromocao;

	public Filme() {

	}
	

	
	public Filme(int codigo, String nome, String genero, Double valor, boolean disponivel, boolean promocao,
			Double valorPromocao) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
		this.valor = valor;
		this.disponivel = disponivel;
		this.promocao = promocao;
		this.valorPromocao = valorPromocao;
	}

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Double getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(Double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	

}