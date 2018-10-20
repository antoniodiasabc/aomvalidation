package hello;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerNew {

	static int posicao = 2;

	@Autowired
	private ResourceLoader resourceLoader;

	@RequestMapping("/insere")
	public Object greeting(@RequestParam(value = "nome", required = true) String nome,
			@RequestParam(value = "regra", required = false) String regra,
			@RequestParam(value = "data", required = false) String data,
			@RequestParam(value = "index", required = false) String index) {
		System.out.println("nome: " + nome + " index: " + index);
		posicao = Integer.parseInt(index);
		String regraLine = "\r\nexercicio" + posicao + ".produto.dataFabricacaoR@" + regra + "=" + data;
		String endPointLine = "nomeendpoint2" + posicao + "=exercicio" + posicao + "/" + nome;

		if (regra.startsWith("$")) { 			// formula
			endPointLine = "nomeendpoint1" + posicao + "=exercicio" + posicao + "/" + nome;
			regraLine = "\r\nexercicio" + posicao + ".produto.formula=" + regra;
			regraLine = montaFormula(regraLine, regra, data);
		}
		String resultLine = "\r\nexercicio" + posicao + ".produto.valido=1";
		System.out.println(endPointLine + " " + regraLine + " " + resultLine);
		readFile(endPointLine, regraLine, resultLine);
		return "succesfull";
	}

	private String montaFormula(String regraLine, String regra, String data) {
		String result = regraLine;
		String[] partes = regra.split(" ");
		for (int i = 1; i < partes.length; i += 2) {
			String parte = partes[i];
			if (parte.equals("pi")) {
				continue;
			}
			result += "\r\nexercicio" + posicao + ".produto." + parte + "=" + data;
		}
		return result;
	}

	private void readFile(String configName, String regraLine, String resultLine) {
		try {
			Resource fileResource = resourceLoader.getResource("classpath:application.properties");

			File file = fileResource.getFile();

			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(file, true);
				BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
				bufferFileWriter.append(configName);
				bufferFileWriter.append(regraLine);
				bufferFileWriter.append(resultLine);
				bufferFileWriter.newLine();
				bufferFileWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
