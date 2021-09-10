package com.wavesplatform.wavesj;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class LeaseInfo implements Serializable {

    private final String id;
    private final String originTransactionId;
    private final String sender;
    private final String recipient;
    private final long amount;
    private final int height;
    private final String status;
    private final int cancelHeight;
    private final String cancelTransactionId;

    @JsonCreator
    public LeaseInfo(@JsonProperty("id") String id, @JsonProperty("originTransactionId") String originTransactionId,
                     @JsonProperty("address") String address, @JsonProperty("recipient") String recipient,
                     @JsonProperty("amount") long amount, @JsonProperty("height") int height,
                     @JsonProperty("status") String status, @JsonProperty("cancelHeight") int cancelHeight,
                     @JsonProperty("cancelTransactionId") String cancelTransactionId) {
        this.id = id;
        this.originTransactionId = originTransactionId;
        this.sender = address;
        this.recipient = recipient;
        this.amount = amount;
        this.height = height;
        this.status = status;
        this.cancelHeight = cancelHeight;
        this.cancelTransactionId = cancelTransactionId;
    }

    public LeaseInfo(String id, String originTransactionId, String address, String recipient, long amount, int height,
                     String status, int cancelHeight, String cancelTransactionId, Object unused) {
        this.id = id;
        this.originTransactionId = originTransactionId;
        this.sender = address;
        this.recipient = recipient;
        this.amount = amount;
        this.height = height;
        this.status = status;
        this.cancelHeight = cancelHeight;
        this.cancelTransactionId = cancelTransactionId;
    }

    public String getId() {
        return id;
    }

    public String getOriginTransactionId() {
        return originTransactionId;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public long getAmount() {
        return amount;
    }

    public int getHeight() {
        return height;
    }

    public String status() {
        return status;
    }

    public int getCancelHeight() {
        return cancelHeight;
    }

    public String getCancelTransactionId() {
        return cancelTransactionId;
    }

    @Override
    public String toString() {
        return "LeaseInfo{" +
                "id='" + id + '\'' +
                ", originTransactionId='" + originTransactionId + '\'' +
                ", address='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount=" + amount +
                ", height=" + height +
                ", status='" + status + '\'' +
                ", cancelHeight=" + cancelHeight +
                ", cancelTransactionId='" + cancelTransactionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaseInfo leaseInfo = (LeaseInfo) o;

        if (amount != leaseInfo.amount) return false;
        if (height != leaseInfo.height) return false;
        if (cancelHeight != leaseInfo.cancelHeight) return false;
        if (id != null ? !id.equals(leaseInfo.id) : leaseInfo.id != null) return false;
        if (originTransactionId != null ? !originTransactionId.equals(leaseInfo.originTransactionId) : leaseInfo.originTransactionId != null)
            return false;
        if (sender != null ? !sender.equals(leaseInfo.sender) : leaseInfo.sender != null) return false;
        if (recipient != null ? !recipient.equals(leaseInfo.recipient) : leaseInfo.recipient != null) return false;
        if (status != null ? !status.equals(leaseInfo.status) : leaseInfo.status != null) return false;
        return cancelTransactionId != null ? cancelTransactionId.equals(leaseInfo.cancelTransactionId) : leaseInfo.cancelTransactionId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (originTransactionId != null ? originTransactionId.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + height;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + cancelHeight;
        result = 31 * result + (cancelTransactionId != null ? cancelTransactionId.hashCode() : 0);
        return result;
    }
}
