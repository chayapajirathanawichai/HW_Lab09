/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw_lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Account {
    private String id;
    private double money;
    private double interestRate;
    private String dayOpenAccount;
    private String firstName;
    private String lastName;
    private String birthDay;
    private int age;

    public Account(String id, double money, double interestRate, String dayOpenAccount, 
                   String firstName, String lastName, String birthDay, int age) {
        this.id = id;
        this.money = money;
        this.interestRate = interestRate;
        this.dayOpenAccount = dayOpenAccount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + 
               "\nName: " + firstName + " " + lastName + 
               "\nMoney: " + money + " BATH" +
               "\nInterest Rate: " + interestRate + "%" +
               "\nOpen Date: " + dayOpenAccount + 
               "\nBirth Day: " + birthDay + 
               "\nAge: " + age + " YEAR\n------------------------------";
    }
}

public class AccountFormUI extends JFrame{
    private JTextField txtId, txtMoney, txtInterestRate, txtFirstName, txtLastName, txtAge;
    private JComboBox<String> cbOpenDay, cbOpenMonth, cbOpenYear;
    private JComboBox<String> cbBirthDay, cbBirthMonth, cbBirthYear;
    private JButton btnSave, btnShow;
    
    private ArrayList<Account> accountList = new ArrayList<>();

    public AccountFormUI() {
        setTitle("Show Detail of Account ...");
        setSize(480, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        JLabel lblHeader = new JLabel("ACCOUNT MONEY", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblHeader.setBounds(20, 10, 420, 20);
        add(lblHeader);

        JLabel lblSubHeader = new JLabel("Enter Data Account Money");
        lblSubHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSubHeader.setBounds(20, 30, 200, 20);
        add(lblSubHeader);

        // --- ID & MONEY ---
        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(30, 70, 40, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(70, 70, 80, 25);
        add(txtId);

        JLabel lblMoney = new JLabel("MONEY :");
        lblMoney.setBounds(160, 70, 60, 25);
        add(lblMoney);

        txtMoney = new JTextField();
        txtMoney.setBounds(220, 70, 100, 25);
        add(txtMoney);

        JLabel lblBath = new JLabel("BATH :");
        lblBath.setBounds(330, 70, 50, 25);
        add(lblBath);

        // --- ANNUAL INTEREST RATE ---
        JLabel lblRate = new JLabel("ANNUALINTERATE RATE :");
        lblRate.setBounds(30, 110, 150, 25);
        add(lblRate);

        txtInterestRate = new JTextField();
        txtInterestRate.setBounds(180, 110, 100, 25);
        add(txtInterestRate);

        // --- DATA Array ---
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        String[] years = new String[50];
        for (int i = 0; i < 50; i++) years[i] = String.valueOf(2026 - i);

        // --- DAY OPEN ACCOUNT ---
        JLabel lblOpenAcc = new JLabel("DAY OPEN ACCOUNT :");
        lblOpenAcc.setBounds(30, 150, 140, 25);
        add(lblOpenAcc);

        cbOpenDay = new JComboBox<>(days);
        cbOpenDay.setBounds(175, 150, 55, 25);
        add(cbOpenDay);

        cbOpenMonth = new JComboBox<>(months);
        cbOpenMonth.setBounds(235, 150, 65, 25);
        add(cbOpenMonth);

        cbOpenYear = new JComboBox<>(years);
        cbOpenYear.setBounds(30, 185, 65, 25);
        add(cbOpenYear);

        // --- FIRST NAME ---
        JLabel lblFirstName = new JLabel("FIRST NAME :");
        lblFirstName.setBounds(105, 185, 90, 25);
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(190, 185, 150, 25);
        add(txtFirstName);

        // --- LAST NAME ---
        JLabel lblLastName = new JLabel("LAST NAME :");
        lblLastName.setBounds(30, 225, 90, 25);
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(110, 225, 150, 25);
        add(txtLastName);

        // --- BIRTH DAY ---
        JLabel lblBirthDay = new JLabel("BIRTH DAY :");
        lblBirthDay.setBounds(30, 265, 90, 25);
        add(lblBirthDay);

        cbBirthDay = new JComboBox<>(days);
        cbBirthDay.setBounds(110, 265, 55, 25);
        add(cbBirthDay);

        cbBirthMonth = new JComboBox<>(months);
        cbBirthMonth.setBounds(170, 265, 65, 25);
        add(cbBirthMonth);

        cbBirthYear = new JComboBox<>(years);
        cbBirthYear.setBounds(240, 265, 65, 25);
        add(cbBirthYear);

        // --- AGE ---
        JLabel lblAge = new JLabel("AGE :");
        lblAge.setBounds(30, 305, 50, 25);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(70, 305, 60, 25);
        add(txtAge);

        JLabel lblYear = new JLabel("YEAR");
        lblYear.setBounds(140, 305, 50, 25);
        add(lblYear);

        // --- BUTTONS ---
        btnSave = new JButton("SAVE");
        btnSave.setBounds(230, 370, 75, 30);
        add(btnSave);

        btnShow = new JButton("SHOW");
        btnShow.setBounds(315, 370, 75, 30);
        add(btnShow);

        //event
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = txtId.getText();
                    double money = Double.parseDouble(txtMoney.getText());
                    double interestRate = Double.parseDouble(txtInterestRate.getText());

                    String openDate = cbOpenDay.getSelectedItem() + "/" + 
                                       cbOpenMonth.getSelectedItem() + "/" + 
                                       cbOpenYear.getSelectedItem();

                    String firstName = txtFirstName.getText();
                    String lastName = txtLastName.getText();

                    String birthDate = cbBirthDay.getSelectedItem() + "/" + 
                                       cbBirthMonth.getSelectedItem() + "/" + 
                                       cbBirthYear.getSelectedItem();

                    int age = Integer.parseInt(txtAge.getText());

                    Account acc = new Account(id, money, interestRate, openDate, firstName, lastName, birthDate, age);
                    accountList.add(acc);

                    JOptionPane.showMessageDialog(AccountFormUI.this, "Save!");
                    clearForm();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AccountFormUI.this, 
                        "please input again", 
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (accountList.isEmpty()) {
                    JOptionPane.showMessageDialog(AccountFormUI.this, "not found");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Account acc : accountList) {
                        sb.append(acc.toString()).append("\n");
                    }
                    JTextArea textArea = new JTextArea(sb.toString());
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(350, 250));
                    
                    JOptionPane.showMessageDialog(AccountFormUI.this, scrollPane, "Account List", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void clearForm() {
        txtId.setText("");
        txtMoney.setText("");
        txtInterestRate.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        cbOpenDay.setSelectedIndex(0);
        cbOpenMonth.setSelectedIndex(0);
        cbOpenYear.setSelectedIndex(0);
        cbBirthDay.setSelectedIndex(0);
        cbBirthMonth.setSelectedIndex(0);
        cbBirthYear.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AccountFormUI().setVisible(true);
        });
    }
}
