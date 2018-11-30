import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HW2014190725 extends JFrame{
  
   JLabel num, name, count, price, hap, total;
   JPanel panel1, panel2, panel3, panel4;
   JButton addbtn;
   Object[][] temp;
   JTable table;
   DefaultTableModel model = new DefaultTableModel();
   JScrollPane scrollPane;
   File file = new File("./file/order.txt");
   FileReader fr = new FileReader(file);

   String[] line = null;
   String[] words1 = null;
   String[] words2 = null;
   String[] words3 = null;
   String[] words4 = null;
   String[] words5 = null;
   String[] words6 = null;
   String[] words7 = null;
   Container c;
   JTextField text3;
   int temp2;
   public HW2014190725() throws IOException{
	   
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       panel4 = new JPanel();
     
         setBounds(100 , 100 , 800 , 400);
         Container c = this.getContentPane();
         c.setBackground(Color.WHITE);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setTitle("주문 관리 프로그램");
         JMenuBar menuBar = new JMenuBar();
         JMenu orderMenu = new JMenu("주문관리");
         JMenuItem listItem = new JMenuItem("주문 목록 조회");
         JMenuItem saveItem = new JMenuItem("주문저장");
         JMenuItem exitItem = new JMenuItem("종료");
         setJMenuBar(menuBar);
         menuBar.add(orderMenu);
         orderMenu.add(listItem);
         orderMenu.add(saveItem);
         orderMenu.addSeparator();
         orderMenu.add(exitItem);
      
         model.addColumn("번호");
         model.addColumn("이름");
         model.addColumn("수량");
         model.addColumn("단가");
         model.addColumn("소계");
         
         name = new JLabel("상품명");
         num = new JLabel("번호");
         count = new JLabel("수량");
         price = new JLabel("가격(원)");
         hap = new JLabel("소계(원)");
         total = new JLabel("합계(원)");
         
         table = new JTable(model);
         scrollPane = new JScrollPane(table);
         
         addbtn = new JButton("Add");
         addbtn.setBackground(Color.GRAY);
         String[] menu = {"치약", "칫솔", "비누", "샴푸", "휴지"};
         JComboBox combo = new JComboBox(menu);
         JTextField text1 = new JTextField(8);
         JTextField text2 = new JTextField(8);
         
         panel1.add(name);
         panel1.add(combo);
         
         combo.addActionListener (new ActionListener () {
             public void actionPerformed(ActionEvent e) {
                 if(combo.getSelectedItem() == "치약") text2.setText("1000");
                 else if(combo.getSelectedItem() == "칫솔") text2.setText("500");
                 else if(combo.getSelectedItem() == "비누") text2.setText("2000");
                 else if(combo.getSelectedItem() == "샴푸") text2.setText("5000");
                 else if(combo.getSelectedItem() == "휴지") text2.setText("1500");
                 else text2.setText(null);
                 text2.disable();
             }
         });
         
         combo.setSelectedItem(null);
         panel1.add(count);
         panel1.add(text1);
         panel1.add(price);
         panel1.add(text2);
         panel1.add(addbtn);

         panel1.setBackground(Color.GRAY);
         panel1.setSize(600,50);
         panel1.setLocation(100, 10);
         
         scrollPane.setPreferredSize(new Dimension(590, 145));
         table.setBackground(Color.WHITE);
         table.setFillsViewportHeight(true);
         table.setRowHeight(30);
      
         TableColumnModel columnModel = table.getColumnModel();
         
         columnModel.getColumn(0).setPreferredWidth(50);
         columnModel.getColumn(1).setPreferredWidth(150);
         columnModel.getColumn(2).setPreferredWidth(100);
         columnModel.getColumn(3).setPreferredWidth(100);
         columnModel.getColumn(4).setPreferredWidth(100);
         
         panel2.add(scrollPane);
         panel2.setSize(600,160);
         panel2.setLocation(100, 90);
         panel3.add(total);
         text3 = new JTextField(8);
         panel3.add(text3);
         panel3.setBackground(Color.WHITE);
         panel3.setSize(600, 50);
         panel3.setLocation(100, 260);
         panel4.setBackground(Color.WHITE);
 
         c.add(panel1);
         c.add(panel2);
         c.add(panel3);
         c.add(panel4);
         
         listItem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
            	 String b = "";
                 int a = 0;
                 try {
					while((a = fr.read()) != -1) {
					    b += (char)a;   
					 }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 if(b != "") {
                	line = b.split("\n");
	                for(int i = 0; i < line.length; i++) {
                    if(i == 0) words1 = line[i].split(",");
                    else if(i == 1) words2 = line[i].split(",");
                    else if(i == 2) words3 = line[i].split(",");
                    else if(i == 3) words4 = line[i].split(",");
                    else if(i == 4) words5 = line[i].split(",");
                    else if(i == 5) words6 = line[i].split(",");
                    else if(i == 6) words7 = line[i].split(",");
	                }
                
                 if(line[0].startsWith("-")) {
                 }else if(line[1].startsWith("-")) {
                 model.addRow(new Object[]{"1", words1[0], words1[1], words1[2], words1[3]});
                 }else if(line[2].startsWith("-")) {
                    model.addRow(new Object[]{"1", words1[0], words1[1], words1[2], words1[3]});
                    model.addRow(new Object[]{"2", words2[0], words2[1], words2[2], words2[3]});
                 }else if(line[3].startsWith("-")) {
                    model.addRow(new Object[]{"1", words1[0], words1[1], words1[2], words1[3]});
                    model.addRow(new Object[]{"2", words2[0], words2[1], words2[2], words2[3]});
                    model.addRow(new Object[]{"3", words3[0], words3[1], words3[2], words3[3]});
                 }else if(line[4].startsWith("-")) {
                    model.addRow(new Object[]{"1", words1[0], words1[1], words1[2], words1[3]});
                    model.addRow(new Object[]{"2", words2[0], words2[1], words2[2], words2[3]});
                    model.addRow(new Object[]{"3", words3[0], words3[1], words3[2], words3[3]});
                    model.addRow(new Object[]{"4", words4[0], words4[1], words4[2], words4[3]});         
                 }else if(line[5].startsWith("-")) {
                    model.addRow(new Object[]{"1", words1[0], words1[1], words1[2], words1[3]});
                    model.addRow(new Object[]{"2", words2[0], words2[1], words2[2], words2[3]});
                    model.addRow(new Object[]{"3", words3[0], words3[1], words3[2], words3[3]});
                    model.addRow(new Object[]{"4", words4[0], words4[1], words4[2], words4[3]});
                    model.addRow(new Object[]{"5", words5[0], words5[1], words5[2], words5[3]});}}
                 temp2 = 0;
                 for(int i = 0; i < model.getRowCount(); i++) { 
                	 temp2 += Integer.parseInt((String)model.getValueAt(i, 4));
                	 text3.setText(String.valueOf(temp2));
                	 text3.disable();
                 }
                 table.disable();

                 addbtn.addActionListener(new ActionListener() {

                  @Override
                  public void actionPerformed(ActionEvent arg0) {
                     DefaultTableModel m = (DefaultTableModel)table.getModel();  
                     int l = -1;
                     for(int i = 0; i < m.getRowCount(); i++) {
                        if(m.getValueAt(i, 1).equals(combo.getSelectedItem())) {
                           String k = m.getValueAt(i, 2).toString();
                           if(text1.getText() != null) {
                              int q = Integer.parseInt(k) + Integer.parseInt(text1.getText());
                              m.setValueAt(q, i, 2);
                              l=i;
                              m.setValueAt(q*Integer.parseInt((String) m.getValueAt(i, 3)), i, 4);
                              if(q>10) m.setValueAt(10, i, 2);
                           }
                        }
                     }
                     if(l == -1 && combo.getSelectedItem() != null) {
                        if(Integer.parseInt(text1.getText()) != 0) {
                        	if(Integer.parseInt(text1.getText()) >= 10) text1.setText("10");
                        		m.addRow(new Object[] {m.getRowCount()+1, combo.getSelectedItem(),
                        				text1.getText(), text2.getText(), Integer.parseInt(text1.getText())*Integer.parseInt(text2.getText()) });
                        }
                     }
                     combo.setSelectedItem(null);
                     text1.setText(null);
                     temp2 = 0;
                     for(int i = 0; i < m.getRowCount(); i++) {
                    	temp2 += Integer.parseInt(String.valueOf(m.getValueAt(i,4)));
                    	text3.setText(String.valueOf(temp2));
                    	text3.disable();
                     }
                  
                  }
                  });
               }
         });

         saveItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
            	   FileWriter fw = null;
				try {
					fw = new FileWriter(file);
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
            	String[] out = null;
            	String temp3 = "";
               // TODO Auto-generated method stub
            	for(int i = 0; i < table.getRowCount(); i++) {
            		for(int j = 1; j < table.getColumnCount(); j++) {
            			temp3 += table.getValueAt(i, j);
            			if(j%4!=0) temp3 += ",";
            			else temp3 += "\n";
            		}
            	}
            	out = temp3.split("\n");
            	String change = "----------------------------";
            	String change2 = "합계," + temp2;
            	for(int i = 0; i < table.getRowCount(); i++) {
            		try {
						fw.write(out[i]+"\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	try {
					fw.write(change+"\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	try {
					fw.write(change2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	try {
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
         });
         
         exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
               System.exit(0);
            }
            
         });
         
         setResizable(false);
         setVisible(true);
      }
   
   
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
	   HW2014190725 application = new HW2014190725();
   }
}