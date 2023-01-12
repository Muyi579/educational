package ui;

import service.StudentService;
import service.StudentServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SkipinfoJFrame {

	private JFrame frame;
	private JTable table;

	private static List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkipinfoJFrame window = new SkipinfoJFrame(list);
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
	public SkipinfoJFrame() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public SkipinfoJFrame(List<Map<Object, Object>> list) {
		SkipinfoJFrame.list = list;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("个人信息");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 窗口显示在页面中间
		frame.setLocationRelativeTo(null);
		// 窗口不允许调整大小
		frame.setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 57, 418, 183);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		StudentService stuser = new StudentServiceImpl(); // 调用业务层方法
		String[] str = new String[] { "学号", "姓名", "性别", "入学日期", "班级名", "密码", "状态 " }; // 创建列数组
		// 构建二维数组存放信息
		Object[][] objects = new Object[1][7];
		Map<Object, Object> map = list.get(0);
		String stuNo = (String) map.get("studentNo");
		String password = (String) map.get("password");
		objects[0][0] = map.get("studentNo");
		objects[0][1] = map.get("studentName");
		objects[0][2] = map.get("gender");
		objects[0][3] = map.get("birthday");
		objects[0][4] = map.get("className");
		objects[0][5] = map.get("password");
		Object ob = map.get("status");
		int num = (int) ob;
		if (num == 0) {
			objects[0][6] = "在读";
		} else {
			objects[0][6] = "休学";
		}
		stuser.studententry(stuNo, password);

		table.setModel(new DefaultTableModel(objects, str));
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("个人信息");
		label.setBounds(179, 26, 72, 18);
		frame.getContentPane().add(label);

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
		button.setBackground(Color.WHITE);
		button.setBounds(14, 0, 113, 27);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("返回上一层");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unused")
				StudentJFrame studentJFrame = new StudentJFrame();
				frame.dispose();
			}
		});
		button_1.setBounds(319, 0, 113, 27);
		frame.getContentPane().add(button_1);

		frame.setVisible(true);
	}
}
