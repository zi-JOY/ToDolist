import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TodoListGUI extends JFrame {
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskInput;
    private JButton addButton;
    private JButton deleteButton;

    public TodoListGUI() {
        super("To-Do List");

        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        taskInput = new JTextField(20);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");

        setLayout(new FlowLayout());

        add(new JLabel("Task: "));
        add(taskInput);
        add(addButton);
        add(deleteButton);
        add(new JScrollPane(todoList));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    todoListModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    todoListModel.remove(selectedIndex);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoListGUI();
            }
        });
    }
}
