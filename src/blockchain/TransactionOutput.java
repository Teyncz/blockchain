package blockchain;

import blockchain.utils.StringUtil;

import java.security.PublicKey;

public class TransactionOutput {

    public String id;
    public PublicKey recipient;
    public float value;
    public String parentTransactionId;

    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.hash(StringUtil.getStringFromKey(recipient) + Float.toString(value) + parentTransactionId);
    }

    // Check if coin belongs to a publicKey
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recipient);
    }
}
