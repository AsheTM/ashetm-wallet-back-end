package dev.ashetm.wallet.views;

import java.util.List;

import dev.ashetm.wallet.entities.Client;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ClientsResponseView implements ResponseView {

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
