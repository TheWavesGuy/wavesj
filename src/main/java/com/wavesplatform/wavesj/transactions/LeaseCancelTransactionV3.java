package com.wavesplatform.wavesj.transactions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PrivateKeyAccount;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.Transaction;

import java.util.List;

public class LeaseCancelTransactionV3 extends LeaseCancelTransactionV2 implements LeaseCancelTransaction {
    public static final byte LEASE_CANCEL = 9;

    @JsonCreator
    public LeaseCancelTransactionV3(@JsonProperty("senderPublicKey") PublicKeyAccount senderPublicKey,
                                    @JsonProperty("chainId") byte chainId,
                                    @JsonProperty("leaseId") String leaseId,
                                    @JsonProperty("fee") long fee,
                                    @JsonProperty("timestamp") long timestamp,
                                    @JsonProperty("proofs") List<ByteString> proofs) {
        super(senderPublicKey, chainId, leaseId, fee, timestamp, proofs);
    }

    public LeaseCancelTransactionV3(PrivateKeyAccount senderPublicKey,
                                    byte chainId,
                                    String leaseId,
                                    long fee,
                                    long timestamp) {
        super(senderPublicKey, chainId, leaseId, fee, timestamp);
    }

    @Override
    public byte getVersion() {
        return Transaction.V3;
    }
}
