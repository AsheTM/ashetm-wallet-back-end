package dev.ashetm.wallet.counter.views.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthenticateCardRequestView implements IRequestView {
	
	private String password;

}
