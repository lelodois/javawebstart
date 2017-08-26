package br.com.lelo.clientserver.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ReverseComparator;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.lelo.clientserver.business.PublicServicesSession;
import br.com.lelo.clientserver.model.ClientServiceBean;

@Controller
public class IndexController {

	private Result result;
	private PublicServicesSession publicServices;

	public IndexController() {
	}

	@Inject
	public IndexController(Result result) {
		this.result = result;
		this.publicServices = new PublicServicesSession();
	}

	@Path("/")
	public void index() {
		result.include("services", this.getOnlineServices());
	}

	private List<ClientServiceBean> getOnlineServices() {
		List<ClientServiceBean> beans = new ArrayList<ClientServiceBean>(publicServices.getOnlineServices());
		Collections.sort(beans, new BeanComparator<ClientServiceBean>("lastDateOnline", new ReverseComparator()));
		return beans;
	}
}