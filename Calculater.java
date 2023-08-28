import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Calculater implements ActionListener,MouseListener,KeyListener
{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionbutton=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,eqButton,ClrButton,DelButton,negButton;
  

    JPanel panel=new JPanel();

    Font myFont=new Font("Stylus", Font.ROMAN_BASELINE, 30);

    double num1=0,num2=0,result=0;
    char operator;

    Calculater()
    {
        

        frame=new JFrame("Calculater");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        

        textField=new JTextField();
        textField.setFont(new Font("Roman", Font.ROMAN_BASELINE, 40));
        textField.setBounds(50, 20, 300, 70);

        int borderRadius = 5; 
        Color borderColor = Color.GRAY;
        Border roundedBorder = BorderFactory.createLineBorder(borderColor, borderRadius, true);

      
        textField.setBorder(roundedBorder);
        textField.setBackground(Color.white);
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.ORANGE);
        textField.setEditable(false);
       
        
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        eqButton=new JButton("=");
        ClrButton=new JButton("AC");
        DelButton=new JButton("Del");
        negButton=new JButton("(-)");

        functionbutton[0]=addButton;
        functionbutton[1]=subButton;
        functionbutton[2]=mulButton;
        functionbutton[3]=divButton;
        functionbutton[4]=decButton;
        functionbutton[5]=eqButton;
        functionbutton[6]=ClrButton;
        functionbutton[7]=DelButton;
        functionbutton[8]=negButton;


        for(int i=0;i<9;i++)
        {
            functionbutton[i].setFont(myFont);
            functionbutton[i].setFocusable(false);
            functionbutton[i].addActionListener(this);
            functionbutton[i].addMouseListener(this);
            functionbutton[i].setBackground(Color.WHITE);

        }

        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setFont(myFont);
        
            numberButtons[i].addActionListener(this);
            numberButtons[i].addMouseListener(this);

            

        }

        negButton.setBounds(50, 420, 95, 50);
        ClrButton.setBounds(150, 420, 95, 50);
        DelButton.setBackground(Color.red);
        DelButton.setBounds(250, 420, 95, 50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(DelButton);
        frame.add(ClrButton);
        frame.add(textField);
        frame.setVisible(true);
        
    }

    
    private String getName() {
        return null;
    }


    public static void main(String[] args) 
    {
            new Calculater();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton)
        {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource()==addButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }

        if(e.getSource()==subButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }

        if(e.getSource()==mulButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }

        if(e.getSource()==divButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");

        }

        if(e.getSource()==eqButton)
        {
            num2=Double.parseDouble(textField.getText());

            switch(operator)
            {
                case '+':
                    result=num1+num2;
                    break;
                
                case '-':
                    result=num1-num2;
                    break;

                case '*':
                    result=num1*num2;
                    break;
                    
                case '/':
                    result=num1/num2;
                    break;

            }

            textField.setText(String.valueOf(result));
            num1=result;
        
        }

        

        if(e.getSource()==ClrButton)
        {
            textField.setText("");
        }

        if(e.getSource()==DelButton)
        {
            String str=textField.getText();
            textField.setText("");
            for(int i=0;i<str.length()-1;i++)
            {
                textField.setText(textField.getText()+str.charAt(i));
            }

        }

        if(e.getSource()==negButton)
        {
            Double temp=Double.parseDouble(String.valueOf(textField.getText()));
            temp=temp*(-1);
            textField.setText(String.valueOf(temp));

        }
        
    }

    
	@Override
	public void mousePressed(MouseEvent e) 
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                numberButtons[i].setBackground(Color.green);
                
            }
        }

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==functionbutton[i])
            {
                functionbutton[i].setBackground(Color.green);
                
            }

            
        }
		
        DelButton.setBackground(Color.red);
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                numberButtons[i].setBackground(Color.green);
            }
        }

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==functionbutton[i])
            {
                functionbutton[i].setBackground(Color.green);
            }

            
        }
		
        DelButton.setBackground(Color.red);
	}

	@Override
	public void mouseEntered(MouseEvent e) 
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                numberButtons[i].setBackground(Color.green);    
            }

        }

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==functionbutton[i])
            {
                functionbutton[i].setBackground(Color.green);   
            }

            
        }
		
		 DelButton.setBackground(Color.red);

	}

    @Override
	public void mouseExited(MouseEvent e) 
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                numberButtons[i].setBackground(Color.WHITE); 
                
            }
        }

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==functionbutton[i])
            {
               functionbutton[i].setBackground(Color.WHITE); 
                
            }

           
        }

         DelButton.setBackground(Color.red);
		
    }


    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
    }

    //KEYLISTNER

    @Override
    public void keyTyped(KeyEvent e) 
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                
                
            }
        }

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==functionbutton[i])
            {
               functionbutton[i].setBackground(Color.WHITE); 
                
            }

           
        }
        

    }


    @Override
    public void keyPressed(KeyEvent e) 
    {
        
    }


    @Override
    public void keyReleased(KeyEvent e) 
    {
       
        

    }
  
    
}