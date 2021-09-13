package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.*;

import java.util.List;

public class AliasTransactionV3 extends AliasTransactionV2 implements AliasTransaction {

    public AliasTransactionV3(PrivateKeyAccount senderPublicKey,
                              Alias alias,
                              long fee,
                              long timestamp) {
        super(senderPublicKey, alias, fee, timestamp);
    }

    @JsonCreator
    public AliasTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                              @JsonProperty("alias") Alias alias,
                              @JsonProperty("fee") long fee,
                              @JsonProperty("timestamp") long timestamp,
                              @JsonProperty("proofs") List<ByteString> proofs
    ) {
        super(senderPublicKey, alias, fee, timestamp, proofs);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
