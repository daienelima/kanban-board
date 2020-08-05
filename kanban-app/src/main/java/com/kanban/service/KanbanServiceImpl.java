package com.kanban.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kanban.model.Kanban;
import com.kanban.model.KanbanDTO;
import com.kanban.model.Task;
import com.kanban.model.TaskDTO;
import com.kanban.repository.KanbanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KanbanServiceImpl implements KanbanService {

	@Autowired
    KanbanRepository kanbanRepository;

    @Override
    @Transactional
    public List<Kanban> getAllKanbanBoards() {
        List<Kanban> kanbanList = new ArrayList<>();
        kanbanRepository.findAll().forEach(kanbanList::add);
        return kanbanList;
    }

    @Override
    @Transactional
    public Optional<Kanban> getKanbanById(Long id) {
        return kanbanRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Kanban> getKanbanByTitle(String title) {
        return kanbanRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public Kanban saveNewKanban(KanbanDTO kanbanDTO) {
        return kanbanRepository.save(convertDTOToKanban(kanbanDTO));
    }

    @Override
    @Transactional
    public Kanban updateKanban(Kanban oldKanban, KanbanDTO newKanbanDTO) {
        oldKanban.setTitle(newKanbanDTO.getTitle());
        return kanbanRepository.save(oldKanban);
    }

    @Override
    @Transactional
    public void deleteKanban(Kanban kanban) {
        kanbanRepository.delete(kanban);
    }

    @Override
    @Transactional
    public Kanban addNewTaskToKanban(Long kanbanId, TaskDTO taskDTO) {
        Kanban kanban = kanbanRepository.findById(kanbanId).get();
        kanban.addTask(convertDTOToTask(taskDTO));
        return kanbanRepository.save(kanban);
    }

    private Kanban convertDTOToKanban(KanbanDTO kanbanDTO){
        Kanban kanban = new Kanban();
        kanban.setTitle(kanbanDTO.getTitle());
        return kanban;
    }

    private Task convertDTOToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setColor(taskDTO.getColor());
        task.setStatus(taskDTO.getStatus());
        return task;
    }
}
