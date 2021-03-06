package ph.apper.purchase.data;

import lombok.Data;

@Data
public class Purchase {
    private String productId;
    private String accountId;

    public Purchase(String productId, String accountId) {
        this.productId = productId;
        this.accountId = accountId;
    }
}