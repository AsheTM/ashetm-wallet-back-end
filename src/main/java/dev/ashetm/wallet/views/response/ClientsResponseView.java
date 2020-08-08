package dev.ashetm.wallet.views.response;

import java.util.List;

import dev.ashetm.wallet.entities.Client;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private List<Client> clients;
	
	public static ClientsResponseView from(List<Client> clients) {
		return new ClientsResponseView(clients);
	}

}
