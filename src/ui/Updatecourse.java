package ui;

import service.CourseService;
import service.CourseServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Updatecourse {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private static String courseNo;
	private JScrollPane scrollPane;
	private JPopupMenu popupMenu;
	private static CourseService course = new CourseServiceImpl(); // 课程业务类
	private String courseName2;
	private String studentNo;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatecourse window = new Updatecourse(courseNo);
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
	public Updatecourse() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public Updatecourse(String courseNo) {
		Updatecourse.courseNo = courseNo;
		initialize();
	}

	/**
	 * @param 分数管理界面table表格赋值
	 */
	private void studentcourseshowDate(List<Map<String, Object>> list2) {
		String[] str = new String[] { "学号", "姓名", "课程名" };
		Object[][] objects = new Object[list2.size()][3];
		for (int i = 0; i < list2.size(); i++) {
			Map<String, Object> map2 = list2.get(i);
			objects[i][0] = map2.get("studentNo");
			objects[i][1] = map2.get("studentName");
			objects[i][2] = map2.get("courseName");
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
		frame.setTitle("修改学生课程");
		frame.setBounds(100, 100, 655, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 窗口显示在页面中间
		frame.setLocationRelativeTo(null);
		// 窗口不允许调整大小
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("返回上一层");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherJFrame teacherJFrame = new TeacherJFrame();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(478, 13, 113, 27);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("修改学生课程");
		lblNewLabel.setBounds(52, 54, 90, 18);
		frame.getContentPane().add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 74, 540, 111);
		frame.getContentPane().add(scrollPane);
		
		comboBox = new JComboBox();
		comboBox.setBounds(458, 220, 133, 24);
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
								studentNo = (String) table.getValueAt(i, 0); // 学号
								String stuName = (String) table.getValueAt(i, 1); // 姓名
								courseName2 = (String) table.getValueAt(i, 2); // 课程名
								textField.setText(studentNo); // 赋值
								textField_1.setText(stuName);
								Object str = courseName2;
								
								List<String> list = course.get(studentNo); // 得到所报科目

								List<String> lStrings = course.courseAll();
								Iterator<String> iterator = lStrings.iterator();
								while (iterator.hasNext()) {
									String string = iterator.next();
									for (String string2 : list) {
										if (string2.equals(string)) {
											iterator.remove();
										}
									}
								}

								String[] oo = new String[lStrings.size()];
								for (int o = 0; o < lStrings.size(); o++) {
									oo[o] = lStrings.get(o);
								}
								comboBox.setModel(new DefaultComboBoxModel(oo));

								comboBox.setSelectedItem(str); // 设置指定的内容
							}
						});
						popupMenu.add(menuItemdelete);
						popupMenu.show(table, e.getX(), e.getY());
					}
				}
			}
		});

		List<Map<String, Object>> studentClassAll = course.getstudentInfo(courseNo);
		studentcourseshowDate(studentClassAll);

		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("学号:");
		lblNewLabel_1.setBounds(52, 223, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(114, 220, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("课程：");
		lblNewLabel_2.setBounds(402, 223, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("姓名:");
		lblNewLabel_3.setBounds(229, 223, 72, 18);
		frame.getContentPane().add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(300, 220, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String courseName = comboBox.getSelectedItem().toString();
				String courseNo2 = course.getCourseNo(courseName2);
				boolean updatestudentcourse = course.updatestudentcourse(courseName, courseNo2);
				if (updatestudentcourse == true) {
					JOptionPane.showMessageDialog(null, "修改成功");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}

			}
		});
		btnNewButton_1.setBounds(256, 266, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}

}
