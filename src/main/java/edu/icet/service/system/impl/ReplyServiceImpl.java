package edu.icet.service.system.impl;


import edu.icet.dto.Reply;
import edu.icet.entity.ReplyEntity;
import edu.icet.repository.ReplyRepository;
import edu.icet.service.system.ReplyService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private static String BAD_WORDS_FILE_PATH = "src/main/resources/text/profanity.txt";
    private  Set<String> badWords = new HashSet<>();
    private final ModelMapper mapper;
    @Autowired
    private  ReplyRepository replyRepository;

    @PostConstruct
    public void loadBadWords() {
        try (BufferedReader br = new BufferedReader(new FileReader(BAD_WORDS_FILE_PATH))) {
            badWords.addAll(br.lines()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet()));
        } catch (Exception e) {
            throw new RuntimeException("Error loading bad words from file", e);
        }
    }

    @Override
    public void addReply(Reply reply) {
//        System.out.println(containsBadWords(reply.getText()));

        if (containsBadWords(reply.getText())) {
            throw new IllegalArgumentException("This reply cannot be sent coz it contains bad words!!");
        }

        replyRepository.save(mapper.map(reply, ReplyEntity.class));
    }

    @Override
    public List<Reply> getAllReplies() {
        List<Reply> list = new ArrayList<>();

        replyRepository.findAll().forEach(replyEntity -> list.add(
                mapper.map(replyEntity, Reply.class)
        ));

        return list;
    }

    @Override
    public void updateReply(Reply reply) {

    }



    @Override
    public void deleteReplyById(Long replyId) {
        replyRepository.deleteById(replyId);
    }

    @Override
    public ReplyEntity searchReplyById(Long replyId) {
        return replyRepository.findById(replyId).orElse(null);
    }

    @Override
    public Reply searchReplyByUserId(Long userId) {
        return replyRepository.findByUserId(userId).stream().findFirst().orElse(null);
    }


    @Override
    public boolean containsBadWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if (badWords.contains(cleanedWord)) {
                return true;
            }
        }
        return false;
    }
}
