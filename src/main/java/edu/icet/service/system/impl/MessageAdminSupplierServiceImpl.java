package edu.icet.service.system.impl;

import edu.icet.dto.system.MessageAdminSupplier;
import edu.icet.entity.system.MessageAdminSupplierEntity;
import edu.icet.repository.system.MessageAdminSupplierRepository;
import edu.icet.service.system.MessageAdminSupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageAdminSupplierServiceImpl implements MessageAdminSupplierService {
    private final MessageAdminSupplierRepository messageAdminSupplierRepository;
    private final ModelMapper mapper;


    @Override
    public MessageAdminSupplier sendMessage(MessageAdminSupplier dto) {
        // Always set sendTime server-side
        dto.setSendTime(Instant.now());

        MessageAdminSupplierEntity entity = mapper.map(dto, MessageAdminSupplierEntity.class);
        MessageAdminSupplierEntity savedEntity = messageAdminSupplierRepository.save(entity);
        return mapper.map(savedEntity, MessageAdminSupplier.class);
    }

    @Override
    public boolean deleteMessage(Long mid) {
        if (messageAdminSupplierRepository.existsById(mid)) {
            messageAdminSupplierRepository.deleteById(mid);
            return true;
        }
        return false;

    }



    @Override
    public MessageAdminSupplier getMessageById(Long mid) {
        return mapper.map(messageAdminSupplierRepository.findById(mid).orElse(null), MessageAdminSupplier.class);

    }


    @Override
    public List<MessageAdminSupplier> getMessagesBySupplierId(Long supplierId) {
        ArrayList<MessageAdminSupplier> list = new ArrayList<>();
        messageAdminSupplierRepository.findBySupplierId(supplierId).forEach(messageAdminSupplierEntity -> list.add(mapper.map(messageAdminSupplierEntity, MessageAdminSupplier.class)));
        return list;

    }

    @Override
    public List<MessageAdminSupplier> getMessagesByIds(Long adminId, Long supplierId) {
        return messageAdminSupplierRepository.findByAdminIdAndSupplierId(adminId, supplierId)
                .stream()
                .map((MessageAdminSupplierEntity entity) -> mapper.map(entity, MessageAdminSupplier.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<MessageAdminSupplier> getMessagesByAdminId(Long adminId) {
        ArrayList<MessageAdminSupplier> list = new ArrayList<>();
        messageAdminSupplierRepository.findByAdminId(adminId).forEach(messageAdminSupplierEntity -> list.add(mapper.map(messageAdminSupplierEntity, MessageAdminSupplier.class)));
        return list;

    }

//No Usage
    @Override
    public MessageAdminSupplier searchMessage(Long mid) {
        return mapper.map(messageAdminSupplierRepository.findById(mid).orElse(null), MessageAdminSupplier.class);

    }

    @Override
    public List<MessageAdminSupplier> getAllMessages() {
        ArrayList<MessageAdminSupplier> list = new ArrayList<>();
        messageAdminSupplierRepository.findAll().forEach(messageAdminSupplierEntity -> list.add(mapper.map(messageAdminSupplierEntity, MessageAdminSupplier.class)));
        return list;

    }
}
