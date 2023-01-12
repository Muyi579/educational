
package ui;

import entity.ClassEntity;
import entity.StudentEntity;
import entity.TeacherEntity;
import service.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherJFrame {

	private JFrame frame;
	private JTextField textField_search;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_stuNo;
	private JTextField textField_stuName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_updateStudentName;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_stuDate;
	private JPasswordField passwordField_stupassword;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private static CourseService course = new CourseServiceImpl(); // 课程业务类
	private static StudentService serviceImpl = new StudentServiceImpl(); // 学生业务类
	private static TeacherEntity teacherEntity = new TeacherEntity();// 教师实体类
	private static TeacherService tea = new TeacherServiceImpl();// 教师业务类
	private static CourseScoreService scoreService = new CourseScoreServiceImpl(); // 分数
	private static ClassService classService = new ClassServiceImpl(); // 班级
	private JTextField textField_studentNo;
	private static JPopupMenu popupMenu;
	private JTextField textField_scoreNo;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_3;
	private JTable table_1;
	private JTextField textField_scoreStudentNo;
	private JTextField textField_score;
	private JTable table_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JScrollPane scrollPane_2;
	// private static JMenuItem jItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherJFrame window = new TeacherJFrame(teacherEntity);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @param 学生管理界面table表格赋值
	 */
	private void showDate(List<Map<String, Object>> list1) {
		String[] str = new String[] { "学生学号", "学生姓名", "性别", "出生日期", "所属班级编号", "所属班级名", "状态" };
		Object[][] objects = new Object[list1.size()][7];
		for (int i = 0; i < list1.size(); i++) {
			Map<String, Object> map2 = list1.get(i);
			objects[i][0] = map2.get("studentNo");
			objects[i][1] = map2.get("studentName");
			objects[i][2] = map2.get("gender");
			objects[i][3] = map2.get("birthday");
			objects[i][4] = map2.get("classNo");
			objects[i][5] = map2.get("className");
			objects[i][6] = map2.get("status");
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
	 * @param 分数管理界面table表格赋值
	 */
	private void studentScoreshowDate(List<Map<String, Object>> list2) {
		String[] str = new String[] { "学号", "姓名", "所属班级", "课程名", "成绩" };
		Object[][] objects = new Object[list2.size()][5];
		for (int i = 0; i < list2.size(); i++) {
			Map<String, Object> map2 = list2.get(i);
			objects[i][0] = map2.get("studentNo");
			objects[i][1] = map2.get("studentName");
			objects[i][2] = map2.get("className");
			objects[i][3] = map2.get("courseName");
			objects[i][4] = map2.get("score");
		}

		table_1.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane_1.setViewportView(table_1);
	}

	/**
	 * @param .班级管理界面table表格赋值所有班级
	 */
	private void classScoreshowDate(List<Map<String, String>> list) {
		String[] str = new String[] { "班级编号", "班级名", "班级人数" };
		Object[][] objects = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			objects[i][0] = map.get("classNo");
			objects[i][1] = map.get("className");
			objects[i][2] = map.get("count");

		}

		table_3.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane_3.setViewportView(table_3);
	}

	/**
	 * @param .班级管理界面table表格赋值所有班级学生
	 */
	private void classstudentScoreshowDate(List<Map<String, String>> o) {
		String[] str = new String[] { "学生编号", "学生姓名", "班级编号", "班级名" };
		Object[][] objects = new Object[o.size()][4];
		for (int i = 0; i < o.size(); i++) {
			Map<String, String> map = o.get(i);
			objects[i][0] = map.get("studentNo");
			objects[i][1] = map.get("studentName");
			objects[i][2] = map.get("classNo");
			objects[i][3] = map.get("className");

		}

		table_3.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		scrollPane_3.setViewportView(table_3);
	}

	/**
	 * @param .班级管理界面table表格赋值指定班级学生
	 */
	private void classstudentScoreshowDateNum(List<Map<String, Object>> o) {
		String[] str = new String[] { "学生编号", "学生姓名", "班级编号", "班级名" };
		Object[][] objects = new Object[o.size()][4];
		for (int i = 0; i < o.size(); i++) {
			Map<String, Object> map = o.get(i);
			objects[i][0] = map.get("studentNo");
			objects[i][1] = map.get("studentName");
			objects[i][2] = map.get("classNo");
			objects[i][3] = map.get("className");

		}

		table_3.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		scrollPane_3.setViewportView(table_3);
	}

	/**
	 * @param .课程管理界面table表格赋值所有课程
	 */
	private void courseShowDate(List<Map<String, Object>> list) {
		String[] str = new String[] { "课程编号", "课程名", "课程人数" };
		Object[][] objects = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			objects[i][0] = map.get("courseNo");
			objects[i][1] = map.get("courseName");
			objects[i][2] = map.get("count");

		}

		table_2.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane_2.setViewportView(table_2);
	}

	/**
	 * @param .课程管理界面table表格赋值所有课程学生信息
	 */
	private void coursestudentShowDate(List<Map<String, Object>> list) {
		String[] str = new String[] { "学生编号", "学生姓名", "课程编号", "课程名", "分数" };
		Object[][] objects = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			objects[i][0] = map.get("studentNo");
			objects[i][1] = map.get("studentName");
			objects[i][2] = map.get("courseNo");
			objects[i][3] = map.get("courseName");
			objects[i][4] = map.get("score");

		}

		table_2.setModel(new DefaultTableModel(objects, str) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane_2.setViewportView(table_2);
	}

	/**
	 * Create the application.
	 */
	public TeacherJFrame() {
		initialize();
	}

	/**
	 * Create the application.
	 */
	public TeacherJFrame(TeacherEntity teacherEntity) {
		TeacherJFrame.teacherEntity = teacherEntity;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param teacherEntity
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 755, 742);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// 窗口显示在页面中间
		frame.setLocationRelativeTo(null);
		// 窗口不允许调整大小
		frame.setResizable(false);

		JLabel label = new JLabel("教师工号：" + teacherEntity.getTeacherNo());
		label.setBounds(14, 13, 160, 18);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("教师名：" + teacherEntity.getTeacherName());
		label_1.setBounds(14, 49, 146, 18);
		frame.getContentPane().add(label_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(529, 17, 150, 30);
		frame.getContentPane().add(menuBar);

		JMenu menu = new JMenu("个人中心");
		menuBar.add(menu);

		JMenuItem menuItem_1 = new JMenuItem("个人信息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TechershipJFrame techershipJFrame = new TechershipJFrame(teacherEntity);
				frame.dispose();

			}
		});
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("修改密码");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newpassword = JOptionPane.showInputDialog("请输入新密码");
				boolean stuPassWordUpdate = tea.updateTeacherInfo(teacherEntity.getTeacherNo(), newpassword);
				if (stuPassWordUpdate == true) {
					JOptionPane.showMessageDialog(null, "修改成功重新登录");
					LoginJFrame loginJFrame = new LoginJFrame();
					frame.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "修改失败", "修改信息", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		menu.add(menuItem_2);

		JMenu menu_1 = new JMenu("退出登录");
		menuBar.add(menu_1);

		JMenuItem menuItem_3 = new JMenuItem("退出登录");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int showConfirmDialog = JOptionPane.showConfirmDialog(null, "是否退出系统", "退出提示",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (showConfirmDialog == 0) {
					System.exit(0);
				}
			}
		});
		menu_1.add(menuItem_3);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 77, 711, 605);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("学生管理", null, panel, null);
		panel.setLayout(null);

		JLabel label_2 = new JLabel("关键字：");
		label_2.setBounds(46, 13, 72, 18);
		panel.add(label_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "按全文搜索", "按学号搜索", "按学生姓名搜索" }));
		comboBox.setBounds(129, 10, 104, 24);
		panel.add(comboBox);

		textField_search = new JTextField();
		textField_search.setBounds(258, 10, 234, 24);
		panel.add(textField_search);
		textField_search.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 65, 646, 163);
		panel.add(scrollPane);

		JButton button = new JButton("搜索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Map<String, Object> map = new HashMap<String, Object>();
				String keyword = (String) comboBox.getSelectedItem().toString(); // 下拉框内容
				if ("按全文搜索".equals(keyword)) {
					map.put("按全文搜索", keyword);
				} else if ("按学号搜索".equals(keyword)) {
					map.put("按学号搜索", keyword);
					map.put("stuNo", textField_search.getText());
				} else if ("按学生姓名搜索".equals(keyword)) {
					map.put("按学生姓名搜索", keyword);
					map.put("stuName", textField_search.getText());
				}
				list = serviceImpl.getStudent(map);

				showDate(list);

			}
		});

		button.setBounds(581, 9, 81, 27);
		panel.add(button);

		JLabel label_3 = new JLabel("新增学生");
		label_3.setBounds(33, 241, 72, 18);
		panel.add(label_3);

		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.WHITE);
		panel_4.setBackground(SystemColor.scrollbar);
		panel_4.setBounds(35, 263, 281, 297);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel label_4 = new JLabel("学号：");
		label_4.setBounds(25, 34, 72, 18);
		panel_4.add(label_4);

		textField_stuNo = new JTextField();
		textField_stuNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> studentNolist = serviceImpl.getStudentNo();
				for (String string : studentNolist) {
					if (string.equals(textField_stuNo.getText())) {
						JOptionPane.showMessageDialog(null, "学号已存在，请重新输入");
						textField_stuNo.setText("");
					}
				}

			}
		});
		textField_stuNo.setBounds(120, 31, 140, 24);
		panel_4.add(textField_stuNo);
		textField_stuNo.setColumns(10);

		JLabel label_5 = new JLabel("学生姓名：");
		label_5.setBounds(25, 82, 96, 18);
		panel_4.add(label_5);

		textField_stuName = new JTextField();
		textField_stuName.setBounds(120, 79, 140, 24);
		panel_4.add(textField_stuName);
		textField_stuName.setColumns(10);

		JLabel label_6 = new JLabel("性别：");
		label_6.setBounds(25, 140, 72, 18);
		panel_4.add(label_6);

		JRadioButton radioButton_addman = new JRadioButton("男");
		buttonGroup.add(radioButton_addman);
		radioButton_addman.setBounds(120, 136, 45, 27);
		panel_4.add(radioButton_addman);

		JRadioButton radioButton_addwumen = new JRadioButton("女");
		buttonGroup.add(radioButton_addwumen);
		radioButton_addwumen.setBounds(188, 136, 44, 27);
		panel_4.add(radioButton_addwumen);

		ClassServiceImpl classser = new ClassServiceImpl();
		JLabel label_7 = new JLabel("所属班级：");
		label_7.setBounds(22, 213, 99, 18);
		panel_4.add(label_7);

		JComboBox comboBox_class = new JComboBox();
		comboBox_class.setBounds(120, 210, 140, 24);

		// 把查询到的班级赋值给下拉框
		List<String> classAll3 = classser.classAll();
		List<String> classAll = classAll3;
		String[] strings = new String[classAll.size()];
		for (int i = 0; i < classAll.size(); i++) {
			strings[i] = classAll.get(i);
		}
		comboBox_class.setModel(new DefaultComboBoxModel(strings));
		panel_4.add(comboBox_class);

		JLabel label_16 = new JLabel("出生日期：");
		label_16.setBounds(25, 171, 85, 18);
		panel_4.add(label_16);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.scrollbar);
		panel_5.setBounds(347, 263, 352, 297);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblLv = new JLabel("学号：      ");
		lblLv.setBounds(46, 13, 93, 18);
		panel_5.add(lblLv);

		JLabel label_10 = new JLabel("学生姓名：");
		label_10.setBackground(SystemColor.scrollbar);
		label_10.setBounds(46, 48, 93, 18);
		panel_5.add(label_10);

		textField_updateStudentName = new JTextField();
		textField_updateStudentName.setBounds(142, 45, 170, 24);
		panel_5.add(textField_updateStudentName);
		textField_updateStudentName.setColumns(10);

		JLabel label_11 = new JLabel("性别：");
		label_11.setBounds(46, 82, 72, 18);
		panel_5.add(label_11);

		JRadioButton radioButton_updatestuMan = new JRadioButton("男");
		buttonGroup_1.add(radioButton_updatestuMan);
		radioButton_updatestuMan.setBounds(163, 78, 51, 27);
		panel_5.add(radioButton_updatestuMan);

		JRadioButton radioButton_updateStuWuman = new JRadioButton("女");
		buttonGroup_1.add(radioButton_updateStuWuman);
		radioButton_updateStuWuman.setBounds(247, 78, 51, 27);
		panel_5.add(radioButton_updateStuWuman);

		JLabel label_12 = new JLabel("出生日期：");
		label_12.setBounds(45, 118, 100, 18);
		panel_5.add(label_12);

		textField_stuDate = new JTextField();
		textField_stuDate.setBounds(144, 114, 167, 24);
		panel_5.add(textField_stuDate);
		textField_stuDate.setColumns(10);

		JLabel label_13 = new JLabel("密码：");
		label_13.setBounds(46, 149, 72, 18);
		panel_5.add(label_13);

		passwordField_stupassword = new JPasswordField();
		passwordField_stupassword.setBounds(143, 154, 167, 25);
		panel_5.add(passwordField_stupassword);

		JLabel label_14 = new JLabel("状态：");
		label_14.setBounds(43, 188, 72, 18);
		panel_5.add(label_14);

		JRadioButton radioButton_zhuangtaizaidu = new JRadioButton("在读");
		buttonGroup_2.add(radioButton_zhuangtaizaidu);
		radioButton_zhuangtaizaidu.setBounds(145, 184, 69, 27);
		panel_5.add(radioButton_zhuangtaizaidu);

		JRadioButton rdbtnX_zhuangtaixiuxue = new JRadioButton("休学");
		buttonGroup_2.add(rdbtnX_zhuangtaixiuxue);
		rdbtnX_zhuangtaixiuxue.setBounds(226, 184, 72, 27);
		panel_5.add(rdbtnX_zhuangtaixiuxue);

		JLabel label_15 = new JLabel("所属班级：");
		label_15.setBounds(46, 223, 80, 18);
		panel_5.add(label_15);

		JComboBox comboBox_suoshu = new JComboBox();
		comboBox_suoshu.setBounds(142, 220, 170, 24);
		comboBox_suoshu.setModel(new DefaultComboBoxModel(strings));
		panel_5.add(comboBox_suoshu);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					if (e.getButton() == MouseEvent.BUTTON3) {
						int i = table.rowAtPoint(e.getPoint());
						// 在table显示
						popupMenu = new JPopupMenu();
						JMenuItem menuItem = new JMenuItem("注销");
						menuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String valueAt = (String) table.getValueAt(i, 0);
								boolean updatestudent = serviceImpl.updatestudent(valueAt);
								if (updatestudent == true) {
									JOptionPane.showMessageDialog(null, "注销成功");
								}
							}
						});
						JMenuItem menuItemdelete = new JMenuItem("修改");
						menuItemdelete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String stuNo = (String) table.getValueAt(i, 0); // 学号
								String stuName = (String) table.getValueAt(i, 1); // 姓名
								String gender = (String) table.getValueAt(i, 2); // 性别
								String birthday = (String) table.getValueAt(i, 3); // 出生日期
								String className = (String) table.getValueAt(i, 5); // 班级名
								String status = (String) table.getValueAt(i, 6); // 状态
								textField_studentNo.setText(stuNo); // 赋值
								textField_updateStudentName.setText(stuName);
								if (gender.equals("男")) {
									radioButton_updatestuMan.setSelected(true);
								} else if (gender.equals("女")) {
									radioButton_updateStuWuman.setSelected(true);
								}
								textField_stuDate.setText(birthday);
								if ("在读".equals(status)) {
									radioButton_zhuangtaizaidu.setSelected(true);
								} else if ("休学".equals(status)) {
									rdbtnX_zhuangtaixiuxue.setSelected(true);
								}
								Object str = className;
								comboBox_suoshu.setSelectedItem(str); // 设置指定的内容
							}
						});
						popupMenu.add(menuItem);

						popupMenu.add(menuItemdelete);

						popupMenu.show(table, e.getX(), e.getY());

					}
				}

			}

		});

		scrollPane.setViewportView(table);

		JTextField textField_date = new JTextField();
		textField_date.setBounds(120, 172, 140, 24);
		panel_4.add(textField_date);
		textField_date.setColumns(10);

		JButton button_3 = new JButton("新增学生");
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentEntity studentEntity = new StudentEntity(); // 学生实体类
				boolean flag = true;
				if (textField_stuNo.getText() != null && textField_stuName.getText() != null
						&& (radioButton_addman.isDisplayable() != false
								|| radioButton_addwumen.isDisplayable() != false)
						&& textField_date.getText() != null) {

					String str = comboBox_class.getSelectedItem().toString(); // 获取下拉框内容 String classNo
					String classnum = classser.classnum(str); // 得到班级编号
					ClassEntity classEntity = new ClassEntity(classnum, str);// 得到班级信息

					radioButton_addwumen.setFocusable(true);
					if (radioButton_addman.isDisplayable()) { // 判断单选按钮
						studentEntity = new StudentEntity(textField_stuNo.getText(), textField_stuName.getText(), "男",
								textField_date.getText(), "123456", 0);
						studentEntity.setClassEntity(classEntity); // 赋值
						flag = serviceImpl.addStudent(studentEntity);
					} else if (radioButton_addwumen.isDisplayable()) {
						studentEntity = new StudentEntity(textField_stuNo.getText(), textField_stuName.getText(), "女",
								textField_date.getText(), "123456", 0);
						studentEntity.setClassEntity(classEntity); // 赋值
						flag = serviceImpl.addStudent(studentEntity);
					}
				}
				if (flag == true) {
					JOptionPane.showMessageDialog(null, "添加成功");
				} else {
					JOptionPane.showMessageDialog(null, "添加失败");
				}

			}
		});
		button_3.setBounds(92, 257, 113, 27);
		panel_4.add(button_3);
		JButton button_2 = new JButton("修改信息");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentNo = textField_studentNo.getText();
				String stuName = textField_updateStudentName.getText();
				String gender = "";
				if (radioButton_updatestuMan.isSelected()) {
					gender = "男";
				} else if (radioButton_updateStuWuman.isSelected()) {
					gender = "女";
				}
				String birthday = textField_stuDate.getText();
				char[] pw = passwordField_stupassword.getPassword();
				String password = new String(pw);
				Integer status = 0;
				if (radioButton_zhuangtaizaidu.isSelected()) {
					status = 0;
				} else if (rdbtnX_zhuangtaixiuxue.isSelected()) {
					status = 1;
				}
				String str = comboBox_suoshu.getSelectedItem().toString(); // 获取下拉框内容 String classNo
				String classNo = classser.classnum(str); // 得到班级编号
				Map<String, Object> map = new HashMap<>();
				map.put("stuName", stuName);
				map.put("birthday", birthday);
				map.put("password", password);
				map.put("status", status);
				map.put("classNo", classNo);
				map.put("gender", gender);
				map.put("studentNo", studentNo);
				boolean updatestudentAll = serviceImpl.updatestudentAll(map);
				if (updatestudentAll == true) {
					JOptionPane.showMessageDialog(null, "修改成功");
				} else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			}
		});
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(130, 257, 113, 27);
		panel_5.add(button_2);

		textField_studentNo = new JTextField();
		textField_studentNo.setBounds(142, 10, 170, 24);
		panel_5.add(textField_studentNo);
		textField_studentNo.setColumns(10);

		JLabel label_8 = new JLabel("修改学生");
		label_8.setBounds(343, 238, 72, 18);
		panel.add(label_8);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("成绩管理", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label_9 = new JLabel("学号：");
		label_9.setBounds(28, 47, 72, 18);
		panel_1.add(label_9);

		textField_scoreNo = new JTextField();
		textField_scoreNo.setBackground(SystemColor.controlHighlight);
		textField_scoreNo.setBounds(72, 44, 84, 24);
		panel_1.add(textField_scoreNo);
		textField_scoreNo.setColumns(10);

		JLabel label_17 = new JLabel("课程：");
		label_17.setBounds(172, 48, 72, 18);
		panel_1.add(label_17);

		// 课程下选框
		JComboBox comboBox_1 = new JComboBox();

		List<String> courseAll2 = course.courseAll();
		List<String> getcourseAll = courseAll2;
		List<String> courseAll = getcourseAll;
		String[] courseName = new String[courseAll.size() + 1];
		courseName[0] = "全部课程";
		int count = 0;
		for (int i = 1; i < courseAll.size() + 1; i++) {
			courseName[i] = courseAll.get(count);
			count++;
		}

		comboBox_1.setBounds(215, 44, 102, 24);
		comboBox_1.setModel(new DefaultComboBoxModel(courseName));
		panel_1.add(comboBox_1);

		JComboBox comboBox_3 = new JComboBox();

		// 班级下拉框
		List<String> classAll5 = classService.classAll();
		List<String> classAll4 = classAll5;
		List<String> classAll2 = classAll4;
		String[] getClassName = new String[classAll2.size() + 1];
		getClassName[0] = "全部班级";
		int n = 0;
		for (int i = 1; i < classAll2.size() + 1; i++) {
			getClassName[i] = classAll2.get(n);
			n++;
		}
		comboBox_3.setBounds(381, 44, 103, 24);
		comboBox_3.setModel(new DefaultComboBoxModel(getClassName));
		panel_1.add(comboBox_3);
		JButton button_1 = new JButton("搜索");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> map3 = new HashMap<String, Object>();
				String keyword = (String) comboBox_1.getSelectedItem().toString(); // 课程下拉框内容
				String classBox = (String) comboBox_3.getSelectedItem().toString(); // 班级下拉框内容
				if ("全部课程".equals(keyword) && "全部班级".equals(classBox) && textField_scoreNo.getText().length() == 0) {
					map3.put("全部课程", keyword);
					map3.put("全部班级", classBox);
				} else if (!"全部课程".equals(keyword) && textField_scoreNo.getText().length() > 0) {
					map3.put("课程加学号其他", keyword);
					map3.put("studentNo", textField_scoreNo.getText());
					map3.put("courseName", keyword);
				} else if (!"全部班级".equals(classBox)) {
					map3.put("班级其他", classBox);
					map3.put("className", classBox);
				} else if (!"全部课程".equals(keyword) && textField_scoreNo.getText().length() == 0) {
					map3.put("课程其他", keyword);
					map3.put("courseName", keyword);
				} else if ("全部课程".equals(keyword) && "全部班级".equals(classBox)
						&& textField_scoreNo.getText().length() > 0) {
					map3.put("学号", "学号");
					map3.put("studentNo", textField_scoreNo.getText());
				}
				List<Map<String, Object>> getscore = scoreService.getscore(map3);

				studentScoreshowDate(getscore);
			}
		});
		button_1.setBounds(485, 42, 69, 27);
		panel_1.add(button_1);

		JButton button_4 = new JButton("清除搜索条件");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_scoreNo.setText("");
				Object str = "全部课程";
				comboBox_1.setSelectedItem(str); // 设置指定的课程内容

				Object st = "全部班级";
				comboBox_3.setSelectedItem(st);
			}
		});
		button_4.setBounds(576, 43, 130, 27);
		panel_1.add(button_4);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 103, 665, 215);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JLabel label_25 = new JLabel("班级：");
		label_25.setBounds(335, 49, 72, 18);
		panel_1.add(label_25);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.scrollbar);
		panel_8.setBounds(33, 360, 252, 209);
		panel_1.add(panel_8);
		panel_8.setLayout(null);

		JLabel label_27 = new JLabel("学号：");
		label_27.setBounds(26, 17, 72, 18);
		panel_8.add(label_27);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(104, 71, 125, 24);
		List<String> getCourseName = courseAll2;
		String[] cour = new String[getCourseName.size()];
		for (int i = 0; i < getCourseName.size(); i++) {
			cour[i] = getCourseName.get(i);
		}

		comboBox_4.setModel(new DefaultComboBoxModel(cour));

		panel_8.add(comboBox_4);

		textField_scoreStudentNo = new JTextField();
		textField_scoreStudentNo.setBackground(SystemColor.controlHighlight);
		textField_scoreStudentNo.setBounds(104, 12, 125, 24);
		panel_8.add(textField_scoreStudentNo);
		textField_scoreStudentNo.setColumns(10);

		JLabel label_28 = new JLabel("课程：");
		label_28.setBounds(26, 74, 72, 18);
		panel_8.add(label_28);

		JLabel label_29 = new JLabel("分数：");
		label_29.setBounds(26, 120, 72, 18);
		panel_8.add(label_29);

		textField_score = new JTextField();
		textField_score.setBounds(104, 117, 125, 24);
		panel_8.add(textField_score);
		textField_score.setColumns(10);

		JButton button_8 = new JButton("录入");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = comboBox_4.getSelectedItem().toString(); // 获取下拉框内容 String classNo
				String courseNo = course.getCourseNo(str); // 得到课程编号
				boolean flag = scoreService.getscore(textField_scoreStudentNo.getText(), courseNo);
				if (flag == true) {
					boolean updateScoreNo = scoreService.updateScoreNo(textField_score.getText(),
							textField_scoreStudentNo.getText(), courseNo);
					if (updateScoreNo == true) {
						JOptionPane.showConfirmDialog(null, "录入成功");
					}
				} else {
					JOptionPane.showMessageDialog(null, "该课程已有分数/暂无该课程");
				}

			}
		});
		button_8.setBounds(66, 169, 113, 27);
		panel_8.add(button_8);

		JLabel label_26 = new JLabel("录入成绩：");
		label_26.setBounds(34, 338, 93, 18);
		panel_1.add(label_26);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("班级管理", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel label_18 = new JLabel("查询：");
		label_18.setBounds(128, 34, 72, 18);
		panel_2.add(label_18);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(240, 31, 144, 24);
		List<String> lStrings = classService.classAll();
		String[] oo = new String[lStrings.size() + 2];
		oo[0] = "全部班级";
		oo[1] = "全部班级学生";
		int counnn = 0;
		for (int i = 2; i < lStrings.size() + 2; i++) {
			oo[i] = lStrings.get(counnn);
			counnn++;
		}
		comboBox_2.setModel(new DefaultComboBoxModel(oo));

		panel_2.add(comboBox_2);

		JButton button_5 = new JButton("搜索");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String classBox = (String) comboBox_2.getSelectedItem().toString(); // 班级下拉框内容
				if ("全部班级".equals(classBox)) {
					List<Map<String, String>> getcounystudent = serviceImpl.getcounystudent();
					classScoreshowDate(getcounystudent);
				} else if ("全部班级学生".equals(classBox)) {
					List<Map<String, String>> stuAllClassAll = classService.getStuAllClassAll();
					classstudentScoreshowDate(stuAllClassAll);
				} else if ("全部班级".equals(classBox) == false && "全部班级学生".equals(classBox) == false) {
					Map<String, Object> oo = new HashMap<>();
					oo.put("className", classBox);
					List<Map<String, Object>> studentClassAll = classService.getStudentClassAll(oo);
					classstudentScoreshowDateNum(studentClassAll);
				}

			}
		});
		button_5.setBounds(452, 30, 113, 27);
		panel_2.add(button_5);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(50, 65, 600, 230);
		panel_2.add(scrollPane_3);

		table_3 = new JTable();

		scrollPane_3.setViewportView(table_3);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(50, 330, 227, 230);
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JLabel label_21 = new JLabel("班级编号：");
		label_21.setBounds(14, 39, 83, 18);
		panel_6.add(label_21);

		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> judgeclass = classService.judgeclass(); // 得到所有班级编号判断是否已有
				for (String string : judgeclass) {
					if (string.equals(textField_4.getText())) {
						JOptionPane.showConfirmDialog(null, "班级编号重复", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
						textField_4.setText("");
					}
				}

			}
		});
		textField_4.setBounds(100, 35, 113, 24);
		panel_6.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_22 = new JLabel("班级名：");
		label_22.setBounds(14, 98, 72, 18);
		panel_6.add(label_22);

		textField_5 = new JTextField();
		textField_5.setBounds(100, 95, 113, 24);
		panel_6.add(textField_5);
		textField_5.setColumns(10);

		JButton button_6 = new JButton("添加");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText() != null && textField_5.getText() != null) {
					boolean addclass = classService
							.addclass(new ClassEntity(textField_4.getText(), textField_5.getText()));
					if (addclass == true) {
						JOptionPane.showConfirmDialog(null, "添加成功", "添加提示", JOptionPane.YES_NO_CANCEL_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, "添加失败", "添加提示", JOptionPane.YES_NO_CANCEL_OPTION);
					}
				} else {
					JOptionPane.showMessageDialog(null, "请符合规范");
				}

			}
		});
		button_6.setBounds(56, 153, 113, 27);
		panel_6.add(button_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(416, 330, 234, 230);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		JLabel label_23 = new JLabel("班级名：");
		label_23.setBounds(22, 95, 72, 18);
		panel_7.add(label_23);

		JLabel label_24 = new JLabel("班级编号：");
		label_24.setBounds(22, 40, 81, 18);
		panel_7.add(label_24);

		textField_6 = new JTextField();

		textField_6.setBounds(103, 37, 117, 24);
		panel_7.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(103, 92, 117, 24);
		panel_7.add(textField_7);
		textField_7.setColumns(10);

		JButton button_7 = new JButton("修改");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText() != null && textField_7.getText() != null) {
					boolean updatelass = classService
							.updateclass(new ClassEntity(textField_6.getText(), textField_7.getText()));
					if (updatelass == true) {
						JOptionPane.showConfirmDialog(null, "修改成功", "修改提示", JOptionPane.YES_NO_CANCEL_OPTION);
					} else {
						JOptionPane.showConfirmDialog(null, "修改失败", "修改提示", JOptionPane.YES_NO_CANCEL_OPTION);
					}
				} else {
					JOptionPane.showMessageDialog(null, "请符合规范");
				}

			}
		});
		button_7.setBounds(22, 167, 72, 27);
		panel_7.add(button_7);

		JButton button_9 = new JButton("删除");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText() != null && textField_7.getText() != null) {
					boolean getstudentclass = classService.getstudentclass(textField_6.getText()); // 判断班级是否有学生
					if (getstudentclass == true) {
						classService.deleteclass(textField_6.getText(), textField_7.getText());
						JOptionPane.showMessageDialog(null, "删除成功");
					} else if (getstudentclass == false) {
						int aa = JOptionPane.showConfirmDialog(null, "班级有学生，请先修改学生", "提示",
								JOptionPane.YES_NO_CANCEL_OPTION);
						if (aa == 0) {
							UpdateClass tt = new UpdateClass(textField_7.getText());
							frame.dispose();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "请符合规范");
				}

			}
		});
		button_9.setBounds(139, 167, 81, 27);
		panel_7.add(button_9);

		JLabel label_19 = new JLabel("添加：");
		label_19.setBounds(49, 308, 72, 18);
		panel_2.add(label_19);

		JLabel label_20 = new JLabel("修改：");
		label_20.setBounds(412, 302, 72, 18);
		panel_2.add(label_20);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("课程管理", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel label_30 = new JLabel("查询：");
		label_30.setBounds(117, 36, 72, 18);
		panel_3.add(label_30);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(257, 33, 181, 24);
		List<String> tt = course.courseAll();
		String[] pp = new String[tt.size() + 2];
		pp[0] = "全部课程";
		pp[1] = "全部课程学生";
		int nnn = 0;
		for (int i = 2; i < tt.size() + 2; i++) {
			pp[i] = tt.get(nnn);
			nnn++;
		}
		comboBox_5.setModel(new DefaultComboBoxModel(pp));
		panel_3.add(comboBox_5);

		JButton button_10 = new JButton("搜索");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Object> map = new HashMap<>();
				String sr = comboBox_5.getSelectedItem().toString();
				if ("全部课程".equals(sr)) {
					List<Map<String, Object>> getcourse = course.getcourseInfo();
					courseShowDate(getcourse);
				} else if ("全部课程学生".equals(sr)) {
					map.put("全部课程学生", sr);
					List<Map<String, Object>> getcourseAll = course.getcourse(map);
					coursestudentShowDate(getcourseAll);
				} else if (!"全部课程".equals(sr) && !"全部课程学生".equals(sr)) {
					List<String> courseAll3 = course.courseAll();
					for (String string : courseAll3) {
						if (string.equals(sr)) {
							map.put(string, sr);
							List<Map<String, Object>> get = course.getcourse(map);
							coursestudentShowDate(get);
						}
					}
				}

			}
		});
		button_10.setBounds(512, 32, 113, 27);
		panel_3.add(button_10);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(47, 94, 605, 203);
		panel_3.add(scrollPane_2);

		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
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
								String courseNo = (String) table.getValueAt(i, 0); // 课程编号
								String courseName = (String) table.getValueAt(i, 1); // 课程名
								textField_2.setText(courseNo); // 赋值
								textField_3.setText(courseName);
							}
						});

						popupMenu.add(menuItemdelete);

						popupMenu.show(table, e.getX(), e.getY());
					}
				}
			}
		});

		scrollPane_2.setViewportView(table_2);

		JLabel label_31 = new JLabel("添加课程：");
		label_31.setBounds(47, 310, 98, 18);
		panel_3.add(label_31);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.scrollbar);
		panel_9.setBounds(47, 341, 288, 219);
		panel_3.add(panel_9);
		panel_9.setLayout(null);

		JLabel label_33 = new JLabel("课程编号：");
		label_33.setBounds(27, 37, 101, 18);
		panel_9.add(label_33);

		textField = new JTextField();
		textField.setBackground(SystemColor.activeCaptionBorder);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				List<String> getcourseNo = course.getcourseNo();
				for (String string : getcourseNo) {
					if (string.equals(textField.getText())) {
						JOptionPane.showMessageDialog(null, "编号重复重新输入");
						textField.setText("");
					}
				}

			}
		});
		textField.setBounds(142, 34, 115, 24);
		panel_9.add(textField);
		textField.setColumns(10);

		JLabel label_34 = new JLabel("课程名：");
		label_34.setBounds(27, 97, 101, 18);
		panel_9.add(label_34);

		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.scrollbar);
		textField_1.setBounds(142, 94, 115, 24);
		panel_9.add(textField_1);
		textField_1.setColumns(10);

		JButton button_11 = new JButton("添加");
		button_11.setBackground(SystemColor.scrollbar);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null && textField_1.getText() != null) {
					boolean addcourse = course.addcourse(textField.getText(), textField_1.getText());
					if (addcourse == true) {
						JOptionPane.showMessageDialog(null, "添加成功");
					} else {
						JOptionPane.showMessageDialog(null, "添加失败");
					}
				}
			}
		});
		button_11.setBounds(75, 155, 113, 27);
		panel_9.add(button_11);

		JLabel label_32 = new JLabel("修改课程：");
		label_32.setBounds(371, 310, 98, 18);
		panel_3.add(label_32);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.scrollbar);
		panel_10.setBounds(371, 341, 280, 219);
		panel_3.add(panel_10);
		panel_10.setLayout(null);

		JLabel label_35 = new JLabel("课程编号：");
		label_35.setBounds(25, 37, 98, 18);
		panel_10.add(label_35);

		JLabel lblK = new JLabel("课程名：");
		lblK.setBounds(25, 91, 72, 18);
		panel_10.add(lblK);

		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.scrollbar);

		textField_2.setBounds(110, 34, 131, 24);
		panel_10.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.scrollbar);
		textField_3.setBounds(111, 88, 130, 24);
		panel_10.add(textField_3);
		textField_3.setColumns(10);

		JButton button_12 = new JButton("修改");
		button_12.setBackground(SystemColor.scrollbar);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_2.getText() != null && textField_3.getText() != null) {
					boolean updatecourse = course.updatecourse(textField_3.getText(), textField_2.getText());
					if (updatecourse == true) {
						JOptionPane.showMessageDialog(null, "修改成功");
					} else {
						JOptionPane.showMessageDialog(null, "修改失败");
					}
				}

			}
		});
		button_12.setBounds(24, 157, 113, 27);
		panel_10.add(button_12);

		JButton button_13 = new JButton("删除课程");
		button_13.setBackground(SystemColor.scrollbar);
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField_2.getText() != null && textField_3.getText() != null) {
					boolean getcountcourse = course.getcountcourse(textField_2.getText());
					if (getcountcourse == false) {
						JOptionPane.showMessageDialog(null, "改课程暂有学生选，请先修改学生科目");
						Updatecourse updatecourse = new Updatecourse(textField_2.getText());
						frame.dispose();
					} else {
						boolean deletecourse = course.deletecourse(textField_2.getText());
						if (deletecourse == true) {
							JOptionPane.showMessageDialog(null, "删除成功");
						} else {
							JOptionPane.showMessageDialog(null, "删除失败");

						}
					}
				}

			}
		});
		button_13.setBounds(151, 157, 113, 27);
		panel_10.add(button_13);
		frame.setVisible(true);

	}

	protected JPopupMenu createYourPopUp() {
		// TODO Auto-generated method stub
		return null;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
