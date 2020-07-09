package condo.tarefa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import condo.tarefa.condomino.EditarDadosCondomino;
import condo.tarefa.condomino.EmitirRelatorioContaPagaEAVencer;
import condo.tarefa.condomino.EmitirRelatorioInformativoCondomino;
import condo.tarefa.condomino.ListarDadosPessoa;
import condo.tarefa.sindico.contaareceber.AtualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaTodos;
import condo.tarefa.sindico.contaareceber.AtualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaUM;
import condo.tarefa.sindico.contaareceber.CadastrarContaAReceber;
import condo.tarefa.sindico.contaareceber.EditarContaAReceber;
import condo.tarefa.sindico.contaareceber.EditarDataVencimentoContaTodos;
import condo.tarefa.sindico.contaareceber.EditarDataVencimentoContaUm;
import condo.tarefa.sindico.contaareceber.ExcluirContaAReceberPelaDataVencimento;
import condo.tarefa.sindico.contaareceber.ExcluirContaAReceberPeloID;
import condo.tarefa.sindico.contaareceber.ListarContaAReceber;
import condo.tarefa.sindico.imovel.CadastrarImovel;
import condo.tarefa.sindico.imovel.EditarImovel;
import condo.tarefa.sindico.imovel.ExcluirCondominoImovel;
import condo.tarefa.sindico.imovel.ExcluirImovel;
import condo.tarefa.sindico.imovel.ExcluirProprietarioImovel;
import condo.tarefa.sindico.imovel.InserirEditarCondominoImovel;
import condo.tarefa.sindico.imovel.InserirEditarProprietarioImovel;
import condo.tarefa.sindico.imovel.ListarImovel;
import condo.tarefa.sindico.informativo.CadastrarInformativo;
import condo.tarefa.sindico.informativo.CancelarEnvioInformativoParaTodos;
import condo.tarefa.sindico.informativo.CancelarEnvioInformativoParaUm;
import condo.tarefa.sindico.informativo.EditarInformativo;
import condo.tarefa.sindico.informativo.EnviarInformativoParaTodos;
import condo.tarefa.sindico.informativo.EnviarInformativoParaUm;
import condo.tarefa.sindico.informativo.ExcluirInformativo;
import condo.tarefa.sindico.informativo.ListarInformativo;
import condo.tarefa.sindico.pessoa.AlterarSenhaPessoa;
import condo.tarefa.sindico.pessoa.CriarPessoa;
import condo.tarefa.sindico.pessoa.EditarPessoa;
import condo.tarefa.sindico.pessoa.ExcluirPessoa;
import condo.tarefa.sindico.pessoa.ListarPessoa;
import condo.tarefa.sindico.relatorio.EmitirRelatorioContaAReceber;
import condo.tarefa.sindico.relatorio.EmitirRelatorioContaRecebidaArrecadacaoPeriodo;
import condo.tarefa.sindico.relatorio.EmitirRelatorioImovel;
import condo.tarefa.sindico.relatorio.EmitirRelatorioInformativo;
import condo.tarefa.sindico.relatorio.EmitirRelatorioPessoa;

public class FabricaDeTarefa {

