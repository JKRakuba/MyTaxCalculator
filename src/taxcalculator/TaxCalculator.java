/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import javax.swing.JOptionPane;

/**
 *
 * @author NaeemFranks
 */
public class TaxCalculator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double salary = getSalary();
        double tax = getTax(salary);
        
        output(salary, tax);
        finish();
    }

    private static double getSalary() {
        
        double salary = 0;
        try{
            String input = JOptionPane.showInputDialog(null, "Enter Salary\n"
                    + "(Please input digits only)\n"
                    + "or click Cancel to exit: \n\n",
                    "Julliet's Tax Calculator", JOptionPane.QUESTION_MESSAGE);
            if(input == null)
                finish();
            
            salary = Double.parseDouble(input);
            
            if(salary < 0)
                finish();

        }
        catch(NullPointerException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "An error has occured while \n"
                    + "processing your request. Please try again!\n\n"
                    + "Error: " + ex.getMessage(),
                    "Julliet's Tax Calculator", JOptionPane.ERROR_MESSAGE);
            finish();
        }
        return salary;
    }

    private static double getTax(double salary) {
       double tax = 0; 
        if(salary <= 74000)
            tax = 0;
        else 
            if(salary >= 74001 && salary <= 115000)
                tax = 13320 + (salary * 0.25);
        else 
            if(salary >= 115001 && salary <= 155000)
                tax = 23570 + (salary * 0.3);
        else 
            if(salary >= 155001 && salary <= 195000)
                tax = 35570 + (salary * 0.35);
        else 
            if(salary >= 195001 && salary <= 270000)
                tax = 49570 + (salary * 0.38);
        else 
            if(salary >= 270001)
                tax = 78070 + (salary * 0.4);
        return tax;
    }

    private static void finish(){
        JOptionPane.showMessageDialog(null, "Thank you for using Julliet's Tax Calculator!",
                "Thank You!", JOptionPane.INFORMATION_MESSAGE);
           System.exit(0);
    }
    
    private static void output(double salary, double tax){
        JOptionPane.showMessageDialog(null, "Your tax on a salary of R " + Editors.format(salary) 
                + " is R " + Editors.format(tax), "Julliet's Tax Calculator",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
