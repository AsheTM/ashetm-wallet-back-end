package dev.ashetm.wallet.views.response;

import dev.ashetm.wallet.entities.Client;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ClientResponseView implements IResponseView {

	@ApiModelProperty(
			name = "client", 
			dataType = "Client", 
			readOnly = false, 
			allowEmptyValue = true, 
			notes = "Client object to send to front", 
			position = 0, 
			hidden = false, 
			required = true)
	@Setter
	private Client client;

	public ClientResponseView(Client client) {
		super();
		this.client = client;
	}

	public static Client to(ClientResponseView clientResponseView) {
		return clientResponseView.getClient();
	}
	
	public static ClientResponseView from(Client client) {
		return new ClientResponseView(client);
	}

}
