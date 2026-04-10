package com.pd.CacheDemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonSerialize
public class Item {

    @JsonProperty
    private int id;

    public Item(int i) {
        this.id = i;
    }
}
