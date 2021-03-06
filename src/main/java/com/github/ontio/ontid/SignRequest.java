package com.github.ontio.ontid;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;

@JSONType(orders = {"credentialSubject", "ontId", "proof"})
public class SignRequest {
    Object credentialSubject;
    String ontId;
    Proof proof;

    public SignRequest(Object credentialSubject, String ontId, Proof proof) {
        this.credentialSubject = credentialSubject;
        this.ontId = ontId;
        this.proof = proof;
    }

    public byte[] genNeedSignData() {
        Proof proof = this.proof;
        this.proof = this.proof.genNeedSignProof();
        String jsonStr = JSON.toJSONString(this, SerializerFeature.MapSortField);
        this.proof = proof;
        return jsonStr.getBytes();
    }
}
