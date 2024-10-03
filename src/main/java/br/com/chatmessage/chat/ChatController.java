package br.com.chatmessage.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChatController {

    private final ChatMessageSender chatMessageSender;
    private final ChatMessageReceiver chatMessageReceiver;

    public ChatController(ChatMessageSender chatMessageSender, ChatMessageReceiver chatMessageReceiver) {
        this.chatMessageSender = chatMessageSender;
        this.chatMessageReceiver = chatMessageReceiver;
    }

    @PostMapping("/send")
    public String sendMessage(String username, String message,String gender, RedirectAttributes redirect) {
        String formattedMessage = username + ": " + message;
        chatMessageSender.sendMessage(formattedMessage);
        redirect.addFlashAttribute("username", username);
        redirect.addFlashAttribute("gender", gender);
        return "redirect:/chat";
    }

    @GetMapping("/chat")
    public String getMenssage (Model model){
        var messagens =chatMessageReceiver.getMessages();
        model.addAttribute("messages", messagens);
        return "chat";
    
    }
}

