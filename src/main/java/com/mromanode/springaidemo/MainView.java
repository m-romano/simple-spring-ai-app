package com.mromanode.springaidemo;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.ChatClient;

import java.awt.*;

@Route("")
public class MainView extends VerticalLayout {

    public MainView(ChatClient chatClient) {

        var question = new TextField();
        var ask = new Button("Ask");
        var answer = new Paragraph();

        ask.addClickListener(e -> {
            answer.setText(chatClient.call(question.getValue()));
        });

        add(
                new HorizontalLayout(question, ask),
                answer
        );
    }
}
