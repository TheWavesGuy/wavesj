package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PrivateKeyAccount;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.Transaction;

import java.util.List;

public class BurnTransactionV3 extends BurnTransactionV2 implements BurnTransaction {

    public BurnTransactionV3(PrivateKeyAccount senderPublicKey,
                             byte chainId,
                             String assetId,
                             long amount,
                             long fee,
                             long timestamp) {
        super(senderPublicKey, chainId, assetId, amount, fee, timestamp);
    }

    @JsonCreator
    public BurnTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                             @JsonProperty("chainId") byte chainId,
                             @JsonProperty("assetId") String assetId,
                             @JsonProperty("amount") long amount,
                             @JsonProperty("fee") long fee,
                             @JsonProperty("timestamp") long timestamp,
                             @JsonProperty("proofs") List<ByteString> proofs) {
        super(senderPublicKey, chainId, assetId, amount, fee, timestamp, proofs);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
