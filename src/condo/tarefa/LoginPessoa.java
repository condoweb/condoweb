package condo.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.PessoaSimp;

public class LoginPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nomeUsuarioEmail = request.getParameter("usuarioemail");
		String senha = request.getParameter("senha");
		PessoaSimp usuario = new SindicoDAO().buscarPessoa(nomeUsuarioEmail, senha);
		if (usuario != null && usuario.getStatus()) {
			request.setAttribute("usuario", usuario);
			request.getSession().setAttribute("usuario", usuario.getNome());
			if (usuario.getPerfil().equals("Condomino")) {
				return "menucondomino";
			} else if (usuario.getPerfil().equals("Sindico")) {
				return "menusindico";
			} else {
				return "index";
			}
		} else if (usuario != null && usuario.getStatus() == false) {
			request.setAttribute("erro", "Usuário desativado, informe ao Síndico e tente novamente.");
			return "index";
		} else {
			request.setAttribute("erro", "Nome de Usuário/Email ou senha inválidos. Tente novamente.");
			return "index";
		}
	}
	
	@Override
	public String toString() {
		return "Tarefa Login";
	}
}
