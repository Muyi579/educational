package ui;

import entity.TeacherEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TechershipJFrame {

	private JFrame frame;
	private JTable table;
	private static TeacherEntity teacherEntity = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TechershipJFrame window = new TechershipJFrame(teacherEntity);
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
	public TechershipJFrame() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public TechershipJFrame(TeacherEntity teacherEntity) {
		TechershipJFrame.teacherEntity = teacherEntity;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 窗口显示在页面中间
		frame.setLocationRelativeTo(null);
		// 窗口不允许调整大小
		frame.setResizable(false);

		JButton button = new JButton("退出程序");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int showConfirmDialog = JOptionPane.showConfirmDialog(null, "是否退出系统", "退出提示",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (showConfirmDialog == 0) {
					System.exit(0);
				}
			}
		});
		button.setBounds(10, 10, 112, 34);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("返回上一层");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TeacherJFrame teacherJFrame = new TeacherJFrame();
				frame.dispose();
			}
		});
		button_1.setBounds(291, 10, 127, 34);
		frame.getContentPane().add(button_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 412, 186);
		frame.getContentPane().add(scrollPane);

		table = new JTable();

		String[] str = new String[] { "教师工号", "教师名", "密码" };
		Object[][] objects = new Object[1][3];
		objects[0][0] = teacherEntity.getTeacherNo();
		objects[0][1] = teacherEntity.getTeacherName();
		objects[0][2] = teacherEntity.getPassword();
		table.setModel(new DefaultTableModel(objects, str

		));
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}
}
