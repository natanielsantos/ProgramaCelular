package celular;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Contato> contatos;
		
		GerenciaContatos contatos;
		
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
					
					System.out.println("Menu Contatos");
					System.out.println("1 - Cadastrar");
					System.out.println("2 - Alterer");
					System.out.println("3 - Excluir");
					System.out.println("4 - Consultar");
					System.out.println("0 - Retornar");
					System.out.println("Opção: ");
					op = ent.nextInt();
					
					switch(opCt){
					case 1:
						gc.cadastrar();
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					default :
						break;

					}
					
				}while(opCt != 0);
				
				
				// FIM CONTATOS
				break;
			case 2:
				break;
			case 3:
				break;
			default :
				break;
			}

		}while(op != 0);

	}

}
