package view;

import javax.swing.JOptionPane;

import adamczuk.nathan.Fila;
import controller.ImpressoraController;

public class Principal {

	public static void main(String[] args) {

		String entrada = null;

		Fila fila = new Fila();

		do {
			entrada = janela();

			if (entrada == null || entrada.equals("9")) {
				break;
			} else if (entrada.equals("1")) {
				inserirNaFila(fila);
			} else if (entrada.equals("2")) {
				imprimirFila(fila);

			} else {
				JOptionPane.showMessageDialog(null, "ENTRADA INVALIDA. TENTE NOVAMENTE");
			}

		} while (true);

	}


	private static String janela() {
		String entrada = null;

		entrada = JOptionPane
				.showInputDialog("ESCOLHA UMA OPÇÃO: \n\n" + "1 - Inserir um documento na fila de impressão \n\n"
						+ "2 - Imprimir documentos na fila \n\n" + "9 - Finalizar o programa");

		return entrada;
	}

	private static void inserirNaFila(Fila fila) {
		ImpressoraController iCont = new ImpressoraController();
		
		
		String dadosPC = null;
		String nomeDocumento = null;
		
		String documento = null;
		
		do {
			dadosPC = JOptionPane.showInputDialog("INSERIR O ID DA MAQUINA");
			if (dadosPC.contains(";")) {
				continue;
			} else {
				break;
			}
		} while (true);

		do {
			nomeDocumento = JOptionPane.showInputDialog("INSERIR O NOME DO ARQUIVO");
			if (nomeDocumento.contains(";")) {
				continue;
			} else {
				break;
			}
		} while (true);

		documento = dadosPC + ";" + nomeDocumento;

		iCont.insereDocumento(fila, documento);
	}

	private static void imprimirFila(Fila fila) {
		ImpressoraController iCont = new ImpressoraController();
		
		iCont.imprime(fila);

	}
}
