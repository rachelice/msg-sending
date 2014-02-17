/*     */package com.sunshineroad.framework.codegenerate.window;

/*     */
/*     */import java.awt.Color;
/*     */
import java.awt.Dimension;
/*     */
import java.awt.GridLayout;
/*     */
import java.awt.event.ActionEvent;
/*     */
import java.awt.event.ActionListener;
/*     */
import java.io.PrintStream;
/*     */
import javax.swing.ButtonGroup;
/*     */
import javax.swing.JButton;
/*     */
import javax.swing.JCheckBox;
/*     */
import javax.swing.JComboBox;
/*     */
import javax.swing.JFrame;
/*     */
import javax.swing.JLabel;
/*     */
import javax.swing.JPanel;
/*     */
import javax.swing.JRadioButton;
/*     */
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import org.apache.commons.lang.StringUtils;

import com.sunshineroad.framework.codegenerate.database.SitReadTable;
import com.sunshineroad.framework.codegenerate.generate.CodeGenerate;
import com.sunshineroad.framework.codegenerate.pojo.CreateFileProperty;

/*     */
/*     */public class CodeWindow extends JFrame
/*     */{
	/*     */private static final long serialVersionUID = -5324160085184088010L;
	/* 32 */private static String entityPackage = "test";
	/* 33 */private static String entityName = "TestEntity";
	/* 34 */private static String tableName = "t00_company";
	/* 35 */private static String ftlDescription = "分公司";
	/* 36 */private static int fieldRowNum = 1;
	/* 37 */private static String primaryKeyPolicy = "identity";
	/* 38 */private static String sequenceCode = "";
	/*     */
	/* 40 */String[] planets = { "sequence", "identity", "uuid" };

	/*     */
	/*     */public CodeWindow() {
		/* 43 */JPanel jp = new JPanel();
		/* 44 */setContentPane(jp);
		/* 45 */jp.setLayout(new GridLayout(14, 2));
		/*     */
		/* 47 */final JLabel infolbl = new JLabel("提示:");
		/* 48 */final JLabel showlbl = new JLabel();
		/* 49 */final JLabel packagebl = new JLabel("包名（小写）：");
		/* 50 */final JTextField packagefld = new JTextField("tfunciton");// 包名文字域
		/* 51 */final JLabel entitylbl = new JLabel("实体类名（首字母大写）：");
		/* 52 */final JTextField entityfld = new JTextField("Tfunction");// 实体文字域
		/* 53 */final JLabel tablejbl = new JLabel("表名：");
		/* 54 */final JTextField tablefld = new JTextField("t_s_function");// 表名文字域
		/*     */
		/* 56 */final JLabel tablekeyjbl = new JLabel("主键生成策略：");
		/* 57 */final JComboBox tablekeyfld = new JComboBox(this.planets);

		/* 58 */final JLabel sequence_lb = new JLabel("主键SEQUENCE：(oracle序列名)");
		/* 59 */final JTextField sequence_fld = new JTextField(20);
		/*     */
		/* 61 */final JLabel titlelbl = new JLabel("功能描述：");
		/* 62 */final JTextField titlefld = new JTextField();
		/*     */
		/* 64 */final JLabel fieldRowNumlbl = new JLabel("行字段数目：");
		/* 65 */final JTextField fieldRowNumfld = new JTextField();
		/* 66 */fieldRowNumfld.setText(String.valueOf(fieldRowNum));
		/*     */
		/* 68 */final ButtonGroup bg = new ButtonGroup();
		/* 69 */final JRadioButton jsp = new JRadioButton("Table风格(form)");
		/* 70 */jsp.setSelected(true);
		/* 71 */final JRadioButton jsp_row = new JRadioButton("Div风格(form)");
		/* 72 */bg.add(jsp);
		/* 73 */bg.add(jsp_row);
		/*     */
		/* 77 */final JCheckBox actionButton = new JCheckBox("Action");
		/* 78 */actionButton.setSelected(true);
		/* 79 */final JCheckBox jspButton = new JCheckBox("Jsp");
		/* 80 */jspButton.setSelected(true);
		/* 81 */final JCheckBox serviceIButton = new JCheckBox("Service");
		/* 82 */serviceIButton.setSelected(true);
		/* 83 */final JCheckBox serviceImplButton = new JCheckBox("ServiceImpl");
		/* 84 */serviceImplButton.setSelected(true);
		/* 85 */final JCheckBox pageButton = new JCheckBox("Page");
		/* 86 */pageButton.setSelected(true);
		/* 87 */final JCheckBox entityButton = new JCheckBox("Entity");
		/* 88 */entityButton.setSelected(true);
		/*     */

		// 表名文字域修改时的事件监听
		tablefld.getDocument().addDocumentListener(
				new javax.swing.event.DocumentListener() {
					public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
						String s = tablefld.getText().trim();// 去掉误输入的空格
						packagefld.setText(s.toLowerCase().replaceAll("_", "")); // 同步包文字域
						sequence_fld.setText(s + "_seq"); // 同步修改主键文字域
						// 处理实体名
						String result = "";
						String[] temp = s.split("_"); // 下划线分割
						if (s.length() != 0) { // 非空验证 否则异常
							for (int i = 0; i < temp.length; i++) {// 对分割后的每个字符进行首字母大写处理
								temp[i] = temp[i].substring(0, 1).toUpperCase()
										+ temp[i].substring(1).toLowerCase();
							}
							if (s.contains("_")) {
								for (int i = 0; i < temp.length; i++) {
									result += temp[i];
								}
							} else {
								result = temp[0];
							}
						}
						entityfld.setText(result);// 同步实体名文字域 首字母大写
					}

					public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
						String s = tablefld.getText().trim();// 去掉误输入的空格
						packagefld.setText(s.toLowerCase().replaceAll("_", "")); // 同步包文字域
						sequence_fld.setText(s + "_seq"); // 同步修改主键文字域
						// 处理实体名
						String result = "";
						String[] temp = s.split("_"); // 下划线分割
						if (s.length() != 0) { // 非空验证 否则异常
							for (int i = 0; i < temp.length; i++) {// 对分割后的每个字符进行首字母大写处理
								temp[i] = temp[i].substring(0, 1).toUpperCase()
										+ temp[i].substring(1).toLowerCase();
							}
							if (s.contains("_")) {
								for (int i = 0; i < temp.length; i++) {
									result += temp[i];
								}
							} else {
								result = temp[0];
							}
						}
						entityfld.setText(result);// 同步实体名文字域 首字母大写
					}

					public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
						String s = tablefld.getText().trim();// 去掉误输入的空格
						packagefld.setText(s.toLowerCase().replaceAll("_", "")); // 同步包文字域
						sequence_fld.setText(s + "_seq"); // 同步修改主键文字域
						// 处理实体名
						String result = "";
						String[] temp = s.split("_"); // 下划线分割
						if (s.length() != 0) { // 非空验证 否则异常
							for (int i = 0; i < temp.length; i++) {// 对分割后的每个字符进行首字母大写处理
								temp[i] = temp[i].substring(0, 1).toUpperCase()
										+ temp[i].substring(1).toLowerCase();
							}
							if (s.contains("_")) {
								for (int i = 0; i < temp.length; i++) {
									result += temp[i];
								}
							} else {  
								result = temp[0];
							}
						}
						entityfld.setText(result);// 同步实体名文字域 首字母大写
					}
				});

		/* 90 */jp.add(infolbl);
		/* 91 */jp.add(showlbl);
		/* 92 */jp.add(packagebl);
		/* 93 */jp.add(packagefld);
		/* 94 */jp.add(entitylbl);
		/* 95 */jp.add(entityfld);
		/* 96 */jp.add(tablejbl);
		/* 97 */jp.add(tablefld);
		/*     */
		/* 99 */jp.add(tablekeyjbl);
		/* 100 */jp.add(tablekeyfld);
		/*     */
		/* 102 */jp.add(sequence_lb);
		/* 103 */jp.add(sequence_fld);
		/*     */
		/* 105 */jp.add(titlelbl);
		/* 106 */jp.add(titlefld);
		/* 107 */jp.add(fieldRowNumlbl);
		/* 108 */jp.add(fieldRowNumfld);
		/*     */
		/* 112 */jp.add(actionButton);
		/* 113 */jp.add(jspButton);
		/* 114 */jp.add(serviceIButton);
		/* 115 */jp.add(serviceImplButton);
		/* 116 */jp.add(pageButton);
		/* 117 */jp.add(entityButton);
		/*     */
		/* 120 */jp.add(jsp);
		/* 121 */jp.add(jsp_row);
		/*     */
		/* 123 */JButton confirmbtn = new JButton("生成");
		ActionListener al = new ActionListener()
		/*     */{

			public void actionPerformed(ActionEvent e) {
				if (!"".equals(packagefld.getText())) {
					CodeWindow.entityPackage = packagefld.getText();
				} else {
					showlbl.setForeground(Color.red);
					showlbl.setText("包名不能为空！");
					return;
				}
				if (!"".equals(entityfld.getText())) {
					CodeWindow.entityName = StringUtils.capitalise(entityfld
							.getText());

				} else {
					showlbl.setForeground(Color.red);
					showlbl.setText("实体类名不能为空！");
					return;
				}
				if (!"".equals(titlefld.getText())) {
					CodeWindow.ftlDescription = titlefld.getText();
				} else {
					showlbl.setForeground(Color.red);
					showlbl.setText("描述不能为空！");
					return;
				}
				if (!"".equals(tablefld.getText())) {
					CodeWindow.tableName = tablefld.getText();
				} else {
					showlbl.setForeground(Color.red);
					showlbl.setText("表名不能为空！");
					return;
				}

				CodeWindow.primaryKeyPolicy = (String) tablekeyfld
						.getSelectedItem();

				if (CodeWindow.primaryKeyPolicy.equals("sequence")) {
					if (!"".equals(sequence_fld.getText())) {
						CodeWindow.sequenceCode = sequence_fld.getText();
					} else {
						showlbl.setForeground(Color.red);
						showlbl.setText("主键生成策略为sequence时，序列号不能为空！");
						return;
					}

				}

				CreateFileProperty createFileProperty = new CreateFileProperty();

				if (jsp.isSelected()) {
					createFileProperty.setJspMode("01");
				}
				if (jsp_row.isSelected()) {
					createFileProperty.setJspMode("02");
				}

				if (actionButton.isSelected()) {
					createFileProperty.setActionFlag(true);
				}
				if (jspButton.isSelected()) {
					createFileProperty.setJspFlag(true);
				}
				if (serviceIButton.isSelected()) {
					createFileProperty.setServiceFlag(true);
				}
				if (serviceImplButton.isSelected()) {
					createFileProperty.setServiceImplFlag(true);
				}

				if (entityButton.isSelected()) {
					createFileProperty.setEntityFlag(true);
				}

				try {
					boolean tableexist = new SitReadTable()
							.checkTableExist(CodeWindow.tableName);
					if (tableexist) {
						new CodeGenerate(CodeWindow.entityPackage,
								CodeWindow.entityName, CodeWindow.tableName,
								CodeWindow.ftlDescription, createFileProperty,
								CodeWindow.fieldRowNum,
								CodeWindow.primaryKeyPolicy,
								CodeWindow.sequenceCode).generateToFile();
						showlbl.setForeground(Color.red);
						showlbl.setText("成功生成增删改查->功能："
								+ CodeWindow.ftlDescription);
					} else {
						showlbl.setForeground(Color.red);
						showlbl.setText("表[" + CodeWindow.tableName
								+ "] 在数据库中，不存在");
					}
				} catch (Exception e1) {
					showlbl.setForeground(Color.red);
					showlbl.setText(e1.getMessage());
					System.out.println(e1.getMessage()); // GUI上显示不全 加入console显示
				}
			}
		};
		/* 124 */confirmbtn.addActionListener(al);
		/* 226 */JButton extbtn = new JButton("退出");
		/* 227 */extbtn.addActionListener(new ActionListener()
		/*     */{
			/*     */public void actionPerformed(ActionEvent e) {
				/* 230 */CodeWindow.this.dispose();
				/* 231 */System.exit(0);
				/*     */}
			/*     */
		});
		/* 235 */jp.add(confirmbtn);
		/* 236 */jp.add(extbtn);
		/*     */
		/* 238 */setTitle("JEECG代码生成器[单表模型]");
		/* 239 */setVisible(true);
		/* 240 */setDefaultCloseOperation(3);
		/* 241 */setSize(new Dimension(600, 400));
		/* 242 */setResizable(false);
		/* 243 */setLocationRelativeTo(getOwner());
		/*     */}

	/*     */
	/*     */public static void main(String[] args) {
		/*     */try {
			/* 248 */new CodeWindow().pack();
			/*     */} catch (Exception e) {
			/* 250 */System.out.println(e.getMessage());
			/*     */}
		/*     */}
	/*     */
}

/*
 * Location:
 * C:\Users\Administrator.WIN-ARR84UMMDSP\Desktop\org.jeecgframework.codegenerate
 * .jar Qualified Name: org.jeecgframework.codegenerate.window.CodeWindow
 * JD-Core Version: 0.5.4
 */