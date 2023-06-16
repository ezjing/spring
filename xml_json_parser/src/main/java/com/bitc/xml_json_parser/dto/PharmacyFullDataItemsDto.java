package com.bitc.xml_json_parser.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class PharmacyFullDataItemsDto {
    private List<PharmacyFullDataItemDto> itemList;

    @XmlElement(name = "item")
    public List<PharmacyFullDataItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<PharmacyFullDataItemDto> itemList) {
        this.itemList = itemList;
    }
}
