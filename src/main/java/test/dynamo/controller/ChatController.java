package test.dynamo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.dynamo.repository.ChatRepository;
import test.dynamo.entity.Chat;
import test.dynamo.util.ULID;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRepository chatRepository;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Chat chat) {

        String ULID = new ULID().nextULID();
        chat.setMessageId(ULID);
        chat.setTimestamp(String.valueOf(System.currentTimeMillis()));

        chatRepository.save(chat);
        return ResponseEntity.ok("chat log saved successfully");
    }

    @GetMapping("/{roomId}/{messageId}")
    public ResponseEntity<Chat> getChat(@PathVariable String roomId, @PathVariable String messageId) {
        Optional<Chat> chat = chatRepository.findChatByRoomIdAndMessageId(roomId, messageId);
        return chat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<List<Chat>> getChats(@PathVariable String roomId) {
        List<Chat> chats = chatRepository.findByRoomId(roomId);
        return ResponseEntity.ok(chats);
    }
}
