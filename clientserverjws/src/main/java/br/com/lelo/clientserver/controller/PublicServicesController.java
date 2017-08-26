package br.com.lelo.clientserver.controller;

import static br.com.lelo.clientserver.business.FilaImpressaoBusiness.consumir;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lelo.clientserver.business.PublicServicesSession;
import br.com.lelo.clientserver.model.ClientServiceBean;
import br.com.lelo.clientserver.model.FilaImpressaoItem;

@Controller
@Path("/services")
public class PublicServicesController {

	private Result result;
	private PublicServicesSession servicesSession;

	@Inject
	public PublicServicesController(Result result) {
		this.result = result;
		this.servicesSession = new PublicServicesSession();
	}

	public PublicServicesController() {
	}

	@Get
	@Path(value = "/fila-impressao/{nome}/version/{version}")
	public void consumirFilaImpressao(String nome, String version) {
		FilaImpressaoItem filaItem = consumir(this.getClientServiceBean(nome, version));
		if (filaItem == null) {
			result.use(Results.json()).from("Sem itens na fila");
		} else
			result.use(Results.json()).from(filaItem, "fila-impressao").serialize();
	}

	private ClientServiceBean getClientServiceBean(String nome, String version) {
		ClientServiceBean bean = servicesSession.updateExistsClient(nome);
		if (bean == null) {
			bean = new ClientServiceBean(nome);
			servicesSession.getOnlineServices().add(bean);
		}
		bean.setVersion(version);
		return bean;
	}

}
