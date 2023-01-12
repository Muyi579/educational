package ui;

import entity.TeacherEntity;
import service.StudentService;
import service.StudentServiceImpl;
import service.TeacherService;
import service.TeacherServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class LoginJFrame {

    private JFrame frame;
    private JTextField textField_urse;
    private JPasswordField passwordField_pw;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginJFrame window = new LoginJFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LoginJFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("登录");
        frame.getContentPane().setBackground(new Color(176, 196, 222));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        // 窗口显示在页面中间
        frame.setLocationRelativeTo(null);
        // 窗口不允许调整大小
        frame.setResizable(false);

        JLabel label = new JLabel("账户：");
        label.setBackground(Color.GREEN);
        label.setBounds(73, 52, 68, 43);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("密码：");
        label_1.setBackground(Color.GREEN);
        label_1.setBounds(74, 96, 59, 50);
        frame.getContentPane().add(label_1);

        textField_urse = new JTextField();
        textField_urse.setBounds(155, 61, 155, 24);
        frame.getContentPane().add(textField_urse);
        textField_urse.setColumns(10);

        passwordField_pw = new JPasswordField();
        passwordField_pw.setBounds(155, 109, 155, 24);
        frame.getContentPane().add(passwordField_pw);
        JRadioButton radioButton_student = new JRadioButton("学生");
        radioButton_student.setSelected(true);
        buttonGroup.add(radioButton_student);
        radioButton_student.setBackground(new Color(176, 196, 222));
        radioButton_student.setBounds(73, 177, 157, 27);
        frame.getContentPane().add(radioButton_student);

        JRadioButton radioButton_teacher = new JRadioButton("教师");
        buttonGroup.add(radioButton_teacher);
        radioButton_teacher.setBackground(new Color(176, 196, 222));
        radioButton_teacher.setBounds(265, 177, 157, 27);
        frame.getContentPane().add(radioButton_teacher);

        JButton button_login = new JButton("登录");
        button_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentService studentService = new StudentServiceImpl(); // 构建学生业务类
                TeacherService teacher = new TeacherServiceImpl(); // 构建教师业务类
                String urseName = textField_urse.getText(); // 获取文本框信息
                char[] pw = passwordField_pw.getPassword(); // 获取密码
                String password = new String(pw);
                List<Map<Object, Object>> studententry = studentService.studententry(urseName.trim(), password); // 调用业务方法，返回密码
                // 判断是否输入内容
                if (urseName != null && password != null) {
                    if (radioButton_student.isSelected()) { // 判断选择身份

                        String stuNo = "";
                        String pd = "";
                        for (Map<Object, Object> map : studententry) {
                            stuNo = (String) map.get("studentNo");
                            pd = (String) map.get("password");
                        }

                        if (password.trim().equals(pd) && urseName.equals(stuNo)) {
                            JOptionPane.showMessageDialog(null, "登录成功", "登录提示", JOptionPane.INFORMATION_MESSAGE);
                            @SuppressWarnings("unused")
                            StudentJFrame studentJFrame = new StudentJFrame(studententry);
                            frame.dispose(); // 关闭当前页面
                        } else {
                            textField_urse.setText("");
                            passwordField_pw.setText("");
                            JOptionPane.showMessageDialog(null, "登录失败", "登录提示", JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (radioButton_teacher.isSelected()) {
                        TeacherEntity teacherinfo = teacher.teacherinfo(urseName, password);
                        if (password.trim().equals(teacherinfo.getPassword())
                                && urseName.equals(teacherinfo.getTeacherNo())) {
                            JOptionPane.showMessageDialog(null, "登录成功", "登录提示", JOptionPane.INFORMATION_MESSAGE);
                            @SuppressWarnings("unused")
                            TeacherJFrame teacherJFrame = new TeacherJFrame(teacherinfo);
                            frame.dispose();
                        } else {
                            textField_urse.setText("");
                            passwordField_pw.setText("");
                            JOptionPane.showMessageDialog(null, "登录失败", "登录提示", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请符合规范", "登录提示", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        button_login.setBackground(Color.LIGHT_GRAY);
        button_login.setBounds(155, 213, 113, 27);
        frame.getContentPane().add(button_login);
        frame.setVisible(true);

    }
}
