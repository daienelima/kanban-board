package com.kanban.service;

import java.util.List;
import java.util.Optional;

import com.kanban.model.Kanban;
import com.kanban.model.KanbanDTO;
import com.kanban.model.TaskDTO;

public interface KanbanService {

    List<Kanban> getAllKanbanBoards();

    Optional<Kanban> getKanbanById(Long id);

    Optional<Kanban> getKanbanByTitle(String title);

    Kanban saveNewKanban(KanbanDTO kanbanDTO);

    Kanban updateKanban(Kanban oldKanban, KanbanDTO newKanbanDTO);

    void deleteKanban(Kanban kanban);

    Kanban addNewTaskToKanban(Long kanbanId, TaskDTO taskDTO);
}
