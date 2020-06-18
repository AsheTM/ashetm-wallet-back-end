package dev.ashetm.wallet.views.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ActivateCardResponseView implements IResponseView {
	
	private boolean activate;
	
	public ActivateCardResponseView(boolean activate) {
		this.activate = activate;
	}
	
	public static boolean to(ActivateCardResponseView activateCardResponseView) {
		return activateCardResponseView.isActivate();
	}
	
	public static ActivateCardResponseView from(boolean activate) {
		return new ActivateCardResponseView(activate);
	}

}
