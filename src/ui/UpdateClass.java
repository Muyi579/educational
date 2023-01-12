package ui;

import service.ClassService;
import service.ClassServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateClass {

	private JFrame frame;
	private JTable table;
	private static String className;
	private JTextField textField;
	private JTextField textField_1;
	private static ClassService classService = new ClassServiceImpl(); // 班级
	private JScrollPane scrollPane;
	private JPopupMenu popupMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClass window = new UpdateClass("中软一班");
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
	public UpdateClass() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public UpdateClass(String className) {
		UpdateClass.className = className;
		initialize();
	}

	/**
	 * @param
	 */
	private void studentScoreshowDate(List<Map<String, Object>> list2) {
		String[] str = new String[] { "学号", "姓名", "班级编号", "班级名" };
		Object[][] objects = new Object[list2.size()][4];
		for (int i = 0; i < list2.size(); i++) {
			Map<String, Object> map2 = list2.get(i);
			objects[i][0] = map2.get("studentNo");
			objects[i][1] = map2.get("studentName");
			objects[i][2] = map2.get("classNo");
			objects[i][3] = map2.get("className");
		}

		table.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(table);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("UpdateClass");
		frame.setBounds(100, 100, 608, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 窗口显示在页面中间
		frame.setLocationRelativeTo(null);
		// 窗口不允许调整大小
		frame.setResizable(false);

		JButton button = new JButton("返回上一层");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherJFrame teacherJFrame = new TeacherJFrame();
				frame.dispose();
			}
		});
		button.setBounds(423, 29, 113, 27);
		frame.getContentPane().add(button);

		JLabel label_1 = new JLabel("修改班级：");
		label_1.setBounds(43, 87, 113, 18);
		frame.getContentPane().add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(43, 118, 504, 226);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 13, 473, 189);
		panel_1.add(scrollPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 373, 102, 24);
		List<String> lStrings = classService.classAll();
		String[] oo = new String[lStrings.size()];
		for (int i = 0; i < lStrings.size(); i++) {
			oo[i] = lStrings.get(i);
		}
		comboBox.setModel(new DefaultComboBoxModel(oo));
		frame.getContentPane().add(comboBox);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					if (e.getButton() == MouseEvent.BUTTON3) {
						int i = table.rowAtPoint(e.getPoint());
						// 在table显示
						popupMenu = new JPopupMenu();
						JMenuItem menuItemdelete = new JMenuItem("修改");
						menuItemdelete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String stuNo = (String) table.getValueAt(i, 0); // 学号
								String stuName = (String) table.getValueAt(i, 1); // 姓名
								String className = (String) table.getValueAt(i, 3); // 班级名
								textField.setText(stuNo); // 赋值
								textField_1.setText(stuName);
								Object str = className;
								comboBox.setSelectedItem(str); // 设置指定的内容
							}
						});

						popupMenu.add(menuItemdelete);

						popupMenu.show(table, e.getX(), e.getY());

					}
				}

			}
		});
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("className", className);
		List<Map<String, Object>> studentClassAll = classService.getStudentClassAll(map);
		studentScoreshowDate(studentClassAll);
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("学号：");
		label.setBounds(54, 378, 72, 18);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(125, 374, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(221, 376, 72, 18);
		frame.getContentPane().add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(269, 372, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel label_3 = new JLabel("班级：");
		label_3.setBounds(404, 376, 72, 18);
		frame.getContentPane().add(label_3);

		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = comboBox.getSelectedItem().toString();
				String classno = classService.classnum(str);
				boolean updatestudentclass = classService.updatestudentclass(textField.getText(), classno);
				if (updatestudentclass == true) {
					JOptionPane.showMessageDialog(null, "修改成功");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			}
		});
		button_1.setBounds(251, 420, 113, 27);
		frame.getContentPane().add(button_1);
		frame.setVisible(true);
	}
}
