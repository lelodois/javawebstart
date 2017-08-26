package br.com.lelo.clientserver.business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.moznion.random.string.RandomStringGenerator;
import br.com.lelo.clientserver.model.ClientServiceBean;
import br.com.lelo.clientserver.model.FilaImpressaoItem;

public class FilaImpressaoBusiness {

	private static Map<String, FilaImpressaoItem> itens = new HashMap<String, FilaImpressaoItem>();
	private static Set<String> clientsOnline = new HashSet<String>();

	static {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					gerarItensAleatoriamente();
					try {
						Thread.sleep(1000 * 5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private FilaImpressaoBusiness() {
	}

	public static FilaImpressaoItem consumir(ClientServiceBean bean) {
		String clientFilaId = bean.getNome();
		clientsOnline.add(clientFilaId);
		if (itens.containsKey(clientFilaId)) {
			FilaImpressaoItem item = itens.remove(clientFilaId);
			bean.getClientImpressao().adicionarImpressao(item);
			return item;
		}
		return null;
	}

	private static void gerarItensAleatoriamente() {
		for (String clientFila : clientsOnline) {
			if (itens.containsKey(clientFila) == false) {
				RandomStringGenerator generator = new RandomStringGenerator();
				String text = generator.generateFromPattern("cCn!.sb");
				itens.put(clientFila, new FilaImpressaoItem(text, clientFila + "-" + itens.size(), clientFila));
			}
		}
	}
}
