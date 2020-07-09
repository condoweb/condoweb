package condo.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NULLTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "index";
	}

	@Override
	public String toString() {
		return "tarefa NULLTarefa";
	}
}
