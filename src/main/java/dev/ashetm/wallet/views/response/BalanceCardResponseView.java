package dev.ashetm.wallet.views.response;

import dev.ashetm.wallet.entities.Card;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceCardResponseView implements IResponseView {

    @ApiModelProperty(
            name = "id",
            dataType = "Integer",
            readOnly = false,
            allowEmptyValue = true,
            notes = "Id card",
            position = 0,
            hidden = false,
            required = true)
    private Integer id;

    @ApiModelProperty(
            name = "balance",
            dataType = "BigDecimal",
            readOnly = false,
            allowEmptyValue = true,
            notes = "Current balance of this card",
            position = 0,
            hidden = false,
            required = true)
    private BigDecimal balance;

    public static BalanceCardResponseView from(Card card) {
        return new BalanceCardResponseView(card.getId(), card.getBalance());
    }

}
