package br.com.gilmar;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Testes {

	public static void main(String[] args) {
		try {
			Avaliacao avaliacao = new Avaliacao();
			/* pega o arquiivo do Excel */
			Workbook workbook = Workbook.getWorkbook(new File("C:/Users/Aluno/Documents/Atividade 1.xls"));
			/* pega a primeira planilha dentro do arquivo XLS */
			Integer linha = 2;
			Sheet sheet = workbook.getSheet(0);

			while (linha < sheet.getRows()) {
				Cell a1 = sheet.getCell(0, linha);
				Cell a2 = sheet.getCell(1, linha);
				Cell a3 = sheet.getCell(2, linha);
				Cell a4 = sheet.getCell(3, linha);

				System.out.println("CASO DE TESTE: " + a1.getContents() + "\nDADOS: " + a2.getContents()
						+ "\nCLASSES EQUIVALENTES: " + a3.getContents() + "\nRESULTADO ESPERADO: " + a4.getContents());

				try {
					String[] dadosLinha = a2.getContents().split(",");
					if (dadosLinha.length != 4)
						throw new ValoresInvalidosException();

					System.out.println(avaliacao.avalia(Double.valueOf(dadosLinha[0]), Double.valueOf(dadosLinha[1]),
							Double.valueOf(dadosLinha[2]), Double.valueOf(dadosLinha[3])));

				} catch (ValoresInvalidosException e) {
					System.out.println("RESULTADO : Inválido ");
				} catch (Exception e) {
					System.out.println("RESULTADO : FALHA NA EXECUÇÃO ");
				}
				System.out.println("================================================================");
				linha += 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
