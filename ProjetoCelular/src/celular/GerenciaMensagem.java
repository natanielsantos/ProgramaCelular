package celular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaMensagem {

	Scanner ent;
	private Mensagem mensagem;
	private Contato destinatario;
	private ArrayList<Mensagem> mensagens;
	private ArrayList<Contato> contatos;

	String nome, telefone, conteudo;
	LocalDate data;
	LocalTime hora;

	int i = 0, identificacao = 0;

	public GerenciaMensagem(ArrayList<Mensagem> msg, ArrayList<Contato> cts) {
		mensagens = msg;
		contatos = cts;
		ent = new Scanner(System.in);
	}

	public void enviar() {

		int res, posiCont;

		System.out.println("*****==[M�dulo de Cadastro de Mensagems]==*****");
		System.out.println("          *****==[Vers�o 1.1]==*****");

		do {
			System.out.println("Para quem � a mensagem [informe a posicao do contaoto] ");
			posiCont = ent.nextInt();
			ent.nextLine();
			System.out.println("Escreva a mensagem : ");
			conteudo = ent.nextLine();
			destinatario = contatos.get(posiCont);

			data = data.now();
			hora = hora.now();

			i++;

			mensagem = new Mensagem(identificacao, conteudo, destinatario, data, hora);
			
			identificacao++;

			mensagens.add(mensagem);

			System.out.println("       *****==[Mensagem Cadastrado com Sucesso!!]==*****");

			System.out.println("Deseja cadastrar outro mensagem ? (1-Sim / 2-N�o)");
			res = ent.nextInt();

		} while (res != 2);
	}

	public void excluir() {

		boolean existe = true;
		
		System.out.println("Qual a identifica��o do mensagem deseja excluir ?   ");
		int posi = ent.nextInt();
		
		for(int i = 0; i < mensagens.size(); i++){
			
			if( posi == mensagens.get(i).getIdentificacao()){
				posi = i;
				i = mensagens.size() + 1;
			}else{
				existe = false;
			}
		}

		if (!mensagens.isEmpty() && posi >= 0 && existe) {

			mensagens.get(posi).imprimir(); 
			System.out.println("Deseja excluir esse mensagem ? (1 - Sim / 2 - N�o) ");
			int resp = ent.nextInt();

			if (resp == 1) {

				mensagens.remove(posi);
				System.out.println("         *****==[Exclus�o Efetuada com Sucesso!!]==*****");

			} else {
				System.out.println("         *****==[Altera��o n�o Efetuada!]==*****");
			}

		} else {
			System.out.println("         *****==[Mensagem n�o encontrado!]==*****");
		}
	}

	public void imprimir() {

		if (!mensagens.isEmpty()) {
			for (int i = 0; i < mensagens.size(); i++) {
				mensagens.get(i).imprimir();
				System.out.println("-----------------------------");
			}

		} else {
			System.out.println("         *****==[N�o existem mensagens cadastrados!]==*****");
		}
	}
}