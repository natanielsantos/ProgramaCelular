package celular;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mensagem {
	
	static private int identificacao = 0;
	private String conteudo;
	private Contato destinatario;
	private LocalDate data;
	private LocalTime hora;
	
	public Mensagem(int identificacao, String conteudo, Contato destinatario, LocalDate data, LocalTime hora) {
		this.identificacao = identificacao;
		this.conteudo = conteudo;
		this.destinatario = destinatario;
		this.data = data;
		this.hora = hora;
	}
	public int getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Contato getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Contato destinatario) {
		this.destinatario = destinatario;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public void imprimir(){
		System.out.println("Contato: " + destinatario.getNome());
		System.out.println("Conteúdo: " + conteudo);
		System.out.println("Data: " + data);
		System.out.println("Hora: " + hora);
		System.out.println("---------------------------------------------");
	}
	
	

}
