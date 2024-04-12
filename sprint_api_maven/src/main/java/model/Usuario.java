package model;

public class Usuario {
	
	int id;
	String nome;
	int idade;
	String email;
	String deficiencia;
	String cep;
	String uf;
	String localidade;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeficiencia() {
		return deficiencia;
	}
	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}
	
	public Usuario() {}
	
	public Usuario(int id, String nome, int idade, String email, String deficiencia, String cep, String uf, String localidade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.deficiencia = deficiencia;
		this.cep = cep;
		this.uf = uf;
		this.localidade = localidade;
	}
}
