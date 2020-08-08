package dev.ashetm.wallet.views.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateCardRequestView implements IRequestView {

	private String password;

}
