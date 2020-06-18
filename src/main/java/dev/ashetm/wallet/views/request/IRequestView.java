package dev.ashetm.wallet.views.request;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
		description = "Request that contain request body")
public interface IRequestView {
	
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
