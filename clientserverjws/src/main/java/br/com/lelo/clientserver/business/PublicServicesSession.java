package br.com.lelo.clientserver.business;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.lelo.clientserver.model.ClientServiceBean;

public class PublicServicesSession {

	private static final String CLIENT_SERVICES = "client-services";

	private static Map<String, Object> session = new HashMap<String, Object>();

	public Set<ClientServiceBean> getOnlineServices() {
		Set<ClientServiceBean> beans = this.getClientsServicesInSession();
		if (beans == null) {
			beans = this.setClientServicesInSession(new HashSet<ClientServiceBean>());
		}
		return beans;
	}

	public Set<ClientServiceBean> setClientServicesInSession(Set<ClientServiceBean> beans) {
		session.put(CLIENT_SERVICES, beans);
		return beans;
	}

	public ClientServiceBean updateExistsClient(String nome) {
		ClientServiceBean bean = null;
		for (ClientServiceBean clientIndex : this.getOnlineServices()) {
			if (clientIndex.getNome().equals(nome)) {
				bean = clientIndex.setLastDateOnline(new Date());
			}
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	private Set<ClientServiceBean> getClientsServicesInSession() {
		Object services = session.get(CLIENT_SERVICES);
		if (services != null) {
			return (Set<ClientServiceBean>) services;
		}
		return null;
	}

}
