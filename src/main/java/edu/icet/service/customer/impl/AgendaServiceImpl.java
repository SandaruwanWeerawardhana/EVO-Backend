package edu.icet.service.customer.impl;

import edu.icet.dto.Agenda;
import edu.icet.dto.AgendaTask;
import edu.icet.entity.AgendaEntity;
import edu.icet.entity.AgendaTaskEntity;
import edu.icet.repository.AgendaRepository;
import edu.icet.repository.AgendaTaskRepository;
import edu.icet.service.customer.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final AgendaTaskRepository agendaTaskRepository;


    @Override
    public boolean create(Agenda agendaDto) {
        try {

            AgendaEntity agendaEntity = new AgendaEntity();
            agendaEntity.setDate(agendaDto.getDate());
            agendaEntity.setTime(agendaDto.getTime());
            AgendaEntity savedAgenda = agendaRepository.save(agendaEntity);

            List<AgendaTaskEntity> tasks = agendaDto.getTasks().stream()
                    .map(taskDto -> {
                        AgendaTaskEntity taskEntity = new AgendaTaskEntity();
                        taskEntity.setTaskName(taskDto.getTaskName());
                        taskEntity.setAgenda(savedAgenda);
                        return taskEntity;
                    })
                    .collect(Collectors.toList());

            agendaTaskRepository.saveAll(tasks);
            return true;

        } catch (Exception e) {
            System.err.println("Error creating agenda: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Agenda> getAll() {
        List<AgendaEntity> agendaEntities = agendaRepository.findAll();

        return agendaEntities.stream()
                .map(agendaEntity -> {
                    Agenda agendaDto = new Agenda();
                    agendaDto.setId(agendaEntity.getId());
                    agendaDto.setDate(agendaEntity.getDate());
                    agendaDto.setTime(agendaEntity.getTime());


                    List<AgendaTask> tasks = agendaEntity.getTasks().stream()
                            .map(taskEntity -> new AgendaTask(
                                    taskEntity.getTaskId(),
                                    taskEntity.getTaskName()
                            ))
                            .collect(Collectors.toList());

                    agendaDto.setTasks(tasks);
                    return agendaDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean update(Agenda agendaDto) {
        try {
            Optional<AgendaEntity> optionalEntity = agendaRepository.findById(agendaDto.getId());
            if (optionalEntity.isPresent()) {
                AgendaEntity entity = optionalEntity.get();
                entity.setDate(agendaDto.getDate());
                entity.setTime(agendaDto.getTime());

                agendaTaskRepository.deleteAll(entity.getTasks());

                List<AgendaTaskEntity> newTasks = agendaDto.getTasks().stream()
                        .map(taskDto -> {
                            AgendaTaskEntity taskEntity = new AgendaTaskEntity();
                            taskEntity.setTaskName(taskDto.getTaskName());
                            taskEntity.setAgenda(entity);
                            return taskEntity;
                        })
                        .collect(Collectors.toList());

                agendaTaskRepository.saveAll(newTasks);
                agendaRepository.save(entity);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Update Agenda Failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            if (agendaRepository.existsById(id)) {
                agendaRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Delete Agenda Failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Agenda getById(Integer id) {
        try {
            Optional<AgendaEntity> optionalEntity = agendaRepository.findById(id);
            return optionalEntity.map(entity -> {
                Agenda agendaDto = new Agenda();
                agendaDto.setId(entity.getId());
                agendaDto.setDate(entity.getDate());
                agendaDto.setTime(entity.getTime());

                List<AgendaTask> tasks = entity.getTasks().stream()
                        .map(taskEntity -> new AgendaTask(
                                taskEntity.getTaskId(),
                                taskEntity.getTaskName()
                        ))
                        .collect(Collectors.toList());

                agendaDto.setTasks(tasks);
                return agendaDto;
            }).orElse(null);
        } catch (Exception e) {
            System.err.println("Retrieve Agenda By ID Failed: " + e.getMessage());
            return null;
        }
    }
}