package edu.icet.service.customer.impl;

import edu.icet.dto.event.Agenda;
import edu.icet.dto.event.AgendaTask;
import edu.icet.entity.event.AgendaEntity;
import edu.icet.entity.event.AgendaTaskEntity;
import edu.icet.entity.event.EventEntity;
import edu.icet.repository.event.AgendaRepository;
import edu.icet.repository.event.AgendaTaskRepository;
import edu.icet.repository.event.EventRepository;
import edu.icet.service.customer.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final AgendaTaskRepository agendaTaskRepository;
    private final EventRepository eventRepository;

    @Override
    @Transactional
    public boolean create(Agenda agenda) {
        AgendaEntity entity = new AgendaEntity();
        EventEntity event = eventRepository.findById(agenda.getEventId()).orElse(null);

        if (event == null) return false;

        entity.setEvent(event);

        entity.setDate(agenda.getDate());
        entity.setTime(agenda.getTime());
        AgendaEntity savedEntity = agendaRepository.save(entity);
        return savedEntity.getId() != null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Agenda> getAll() {
        return agendaRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean update(Agenda agenda) {
        AgendaEntity existing = agendaRepository.findById(agenda.getId()).orElse(null);
        if (existing == null) return false;

        EventEntity event = eventRepository.findById(agenda.getEventId()).orElse(null);

        if (event == null) return false;

        existing.setEvent(event);
        existing.setDate(agenda.getDate());
        existing.setTime(agenda.getTime());
        agendaRepository.save(existing);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        if (!agendaRepository.existsById(id)) return false;
        agendaRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Agenda getById(Integer id) {
        return agendaRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    @Override
    @Transactional
    public boolean addTaskToAgenda(Integer agendaId, AgendaTask newTask) {
        Optional<AgendaEntity> optionalAgenda = agendaRepository.findById(agendaId);
        if (optionalAgenda.isEmpty()) return false;

        AgendaEntity agenda = optionalAgenda.get();
        AgendaTaskEntity taskEntity = new AgendaTaskEntity();
        taskEntity.setTaskName(newTask.getTaskName());
        taskEntity.setStartTime(newTask.getStartTime());
        taskEntity.setEndTime(newTask.getEndTime());
        taskEntity.setSupplierId(newTask.getSupplierId());
        taskEntity.setSupplierType(newTask.getSupplierType());

        taskEntity.setAgenda(agenda);
        agenda.getTasks().add(taskEntity);

        agendaRepository.save(agenda);
        return true;
    }

    @Override
    @Transactional
    public boolean updateTask(Integer agendaId, Integer taskId, AgendaTask updatedTask) {
        AgendaTaskEntity task = agendaTaskRepository.findByAgendaIdAndTaskId(agendaId, taskId);
        if (task == null) return false;

        task.setTaskName(updatedTask.getTaskName());
        task.setStartTime(updatedTask.getStartTime());
        task.setEndTime(updatedTask.getEndTime());
        task.setSupplierId(updatedTask.getSupplierId());
        task.setSupplierType(updatedTask.getSupplierType());
        agendaTaskRepository.save(task);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTask(Integer agendaId, Integer taskId) {
        AgendaTaskEntity task = agendaTaskRepository.findByAgendaIdAndTaskId(agendaId, taskId);
        if (task == null) return false;

        agendaTaskRepository.delete(task);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public AgendaTask getTaskById(Integer agendaId, Integer taskId) {
        return Optional.ofNullable(agendaTaskRepository.findByAgendaIdAndTaskId(agendaId, taskId))
                .map(this::convertTaskToDto)
                .orElse(null);
    }

    private Agenda convertToDto(AgendaEntity entity) {
        Agenda dto = new Agenda();
        dto.setId(entity.getId());
        dto.setEventId(entity.getEvent().getEventId());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setTasks(entity.getTasks().stream()
                .map(this::convertTaskToDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private AgendaTask convertTaskToDto(AgendaTaskEntity entity) {
        AgendaTask dto = new AgendaTask();
        dto.setTaskId(entity.getTaskId());
        dto.setTaskName(entity.getTaskName());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setSupplierId(entity.getSupplierId());
        dto.setSupplierType(entity.getSupplierType());
        return dto;
    }
}