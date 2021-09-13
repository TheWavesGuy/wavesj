package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PrivateKeyAccount;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.Transaction;

import java.util.List;

public class TransferTransactionV3 extends TransferTransactionV2 implements TransferTransaction {

    @JsonCreator
    public TransferTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                                 @JsonProperty("recipient") String recipient,
                                 @JsonProperty("amount") long amount,
                                 @JsonProperty("address") String assetId,
                                 @JsonProperty("fee") long fee,
                                 @JsonProperty("feeAssetId") String feeAssetId,
                                 @JsonProperty("attachment") ByteString attachment,
                                 @JsonProperty("timestamp") long timestamp,
                                 @JsonProperty("proofs") List<ByteString> proofs) {
        super(senderPublicKey, recipient, amount, assetId, fee, feeAssetId, attachment, timestamp, proofs);
    }

    public TransferTransactionV3(PrivateKeyAccount senderPublicKey,
                                 String recipient,
                                 long amount,
                                 String assetId,
                                 long fee,
                                 String feeAssetId,
                                 ByteString attachment,
                                 long timestamp) {
        super(senderPublicKey, recipient, amount, assetId, fee, feeAssetId, attachment, timestamp);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
