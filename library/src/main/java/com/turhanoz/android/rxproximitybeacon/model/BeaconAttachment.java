package com.turhanoz.android.rxproximitybeacon.model;

import com.turhanoz.android.rxproximitybeacon.util.EncodeUtils;

public class BeaconAttachment {
    String attachmentName;
    String namespacedType;
    String data; //encodedData;

    public BeaconAttachment(String attachmentName, String namespacedType, String base64EncodedData) {
        this.attachmentName = attachmentName;
        this.namespacedType = namespacedType;
        this.data = base64EncodedData;
    }

    public String getDecodedData() {
        return new String(EncodeUtils.base64Decode(this.data));
    }

    public String getSanitizedAttachmentName(){
        if(attachmentName.contains("/")){
            String[] parts = attachmentName.split("/");
            if(parts.length>2)
            return parts[3];
        }
        return attachmentName;
    }

    @Override
    public String toString() {
        return "BeaconAttachments{" +
                "attachmentName='" + attachmentName + '\'' +
                ", namespacedType='" + namespacedType + '\'' +
                ", data='" + getDecodedData() + '\'' +
                '}';
    }
}
