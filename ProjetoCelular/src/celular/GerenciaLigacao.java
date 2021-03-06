package celular;

import java.io.File;
import javax.sound.sampled.*;

import java.io.IOException;
import java.net.MalformedURLException;
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

		System.out.println("*****==[M�dulo de Cadastro de Ligacaos]==*****");
		System.out.println("          *****==[Vers�o 1.1]==*****");

		do {
			System.out.println("Para quem � a ligacao [informe o numero do contaoto] ");
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

			System.out.println("Deseja cadastrar outro ligacao ? (1-Sim / 2-N�o)");
			res = ent.nextInt();

		} while (res != 2);
	}

	public void excluir() {

		boolean existe = true;
		
		System.out.println("Qual a identifica��o do ligacao deseja excluir ?   ");
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
			System.out.println("Deseja excluir esse ligacao ? (1 - Sim / 2 - N�o) ");
			int resp = ent.nextInt();

			if (resp == 1) {

				ligacoes.remove(posi);
				System.out.println("         *****==[Exclus�o Efetuada com Sucesso!!]==*****");

			} else {
				System.out.println("         *****==[Altera��o n�o Efetuada!]==*****");
			}

		} else {
			System.out.println("         *****==[Ligacao n�o encontrado!]==*****");
		}
	}

	public void imprimir() {

		if (!ligacoes.isEmpty()) {
			System.out.println("------ HIST�RICO DE LIGA��ES ------ ");
			for (int i = 0; i < ligacoes.size(); i++) {
				ligacoes.get(i).imprimir();
				System.out.println("-----------------------------");
			}

		} else {
			System.out.println("         *****==[N�o existem ligacoes cadastrados!]==*****");
		}
	}
	
	
	private static synchronized void loading(String msg) throws IOException, InterruptedException {
	    System.out.println(msg);
	    Thread th = new Thread() {
	        @Override
	        public void run() {
	        	try {
	                System.out.write("\r|".getBytes());
	                TocaAudio(1);
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
	
	 private static void TocaAudio(int seleciona){  
         try {  
             //audios que fazem parte do jogo  
         AudioInputStream stream1 = AudioSystem.getAudioInputStream(new File("c:/som-telefone.mp3"));  
         // definicao  
         AudioFormat format = stream1.getFormat();  
           
     if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {  
         format = new AudioFormat(  
                 AudioFormat.Encoding.PCM_SIGNED,  
                 format.getSampleRate(),  
                 format.getSampleSizeInBits()*2,  
                 format.getChannels(),  
                 format.getFrameSize()*2,  
                 format.getFrameRate(),  
                 true);        // big endian  
         stream1 = AudioSystem.getAudioInputStream(format, stream1);  
     }  
         // Create the clip  
     DataLine.Info info = new DataLine.Info(  
         Clip.class, stream1.getFormat(), ((int)stream1.getFrameLength()*format.getFrameSize()));  
     Clip clip = (Clip) AudioSystem.getLine(info);  
   
     // This method does not return until the audio file is completely loaded  
     if (seleciona == 1){  
         clip.open(stream1);  
       
     }
   
     // Start playing  
     clip.start();  


   } catch (MalformedURLException e) {  
 } catch (IOException e) {  
 } catch (LineUnavailableException e) {  
 } catch (UnsupportedAudioFileException e) {  
 }  
 }  
//aqui termina  
}