package celular;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaContato {

	Scanner ent;
	private Contato contato;
	private ArrayList<Contato> contatos;

	String nome, telefone;

	int i = 0, identificacao;

	public GerenciaContato(ArrayList<Contato> cts) {
		contatos = cts;
		ent = new Scanner(System.in);
	}

	public void cadastrar() {

		int res;

		System.out.println("*****==[Módulo de Cadastro de Contatos]==*****");
		System.out.println("          *****==[Versão 1.1]==*****");

		do {
			System.out.println("Identificação: ");
			identificacao = ent.nextInt();
			System.out.println("Digite o nome do Contato : ");
			nome = ent.next();
			System.out.println("Telefone                 : ");
			telefone = ent.next();

			i++;

			contato = new Contato(identificacao, nome, telefone);

			contatos.add(contato);

			System.out.println("       *****==[Contato Cadastrado com Sucesso!!]==*****");

			System.out.println("Deseja cadastrar outro contato ? (1-Sim / 2-Não)");
			res = ent.nextInt();

		} while (res != 2);
	}

	public void alterar() {

		int res;

		do {
			
			boolean existe = true;
			
			System.out.println("Qual identificação do cliente deseja alterar? ");
			int posi = ent.nextInt();
			
			for(int i = 0; i < contatos.size(); i++){
				
				if( posi == contatos.get(i).getIdentificacao()){
					posi = i;
					i = contatos.size() + 1;
				}else{
					existe = false;
				}
			}

			if (!contatos.isEmpty() && (posi >= 0) && existe ) {
				
				contatos.get(posi).imprimir();

				System.out.println("Confirma alteração ? (1 - Sim / 2 - Não) ");
				int resp = ent.nextInt();

				if (resp == 1) {

					Contato novoContato;

					System.out.println("Identificação                 : " + identificacao);
					System.out.println("Digite o novo nome do Contato : ");
					nome = ent.next();
					System.out.println("Digite o número do telefone   : ");
					telefone = ent.next();

					novoContato = new Contato(identificacao, nome, telefone);

					contatos.set(posi, novoContato);

					System.out.println("         *****==[Alteração Efetuada com Sucesso!!]==*****");

				} else {
					System.out.println("         *****==[Alteração não Efetuada!]==*****");
				}
			} else {
				System.out.println("         *****==[Contato Inexistente!]==*****");
			}

			System.out.println("Deseja realizar outra alteração ? (1-Sim / 2-Não)");
			res = ent.nextInt();

		} while (res != 2);
	}

	public void excluir() {

		boolean existe = true;
		
		System.out.println("Qual a identificação do contato deseja excluir ?   ");
		int posi = ent.nextInt();
		
		for(int i = 0; i < contatos.size(); i++){
			
			if( posi == contatos.get(i).getIdentificacao()){
				posi = i;
				i = contatos.size() + 1;
			}else{
				existe = false;
			}
		}

		if (!contatos.isEmpty() && posi >= 0 && existe) {

			contatos.get(posi).imprimir(); 
			System.out.println("Deseja excluir esse contato ? (1 - Sim / 2 - Não) ");
			int resp = ent.nextInt();

			if (resp == 1) {

				contatos.remove(posi);
				System.out.println("         *****==[Exclusão Efetuada com Sucesso!!]==*****");

			} else {
				System.out.println("         *****==[Alteração não Efetuada!]==*****");
			}

		} else {
			System.out.println("         *****==[Contato não encontrado!]==*****");
		}
	}

	public void consultar() {

		int res;

		do {
			System.out.println("Qual a posição deseja consultar ?   ");
			int posi = ent.nextInt();

			if ((!contatos.isEmpty()) && (posi >= 0) && posi <= contatos.size()) {

				contatos.get(posi).imprimir();

			} else {
				System.out.println("         *****==[Contato não encontrado!]==*****");
			}
			System.out.println("Deseja realizar outra consulta ? (1-Sim / 2-Não)");
			res = ent.nextInt();

		} while (res != 2);

	}

	public void imprimir() {

		if (!contatos.isEmpty()) {
			for (int i = 0; i < contatos.size(); i++) {
				contatos.get(i).imprimir();
				System.out.println("-----------------------------");
			}

		} else {
			System.out.println("         *****==[Não existem contatos cadastrados!]==*****");
		}
	}
}