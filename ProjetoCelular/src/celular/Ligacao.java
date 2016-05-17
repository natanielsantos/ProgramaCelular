package celular;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ligacao {
	
	private int identificacao;
	private Contato destinatario;
	private LocalDate data;
	private LocalTime hora;
	
	
	public Ligacao(int identificacao, Contato destinatario, LocalDate data, LocalTime hora) {
		this.identificacao = identificacao;
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
	public Contato getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Contato destinatario) {
		this.destinatario = destinatario;
	}
	
	public void imprimir(){
		System.out.println("Você fez uma ligação para " + destinatario.getNome() + " no dia " + data + " as " + hora);
		System.out.println("---------------------------------------------");
	}
	
	
	

}
