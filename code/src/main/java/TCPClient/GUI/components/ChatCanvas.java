package TCPClient.GUI.components;

import TCPClient.GUI.tasks.MessageInboxTask;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;

public class ChatCanvas extends VBox {

    private TextArea chat;

    public ChatCanvas() {
        chat = new TextArea("");
        chat.getStyleClass().add("chat");
        chat.setEditable(false);
        this.getStyleClass().add("chat-canvas");

        MessageInboxTask messageInboxTask = new MessageInboxTask();
        chat.textProperty().bind(messageInboxTask.messageProperty());

        Thread th = new Thread(messageInboxTask);
        th.setDaemon(true);
        th.start();

        this.getChildren().add(chat);
    }

    public String getChat() {
        return ((TextArea) this.getChildren().get(0)).getText();
    }
}
