package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PrivateKeyAccount;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.Transaction;

import java.util.List;

public class ReissueTransactionV3 extends ReissueTransactionV2 implements ReissueTransaction {
    public static final byte REISSUE = 5;

    @JsonCreator
    public ReissueTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                                @JsonProperty("chainId") byte chainId,
                                @JsonProperty("address") String assetId,
                                @JsonProperty("quantity") long quantity,
                                @JsonProperty("reissuable") boolean reissuable,
                                @JsonProperty("fee") long fee,
                                @JsonProperty("timestamp") long timestamp,
                                @JsonProperty("proofs") List<ByteString> proofs) {
        super(senderPublicKey, chainId, assetId, quantity, reissuable, fee, timestamp, proofs);
    }

    public ReissueTransactionV3(PrivateKeyAccount senderPublicKey,
                                byte chainId,
                                String assetId,
                                long quantity,
                                boolean reissuable,
                                long fee,
                                long timestamp) {
        super(senderPublicKey, chainId, assetId, quantity, reissuable, fee, timestamp);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
