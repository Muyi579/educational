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

public class StudentJFrame {

	private JFrame frame;
	private JTable table;
	private static List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
	private String stuNo = ""; // 标杆获取学生编号
	private String stuName = ""; // 赋值学生姓名

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentJFrame window = new StudentJFrame(list);
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
	public StudentJFrame() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public StudentJFrame(List<Map<Object, Object>> list) {
		StudentJFrame.list = list;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("学生个人窗口");
		frame.setBounds(100, 100, 784, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 窗口显示在页面中间
		frame.setLocationRelativeTo(null);
		// 窗口不允许调整大小
		frame.setResizable(false);

		// 调用界面层学生

		for (Map<Object, Object> map : list) {
			stuNo = (String) map.get("studentNo");
			stuName = (String) map.get("studentName");
		}
		JLabel label = new JLabel("学号：" + stuNo);
		label.setBounds(14, 13, 107, 18);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("姓名：" + stuName);
		label_1.setBounds(14, 44, 107, 18);
		frame.getContentPane().add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 96, 738, 282);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		String[] str = new String[] { "课程名", "课程学分", "分数" }; // 创建列数组
		// 构建二维数组存放信息
		Object[][] objects = new Object[list.size()][5];

		StudentService stuser = new StudentServiceImpl();

		// 添加数据
		for (int i = 0; i < list.size(); i++) {

			Map<Object, Object> map = list.get(i);
			objects[i][0] = map.get("courseName");
			objects[i][1] = map.get("credlit");
			objects[i][2] = map.get("score");
		}
		table.setModel(new DefaultTableModel(objects, str));
		scrollPane.setViewportView(table);

		JLabel label_2 = new JLabel("个人成绩信息");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setBounds(333, 76, 136, 18);
		frame.getContentPane().add(label_2);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(456, 10, 150, 50);
		frame.getContentPane().add(menuBar);

		JMenu menu = new JMenu("个人中心");
		menuBar.add(menu);

		JMenuItem menuItem_deletepassword = new JMenuItem("修改密码");
		menuItem_deletepassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newpassword = JOptionPane.showInputDialog("请输入新密码");
				boolean stuPassWordUpdate = stuser.stuPassWordUpdate(stuNo, newpassword);
				if (stuPassWordUpdate == true) {
					JOptionPane.showMessageDialog(null, "修改成功重新登录");
					LoginJFrame loginJFrame = new LoginJFrame();
					frame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "修改失败", "修改信息", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		menu.add(menuItem_deletepassword);

		JMenuItem menuItem_studeninfo = new JMenuItem("个人信息");
		menuItem_studeninfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				SkipinfoJFrame skipinfoJFrame = new SkipinfoJFrame(list);
				frame.dispose();
			}
		});
		menu.add(menuItem_studeninfo);

		JMenu menu_1 = new JMenu("退出登录");
		menuBar.add(menu_1);

		JMenuItem menuItem = new JMenuItem("退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int showConfirmDialog = JOptionPane.showConfirmDialog(null, "是否退出系统", "退出提示",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (showConfirmDialog == 0) {
					System.exit(0);
				}
			}
		});
		menu_1.add(menuItem);
		frame.setVisible(true); // 显示窗口
	}
}
