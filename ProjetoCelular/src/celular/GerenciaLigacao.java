package celular;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaLigacao {

	Scanner ent;
	private Ligacao ligacao;
	private Contato destinatario;
	private ArrayList<Ligacao> ligacoes;
	private ArrayList<Contato> contatos;
	
	private static boolean loading = true;

	String nome, telefone, conteudo;
	LocalDate data;
	LocalTime hora;

	int i = 0, identificacao = 0;

	public GerenciaLigacao(ArrayList<Ligacao> lg, ArrayList<Contato> cts) {
		ligacoes = lg;
		contatos = cts;
		ent = new Scanner(System.in);
	}

	public void enviar(){

		int res, posiCont;

		System.out.println("*****==[Módulo de Cadastro de Ligacaos]==*****");
		System.out.println("          *****==[Versão 1.1]==*****");

		do {
			System.out.println("Para quem é a ligacao [informe o numero do contaoto] ");
			posiCont = ent.nextInt();
			ent.nextLine();
			
			try {
				loading("Ligando...");
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1-ATENDER / 2-RECUSAR");
			res = ent.nextInt();
		    if(res == 1){
		    	System.out.println("Atendido!");
		    	loading = false;
		    }else{
		    	System.out.println("Cancelado!");
		    	loading = false;
		    }

			destinatario = contatos.get(posiCont);

			data = data.now();
			hora = hora.now();

			i++;

			ligacao = new Ligacao(identificacao, destinatario, data, hora);
			
			identificacao++;

			ligacoes.add(ligacao);

			System.out.println("       *****==[Ligacao Cadastrado com Sucesso!!]==*****");

			System.out.println("Deseja cadastrar outro ligacao ? (1-Sim / 2-Não)");
			res = ent.nextInt();

		} while (res != 2);
	}

	public void excluir() {

		boolean existe = true;
		
		System.out.println("Qual a identificação do ligacao deseja excluir ?   ");
		int posi = ent.nextInt();
		
		for(int i = 0; i < ligacoes.size(); i++){
			
			if( posi == ligacoes.get(i).getIdentificacao()){
				posi = i;
				i = ligacoes.size() + 1;
			}else{
				existe = false;
			}
		}

		if (!ligacoes.isEmpty() && posi >= 0 && existe) {

			ligacoes.get(posi).imprimir(); 
			System.out.println("Deseja excluir esse ligacao ? (1 - Sim / 2 - Não) ");
			int resp = ent.nextInt();

			if (resp == 1) {

				ligacoes.remove(posi);
				System.out.println("         *****==[Exclusão Efetuada com Sucesso!!]==*****");

			} else {
				System.out.println("         *****==[Alteração não Efetuada!]==*****");
			}

		} else {
			System.out.println("         *****==[Ligacao não encontrado!]==*****");
		}
	}

	public void imprimir() {

		if (!ligacoes.isEmpty()) {
			System.out.println("------ HISTÓRICO DE LIGAÇÕES ------ ");
			for (int i = 0; i < ligacoes.size(); i++) {
				ligacoes.get(i).imprimir();
				System.out.println("-----------------------------");
			}

		} else {
			System.out.println("         *****==[Não existem ligacoes cadastrados!]==*****");
		}
	}
	
	
	private static synchronized void loading(String msg) throws IOException, InterruptedException {
	    System.out.println(msg);
	    Thread th = new Thread() {
	        @Override
	        public void run() {
	        	try {
	                System.out.write("\r|".getBytes());
	                while(loading) {
	                    System.out.write("|".getBytes());
	                    Thread.sleep(500);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    };
	    th.start();
	    
	}
}