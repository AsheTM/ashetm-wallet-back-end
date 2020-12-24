package dev.ashetm.wallet.counter.views.responses;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
		description = "Response that contain response body")
public interface IResponseView {
	
	@ApiModelProperty(
			name = "now", 
			dataType = "LocalDate", 
			readOnly = true, 
			allowEmptyValue = false, 
			notes = "Date when the object was created", 
			position = 1, 
			hidden = false, 
			required = true)
	LocalDate now = LocalDate.now();
	
}