	static Map<String, Tarefa> tarefas = new HashMap<String, Tarefa>();
	static {
		// Relatorio Condomino
		tarefas.put("POST/emitirrelatoriocontapagaeavencer", new EmitirRelatorioContaPagaEAVencer());
		tarefas.put("POST/emitirrelatorioinformativocondomino", new EmitirRelatorioInformativoCondomino());

		// Relatorio Sindico
		tarefas.put("POST/emitirrelatoriocontaareceber", new EmitirRelatorioContaAReceber());
		tarefas.put("POST/emitirrelatoriopessoa", new EmitirRelatorioPessoa());
		tarefas.put("POST/emitirrelatoriocontarecebidaarrecadacaoperiodo",
				new EmitirRelatorioContaRecebidaArrecadacaoPeriodo());
		tarefas.put("POST/emitirrelatorioimovel", new EmitirRelatorioImovel());
		tarefas.put("POST/emitirrelatorioinformativo", new EmitirRelatorioInformativo());

		// CRUD Informativo
		tarefas.put("POST/cadastrarinformativo", new CadastrarInformativo());
		tarefas.put("POST/editarinformativo", new EditarInformativo());
		tarefas.put("POST/excluirinformativo", new ExcluirInformativo());
		tarefas.put("POST/listarinformativo", new ListarInformativo());
		tarefas.put("POST/cancelarenvioinformativoparatodos", new CancelarEnvioInformativoParaTodos());
		tarefas.put("POST/cancelarenvioinformativoparaum", new CancelarEnvioInformativoParaUm());
		tarefas.put("POST/enviarinformativoparatodos", new EnviarInformativoParaTodos());
		tarefas.put("POST/enviarinformativoparaum", new EnviarInformativoParaUm());

		// CRUD Imovel
		tarefas.put("POST/cadastrarimovel", new CadastrarImovel());
		tarefas.put("POST/editarimovel", new EditarImovel());
		tarefas.put("POST/excluirimovel", new ExcluirImovel());
		tarefas.put("POST/listarimovel", new ListarImovel());
		tarefas.put("POST/excluirproprietarioimovel", new ExcluirProprietarioImovel());
		tarefas.put("POST/excluircondominoimovel", new ExcluirCondominoImovel());
		tarefas.put("POST/inserireditarproprietarioimovel", new InserirEditarProprietarioImovel());
		tarefas.put("POST/inserireditarcondominoimovel", new InserirEditarCondominoImovel());

		// CRUD Contas a receber
		tarefas.put("POST/cadastrarcontaareceber", new CadastrarContaAReceber());
		tarefas.put("POST/editarcontaareceber", new EditarContaAReceber());
		tarefas.put("POST/editardatavencimentocontatodos", new EditarDataVencimentoContaTodos());
		tarefas.put("POST/editardatavencimentocontaum", new EditarDataVencimentoContaUm());
		tarefas.put("POST/excluircontaareceberpeloid", new ExcluirContaAReceberPeloID());
		tarefas.put("POST/excluircontaareceberpeladatavencimento", new ExcluirContaAReceberPelaDataVencimento());
		tarefas.put("POST/atualizardatapagamentovalorpagodatareferenciacontaareceberparatodos",
				new AtualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaTodos());
		tarefas.put("POST/atualizardatapagamentovalorpagodatareferenciacontaareceberparaum",
				new AtualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaUM());
		tarefas.put("POST/listarcontaareceber", new ListarContaAReceber());

		// CRUD Pessoa
		tarefas.put("POST/criarpessoa", new CriarPessoa());
		tarefas.put("POST/editarpessoa", new EditarPessoa());
		tarefas.put("POST/excluirpessoa", new ExcluirPessoa());
		tarefas.put("POST/listarpessoa", new ListarPessoa());
		tarefas.put("POST/alterarsenhapessoa", new AlterarSenhaPessoa());

		// LOGIN - MenuSindico/MenuCondomino
		tarefas.put("POST/loginpessoa", new LoginPessoa());
		// LOGOUT
		tarefas.put("GET/logoutpessoa", new LogoutPessoa());

		// RU - Condomino
		tarefas.put("POST/editardadoscondomino", new EditarDadosCondomino());
		tarefas.put("POST/listardadoscondomino", new ListarDadosPessoa());
	}

	public static Tarefa getTarefa(HttpServletRequest request) {
		Tarefa tarefa = tarefas.get(request.getMethod() + request.getPathInfo());
		return (tarefa != null) ? tarefa : new NULLTarefa();

		/*
		 * if (tarefa != null) return tarefa; else return new NULLTarefa();
		 */
	}
}
