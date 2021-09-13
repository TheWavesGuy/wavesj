package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PrivateKeyAccount;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.Transaction;

import java.util.List;

public class IssueTransactionV3 extends IssueTransactionV2 implements IssueTransaction {
    public static final byte ISSUE = 3;

    public IssueTransactionV3(PrivateKeyAccount senderPublicKey,
                              byte chainId,
                              String name,
                              String description,
                              long quantity,
                              byte decimals,
                              boolean reissuable,
                              String script,
                              long fee,
                              long timestamp) {
        super(senderPublicKey, chainId, name, description, quantity, decimals, reissuable, script, fee, timestamp);
    }

    @JsonCreator
    public IssueTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                              @JsonProperty("chainId") byte chainId,
                              @JsonProperty("name") String name,
                              @JsonProperty("description") String description,
                              @JsonProperty("quantity") long quantity,
                              @JsonProperty("decimals") byte decimals,
                              @JsonProperty("reissuable") boolean reissuable,
                              @JsonProperty("script") String script,
                              @JsonProperty("fee") long fee,
                              @JsonProperty("timestamp") long timestamp,
                              @JsonProperty("proofs") List<ByteString> proofs) {
        super(senderPublicKey, chainId, name, description, quantity, decimals, reissuable, script, fee, timestamp, proofs);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
