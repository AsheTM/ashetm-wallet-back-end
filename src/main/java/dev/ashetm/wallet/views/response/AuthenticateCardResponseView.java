package dev.ashetm.wallet.views.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthenticateCardResponseView implements IResponseView {
	
	private boolean authenticate;
	
	public AuthenticateCardResponseView(boolean authenticate) {
		this.authenticate = authenticate;
	}
	
	public static AuthenticateCardResponseView from(boolean authenticate) {
		return new AuthenticateCardResponseView(authenticate);
	}

}
