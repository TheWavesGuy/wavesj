package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PrivateKeyAccount;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.Transaction;

import java.util.List;

public class LeaseTransactionV3 extends LeaseTransactionV2 implements LeaseTransaction {
    public static final byte LEASE = 8;

    public LeaseTransactionV3(PrivateKeyAccount senderPublicKey,
                              String recipient,
                              long amount,
                              long fee,
                              long timestamp) {
        super(senderPublicKey, recipient, amount, fee, timestamp);
    }

    @JsonCreator
    public LeaseTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                              @JsonProperty("recipient") String recipient,
                              @JsonProperty("amount") long amount,
                              @JsonProperty("fee") long fee,
                              @JsonProperty("timestamp") long timestamp,
                              @JsonProperty("proofs") List<ByteString> proofs) {
        super(senderPublicKey, recipient, amount, fee, timestamp, proofs);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
