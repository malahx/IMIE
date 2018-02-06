package fr.imie.malah.designpattern.controller;

import fr.imie.malah.designpattern.utils.ViewUtils;
import fr.imie.malah.designpattern.view.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static volatile Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            synchronized (Controller.class) {
                if (instance == null) {
                    instance = new Controller();
                }
            }
        }
        return instance;
    }

    private int position;
    private List<View> history;
    private final JFrame frame;
    private HelloWorldView helloWorldView;
    private ButtonWorldView buttonWorldView;
    private EmptyWorldView emptyWorldView;

    private boolean hasNext() {
        return position < history.size() - 1;
    }

    private Controller() {
        frame = new JFrame();
        history = new ArrayList<>();
        position = -1;
        initView();
    }

    private void initView() {
        buttonWorldView = new ButtonWorldView();
        helloWorldView = new HelloWorldView();
        emptyWorldView = new EmptyWorldView();
        initBtn();
    }

    private void initBtn() {
        buttonWorldView.getBtnExit().addActionListener(e -> frame.dispose());
        buttonWorldView.getBtnHelloWorld().addActionListener(e -> nextView(helloWorldView));
        buttonWorldView.getBtnEmptyWorld().addActionListener(e -> nextView(emptyWorldView));
        buttonWorldView.getBtnNext().addActionListener(e -> nextView());
        helloWorldView.getBtnReturn().addActionListener(e -> backView());
        helloWorldView.getBtnEmptyWorld().addActionListener(e -> nextView(emptyWorldView));
        helloWorldView.getBtnNext().addActionListener(e -> nextView());
        emptyWorldView.getBtnReturn().addActionListener(e -> backView());
    }

    public void run() {
        ViewUtils.configure(frame);
        nextView(buttonWorldView);
    }

    private void nextView(View view) {
        goTo(view);
        if (position == 0) {
            history = new ArrayList<>();
            history.add(buttonWorldView);
        }
        history.add(view);
        position++;
    }

    private void nextView() {
        if (!hasNext()) {
            return;
        }
        goTo(history.get(++position));
    }

    private void goTo(View view) {
        if (view instanceof NextView) {
            ((NextView) view).getBtnNext().setEnabled(hasNext());
        }
        frame.setContentPane(view.getPanel());
        frame.revalidate();
        frame.repaint();
    }

    private void backView() {
        if (history.size() < 1 || position <= 0) {
            throw new RuntimeException("can't backview");
        }
        goTo(history.get(--position));
    }
}
