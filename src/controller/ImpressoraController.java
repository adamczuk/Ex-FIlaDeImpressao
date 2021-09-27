package controller;

import java.util.Random;

import adamczuk.nathan.Fila;

public class ImpressoraController {

	public void insereDocumento(Fila f, String documento) {
		f.insert(documento);
	}

	public void imprime(Fila f) {

		String[] dadosDocumento = new String[2];

		if (f.isEmpty()) {
			System.err.println("NÃO HÁ DOCUMENTOS NA FILA DE IMPRESSÃO");
		} else {
			Random rand = new Random();
			while (!f.isEmpty()) {

				try {
					String valorRemovido = f.remove();
					dadosDocumento = valorRemovido.split(";");

					System.out.println("#PC: " + dadosDocumento[0] + " - Arquivo: " + dadosDocumento[1]);

					Thread.sleep((rand.nextInt(1) + 1) * 1000);

				} catch (Exception e) {
				}
			}
		}
	}

}
