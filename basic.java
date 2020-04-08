package com.javatut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Map;

public class basic {
    private JButton button1;
    private JPanel panel1;
    private JTextField textField1;
    private JLabel label;

    public basic() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String a = textField1.getText();
                StringBuilder ret = new StringBuilder();
                ret.append("<html><table style=\"width:100%\">\n" +
                        "  <tr>\n" +
                        "    <th>Month</th>\n" +
                        "    <th>Amount</th>\n" +
                        "  </tr>\n" );
                for (int i = 0; i < Integer.parseInt(a); i++) {
                   Map response = LoanRepository.processPeriod(i);
                    Object ll =  response.get(i);
                    for (String a:ll){

                    }
                    StringBuilder append = ret.append(ll[0]);
                }

//                label.setText("<html>" + ret.toString() + "</html>");
                label.setText(
                        "  <tr>\n" +
                        "    <td>Jill</td>\n" +
                        "    <td>Smith</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Eve</td>\n" +
                        "    <td>Jackson</td>\n" +
                        "  </tr>\n" +
                        "</table></html>");
//                JOptionPane.showMessageDialog(null, ret.toString());

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("basic");
        frame.setContentPane(new basic().panel1);
        frame.setPreferredSize(new Dimension(400, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
