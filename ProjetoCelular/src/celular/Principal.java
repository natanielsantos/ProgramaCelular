package celular;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Contato> contatos = new ArrayList<>();
		ArrayList<Mensagem> mensagens = new ArrayList<>();
		ArrayList<Ligacao> ligacoes = new ArrayList<>();
		
		GerenciaContato gc = new GerenciaContato(contatos);
		GerenciaMensagem gm = new GerenciaMensagem(mensagens, contatos);
		GerenciaLigacao gl = new GerenciaLigacao(ligacoes, contatos);
		
		Scanner ent = new Scanner(System.in);
		int op;
		
		do{
			System.out.println("Menu Principal");
			System.out.println("1 - Contatos");
			System.out.println("2 - Mensagens");
			System.out.println("3 - Ligações");
			System.out.println("0 - Desligar");
			System.out.println("Opção: ");
			op = ent.nextInt();
			
			switch(op){
			case  1: // INICIO CONTATOS
				
				int opCt = 0;
				do{
					
					System.out.println("Gerenciar Contatos");
					System.out.println("1 - Cadastrar");
					System.out.println("2 - Alterar");
					System.out.println("3 - Excluir");
					System.out.println("4 - Consultar");
					System.out.println("5 - Ver todos");
					System.out.println("0 - Retornar");
					System.out.println("Opção: ");
					opCt = ent.nextInt();
					
					switch(opCt){
					case 1:
						gc.cadastrar();
						break;
					case 2:
						gc.alterar();
						break;
					case 3:
						gc.excluir();
						break;
					case 4:
						gc.consultar();
						break;
					case 5:
						gc.imprimir();
						break;
					default :
						break;

					}
					
				}while(opCt != 0);
				
				
				// FIM CONTATOS
				break;
			case 2:
				int opMg = 0;
				do{
					
					System.out.println("Gerenciar Mensagens");
					System.out.println("1 - Enviar mensagem");
					System.out.println("2 - Excluir");
					System.out.println("3 - Ver histórico de mensagens");
					System.out.println("0 - Retornar");
					System.out.println("Opção: ");
					opMg = ent.nextInt();
					
					switch(opMg){
					case 1:
						gm.enviar();
						break;
					case 2:
						gm.excluir();
						break;
					case 3:
						gm.imprimir();
						break;
					default :
						break;

					}
					
				}while(opMg != 0);
				
				
				// FIM CONTATOS

				break;
			case 3:
				int opLg = 0;
				do{
					
					System.out.println("Gerenciar Ligações");
					System.out.println("1 - Fazer uma ligação");
					System.out.println("2 - Apagar ligações do histórico");
					System.out.println("3 - Ver histórico de ligações");
					System.out.println("0 - Retornar");
					System.out.println("Opção: ");
					opLg = ent.nextInt();
					
					switch(opLg){
					case 1:
						gl.enviar();
						break;
					case 2:
						gl.excluir();
						break;
					case 3:
						gl.imprimir();
						break;
					default :
						break;

					}
					
				}while(opLg != 0);
				
				
				// FIM CONTATOS

				break;
			default :
				break;
			}

		}while(op != 0);

	}

}
