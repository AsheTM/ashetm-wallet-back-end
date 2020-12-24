package dev.ashetm.wallet.counter.views.responses;

import java.util.List;

import dev.ashetm.wallet.counter.models.Client;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ClientsResponseView implements IResponseView {

	@ApiModelProperty(
			name = "clients", 
			dataType = "Client[]", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "List of Client object to send to front", 
			position = 0, 
			hidden = false, 
			required = true)
	@Setter
	private List<Client> clients;

	public ClientsResponseView(List<Client> clients) {
		super();
		this.clients = clients;
	}
	
	public static List<Client> to(ClientsResponseView clientsResponseView) {
		return clientsResponseView.getClients();
	}
	
	public static ClientsResponseView from(List<Client> clients) {
		return new ClientsResponseView(clients);
	}

}
