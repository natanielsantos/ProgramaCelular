package celular;

public class Contato {
	
	private int identificacao;
	private String nome;
	private String telefone;
	
	public Contato(int identificacao, String nome, String telefone) {
		this.identificacao = identificacao;
		this.nome = nome;
		this.telefone = telefone;
	}
	public int getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void imprimir(){
		System.out.println("------------------------------------------");
		System.out.println("Identificacao: " + identificacao);
		System.out.println("Nome: " + nome);
		System.out.println("Telefone: " + telefone);
		
	}
	
	

}
