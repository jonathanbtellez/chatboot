package com.coding.chatbot.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Model {
    public String id;
    public String owned_by;
    public boolean active;
}
