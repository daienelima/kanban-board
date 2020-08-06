package com.kanban.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KanbanDTO {

    private String title;
}
